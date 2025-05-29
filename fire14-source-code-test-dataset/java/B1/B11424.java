import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class RecycledNumbers {
  public static String input = "easy.txt";
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(input));
    
    int n = Integer.parseInt(in.readLine());
    for (int i = 1; i <= n; i++) {
      String line = in.readLine();
      int idx1 = line.indexOf(' ');
      int a = Integer.parseInt(line.substring(0, idx1));
      int b = Integer.parseInt(line.substring(idx1 + 1));
      
      long totalCount = 0;
      Map<Map<Integer, Integer>, Long> signatureMap = new HashMap<Map<Integer, Integer>, Long>();
      
      for (int x = a; x <= b; x++) {
        totalCount += recycledNums(x, b);
      }
      
      System.out.println("Case #" + i + ": " + totalCount);
    }
  }

  private static int recycledNums (int n, int max) {
    List<Integer> digits = new LinkedList<Integer>();
    
    int remaining = n;
    while (remaining > 0) {
      int digit = remaining % 10;
      digits.add(digit);
      remaining /= 10;
    }
    
    //System.out.println("<<" + n + ">>");
    Set<Integer> nums = new HashSet<Integer>();
    for (int i = 0; i < digits.size() - 1; i++) {
      int n0 = digits.remove(0);
      digits.add(n0);
      int recycled = numFromList(digits);
      //System.out.println(recycled);
      if (recycled > n && recycled <= max) nums.add(recycled);
    }
    
    //System.out.println(n + ": " + nums);
    
    return nums.size();
  }
  
  private static int numFromList(List<Integer> list) {
    int num = 0;
    for (int i = list.size() - 1; i >= 0; i--) {
      num *= 10;
      num += list.get(i);
    }
    return num;
  }
}
