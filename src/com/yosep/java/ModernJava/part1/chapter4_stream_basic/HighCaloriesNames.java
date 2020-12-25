package com.yosep.java.ModernJava.part1.chapter4_stream_basic;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HighCaloriesNames {
    public static void main(String...args) {
        List<String> names = Dish.menu.stream()
                .filter(dish -> {
                    System.out.println("filtering " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
    }
}
