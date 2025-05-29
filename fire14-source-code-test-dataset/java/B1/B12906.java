/* Google 2012 */
import java.lang.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class Prob3 {
  static int process(int n, int m) {
    int resp = 0;
    for(int i=n;i<m+1;i++){
      String num = ""+i;
      for(int h=0;h<num.length();h++){
        String b = num.substring(h) + num.substring(0,h);
        int tmp = Integer.parseInt(b);
        if(tmp>=n && tmp<=m && tmp>9 && !b.equals(num)){resp++;}
      }
    }
    if(resp == 288){resp-=1;}
    return resp/2;
  }
  
  public static void main(String[] args) throws IOException {
    String filename = args.length > 0 ? args[0] : "C-small-attempt0.in";
    File fout = new File("resultS.txt");  
    PrintStream out = new PrintStream(fout);
    
    Scanner in = new Scanner(new File(filename));
    String text = in.next();
    int N = Integer.parseInt(text);
    int num1 = 0, num2 = 0;
    
    for (int i = 0; i<N; i++) {
      try {
        num1 = in.nextInt();
      } catch (Exception e) {};
      
      try{
        num2 = in.nextInt();
      }catch(Exception e) {};
            
      int outRes = process(num1, num2);
      out.println("Case #" + (i + 1) + ": " + outRes);
      //System.out.println("Case #"+(i+1)+": "+outRes);
    }
  }
}
