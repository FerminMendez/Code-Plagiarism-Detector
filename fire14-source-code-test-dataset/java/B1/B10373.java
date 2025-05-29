import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Recycled {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int t = Integer.parseInt(line);
    for (int i = 0; i < t; i++) {
      Set<String> set = new HashSet<String>();
      line = br.readLine();
      String[] split = line.split(" ");
      int A = Integer.parseInt(split[0]);
      int B = Integer.parseInt(split[1]);
      int digits = String.valueOf(A).length();
      if (digits != 1){
        for (int j = A; j <= B; j++) {
          String oldString = String.valueOf(j);
//          System.out.println("AA  " + oldString);
          for (int j2 = 1; j2 < digits; j2++) {
            String newString = oldString.substring(j2).concat(oldString.substring(0, j2));
            if(newString.charAt(0) == '0')continue;
            int newInt = Integer.valueOf(newString);
            if (newInt >= A && newInt <= B && j<newInt) {
//              System.out.println("BBB  " + newString);
              set.add(oldString+newString);
            }
          }
        }
      }
      System.out.println("Case #" + (i + 1) + ": " + set.size());
    }
  }

}
