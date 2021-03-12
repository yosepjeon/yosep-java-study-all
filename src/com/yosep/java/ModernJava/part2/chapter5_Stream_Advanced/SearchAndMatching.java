package com.yosep.java.ModernJava.part2.chapter5_Stream_Advanced;

import com.yosep.java.ModernJava.part1.chapter4_stream_basic.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchAndMatching {
    public static void main(String[] args) {
        // 프레디케이트가 적어도 한 요소와 일치하는지 확인
        System.out.println("프레디케이트가 적어도 한 요소와 일치하는지 확인");
        if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        // 프레디케이트가 모든 요소와 일치하는지 검사
        System.out.println("\n프레디케이트가 모든 요소와 일치하는지 검사");
        boolean isHealthy = Dish.menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println("isHealthy: " + isHealthy);

        // 프레디케이트가 일치하지 않는 요소가 없는지 검사
        System.out.println("\n프레디케이트가 일치하지 않는 요소가 없는지 검사");
        isHealthy = Dish.menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
        System.out.println("isHealthy: " + isHealthy);

        // 요소 검색
        System.out.println("\n요소 검색");
        Optional<Dish> dish = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(dish);

        // 첫 번째 요소 찾기
        System.out.println("\n첫 번째 요소 찾기");
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSqareDivisibleByThree =
                someNumbers.stream()
                        .map(n -> n * n)
                        .filter(n -> n % 3 == 0)
                        .findFirst();
        System.out.println(firstSqareDivisibleByThree);
    }
}
