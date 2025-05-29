import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main implements Runnable {
    final String fileName = "B-small-attempt1";

    void solveCase(int test) throws Exception {
        out.print("Case #" + test + ": ");
        int n = nextInt();
        int s = nextInt();
        int p = nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            int c = t / 3 + (t % 3 >= 1 ? 1 : 0);
            if (c >= p)
                answer++;
            else if (s > 0 && t % 3 != 1 && t >= 2 && c < 10 && c + 1 >= p) {
                answer++;
                s--;
            }
        }
        out.println(answer);
    }

    void solution() throws Exception {
        int t = nextInt();
        for (int i = 0; i < t; i++)
            solveCase(i + 1);
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String l = in.readLine();
            if (l == null) return null;
            st = new StringTokenizer(l);
        }
        return st.nextToken();
    }

    public static void main(String args[]) {
        //Locale.setDefault(Locale.UK);
        new Thread(new Main()).start();
    }

    public void run() {
        try {
            in = new BufferedReader(new FileReader(fileName + ".in"));
            //out = new PrintWriter(System.out);
            out = new PrintWriter(fileName + ".out");
            solution();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(202);
        }
    }

    BufferedReader in;
    StringTokenizer st;
    PrintWriter out;
}