package com.yosep.java.ModernJava.part1.chapter3_람다표현식;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {

    private static final String FILE = ExecuteAround.class.getResource("./data.txt").getFile();

    public static void main(String... args) {
        // 더 유연하게 리팩토링할 메서드
//        String result =
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
