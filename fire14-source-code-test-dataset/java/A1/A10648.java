import java.util.*;

public class B {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int N = scan.nextInt();
      scan.nextLine();
      for (int i = 1; i <= N; i++)
         System.out.println("Case #"+i+": "+solve(scan));
   }

   public static Object solve(Scanner scan) {
      int n = scan.nextInt(), s = scan.nextInt(), p = scan.nextInt();
      int out = 0, t;

      while (n-- > 0) {
         t = scan.nextInt();
         if ((t+2)/3 >= p || t > 1 && (t+4)/3 >= p && s-- > 0)
            out++;
      }

      return out+"";
   }
}
