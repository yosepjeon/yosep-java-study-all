package com.yosep.java.ModernJava.part2.chapter5_Stream_Advanced;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("practice1");
        Stream<Integer> ex1 = Stream.iterate(0, n -> n + 2).limit(10);
        ex1.forEach(e -> System.out.println(e));

        System.out.println("\npractice2");
        IntStream ex2 = IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100);
        ex2.forEach(System.out::println);

        System.out.println("\npractice3");


        System.out.println("\nfibonacci1");
        Stream<int[]> fibonacci1 = Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20);

        fibonacci1.forEach(e -> System.out.println(e[0]));

        System.out.println("\nfibonacci2");
        IntSupplier fiboSupplier = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;

                return oldPrevious;
            }
        };

        IntStream fibonacci2 = IntStream.generate(fiboSupplier).limit(20);
        fibonacci2.forEach(System.out::println);
    }
}
