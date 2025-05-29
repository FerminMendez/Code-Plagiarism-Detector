import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class B {
  
  
  public static void main(String[]args)throws Exception {
    File f = new File(args[0]);
    File out = new File(f.getParentFile(), f.getName()+".out");
    BufferedWriter w = new BufferedWriter(new FileWriter(out));
    Scanner s = new Scanner(f);
    int T = s.nextInt();
    s.nextLine();
    for (int t=1;t<=T;t++) {
      int A = s.nextInt();
      int B = s.nextInt();
      println(w, "Case #"+t+": "+solve(A,B));
      s.nextLine();
    }
    s.close();
    w.close();
  }
  
  private static String solve(int A, int B) {
    int num = 0;
    Set<String> set = new HashSet<String>();
    for (int i=A; i<=B; i++) {
      int[] check = check(i);
      for (int j = 0; j < check.length; j++) {
        if (check[j] <= i) continue;
        if (check[j] >i && check[j] <=B)
          set.add(i+":"+check[j]);
      }
    }
    return ""+set.size();
  }
  static int[] check(int i) {
    String s = String.valueOf(i);
    int[] ret = new int[s.length()-1];
    for (int x=0;x<s.length()-1;x++) {
      s = s.charAt(s.length() - 1) + s.substring(0, s.length()-1);
      if (s.charAt(0)=='0')continue;
      ret[x] = Integer.parseInt(s);
    }
    return ret;
  }

  static void println(BufferedWriter w, String s) throws IOException {
    System.out.println(s);
    w.write(s+"\n");
  }
}
