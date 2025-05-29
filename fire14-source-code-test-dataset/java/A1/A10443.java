import java.util.Scanner;
import java.io.*;

public class Prob2 {
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(new File("D:/B-small-attempt0.in"));
    PrintStream out = new PrintStream(new File("D:/outputProb2.txt"));
    
    int lineAmount = Integer.parseInt(in.nextLine());
    
    for (int n = 1; n <= lineAmount; n++) {
      int m = in.nextInt();
      int s = in.nextInt();
      int p = in.nextInt();
      int y = 0, spare = 0;
      for (int i = 0; i < m; i++) {
        int a = in.nextInt();
        
        if (a == 0) {
          if (p == 0) y++;
        }
        
        else if (a % 3 == 0) {
          int k = a / 3;
          if (p <= k) y++;
          else if (p == k + 1) spare++;
        }
        
        else if (a % 3 == 1) {
          int k = (a - 1) / 3;
          if (p <= k + 1) y++;
        }
        
        else {
          int k = (a - 2) / 3;
          if (p <= k + 1) y++;
          else if (p == k + 2) spare++;
        }
      }
      
      if (s <= spare) y += s;
      else y += spare;
      
      out.println("Case #"+n+": "+y);
    }
    
    in.close();
    out.close();

  }
}
