import java.util.*;
import java.io.*;

public class Recycled {

  public static void main(String[] args) {
    Recycled d = new Recycled();
    d.run();
  }

  public Recycled() {}


  public boolean isRecyclable(int n, int m) {
    boolean result = false;
    String mStr = m + "";
    String nStr = n + "";

    if (mStr.length() == 1) {
        return result;
    } 


    for (int i = 1; i < mStr.length(); i++) {
        String newM = mStr.substring(i) + mStr.substring(0, i);
        if (newM.equals(nStr)) {
            result = true;
            break;
        }
    }

    return result;
  }


  public void run() {
    Scanner sc = new Scanner(System.in);
    int testCases = sc.nextInt();

    for (int i = 0; i < testCases; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      int n = 0;
      int m = 0;

      int recyclable = 0;
      for (n = a; n < b; n++) {
        for (m = n+1; m <= b; m++) {
           if (isRecyclable(n, m)) {
             recyclable++;
           }
        }
      }

      System.out.println("Case #" + (i+1) + ": " + recyclable);
    }
  }
}

