package org.rudy.cj2012;

import java.io.*;
import java.util.Scanner;

/**
 * User: rudy
 */
public class Dancing {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream("B-small-attempt0.in")));
        PrintStream out = new PrintStream(new FileOutputStream("B-small.out"));
        int nTests = scanner.nextInt();
        for (int test = 1; test <= nTests; test++) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int p = scanner.nextInt();
            int [] t = new int[n];
            int potential = 0;
            int already = 0;
            for (int f = 0; f < n; f++) {
                t[f] = scanner.nextInt();
                int minScore = (t[f]+2) / 3;
                int maxScore = (t[f]+4) / 3;
                if (minScore >= p) {
                    already++;
                    continue;
                }
                if (maxScore >=p && t[f] > 1)
                    potential++;
            }

            out.printf("Case #%d: %d\n", test, already + Math.min(potential, s));
        }
        out.close();
    }
}
