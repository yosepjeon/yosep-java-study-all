package com.yosep.java.ModernJava.part2.chapter5_Stream_Advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionQuiz {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("Quiz1");
        List<Transaction> answer1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        answer1.forEach(System.out::println);

        System.out.println("\nQuiz2");
        List<String> answer2 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        answer2.forEach(System.out::println);

        System.out.println("\nQuiz3");
        List<Trader> answer3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
        answer3.forEach(System.out::println);

        System.out.println("\nQuiz4");
        List<String> answer4 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(Comparator.comparing(String::valueOf))
                .collect(Collectors.toList());
        answer4.forEach(System.out::println);

        System.out.println("\nQuiz5");
        boolean answer5 = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println(answer5);

        System.out.println("\nQuiz6");
        List<Integer> answer6 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        answer6.forEach(System.out::println);

        System.out.println("\nQuiz7");
        Optional<Integer> answer7 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(answer7);

        System.out.println("\nQuiz8");
        Optional<Integer> answer8 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println(answer8);
    }
}
