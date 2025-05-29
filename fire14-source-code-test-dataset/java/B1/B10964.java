import java.io.*;
import java.math.BigInteger;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * User: Igor Kirov
 * Date: 14.04.12
 */
public class C implements Runnable {

    private int recycle(int t, int multiplier) {
        int cc = t % 10;
        while (cc == 0) {
            t = t / 10;
            t = t + cc * multiplier;
            cc = t % 10;
        }
        t = t / 10;
        t = t + cc * multiplier;
        return t;
    }

    private void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();

        int temp = a / 10;
        int multiplier = 1;
        while (temp > 0) {
            multiplier *= 10;
            temp = temp / 10;
        }

        int ans = 0;
        boolean used[] = new boolean[b + 10];
        for (int i = a; i <= b; i++) {
            int next = recycle(i, multiplier);
            while (next != i) {
                if (next >= a && next <= b) {
                    ans++;
                }
                next = recycle(next, multiplier);
            }
        }
        writer.println(ans / 2);
    }

    public static void main(String[] args) {
        new Thread(null, new C(), "", 64 * 1024 * 1024).start();
    }

    StringTokenizer tokenizer;
    BufferedReader reader;
    PrintWriter writer;

    public void run() {
        try {
            try {
                Locale.setDefault(Locale.US);
            } catch (Exception ignored) {
            }

            reader = new BufferedReader(new FileReader("C.in"));
            writer = new PrintWriter(new FileWriter("C.out"));
            tokenizer = null;

            int tests = nextInt();
            for (int i = 0; i < tests; i++) {
                writer.printf("Case #%d: ", i + 1);
                solve();
                writer.flush();
            }

            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}