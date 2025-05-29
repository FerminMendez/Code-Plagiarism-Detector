import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class recyle {
  
  public static int solve(String s) {
    String[] input = s.split(" ");
    String a = input[0];
    String b = input[1];
    if (a.length() != b.length()) return 0;
    if (Integer.parseInt(b) <= 10) return 0;
    int rotats = a.length();
    int largest = Integer.parseInt(b);
    int count = 0; 
    
    HashSet<Integer> done = new HashSet<Integer>();
    for (int i = Integer.parseInt(a); i <= largest; i++) {
      for (int j = 1; j < rotats; j++) {
        String n = String.valueOf(i);
        String x = n.substring(0, rotats - j);
        String y = n.substring(rotats - j);
        if (y.charAt(0) == '0') continue; // No zero startings
        int nn = (int) (Integer.parseInt(y) * Math.pow(10, rotats - j) + Integer.parseInt(x));
        if (nn == i || i >= nn || nn > largest) continue;
        //sb.append(n); sb.append(String.valueOf(nn));
        int key = nn << 8 | i;
        if (!done.contains(key)) {
          done.add(key);
          count++; 
        }
      }
    }
    return count;
  }
  
  public static void main(String[] args) {
    Scanner scanner = null;
    try {
      //scanner = new Scanner(System.in);
      scanner = new Scanner(new File("A-small-attempt0.in"));
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
    
    String c = scanner.nextLine();
    int i = 1;
    while (scanner.hasNextLine()) {
      String input = scanner.nextLine();
      System.out.println("Case #" + i + ": " + solve(input));
      i++;
    }
  }
}
