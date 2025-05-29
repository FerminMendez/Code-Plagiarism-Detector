package qr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("B-small-attempt3.in"));
    int tcn = scanner.nextInt();
    int tc = 1;
    while (tc <= tcn) {
      int n = scanner.nextInt();
      int s = scanner.nextInt();
      int p = scanner.nextInt();
      // int[] base = new int[n];
      int y = 0;

      for (int i = 0; i < n; i++) {
        int t = scanner.nextInt();
        int base = t / 3;
        int mmm = t % 3;
        if (mmm != 0) {
          base++;
        }

        if (base >= p) {
          if (mmm == 0 && t >= 0)
            y++;
          if (mmm == 1 && t >= 1)
            y++;
          if (mmm == 2 && t >= 2)
            y++;
        } else if (s > 0) {
          if (base + 1 == p) {
            if (mmm == 0 && t >= 3) {
              y++;
              s--;
            }
//            if (mmm == 1 && t >= 4) {
//              y+=0;
//              s--;
//            }
            if (mmm == 2 && t >= 2) {
              y++;
              s--;
            }

          }
        }
      }
      System.out.printf("Case #%d: %d\n", tc, y);

      // base >= p -> ok
      // base -1 -> can be ok

      tc++;
    }

  }
}
