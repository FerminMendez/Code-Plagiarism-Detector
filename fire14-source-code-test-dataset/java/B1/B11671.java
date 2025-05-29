package com.codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C-small-attempt0.in"));
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println("Case #" + (i + 1) + ": " + solve(A, B));
        }

    }

    private static long solve(int a, int b) {

        if (a < 10) {
            return 0L;
        }

        long count = 0L;
        int len = (int) Math.floor((Math.log10((double) a)));

        int factor = 1;
        for (int i = 0; i < len; i++) {
            factor *= 10;
        }

        boolean[] mark = new boolean[b - a + 1];

        for (int n = a; n <= b; n++) {

            if (mark[n - a]) {
                continue;
            }

            int nn = n;

            Set<Integer> pairs = new HashSet<Integer>();
            pairs.add(nn);
            mark[nn - a] = true;
            for (int i = 0; i < len; i++) {
                nn = (nn % 10) * factor + nn / 10;
                if (nn >= a && nn <= b) {
                    pairs.add(nn);
                    mark[nn - a] = true;
                }
            }

            count += cn2(pairs.size());
        }

        return count;
    }

    private static long cn2(int size) {
        long s = (long) size;
        return s * (s - 1) / 2L;
    }

}
