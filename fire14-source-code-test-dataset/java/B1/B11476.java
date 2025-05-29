import java.util.Scanner;
import java.io.*;

public class Google2 {
  public static void main(String[] args) throws IOException {
    Scanner kb = new Scanner(new File("c:/A-small-attempt0.in"));
//    Scanner kb = new Scanner(System.in);
    int num = kb.nextInt();
    for (int i = 0; i < num; i++) {
      int a = kb.nextInt();
      int b = kb.nextInt();
      int count = 0;
      for (int j = a; j < b; j++) {
        for (int k = j + 1; k <= b; k++) {
          //System.out.println("++++ "+j + " " + k + " ");
          if (isRecycled(j, k)) {
            count++;
            //System.out.print(count);
          }
          //System.out.println();
        }
      }
      System.out.println("Case #" + (i + 1) + ": " + count);
    }
  }
  public static boolean isRecycled(int a, int b) {
    String n = a + "";
    String m = b + "";
    int numLength = n.length();
    for (int i = 1; i < numLength; i++) {
      if (n.substring(0, i).equals(m.substring(numLength - i, numLength)) && n.substring(i, numLength).equals(m.substring(0, numLength - i))) {
        //System.out.println(" true");
        return true;
      }
    }
    return false;
  }
}

