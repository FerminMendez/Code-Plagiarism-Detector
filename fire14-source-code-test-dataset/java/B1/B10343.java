import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public void solve() throws IOException {
        int tests = nextInt();
        HashSet<Long> hs = new HashSet<Long>();
        for (int test=1; test<=tests; test++) {
            out.print("Case #"+test+": ");
            int a = nextInt();
            int b = nextInt();
            int t = Integer.valueOf(a).toString().length();
            int dp = 1;
            for (int i=1; i<t; i++) dp *= 10;
            int res = 0;
            for (int i=a; i<=b; i++) {
                int x = i;
                for (int j=1; j<t; j++) {
                    int d = x%10;
                    x /= 10;
                    x = x+d*dp;
                    if (x>i && x>=a && x<=b) {
                        hs.add(x*100l*dp+i);
                        res++;
                    }
                   // out.println(i+" "+x);
                }
            }
            res = hs.size();
            out.println(hs.size());
            hs.clear();
        }
    }






    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public void run() {
        try {
            //br = new BufferedReader(new InputStreamReader(System.in));
            //out = new PrintWriter(System.out);
            br = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
            solve();
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(123);
        }
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null)
                return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
