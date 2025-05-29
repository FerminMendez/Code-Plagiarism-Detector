package google2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main2 {

    static boolean[][] unsurprising = new boolean[11][31];
    static boolean[][] surprising = new boolean[11][31];

    public static void main(String[] args) throws FileNotFoundException {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                int t = Math.max(i, j);
                for (int k = 0; k <= 10; k++) {
                    int max = Math.max(t, k);
                    if (unsurp(i, j, k) || surp(i, j, k)) {
                        //System.out.println((i+j+k)+": "+i + ", " + j + ", " + k + ": " + unsurp(i, j, k) + ": " + surp(i, j, k));
                    }
                    for (int p = 0; p <= max; p++) {
                        unsurprising[p][i + j + k] |= unsurp(i, j, k);
                        surprising[p][i + j + k] |= surp(i, j, k);
                    }
                }
            }
        }

        Scanner sc = new Scanner(new File("B-small-attempt0.in"));
        PrintStream print = new PrintStream(new File("out2.txt"));
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            int out = check(sc);
            String t = "Case #" + (i + 1) + ": " + out;
            print.println(t);
            System.out.println(t);
        }
    }

    private static int check(Scanner sc) {
        int N = sc.nextInt();
        int S = sc.nextInt();
        int p = sc.nextInt();
        int maxPossible = 0;
        //System.out.println("Test");
        for (int i = 0; i < N; i++) {
            int test = sc.nextInt();
            //System.out.println(test + ", " + unsurprising[p][test] + ", " + surprising[p][test]);
            if (unsurprising[p][test]) {
                maxPossible++;
            } else if (S > 0 && surprising[p][test]) {
                S--;
                maxPossible++;
            }
        }
        return maxPossible;
    }

    static boolean unsurp(int i, int j, int k) {
        return unsurp(i, j) && unsurp(i, k) && unsurp(j, k);
    }

    static boolean unsurp(int i, int j) {
        return Math.abs(i - j) < 2;
    }

    static boolean surp(int i, int j, int k) {
        return !unsurp(i, j, k) && surp(i, j) && surp(i, k) && surp(j, k);
    }

    static boolean surp(int i, int j) {
        return Math.abs(i - j) <= 2;
    }
}
