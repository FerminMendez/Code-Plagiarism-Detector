import java.io.*;
import java.util.StringTokenizer;

public class DancingWithTheGooglers {
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
        final String name = "B-small-attempt0";
        MyScanner in = new MyScanner(name + ".in");
        PrintWriter out = new PrintWriter(name + ".txt");

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            int res = 0;
            for (int j = 0; j < n; j++) {
                int q = in.nextInt();
                int m = q / 3;
                if (q % 3 != 0) {
                    m++;
                }
                if (m >= p) {
                    res++;
                } else {
                    if (s > 0 && q >= p) {
                        if (q % 3 == 0 || q % 3 == 2) {
                            m++;
                        }
                        if (m >= p) {
                            s--;
                            res++;
                        }
                    }
                }
            }
            out.println("Case #" + i + ": " + res);
        }

        in.close();
        out.close();
    }
}

