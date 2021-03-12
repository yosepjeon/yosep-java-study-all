package com.yosep.java.ModernJava.part2.chapter5_Stream_Advanced;

import com.yosep.java.ModernJava.part1.chapter4_stream_basic.Dish;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 요소의 합
        System.out.println("요소의 합");
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        List<Integer> list = Collections.emptyList();
        Optional<Integer> sum2 = list.stream().reduce((a, b) -> a + b);
        System.out.println(sum2);

        // 최댓값과 최솟값
        System.out.println("\n최댓값과 최솟값");
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max);
        max = numbers.stream().max((n1, n2) -> n1 - n2);
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min);
        min = numbers.stream().min((n1, n2) -> n1 - n2);
        System.out.println(min);

        // Quiz1
        long countMenu = Dish.menu.stream()
                .map(d -> 1)
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(countMenu);
    }
}
