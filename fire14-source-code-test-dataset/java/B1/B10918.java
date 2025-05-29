import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by IntelliJ IDEA.
 * User: Ran
 * Date: Apr 14, 2012
 * Time: 3:46:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class Recycled {

   private static int numDigits;

   private static int mult[] = {
         10, 100, 1000, 10000, 100000, 1000000, 10000000
   };

   private static int shift (int x)  {

      int lastDigit = x % 10;
      x = x / 10;
      x += lastDigit * mult[numDigits-2];

      return x;
   }
   
   private static boolean isPair (int x, int y) {

      for (int i = 0; i < numDigits - 1; i++) {
         x = shift (x);
         if (x == y)
            return true;
      }

      return false;
   }

   public static void main (String[] args) {

      Scanner s = null;
      try {
//         s = new Scanner (new File ("C-small-test.in"));
         s = new Scanner (new File ("C-small-attempt0.in"));
      } catch (FileNotFoundException e) {
         e.printStackTrace ();
      }

      int t = s.nextInt();

      // Traverse all test cases.
      for (int test = 1; test <= t; test++) {

         int a = s.nextInt();
         int b = s.nextInt();
         numDigits = (int)(Math.floor (Math.log10 (a))) + 1;

         int numPairs = 0;

         for (int i = a; i < b; i++)
            for (int j = i + 1; j <= b; j++)
               if (isPair (i, j))
                  numPairs++;

         System.out.println ("Case #" + test + ": " + numPairs);
      }
   }
}
