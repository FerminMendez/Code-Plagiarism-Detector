import java.io.*;
import java.util.*;

public class C {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new FileReader("C-small-attempt0.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("C-small-output.txt"));
    int T = sc.nextInt();
    int result;
    for (int k=1; k <= T; k++) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      Hashtable<Integer, String> allResults = new Hashtable<Integer, String>();
      String nString = "" + A;
      int numDigits = nString.length();     // find number of digits
      
      result = 0;
      for (int n=A; n<B; n++) {
        nString = "" + n;
        for (int j=0; j<numDigits; j++) {
          String recycleString = nString.substring(j) + nString.substring(0,j);
          int recycled = Integer.parseInt(recycleString);
          if ( (recycled>n) && (recycled<=B) ) {
            String mn = n + "," + recycled;
            if (!allResults.contains(mn)) {
              allResults.put(mn.hashCode(), mn);
              result++;
            }
          }
        }
      }
      System.out.format("Case #%d: %d\n", k, result);
      pw.format("Case #%d: %d\n", k, result);
    }
    
    pw.flush();
    pw.close();
    sc.close();
  }
}