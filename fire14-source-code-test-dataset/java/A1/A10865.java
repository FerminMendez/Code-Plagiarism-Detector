import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new File("./src/B-small-attempt2.in"));
    BufferedWriter out = new BufferedWriter(new FileWriter("./src/output.out"));

    int T = in.nextInt();
    int s, p, n, v, a;
    int[] t;

    for (int zz = 0; zz < T; ++zz) {
      n = in.nextInt();
      s = in.nextInt();
      p = in.nextInt();
      t = new int[n];
      a = 0;
      v = (p - 2 < 0 ? 0 : p - 2);
      v *= 2;
      v += p;
      for (int i = 0; i < n; ++i) {
        t[i] = in.nextInt();
      }
      Arrays.sort(t);
      for (int i = 0; i < n; ++i) {
        if (p == 0) {
          ++a;
          continue;
        }
        if (p == 1 && t[i] > 0) {
          ++a;
          continue;
        }
        if (t[i] < v)
          continue;
        if ((t[i] == v || t[i] == v + 1) && s > 0) {
          --s;
          ++a;
        } else if (t[i] > v + 1)
          ++a;
      }
      out.write("Case #" + (zz + 1) + ": " + a + (zz + 1 == T ? "" : "\n"));
    }

    out.close();
    in.close();
  }
}