package com.yosep.java.ModernJava.part1.chapter4_stream_basic;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HighCaloriesNames {
    public static void main(String...args) {
        System.out.println("Init: " + Dish.menu);

        List<Dish> dishes = Dish.menu
                .stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .collect(Collectors.toList());

        System.out.println(dishes);

        List<String> lowCaloricDishesName = Dish.menu
                .stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(lowCaloricDishesName);

        List<Dish> threeHighCaloricDishes = Dish.menu
                .stream()
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishes);
    }
}
