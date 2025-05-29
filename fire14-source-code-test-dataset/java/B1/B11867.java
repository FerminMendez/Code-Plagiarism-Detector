package es.uam.eps.abk.qualification2012;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * Recycled Numbers
 *
 * Do you ever become frustrated with television because you keep seeing the same
 * things, recycled over and over again? Well I personally don't care about
 * television, but I do sometimes feel that way about numbers.
 *
 * Let's say a pair of distinct positive integers (n, m) is recycled if you can
 * obtain m by moving some digits from the back of n to the front without changing
 * their order. For example, (12345, 34512) is a recycled pair since you can
 * obtain 34512 by moving 345 from the end of 12345 to the front. Note that n
 * and m must have the same number of digits in order to be a recycled pair.
 * Neither n nor m can have leading zeros.
 *
 * Given integers A and B with the same number of digits and no leading zeros,
 * how many distinct recycled pairs (n, m) are there with A ≤ n < m ≤ B?
 *
 * @author Alejandro
 */
public class C {

    private static void solve(InputStream in, PrintStream out) {
        Scanner scan = new Scanner(in);
        int T = scan.nextInt(); // test cases
        for (int t = 1; t <= T; t++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            int n = getRecycled(a, b);

            out.println("Case #" + t + ": " + n);
        }
    }

    private static int getRecycled(int A, int B) {
        int r = 0;
        for (int n = A; n < B; n++) {
            for (int m = n + 1; m <= B; m++) {
                if (n == m) {
                    continue;
                }
                if (isRecycled(n, m, A, B)) {
                    r++;
                }
            }
        }
        return r;
    }

    private static boolean isRecycled(int A, int B, int AA, int BB) {
        String a = "" + A;
        String b = "" + B;
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            String aa = a.substring(i) + a.substring(0, i);
            if (("" + Integer.parseInt(aa)).equals(b)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String file = null;
        file = "inputC2012.txt";

        file = "2012C-small-attempt0.in";
        file = "2012C-small-attempt1.in";

//        file = "A-large.in";

        InputStream in = new FileInputStream(file);
        PrintStream out = new PrintStream("output." + file);

        solve(in, out);

        in.close();
        out.close();
    }
}
