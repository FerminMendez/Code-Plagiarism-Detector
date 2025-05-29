
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Igor
 */
public class Dancing {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");
        int testCount = in.nextInt();
        for (int test = 0; test < testCount; test++) {
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = in.nextInt();
            }
            Arrays.sort(score);
            int res = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (3 * p <= score[i]) {
                    res++;
                } else {
                    if (s > 0) {
                        if (3 * p - 2 <= score[i]) {
                            res++;
                        } else {
                            if (3 * p - 4 <= score[i] && 3 * p - 4 >= 0) {
                                res++;
                                s--;
                            }
                        }
                    } else {
                        if (3 * p - 2 <= score[i]) {
                            res++;
                        }
                    }
                }
            }
            out.println("Case #" + (test + 1) + ": " + res);
        }
        out.close();
    }
}
