/**
 * Created by IntelliJ IDEA.
 * User: SONY
 * Date: 19.02.12
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main extends Thread {
    public Main(String inputFileName, String outputFileName) {
        try {
            this.input = new BufferedReader(new FileReader(inputFileName));
            this.output = new PrintWriter(outputFileName);
            this.setPriority(Thread.MAX_PRIORITY);
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(666);
        }
    }

    final int doit2() throws Throwable {
        int N = nextInt(), S = nextInt(), p = nextInt();
        int t[] = new int[N];
        for (int i = 0; i < N; ++i) t[i] = nextInt();
        int[][] dp = new int[N + 1][S + 2];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j <= Math.min(S, i); ++j) {
                int act = t[i];
                if (act >= 3 * p - 2) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + 1);
                } else {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                }
                if (act >= 2 && act <= 28) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
                    if (act >= Math.max(p, 3 * p - 4)) {
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
                    }
                }
            }
        }
        return dp[N][S];
    }

    final String doit(int ID) throws Throwable {
        return String.format("Case #%d: %d", ID, doit2());
    }


    private void solve() throws Throwable {
        int testCases = nextInt();
        for (int i = 1; i <= testCases; ++i) {
            output.println(doit(i));
        }
    }

    public void run() {
        try {
            solve();
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(666);
        } finally {
            output.close();
        }
    }

    public static void main(String... args) {
        new Main("input.txt", "output.txt").start();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private String next() throws IOException {
        while (tokens == null || !tokens.hasMoreTokens()) {
            tokens = new StringTokenizer(input.readLine());
        }
        return tokens.nextToken();
    }

    private StringTokenizer tokens;
    private BufferedReader input;
    private PrintWriter output;
}
