import java.util.Scanner;
import java.io.*;

public class Prob3 {
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(new File("D:/C-small-attempt0.in"));
    PrintStream out = new PrintStream(new File("D:/outputProb3.txt"));
    
    int lineAmount = Integer.parseInt(in.nextLine());
    
    for (int n = 1; n <= lineAmount; n++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int count = 0;
      
      for (int i = a; i <= b; i++) {

        for (int j = ("" + i).length()-1;j>=1; j--) { 
          if (!("" + i).substring(j, j+1).equals("0")) {
            String temp = ("" + i).substring(j, ("" + i).length());
            String x = temp+("" + i).substring(0, j);
            if (Integer.parseInt(x) >= a && Integer.parseInt(x) <= b && i != Integer.parseInt(x)) {
              count++;
            }
          }
        }
      }
  
      int y = count/2;
      out.println("Case #"+n+": "+y);
    }
    
    in.close();
    out.close();

  }
}