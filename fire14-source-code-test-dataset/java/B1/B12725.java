import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class CodeJamQ3 {

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
    final String[] input = read("C-small-attempt0.in");
    final FileWriter out = new FileWriter("out");

    final int casesCount = Integer.parseInt(input[0]);
    for (int caseN = 1; caseN <= casesCount; caseN++) {
      final String[] data = input[caseN].split("\\s+");
      final int a = Integer.parseInt(data[0]);
      final int b = Integer.parseInt(data[1]);

      out.write("Case #" + caseN + ": " + solve(a, b) + "\n");

    }

    out.close();
  }

  private static long solve(final int a, final int b) {
    long count = 0;
    final HashSet<Tuple> check= new HashSet<Tuple>();
    for (int x = a; x <= b; x++) {
      final String s = String.valueOf(x);
//      int k = 0;
//      int equal = 0;
      for (int i = 1; i < s.length(); i++) {
        final int test = Integer.parseInt(s.substring(i) + s.substring(0, i));
        if (test <= b && test >= a && test > x) {
          final Tuple t = new Tuple(x, test);
          if (check.contains(t)) { continue; }
          check.add(t);
          ++count;
          System.out.println(x + " - "+ test);
        }

//        if (s.charAt(i) == s.charAt(i - 1)) { ++equal; }
//        if (s.charAt(0) <= s.charAt(i) && s.charAt(i) != '0') {
//          final int test = Integer.parseInt(s.substring(i) + s.substring(0, i));
//          if (b >= test) { ++k; }
//        }
      }
//      if (equal < s.length() - 1) { count += k; }
    }
    return count;
  }

  private static class Tuple {
    int x, y;
    Tuple(final int x, final int y) {this.x = x; this.y = y; }
    @Override
    public int hashCode() {
      return x + y;
    }
    @Override
    public boolean equals(final Object obj) {
      final Tuple t = (Tuple)obj;
      return t.x == x && t.y == y || t.x == y && t.y ==x;
    }
  }

}
