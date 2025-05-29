import java.util.Scanner;
import java.io.*;

public class Google3 {
  public static void main(String[] args) throws IOException {
    Scanner kb = new Scanner(new File("c:/input.in"));
//    Scanner kb = new Scanner(System.in);
    int numCase = kb.nextInt();
    for (int i = 0; i < numCase; i++) {
      int numGoogler = kb.nextInt();
      int numSurprising = kb.nextInt();
      int p = kb.nextInt();
      int minSurprising = (p * 3) - 4;
      int minOrdinary = (p * 3) - 2;
      if (p == 0 || p == 1) {
        minSurprising = p;
        minOrdinary = p;
      }
      int count = 0;
      int countSurprising = 0;
      for (int j = 0; j < numGoogler; j++) {
        int point = kb.nextInt();
        if (point < minSurprising);
        else if (point >= minOrdinary) {
          count++;
        }
        else if (point >= minSurprising && point <= minOrdinary && countSurprising < numSurprising) {
          count++;
          countSurprising++;
        }
      }
      System.out.println("Case #" + (i + 1) + ": " + count);
    }
  }
}

