import java.io.*;
import java.util.*;
import java.math.*;

import static java.lang.System.out;
// import static java.lang.Math.*;

public class BaiC implements Runnable {

  public void run() {
    int ntest = nextInt();
    int[] ndigits = new int[2000001];
    for (int i = 0; i < 10; ++i) {
      ndigits[i] = 1;
    }
    for (int i = 10; i < ndigits.length; ++i) {
      ndigits[i] = ndigits[i / 10] + 1;
    }
    int[] p10 = new int[9];
    p10[0] = 1;
    for (int i = 1; i < p10.length; ++i)
      p10[i] = p10[i - 1] * 10;
    int[] s = new int[111];
    for (int test = 1; test <= ntest; ++test) {
      out.print("Case #" + test + ": ");

      int A = nextInt();
      int B = nextInt();

      int res = 0;
      for (int i = A; i < B; ++i) {
        int x = i;
        int nd = ndigits[x];
        int ns = 0;
        for (int k = 1; k < nd; ++k) {
          x = x / 10 + x % 10 * p10[nd - 1];
          if (i < x && x <= B) {
            boolean ok = true;
            for (int j = 0; j < ns; ++j) if (x == s[j]) ok = false;
            if (ok) {
              s[ns++] = x;
              ++res;
            }
          }
        }
      }

      out.println(res);
    }
  }

    int[] ar(int st, int en) { int[] res = new int[Math.max(en - st, 0)]; for (int i = st; i < en; ++i) res[i - st] = i; return res; }
    int[] ar(int n) { return ar(0, n); }
    void viet(Object...os) { System.err.println(Arrays.deepToString(os)); }
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer strtok = null;

    String nextStr() {
        try {
            while(strtok == null || !strtok.hasMoreTokens())
                strtok = new StringTokenizer(keyboard.readLine());
            return strtok.nextToken();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    int nextInt() {
        return Integer.parseInt(nextStr());
    }

    long nextLong() {
        return Long.parseLong(nextStr());
    }

    double nextDouble() {
        return Double.parseDouble(nextStr());
    }

    public static void main(String[] args) {
        new BaiC().run();
    }
}