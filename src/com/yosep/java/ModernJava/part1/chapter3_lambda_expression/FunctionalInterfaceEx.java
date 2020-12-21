package com.yosep.java.ModernJava.part1.chapter3_lambda_expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceEx {
    public static void main(String... args) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("a");
        listOfStrings.add("b");

        // Predicate
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

        System.out.println(nonEmpty);

        // Consumer
        forEach(
                Arrays.asList(1, 2, 3, 4, 5),
                (Integer i) -> System.out.println(i)
        );

        // Function
        List<Integer> list = map(
                Arrays.asList("lambdas","in","action"),
                (String s) -> s.length()
        );

        System.out.println(list);
    }

    // predicate ex
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    // consumer ex
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    // function ex
    public static <T,R> List<R> map(List<T> list, Function<T,R> f) {
        List<R> result = new ArrayList<>();
        for(T t: list) {
            result.add(f.apply(t));
        }

        return result;
    }
}

@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}

@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
}

@FunctionalInterface
interface Function<T,R> {
    R apply(T t);
}