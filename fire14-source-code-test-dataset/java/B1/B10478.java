package qr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class C {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("C-small-attempt0.in"));
    int tcn = scanner.nextInt();
    int tc = 1;
    while (tc <= tcn) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int y = 0;
      // System.out.printf("%d %d\n", a, b);
      if (a > 9) {
        y = 0;
        for (int n = a; n < b; n++) {
          String ns = Integer.toString(n);
          // System.out.println("ns=" + ns);
          int len = ns.length();
          HashSet<Integer> sss = new HashSet<Integer>();
          for (int i = 1; i < len; i++) {
            String ns1 = ns.substring(0, i);
            String ns2 = ns.substring(i, len);
            // System.out.printf("ns1=%s ns2=%s\n",ns1,ns2);
            if (ns2.charAt(0) == '0')
              continue;
            String ms = ns2 + ns1;
            // System.out.println("ms="+ms);
            int m = Integer.parseInt(ms);
            if (sss.contains(m))
              continue;
            if (n < m && m <= b) {
              y++;
              sss.add(m);
//              System.out.printf("%d <= %d < %d <= %d\n", a, n, m, b);
            }
          }
        }
      }
      System.out.printf("Case #%d: %d\n", tc, y);

      tc++;
    }
  }
}
