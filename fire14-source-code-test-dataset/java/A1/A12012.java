import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class B {

    private B() {
    }

    public static void main(final String[] args) throws Exception {
        final B a = new B();
        a.solve();
    }

    public void solve() throws Exception {
        final BufferedReader in = new BufferedReader(new FileReader(new File("f.in")));
        System.setOut(new PrintStream(this.getClass().getSimpleName() + ".out"));
        // StringTokenizer st;
        final String line = in.readLine();
        final int test = Integer.parseInt(line);
        for (int q=1; q <= test;q++) {
            final StringTokenizer st = new StringTokenizer(in.readLine());

            final int N = Integer.parseInt(st.nextToken());
            final int S = Integer.parseInt(st.nextToken());
            final int p = Integer.parseInt(st.nextToken());
            final int[] mas = new int[N];
            for (int i = 0; i < N; i++) {
                mas[i] = Integer.parseInt(st.nextToken());
            }

            final int[][] result = new int[N][3];
            for (int i = 0; i < N; i++) {
                result[i][0] = (mas[i] + 2) / 3; // Normal
                if (mas[i] == 0) {
                    result[i][1] = 0;
                    continue;
                }
                final int div = mas[i] / 3;
                final int mod = mas[i] % 3;
                if (mod == 0) {
                    result[i][1] = div + 1; // Suprised
                } else if (mod == 1) {
                    result[i][1] = -1; // Suprised
                } else if (mod == 2) {
                    result[i][1] = div + 2; // Suprised
                }
                // result[i][0] = (mas[i]+2)/3; //bonus
            }

            int res = 0;
            int added = 0;

            for (int i = 0; i < N; i++) {
                if (result[i][0] >= p) {
                    res++;
                    continue;
                }
                if (result[i][1] >= p) {
                    added++;
                    continue;
                }
            }

            res = res + Math.min(added, S);
            System.out.println("Case #" + q + ": " + res);
        }
    }
}
