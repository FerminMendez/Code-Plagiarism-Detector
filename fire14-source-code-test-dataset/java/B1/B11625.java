import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Recycled {
  public static void main(String[] args) {
    try {
      //File input = new File("/Users/mtervahauta/Dev/mikkot/codejam/recycled.input");
      File input = new File(args[0]);
      FileInputStream fStream = new FileInputStream(input);
      BufferedReader bReader = new BufferedReader(
          new InputStreamReader(fStream));
      int cases = Integer.parseInt(bReader.readLine());
      for (int i = 1; i <= cases; i++) {
        String[] values = bReader.readLine().trim().split(" ");
        solveRecycled(i, values[0], values[1]);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void solveRecycled(int caseNo, String aStr, String bStr) {
    long a = Long.parseLong(aStr);
    long b = Long.parseLong(bStr);
    Set<String> nms = new HashSet<String>();
    for (long n = a; n <= b; n++) {
      findM(nms, a, n, b);
    }
    System.out.println("Case #" + caseNo + ": " + nms.size());
  }

  private static void findM(Set<String> nms, long a, long n, long b) {
    List<Long> recycledValues = recycledStrings(Long.toString(n));
    for (Long recycledN : recycledValues) {
      long m = recycledN.longValue();
      if (n < m && m <= b) {
        nms.add(n+":"+m);
      }
    }
  }

  private static List<Long> recycledStrings(String src) {
    List<Long> resp = new ArrayList<Long>();
    int length = src.length();
    String recycled = null;
    for (int i = 1; i < length; i++) {
      recycled = src.substring(length - i);
      recycled = recycled + src.substring(0, length - i);
      if (!recycled.startsWith("0"))
        resp.add(new Long(Long.parseLong(recycled)));
    }
    return resp;
  }
 }