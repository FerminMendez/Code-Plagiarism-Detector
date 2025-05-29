import java.io.*;
import java.util.*;

public class RecycledNumbers {
  
  public static void main(String... args) throws IOException {
//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader reader = new BufferedReader(new FileReader("C-small-attempt0.in"));
//    PrintWriter writer = new PrintWriter(System.out);
    PrintWriter writer = new PrintWriter("C-small-attempt0.out");

    int len, cases = Integer.parseInt(reader.readLine());

    Set<Integer> unique = new HashSet<Integer>();
    String [] inputs;
    int A, B, k, mod, div, num;
    long res;
    for(int i = 1; i <= cases; i++){
      inputs = reader.readLine().split(" ");
      A = Integer.parseInt(inputs[0]);
      B = Integer.parseInt(inputs[1]);
      res = 0l;
      for(int j = A; j <= B; j++){
        unique.clear();
        k = j;
        int start = 10;
        while(k / start > 0){
          mod = k % start;
          if(mod >= (start / 10)){
            div = k / start;
            num = Integer.parseInt(mod + "" + div);
            if(num > j && num <= B){
              unique.add(num);
            }
          }
          start *= 10;
        }
        res += unique.size();
      }
      System.out.println("Case " + i + " complete");
      writer.println("Case #" + i + ": " + res);
    }

    writer.flush();
  }
}
