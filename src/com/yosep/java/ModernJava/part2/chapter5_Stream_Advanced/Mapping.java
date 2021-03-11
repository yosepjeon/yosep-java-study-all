package com.yosep.java.ModernJava.part2.chapter5_Stream_Advanced;

import com.yosep.java.ModernJava.part1.chapter4_stream_basic.Dish;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {
        // 스트림의 각 요소에 함수 적용하기
        System.out.println("<mapping dish name>");
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        dishNames.forEach(System.out::println);

        System.out.println("\n<mapping words length>");
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        wordLengths.forEach(System.out::println);

        System.out.println("\n<mapping chaining name-length>");
        List<Integer> dishNameLengths = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        dishNameLengths.forEach(System.out::println);

        // 스트림 평면화
        System.out.println("\n<map을 사용한 평면화 String[]을 반환하므로 않좋음...>");
        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nflatmap을 사용한 평면화");
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        // 퀴즈1
        System.out.println("\nQuiz1");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> powNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        powNumbers.forEach(System.out::println);

        // 퀴즈2
        System.out.println("\nQuiz2");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        pairs.forEach(p -> System.out.println(p[0] + ", " + p[1]));

        // 퀴즈3
        System.out.println("\nQuiz3");
        List<int[]> answer3 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());
        answer3.forEach(p -> System.out.println(p[0] + ", " + p[1]));
    }
}
