import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class B {
  
  
  public static void main(String[]args)throws Exception {
    File f = new File(args[0]);
    File out = new File(f.getParentFile(), f.getName()+".out");
    BufferedWriter w = new BufferedWriter(new FileWriter(out));
    Scanner s = new Scanner(f);
    int T = s.nextInt();
    s.nextLine();
    for (int t=1;t<=T;t++) {
      int N = s.nextInt();
      int S = s.nextInt();
      int p = s.nextInt();
      int[] totals = new int[N];
      for (int x=0; x<N; x++) {
        totals[x] = s.nextInt();
      }
      println(w, "Case #"+t+": "+solve(S, p, totals));
    }
    s.close();
    w.close();
  }
  
  private static String solve(int s, int p, int[] totals) {
    int min = p + Math.max(0,(p-1)) + Math.max(0,(p-1));
    int floor = p + Math.max(0,p-2) + Math.max(0,p-2);
    int num = 0;
    for (int x=0; x<totals.length; x++) {
      if (totals[x] >= min) {
        num++;
      } else if (totals[x] < floor) {
        continue;
      } else if (s > 0) {
        s--;
        num++;
      }
    }
    return String.valueOf(num);
  }

  static void println(BufferedWriter w, String s) throws IOException {
    System.out.println(s);
    w.write(s+"\n");
  }
}
