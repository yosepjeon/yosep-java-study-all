package com.yosep.java.ModernJava.part1.chapter3_lambda_expression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {

    private static final String FILE = ExecuteAround.class.getResource("./data.txt").getFile();

    public static void main(String... args) throws IOException {
        // 더 유연하게 리팩토링할 메서드
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(twoLines);
    }

    public static String processFileLimited() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor bp) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            return bp.process(br);
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }
}
