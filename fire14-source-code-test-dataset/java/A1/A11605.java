package com.cuteants.problems.codejam.y2012.qualification;

import java.util.Scanner;

public class DancingWithTheGooglers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner("100\n" +
                "3 1 5 15 13 11\n" +
                "3 0 8 23 22 21\n" +
                "2 0 8 21 24\n" +
                "3 0 6 15 15 14\n" +
                "3 0 0 17 8 1\n" +
                "2 1 9 20 26\n" +
                "3 0 1 18 18 23\n" +
                "3 0 9 5 23 24\n" +
                "2 2 7 28 11\n" +
                "3 0 5 13 5 30\n" +
                "1 0 1 0\n" +
                "3 0 8 7 17 21\n" +
                "1 0 7 2\n" +
                "1 1 4 7\n" +
                "2 0 5 27 3\n" +
                "3 0 9 24 5 23\n" +
                "1 1 1 15\n" +
                "1 0 10 27\n" +
                "1 0 3 30\n" +
                "2 2 6 28 12\n" +
                "2 0 8 21 28\n" +
                "3 1 8 30 3 5\n" +
                "1 0 10 30\n" +
                "3 3 6 5 13 22\n" +
                "3 0 0 30 30 30\n" +
                "1 0 8 20\n" +
                "2 0 3 20 16\n" +
                "3 1 2 3 9 2\n" +
                "1 0 10 26\n" +
                "3 0 6 14 8 14\n" +
                "3 2 1 2 13 18\n" +
                "1 1 2 22\n" +
                "2 1 6 20 24\n" +
                "3 1 10 26 0 27\n" +
                "2 0 5 12 11\n" +
                "3 3 5 22 17 12\n" +
                "1 0 0 15\n" +
                "2 0 6 23 14\n" +
                "3 2 2 22 7 15\n" +
                "3 2 1 24 0 11\n" +
                "3 0 1 28 14 25\n" +
                "2 2 6 15 20\n" +
                "1 0 2 3\n" +
                "2 0 8 21 20\n" +
                "3 0 5 0 12 0\n" +
                "3 0 5 25 25 7\n" +
                "3 0 9 27 22 3\n" +
                "2 1 4 11 15\n" +
                "1 0 9 1\n" +
                "2 1 9 8 27\n" +
                "3 3 4 4 17 15\n" +
                "2 0 1 3 18\n" +
                "2 1 10 25 30\n" +
                "1 0 1 13\n" +
                "3 3 0 20 26 5\n" +
                "3 2 10 4 9 18\n" +
                "1 0 10 30\n" +
                "3 1 4 9 9 9\n" +
                "3 1 9 24 23 23\n" +
                "3 2 10 9 12 4\n" +
                "1 0 4 24\n" +
                "2 1 10 30 23\n" +
                "3 0 2 6 22 1\n" +
                "2 0 10 21 2\n" +
                "1 0 3 5\n" +
                "1 1 0 26\n" +
                "3 1 3 5 9 5\n" +
                "3 0 4 8 8 9\n" +
                "2 0 6 6 15\n" +
                "2 2 2 15 9\n" +
                "2 0 3 21 5\n" +
                "2 1 7 27 28\n" +
                "3 0 8 9 3 21\n" +
                "3 1 3 6 5 30\n" +
                "2 2 0 24 2\n" +
                "2 0 10 2 15\n" +
                "3 2 2 7 1 15\n" +
                "1 0 4 8\n" +
                "1 0 10 17\n" +
                "1 0 10 23\n" +
                "1 0 4 5\n" +
                "1 0 8 12\n" +
                "2 0 2 2 2\n" +
                "3 0 4 8 6 4\n" +
                "1 1 4 28\n" +
                "2 2 1 9 10\n" +
                "1 1 6 8\n" +
                "1 1 2 21\n" +
                "1 0 6 14\n" +
                "3 1 10 30 28 4\n" +
                "3 1 6 15 15 14\n" +
                "2 0 7 10 17\n" +
                "3 2 2 3 3 3\n" +
                "2 0 7 17 17\n" +
                "3 1 6 14 24 14\n" +
                "2 2 0 18 26\n" +
                "3 0 0 0 0 0\n" +
                "3 0 3 5 5 0\n" +
                "1 0 6 14\n" +
                "2 1 6 14 14");
        int tests = sc.nextInt();
        for (int i = 1; i <= tests; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();

            int sum = 0;
            for (int j = 0; j < n; j++) {
                int t = sc.nextInt();
                int a = t / 3;
                switch (t % 3) {
                    case 0:
                        if (a >= p) {
                            // a + a + a
                            sum++;
                        } else if (s > 0 && a + 1 >= p && a >= 1 && a <= 9) {
                            // (a - 1) + a + (a + 1)
                            sum++;
                            s--;
                        }
                        break;
                    case 1:
                        if (a + 1 >= p) {
                            // a + a + (a + 1)
                            sum++;
                        }
                        break;
                    case 2:
                        if (a + 1 >= p) {
                            // a + (a + 1) + (a + 1)
                            sum++;
                        } else if (s > 0 && a + 2 >= p && a <= 8) {
                            // a + a + (a + 2)
                            sum++;
                            s--;
                        }
                        break;
                }
            }
            System.out.println("Case #" + i + ": " + sum);
        }
    }
}
