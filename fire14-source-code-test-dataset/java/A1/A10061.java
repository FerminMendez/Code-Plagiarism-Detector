
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class B {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    String ss = reader.readLine();
    int n = Integer.parseInt(ss);
    
    for (int i = 0; i < n; i++) {
      Map<String, Integer> map = new HashMap<String, Integer>();
      ss = reader.readLine();

      String[] parts = ss.split(" ");
      int N = Integer.parseInt(parts[0]);
      int S = Integer.parseInt(parts[1]);
      int p = Integer.parseInt(parts[2]);
      
      int good = 0;
      int sur = 0;
      int t = (p - 1) + (p - 1) + p;
      int y = p - 2 + p - 2 + p;

      if (p == 0) {
        t = 0;
        y = 0;
      }
      if (p == 1) {
        t = 1;
        y = 1;
      }
      if (p == 2) {
        t = 4;
        y = 2;
      }
      for (int j = 3; j < parts.length; j++) {
        int x = Integer.parseInt(parts[j]);
        if (x >= t) {
          good++;
        } else if (x >= y) {
          sur++;
        }
      }
      int res = good + Math.min(S,  sur);
      String sss = "Case #" + (i + 1) + ": " + res ;
      System.out.println(sss);
      
      
    }
  }
}
