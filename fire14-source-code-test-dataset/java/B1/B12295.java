/**
 * Created by IntelliJ IDEA.
 * User: SONY
 * Date: 19.02.12
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.util.*;


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
    
    static int pow[] = new int[7];

    static int transform[][] = new int[2000001][];
    
    static {
        pow[0] = 1;
        HashSet<Integer> helper = new HashSet<Integer>();
        for (int i = 1; i <= 6; ++i) pow[i] = pow[i - 1] * 10;
        for (int init = 1; init < transform.length; ++init) {
            int shiftsCount = getDigitsCount(init), n = 0;
            helper.clear();
            for (int currentShift = 1; currentShift < shiftsCount; ++currentShift) {
                int left = init / pow[currentShift], right = init % pow[currentShift];
                int result = right * pow[shiftsCount - currentShift] + left;
                if (result != init) helper.add(result);
            }
            transform[init] = new int[helper.size()];
            for (int t : helper) {
                transform[init][n++] = t;
            }
        }
    }

    static final int getDigitsCount(int what) {
        String represents = Integer.toString(what);
        return represents.length();
    }

    final long doit2() throws Throwable {
        int A = nextInt(), B = nextInt();
        long result = 0;
        for (int i = A; i <= B; ++i) {
            for (int j = 0; j < transform[i].length; ++j) {
                if (transform[i][j] >= A && transform[i][j] <= B) ++result;
            }
        }
        return result / 2;
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
