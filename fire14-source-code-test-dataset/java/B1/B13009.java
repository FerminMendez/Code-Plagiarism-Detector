package com.unitedcoders.examples.codejam;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class RecycledNumbers {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("/Users/nh/c.in"));
        PrintStream out = new PrintStream(new File("/Users/nh/c.out"));


        int testcases = scanner.nextInt();
        scanner.nextLine();
        for (int casenr = 1; casenr <= testcases; casenr++) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int p = solve(a, b);

            System.out.printf("Case #%d: %d\n", casenr, p);
            out.printf("Case #%d: %d\n", casenr, p);
        }
    }

    public static int solve(int a, int b) {

        int result = 0;

        String sA = intToString(a);
        String sB = intToString(b);

        for (int i = a; i <= b; i++) {
            if (i < 10) {
                continue;
            }

            String k = intToString(i);
            for (int j = 0; j < sA.length()-1; j++) {
                k = cycle(k);

                if((stringToInt(k)>i) && (stringToInt(k)<=b)){
                    result++;
                }

            }
        }

        return result;

    }

    public static String intToString(int i) {
        StringBuffer sb = new StringBuffer();
        while (i > 0) {
            sb.append(i % 10);
            i = i / 10;
        }

        return sb.reverse().toString();
    }

    public static int stringToInt(String s) {

        return Integer.valueOf(s);
    }

    public static String cycle(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < s.length(); i++) {
            sb.append(s.substring(i, i + 1));
        }
        sb.append(s.substring(0, 1));
        return sb.toString();

    }


}
