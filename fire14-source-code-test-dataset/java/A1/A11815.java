package es.uam.eps.abk.qualification2012;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Dancing With the Googlers
 *
 * You're watching a show where Googlers (employees of Google) dance, and then
 * each dancer is given a triplet of scores by three judges. Each triplet of scores
 * consists of three integer scores from 0 to 10 inclusive. The judges have very
 * similar standards, so it's surprising if a triplet of scores contains two
 * scores that are 2 apart. No triplet of scores contains scores that are more
 * than 2 apart.
 *
 * For example: (8, 8, 8) and (7, 8, 7) are not surprising.
 * (6, 7, 8) and (6, 8, 8) are surprising. (7, 6, 9) will never happen.
 *
 * The total points for a Googler is the sum of the three scores in that
 * Googler's triplet of scores. The best result for a Googler is the maximum
 * of the three scores in that Googler's triplet of scores.
 * Given the total points for each Googler, as well as the number of surprising
 * triplets of scores, what is the maximum number of Googlers that could have
 * had a best result of at least p?
 *
 * @author Alejandro
 */
public class B {

    private static void solve(InputStream in, PrintStream out) {
        Scanner scan = new Scanner(in);
        int T = scan.nextInt(); // test cases
        for (int t = 1; t <= T; t++) {
            int N = scan.nextInt(); // number of Googlers
            int S = scan.nextInt(); // number of surprising scores
            int p = scan.nextInt(); // best result

            int[] points = new int[N]; // total points
            for (int i = 0; i < N; i++) {
                points[i] = scan.nextInt();
            }

            int n = getGooglers(points, S, p);

            out.println("Case #" + t + ": " + n);
        }
    }

    private static int getGooglers(int[] points, int surprisingScores, int bestResult) {
        int n = 0;
        double[] avg = new double[points.length];
        for (int i = 0; i < points.length; i++) {
            avg[i] = 1.0 * points[i] / 3;
        }
        Arrays.sort(avg);
//        System.out.println(Arrays.toString(avg));
        for (int i = points.length - 1, j = 0; i >= 0 && j < surprisingScores; i--) {
            double m = Math.ceil(avg[i]);
            if ((m > 0.0) && (m < bestResult)) {
                avg[i] += 2.0 / 3;
                j++;
            }
        }
//        System.out.println(Arrays.toString(avg));
        for (int i = 0; i < points.length; i++) {
            double m = Math.ceil(avg[i]);
            if (m >= bestResult) {
                n++;
            }
        }
        for (int i = points.length - 1, j = 0; i >= 0 && j < surprisingScores; i--, j++) {
            avg[i] -= 2.0 / 3;
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        String file = null;
        file = "inputB2012.txt";

        file = "2012B-small-attempt0.in";

//        file = "A-large.in";

        InputStream in = new FileInputStream(file);
        PrintStream out = new PrintStream("output." + file);

        solve(in, out);

        in.close();
        out.close();
    }
}
