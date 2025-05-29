import java.io.*;
import java.util.*;
import java.math.*;

import static java.lang.System.out;
import static java.lang.Math.*;

public class BaiB implements Runnable {

  public void run() {
    int[][] C = new int[33][2];
    for (int[] a1 : C) Arrays.fill(a1, -1);
    for (int i = 0; i <= 10; ++i) {
      for (int j = 0; j <= 10; ++j) {
        for (int k = 0; k <= 10; ++k) if (abs(i - j) <= 2 && abs(j - k) <= 2 && abs(k - i) <= 2) {
          int sur = 0;
          if (abs(i - j) == 2 || abs(j - k) == 2 || abs(k - i) == 2) {
            sur = 1;
          }
          C[i + j + k][sur] = max(C[i + j + k][sur], max(i, max(j, k)));
        }
      }
    }
    int ntest = nextInt();
    for (int test = 1; test <= ntest; ++test) {
      int n = nextInt();
      int s = nextInt();
      int p = nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = nextInt();
      }
      int[][] F = new int[n + 1][n + 1];
      for (int[] a1 : F) Arrays.fill(a1, -1);
      F[0][0] = 0;
      for (int i = 0; i < n; ++i)
        for (int j = 0; j <= i; ++j)
          if (F[i][j] >= 0) {
            for (int k = 0; k < 2; ++k) if (C[a[i]][k] >= 0) {
              F[i + 1][j + k] = max(F[i + 1][j + k], F[i][j] + (C[a[i]][k] >= p ? 1 : 0));
            }
          }
      out.println("Case #" + test + ": " + F[n][s]);
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
        new BaiB().run();
    }
}