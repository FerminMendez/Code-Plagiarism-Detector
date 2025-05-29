import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B {
  static int[] arr = new int[32];
  
  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(new File("B.in"));
    PrintWriter out = new PrintWriter(new File("B.out"));
    
    int T = s.nextInt();
    for (int tc = 1; tc <= T; tc++) {
      out.print("Case #" + tc + ": ");
      int N = s.nextInt();
      int S = s.nextInt();
      int p = s.nextInt();
      
      Arrays.fill(arr, 0);
      for (int i = 0; i < N; i++) arr[s.nextInt()]++;
      int ans = 0;
      for (int i = Math.max(3 * p - 2, 0); i <= 30; i++) ans += arr[i];
      int potential = 0;
      if (3 * p - 4 >= 2) potential += arr[3 * p - 4];
      if (3 * p - 3 >= 2) potential += arr[3 * p - 3];
      System.out.println(potential);
      ans += Math.min(potential, S);
      out.println(ans);
    }
    out.close();
  }
}
