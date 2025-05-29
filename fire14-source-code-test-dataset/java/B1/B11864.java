import java.io.*;
import java.util.*;

public class C {

    MyScanner in;
    PrintWriter out;
    final static String FILENAME = "c";

    public static void main(String[] args) throws Exception {
        new C().run();
    }

    public void run() throws Exception {
        in = new MyScanner(FILENAME + ".in");
        out = new PrintWriter(FILENAME + ".out");

        int tests = in.nextInt();
        for (int test = 0; test < tests; test++) {
            out.println("Case #" + (test + 1) + ": " + solve());
        }

        out.close();
    }

    int ten(int length) {
        int ans = 1;
        for (int i = 0; i < length; i++) {
            ans *= 10;
        }
        return ans;
    }
    
    TreeSet<Integer> ts;
    
    int recycle(int n, int max) {
        int l = String.valueOf(n).length();
        int mod = ten(l - 1);
        int ans = 0;
        int m = n;
        String strm = String.valueOf(m);
        ts.clear();
        for (int i = 0; i < l; i++) {
            m = (m / 10) + (m % 10) * mod;
            if (m > n && m <= max && !ts.contains(m)) {
                ans++;
            }
            ts.add(m);
        }
        return ans;
    }
    
    
    public int solve() throws Exception {
        ts = new TreeSet<Integer>();
        int A = in.nextInt();
        int B = in.nextInt();
        int ans = 0;
        for (int n = A; n <= B; n++) {
            ans += recycle(n, B);
        }
        return ans;
    }

    class MyScanner {

        BufferedReader br;
        StringTokenizer st;

        public MyScanner(String file) throws Exception {
            br = new BufferedReader(new FileReader(file));
        }

        String next() throws Exception {
            while ((st == null) || (!st.hasMoreTokens())) {
                String t = br.readLine();
                if (t == null) {
                    return null;
                }
                st = new StringTokenizer(t);
            }
            return st.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }

        boolean nextBoolean() throws Exception {
            return Boolean.parseBoolean(next());
        }

        long nextLong() throws Exception {
            return Long.parseLong(next());
        }
    }
}
