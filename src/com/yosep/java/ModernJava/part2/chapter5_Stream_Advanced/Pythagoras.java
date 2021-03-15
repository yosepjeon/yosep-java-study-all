package com.yosep.java.ModernJava.part2.chapter5_Stream_Advanced;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pythagoras {
    public static void main(String[] args) {
        // 초기 코드
        System.out.println("초기 코드");
        Stream<int[]> pythagorasTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                        );
        pythagorasTriples.limit(5).forEach(element ->
                System.out.println(element[0] + ", " + element[1] + ", " + element[2]));

        // 개선 코드
        System.out.println("\n개선 코드");
        Stream<double[]> pythagorasTriplesRefactored =
                IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                .mapToObj(b -> new double[]{a,b, Math.sqrt(a*a + b*b)})
                .filter(t -> t[2] % 1 == 0));
        pythagorasTriplesRefactored.forEach(element ->
                System.out.println(element[0] + ", " + element[1] + ", " + element[2]));
    }
}
