import java.io.*;
import java.util.StringTokenizer;

public class RecycledNumbers {
    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(String fileName) throws IOException {
            br = new BufferedReader(new FileReader(new File(fileName)));
        }

        public String nextToken() throws IOException, NullPointerException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public String nextString() throws IOException, NullPointerException {
            st = null;
            return br.readLine();
        }

        public Integer nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        void close() throws IOException {
            br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        final String name = "C-small-attempt0";
        MyScanner in = new MyScanner(name + ".in");
        PrintWriter out = new PrintWriter(name + ".txt");

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int res = 0;
            for (int n = a; n < b; n++) {
                int m = n;
                int l = 0;
                int k = 1;
                while (m != 0) {
                    m /= 10;
                    l++;
                    k *= 10;
                }
                m = n;
                k /= 10;
                int[] w = new int[l];
                for (int j = 1; j < l; j++) {
                    m = (m % 10) * k + m / 10;
                    w[j] = m;
                    boolean f = true;
                    for (int q = 1; q < j; q++) {
                        if (m == w[q]) {
                            f = false;
                            continue;
                        }
                    }
                    if (m > n && a <= m && m <= b && f) {
                        res++;
                    }
                }
            }
            out.println("Case #" + i + ": " + res);
        }

        in.close();
        out.close();
    }
}

