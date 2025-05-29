/**
 ID: jerryma1
 LANG: JAVA
 PROG: B
 */

import java.io.*;
import java.util.*;

public class B {
  static BufferedReader cin, in;
  static StringTokenizer tk;
  static PrintWriter out;
  static int [] d = {0, 1, 4, 7, 10, 13, 16, 19, 22, 25, 28};
  static int [] m = {100, 100, 2, 5, 8, 11, 14, 17, 20, 23, 26};
  static int [] x = new int[3];
  static boolean surprising = false;
  static int maxScore;
  public static void main (String [] args) throws IOException {
    init();
    int numTests = gInt();
    for (int count = 1; count <= numTests; count ++) {
      int numPeople = gInt(), numSurprising = gInt(), min = gInt();
      int ans = 0;
      for (int count2 = 0; count2 < numPeople; count2 ++) {
        int s = gInt();
        System.out.printf("%d %d %d\n", count, count2, s);
        maxScore = -100;
        surprising = false;
        find(0, 0, s);
        if (maxScore >= min) {
          ans ++;
          if (count == 100)
            System.out.printf("%d %d %d\n", x[0], x[1], x[2]);
          continue;
        }
        maxScore = -100;
        surprising = true;
        find(0, 0, s);
        if (maxScore >= min && numSurprising > 0) {
          ans ++;
          numSurprising --;
        }
      }
      out.printf("Case #%d: %d\n", count, ans);
    }
    quit();
  }
  public static int abs (int a, int b) {
    if (a > b)
      return a - b;
    return b - a;
  }
  public static void find (int cur, int sum, int score) {
    if (cur == 3) {
      if (sum == score) {
        int maxDiff = abs(x[0], x[1]);
        int b = abs(x[1], x[2]), c = abs(x[2],x[0]);
        if (b > maxDiff)
          maxDiff = b;
        if (c > maxDiff)
          maxDiff = c;
        int m = x[0];
        if (x[1] > m)
          m = x[1];
        if (x[2] > m)
          m = x[2];
        if (surprising && maxDiff == 2) {
          if (m > maxScore)
            maxScore = m;
        }
        else if (!surprising && maxDiff < 2) {
          if (m > maxScore)
            maxScore = m;
        }
      }
      return;
    }
    for (int count = 0; count <= 10; count ++) {
      x[cur] = count;
      find(cur + 1, sum + count, score);
    }
  }
  public static int min (int a, int b) {
    if (a < b)
      return a;
    return b;
  }
  public static void init () throws IOException {
    cin = new BufferedReader(new InputStreamReader(System.in));
    in = new BufferedReader(new FileReader("B.in"));
    tk = new StringTokenizer("");
    out = new PrintWriter(new BufferedWriter(new FileWriter("B.out")));
  }
  public static void quit () throws IOException {
    System.out.flush();
    out.close();
    System.exit(0);
  }
  public static String token () throws IOException {
    while (!tk.hasMoreTokens())
      tk = new StringTokenizer(in.readLine());
    return tk.nextToken();
  }
  public static int gInt () throws IOException {
    return Integer.parseInt(token());
  }
  public static long gLong () throws IOException {
    return Long.parseLong(token());
  }
  public static double gDouble () throws IOException {
    return Double.parseDouble(token());
  }
}
