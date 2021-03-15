package com.yosep.java.ModernJava.part2.chapter5_Stream_Advanced;

import com.yosep.java.ModernJava.part1.chapter4_stream_basic.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerStream {
    public static void main(String[] args) {
        // 기본형 특화 스트림
        System.out.println("기본형 특화 스트림");
        int calories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories);

        // 객체 스트림으로 복원하기
        IntStream intStream = Dish.menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> IntegerStream = intStream.boxed();

        // 기본값: OptionalInt
        System.out.println("\n기본값: OptionalInt");
        OptionalInt maxCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(maxCalories);

        // 숫자 범위
        System.out.println("\n숫자 범위");
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

    }
}
