import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class CodeJamQ2 {

  public static String[] read(final String name) throws IOException {
    final InputStreamReader reader = new FileReader(new File(name));
    final char[] buf = new char[1024];
    int count = 0;
    final StringBuilder res = new StringBuilder();
    do {
      count = reader.read(buf);
      if (count > 0)
      res.append(buf, 0, count);
    } while (count != -1);
    return res.toString().trim().split("(\\r?\\n)+");
  }

  public static void main(final String[] args) throws Exception {
    final String[] input = read("B-small-attempt1.in");
    final FileWriter out = new FileWriter("out");

    final int casesCount = Integer.parseInt(input[0]);
    for (int caseN = 1; caseN <= casesCount; caseN++) {
      final String[] data = input[caseN].split("\\s+");
      final int n = Integer.parseInt(data[0]);
      final int s = Integer.parseInt(data[1]);
      final int p = Integer.parseInt(data[2]);
      final int[] totals = new int[n];
      for (int i = 0; i < totals.length; i++) {
        totals[i] = Integer.parseInt(data[i + 3]);
      }

      out.write("Case #" + caseN + ": " + solve(s, p, totals) + "\n");

    }

    out.close();
  }

  private static int solve(final int s, final int p, final int[] totals) {
    int count = 0;
    int reserv = s;
    for (int i = 0; i < totals.length; i++) {
      final int t = totals[i];
      if (t < p) { continue; }
      final int k = p * 3 - t;
      if (k <= 2) { count++; continue; }
      if (k <= 4 && reserv > 0) {
        count++;
        --reserv;
      }
    }
    return count;
  }

}
