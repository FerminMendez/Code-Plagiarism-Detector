import java.io.*;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author Yuri Denison
 * @date 14.04.12
 */
public class GoogleCodeJamTaskB {
  private static void solve() throws IOException {
    final int t = rInt();
    for (int i = 1; i <= t; i++) {
      final int n = rInt();
      final int s = rInt();
      final int p = rInt();
      int[] results = new int[n];
      for (int j = 0; j < n; j++) {
        results[j] = rInt();
      }
      Arrays.sort(results);

      if (p == 0) {
        out.println(String.format("Case #%d: %d", i, n));
        continue;
      }
      int bestGooglers;
      int count1 = 0;
      int count2 = 0;

      final int limit1 = p + 2 * (p - 1);
      final int limit2 = (p > 1) ? p + 2 * (p - 2) : p;

      for (int j = 0; j < n; j++) {
        if (results[j] >= limit1) {
          count1 = results.length - j;
          break;
        }
      }
      for (int j = 0; j < n; j++) {
        if (results[j] >= limit2) {
          count2 = results.length - j;
          break;
        }
      }
      final int abs = count2 - count1;
      bestGooglers = count1 + ((s < abs) ? s : abs);

      out.println(String.format("Case #%d: %d", i, bestGooglers));
    }
  }

  public static void main(String[] args) throws IOException {
    Locale.setDefault(Locale.US);

    BufferedReader br;
    try {
      final String fileName = "B-small-attempt1";
      br = new BufferedReader(new FileReader(fileName + ".in"));
      out = new PrintWriter(new FileWriter(fileName + ".out"));
    } catch (Exception e) {
      br = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(new OutputStreamWriter(System.out));
    }
    st = new StreamTokenizer(br);

    solve();

    br.close();
    out.close();
  }

  private static StreamTokenizer st;
  private static PrintWriter out;

  static String rNext() throws IOException {
    st.nextToken();
    return st.sval;
  }

  static int rInt() throws IOException {
    st.nextToken();
    return (int) st.nval;
  }
}
