package codejam;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Dancing {
    Scanner in;
    PrintWriter out;
    int N;
    int P, S;

    public void solve() throws IOException {
        int tn = in.nextInt();
        in.nextLine();
        for (int test = 1; test <= tn; test++) {
            String line = in.nextLine();
            String[] numbers = line.split(" ");
            N = Integer.parseInt(numbers[0]);
            S = Integer.parseInt(numbers[1]);
            P = Integer.parseInt(numbers[2]);
            int[] x = new int[N];
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(numbers[3 + i]);
            }
            out.println("Case #" + test + ": " + calculate(x));
        }
    }

    boolean[] moreThanP = new boolean[N];
    boolean[] isSurprising = new boolean[N];
    boolean[] isSurprisingAndMoreThanP = new boolean[N];
    boolean[] seen = new boolean[N];

    private int calculate(int[] x) {
        moreThanP = new boolean[N];
        isSurprising = new boolean[N];
        isSurprisingAndMoreThanP = new boolean[N];
        seen = new boolean[N];
        int res = 0;
        Arrays.sort(x);
        //ArrayUtils.reverse(x);
        for (int i = 0; i < x.length; i++) {
            generate(x, i);
        }

        int i = 0;
        int s = S;
        while (i < N && s > 0) {
            if (isSurprisingAndMoreThanP[i]) {
                s--;
                res++;
                seen[i] = true;
            }
            i++;
        }
        i = 0;
        while (i < N && s > 0) {
           if (!seen[i] && isSurprising[i]) {
               s--;
               seen[i] = true;
           }
            i++;
        }

        i = 0;
        while (i < N) {
            if (!seen[i] && moreThanP[i]) {
                res++;
                seen[i] = true;
            }
            i++;
        }

        return res;
    }

    private void generate(int[] x, int index) {
        for (int a = 10; a >= 0; a--)
            for (int b = 10; b >= 0; b--)
                for (int c = 10; c >= 0; c--) {
                    if (a + b + c == x[index] && isValid(a, b,c)) {
                       if (getMax(a,b,c) >= P) {
                           if (isSurprising(a, b, c)) {
                               isSurprisingAndMoreThanP[index] = true;
                           } else {
                               moreThanP[index] = true;
                           }
                       }
                       else if (isSurprising(a, b, c)) {
                            isSurprising[index] = true;
                       }
                    }
                }
    }


    private boolean isValid(int a, int b, int c) {
        return Math.abs(a - b) <= 2 && Math.abs(b - c) <= 2 && Math.abs(c - a) <= 2;
    }

    private boolean isSurprising(int a, int b, int c) {
        return Math.abs(a - b) == 2 || Math.abs(b - c) == 2 || Math.abs(c - a) == 2;
    }

    private int getMax(int a, int b, int c) {
        return Math.max(Math.max(a, b),c );
    }


    public void run() {
        try {
            in = new Scanner(Googlerese.class.getResourceAsStream("/resources/B-small-attempt0.in"));
            out = new PrintWriter(new File("/tmp/ProblemB.out"));

            solve();

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        new Dancing().run();
    }


}
