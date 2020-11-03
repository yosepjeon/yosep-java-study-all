package com.yosep.java.ModernJava.part2.chapter6_스트림으로데이터수집;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.yosep.java.ModernJava.part2.chapter6_스트림으로데이터수집.Dish.menu;
import static java.util.stream.Collectors.*;

public class Summarizing {
    public static void main(String[] args) {
        System.out.println("Number of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("The most caloric dish is: " + findModstCaloricDishUsingComparator());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }

    private static long howManyDishes() {
//        return menu.stream().collect(counting());
        return menu.stream().count();
    }

    private static Dish findMostCaloricDish() {
//        return menu.stream().collect(reducing((d1,d2)->d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
        return menu.stream().reduce((d1,d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2).get();
    }

    private static Dish findModstCaloricDishUsingComparator() {
//        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
//        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
//        return menu.stream().collect(reducing(moreCaloricOf)).get();

        return menu.stream().max((d1,d2) -> d1.getCalories() - d2.getCalories()).get();
    }

    private static int calculateTotalCalories() {
        return menu.stream().collect(summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories() {
        return menu.stream().collect(averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    private static String getShortMenu() {
        return menu.stream().map(Dish::getName).collect(Collectors.joining());
    }

    private static String getShortMenuCommaSeparated() {
        return menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
