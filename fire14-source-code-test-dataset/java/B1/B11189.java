/**
 * RecycledNumbers.java
 *
 * Either use command line or first argument must be path of input file.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author bsanghvi
 */
public class RecycledNumbers {

   private static final Map<Integer, Long> PRODUCT_SUM_MAP = new HashMap<Integer, Long>();
   private static final Map<Integer, boolean[]> CONTAINS_DIGIT_MAP = new HashMap<Integer, boolean[]>();
   private static final Map<Integer, List<Integer>> DIGITS_MAP = new HashMap<Integer, List<Integer>>();

   /**
    * The main method.
    * 
    * @param args the arguments
    */
   public static void main(final String[] args) {
      try {
         final Scanner in;
         if (args.length >= 1) {
            in = new Scanner(new File(args[0]));
         } else {
            in = new Scanner(System.in);
         }

         final int T = in.nextInt();

         for (int test = 1; test <= T; test++) {
            final long result = processCase(in);
            System.out.println("Case #" + test + ": " + result);
         }
      } catch (final FileNotFoundException e) {
         e.printStackTrace();
      }
   }

   private static long processCase(final Scanner in) {
      long result = 0;

      final int A = in.nextInt();
      final int B = in.nextInt();

      for (int a = A; a < B; ++a) {
         final boolean[] aContainsDigit;
         final List<Integer> aDigits;
         final long aProductSum;
         if (PRODUCT_SUM_MAP.containsKey(a)) {
            assert (CONTAINS_DIGIT_MAP.containsKey(a));
            assert (DIGITS_MAP.containsKey(a));

            aContainsDigit = CONTAINS_DIGIT_MAP.get(a);
            aDigits = DIGITS_MAP.get(a);
            aProductSum = PRODUCT_SUM_MAP.get(a);
         } else {
            aContainsDigit = new boolean[10];
            aDigits = new ArrayList<Integer>();
            aProductSum = processNumber(a, aDigits, aContainsDigit);
         }

         for (int b = a + 1; b <= B; ++b) {
            final boolean[] bContainsDigit;
            final List<Integer> bDigits;
            final long bProductSum;
            if (PRODUCT_SUM_MAP.containsKey(b)) {
               assert (CONTAINS_DIGIT_MAP.containsKey(b));
               assert (DIGITS_MAP.containsKey(b));

               bContainsDigit = CONTAINS_DIGIT_MAP.get(b);
               bDigits = DIGITS_MAP.get(b);
               bProductSum = PRODUCT_SUM_MAP.get(b);
            } else {
               bContainsDigit = new boolean[10];
               bDigits = new ArrayList<Integer>();
               bProductSum = processNumber(b, bDigits, bContainsDigit);
            }

            if (aProductSum == bProductSum && Arrays.equals(aContainsDigit, bContainsDigit)
                  && cyclicEquals(aDigits, bDigits)) {
               ++result;
            }
         }
      }

      return result;
   }

   private static long processNumber(int n, final List<Integer> digits, final boolean[] digitContained) {
      assert (digitContained.length == 10);
      assert (digits.isEmpty());

      Arrays.fill(digitContained, false);
      int sum = 0;
      long product = 1;

      do {
         final int digit = n % 10;
         digits.add(digit);
         digitContained[digit] = true;
         sum += digit;
         if (digit != 0) {
            product *= digit;
         }
         n /= 10;
      } while (n > 0);

      Collections.reverse(digits);

      DIGITS_MAP.put(n, digits);
      CONTAINS_DIGIT_MAP.put(n, digitContained);
      final long productSum = product + sum;
      PRODUCT_SUM_MAP.put(n, productSum);

      return productSum;
   }

   private static boolean cyclicEquals(final List<Integer> a, final List<Integer> b) {
      if (a != null && b != null) {
         final int size = a.size();
         if (size == b.size()) {
            final int a0 = a.get(0);
            for (int i = 0; i < size; ++i) {
               if (a0 == b.get(i)) {
                  if (cyclicEquals(a, b, i)) {
                     return true;
                  }
               }
            }
         }
      }
      return false;
   }

   private static boolean cyclicEquals(final List<Integer> a, final List<Integer> b, final int bStartPosition) {
      assert (a != null);
      assert (b != null);
      final int size = a.size();
      assert (size == b.size());

      for (int i = 0, j = bStartPosition; i < size; ++i, ++j) {
         if (j >= size) {
            j = 0;
         }
         if (a.get(i) != b.get(j)) {
            return false;
         }
      }
      return true;
   }
}
