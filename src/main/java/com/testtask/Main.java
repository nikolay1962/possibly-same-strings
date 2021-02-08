package com.testtask;

import com.testtask.model.UnpackedString;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[][] testCouples = new String[][] {
                {"st2wars", "star3s"},
                {"3b", "a2"},
                {"st2mars","4w2s"},
                {null, "str"},
                {null, null},
                {"star", "4"},
                {"", ""},
                {"am i right?", "am i right!"},
                null
        };

        Arrays.stream(testCouples)
                .forEach(testPair -> showTheResult(testPair));
    }

    private static void showTheResult(String[] testPair) {
        if (testPair == null || testPair.length != 2) {
            System.out.println("Wrong test arguments, array of two strings is expected.");
            return;
        }
        System.out.printf("possiblySame(\"%s\",\"%s\") -> %b \n", testPair[0], testPair[1], possiblySame(testPair[0], testPair[1]));
    }

    private static boolean possiblySame(String firstCaptcha, String secondCaptcha) {
        UnpackedString first = new UnpackedString(firstCaptcha);
        UnpackedString second = new UnpackedString(secondCaptcha);
        return first.possiblySame(second);
    }
}
