package qualification;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dancing {
    private static String fileName = "dancing-small";
    private static String inputFileName = fileName + ".in";
    private static String outputFileName = fileName + ".out";
    private static Scanner in;
    private static PrintWriter out;

    private void solve() {
        int N = in.nextInt();
        int S = in.nextInt();
        int p = in.nextInt();
        int allGood = (3 * p) - 2;
        int almostGood = allGood - 2;
        int sureGood = 0;
        int maybeGood = 0;
        for (int i = 0; i < N; i++) {
            int value = in.nextInt();
            if (value < p) {
                continue;
            }
            if (value >= allGood) {
                sureGood++;
                continue;
            }
            if (value >= almostGood) {
                maybeGood++;
                continue;
            }
        }
        int maxP = sureGood + (maybeGood > S ? S : maybeGood);
        out.print(maxP);
    }

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader(inputFileName));
        out = new PrintWriter(outputFileName);
        int tests = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= tests; t++) {
            out.print("Case #" + t + ": ");
            new Dancing().solve();
            out.println();
        }
        in.close();
        out.close();
    }

}
