package com.codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("B-small-attempt0.in"));
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int S = sc.nextInt();
            int p = sc.nextInt();

            int[] t = new int[N];
            for (int j = 0; j < N; j++) {
                t[j] = sc.nextInt();
            }

            System.out.println("Case #" + (i + 1) + ": " + solve(N, S, p, t));

        }

    }

    private static int solve(int N, int S, int p, int[] t) {

        int countA = 0, countB1 = 0, countB2 = 0, countC1 = 0, countC2 = 0, count = 0;
        for (int i = 0; i < N; i++) {
            int r = t[i] % 3, d = t[i] / 3;
            switch (r) {
            case 1:
                if (d + 1 >= p) {
                    countA++;
                }
                break;
            case 0:
                if (d == 0) {
                    if (d >= p) {
                        countB1++;
                    }
                } else if (d >= 10) {
                    if (d >= p) {
                        countB1++;
                    }
                } else if (d >= p) {
                    countB1++;
                } else if (d + 1 == p && d > 0) {
                    countB2++;
                }
                break;
            case 2:
                if (d >= 9) {
                    if (d + 1 >= p) {
                        countC1++;
                    }
                } else if (d + 1 >= p) {
                    countC1++;
                } else if (d + 2 == p) {
                    countC2++;
                }
                break;
            default:
                break;
            }
        }

        count = countA + countB1 + countC1 + Math.min(countB2 + countC2, S);
        return count;
    }

}
