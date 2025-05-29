import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Googlers implements Runnable {
    final Scanner in;
    final PrintWriter out;

    public Googlers() throws FileNotFoundException {
        out = new PrintWriter(getClass().getName().toLowerCase() + ".out");
        in = new Scanner(new File(getClass().getName().toLowerCase() + ".in"));
    }

    public static void main(String[] args) {
        try {
            new Googlers().run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        int tests = in.nextInt();
        for (int testcase = 1; testcase <= tests; testcase++) {
            out.print("Case #" + testcase + ": ");

            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            Set<Integer> surprise = new HashSet<Integer>();
            Set<Integer> standard = new HashSet<Integer>();

            for (int i = 0; i <= 10; i++) {
                for (int j = i; j <= 10; j++) {
                    for (int k = j; k <= 10; k++) {
                        if (k - i > 2) {
                            break;
                        }

                        if (k < p) {
                            continue;
                        }

                        if (k - i == 2) {
                            surprise.add(i + j + k);
                        } else {
                            standard.add(i + j + k);
                        }
                    }
                }
            }

            int[][] dyn = new int[n + 1][s + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= s; j++) {
                    if (surprise.contains(a[i - 1]) && j > 0) {
                        dyn[i][j] = Math.max(dyn[i][j], dyn[i - 1][j - 1] + 1);
                    }
                    if (standard.contains(a[i - 1])) {
                        dyn[i][j] = Math.max(dyn[i][j], dyn[i - 1][j] + 1);
                    }
                    dyn[i][j] = Math.max(dyn[i][j], dyn[i - 1][j]);
                }
            }
            out.println(dyn[n][s]);
        }

        out.close();
        in.close();
    }
}
