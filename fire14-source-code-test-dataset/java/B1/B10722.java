import java.util.Scanner;
import java.io.*;

public class Pair {
  public static int a, b, l;
  public static boolean inr(String x) {
    int t = Integer.parseInt(x);
    if ((t + "").length() != l) return false;
    if (t <= b && t >= a) {
      return true;
    }
    else return false;
  }
  
  public static String toS(int x) {
    String o = "";
    return o+x;
  }
  
  public static boolean notInT(String[] t, String x, int c) {
    for (int i = 0; i < c; i++) if (t[i].equals(x)) return false;
    return true;
  }
  
  public static int recycle(String s) {
    int count = 0;
    String[] t = new String[l];
    int c = 1;
    t[0] = s;
    for (int i = 0; i < l - 1; i++) {
      String a = s.substring(0, i + 1);
      String b = s.substring(i + 1, l);
      if (notInT(t, b + a, c)) {
        t[c] = b + a;
        c++;
      }
    }
    for (int i = 1; i < c; i++) {
      if (inr(t[i])) count++;
    }
    return count;
  }
  
  public static void main(String args[]) throws IOException {
    int count;
    Scanner in = new Scanner(new File("e:/in.txt"));
    PrintStream out = new PrintStream(new File("e:/out.txt"));
    int n = in.nextInt();
    for (int z = 1; z <= n; z++) {
        count = 0;
        a = in.nextInt();
        b = in.nextInt();
        l = (b + "").length();
        for (int i = a; i <= b; i++) {
          count += recycle(toS(i));
        }
        count /= 2;
        out.println("Case #"+z+": "+count);
    }
  }
}

