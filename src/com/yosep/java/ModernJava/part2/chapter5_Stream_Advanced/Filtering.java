package com.yosep.java.ModernJava.part2.chapter5_Stream_Advanced;

import static com.yosep.java.ModernJava.part1.chapter4_stream_basic.Dish.menu;

import com.yosep.java.ModernJava.part1.chapter4_stream_basic.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String... args) {
        // Predicate로 filtering함
        System.out.println("Filtering with a predicate");
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        vegetarianMenu.forEach(System.out::println);

        // 고유 요소로 거름
        System.out.println("\nFiltering unique elements");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // 스트림 슬라이스
        // 칼로리 값을 기준으로 리스트를 오름차순 정렬:
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
                );

        System.out.println("\nFiltered sorted menu");
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(d -> d.getCalories() < 320)
                .collect(Collectors.toList());
        filteredMenu.forEach(System.out::println);

        System.out.println("\nSorted menu sliced with takeWhile()");
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(d -> d.getCalories() < 320)
                .collect(Collectors.toList());
        slicedMenu1.forEach(System.out::println);

        System.out.println("\nSorted menu sliced with dropWhile()");
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(d -> d.getCalories() < 320)
                .collect(Collectors.toList());
        slicedMenu2.forEach(System.out::println);

        // 스트림 축소
        System.out.println("\nTruncating a filtered stream");
        List<Dish> filteredDishes = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        filteredDishes.forEach(System.out::println);

        System.out.println("\nTruncating a takeWhile stream");
        List<Dish> dishesWithTakeWhile = specialMenu.stream()
                .takeWhile(d -> d.getCalories() < 400)
                .limit(3)
                .collect(Collectors.toList());
        dishesWithTakeWhile.forEach(System.out::println);

        // 요소 생략
        List<Dish> dishesSkip = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("\nSkipping elements");
        dishesSkip.forEach(System.out::println);
    }
}
