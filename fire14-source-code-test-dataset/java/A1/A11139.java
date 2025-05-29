/**
 * DancingWithTheGooglers.java
 *
 * Either use command line or first argument must be path of input file.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author bsanghvi
 */
public class DancingWithTheGooglers {

   private static final Map<Integer, Integer> scopesMap = new HashMap<Integer, Integer>();
   private static final Map<Integer, Integer> surprisingScoresMap = new HashMap<Integer, Integer>();

   static {
      scopesMap.put(30, 10); // 10, 10, 10

      scopesMap.put(29, 10); // 10, 10, 9

      scopesMap.put(28, 10); // 10, 9, 9
      surprisingScoresMap.put(28, 10); // 10, 10, 8

      scopesMap.put(27, 9); // 9, 9, 9
      surprisingScoresMap.put(27, 10); // 10, 9, 8

      scopesMap.put(26, 9); // 9, 9, 8
      surprisingScoresMap.put(26, 10); // 10, 8, 8

      scopesMap.put(25, 9); // 9, 8, 8
      surprisingScoresMap.put(25, 9); // 9, 9, 7

      scopesMap.put(24, 8); // 8, 8, 8
      surprisingScoresMap.put(24, 9); // 9, 8, 7

      scopesMap.put(23, 8); // 8, 8, 7
      surprisingScoresMap.put(23, 9); // 9, 7, 7

      scopesMap.put(22, 8); // 8, 7, 7
      surprisingScoresMap.put(22, 8); // 8, 8, 6

      scopesMap.put(21, 7); // 7, 7, 7
      surprisingScoresMap.put(21, 8); // 8, 7, 6

      scopesMap.put(20, 7); // 7, 7, 6
      surprisingScoresMap.put(20, 8); // 8, 6, 6

      scopesMap.put(19, 7); // 7, 6, 6
      surprisingScoresMap.put(19, 7); // 7, 7, 5

      scopesMap.put(18, 6); // 6, 6, 6
      surprisingScoresMap.put(18, 7); // 7, 6, 5

      scopesMap.put(17, 6); // 6, 6, 5
      surprisingScoresMap.put(17, 7); // 7, 5, 5

      scopesMap.put(16, 6); // 6, 5, 5
      surprisingScoresMap.put(16, 6); // 6, 6, 4

      scopesMap.put(15, 5); // 5, 5, 5
      surprisingScoresMap.put(15, 6); // 6, 5, 4

      scopesMap.put(14, 5); // 5, 5, 4
      surprisingScoresMap.put(14, 6); // 6, 4, 4

      scopesMap.put(13, 5); // 5, 4, 4
      surprisingScoresMap.put(13, 5); // 5, 5, 3

      scopesMap.put(12, 4); // 4, 4, 4
      surprisingScoresMap.put(12, 5); // 5, 4, 3

      scopesMap.put(11, 4); // 4, 4, 3
      surprisingScoresMap.put(11, 5); // 5, 3, 3

      scopesMap.put(10, 4); // 4, 3, 3
      surprisingScoresMap.put(10, 4); // 4, 4, 2

      scopesMap.put(9, 3); // 3, 3, 3
      surprisingScoresMap.put(9, 4); // 4, 3, 2

      scopesMap.put(8, 3); // 3, 3, 2
      surprisingScoresMap.put(8, 4); // 4, 2, 2

      scopesMap.put(7, 3); // 3, 2, 2
      surprisingScoresMap.put(7, 3); // 3, 3, 2

      scopesMap.put(6, 2); // 2, 2, 2
      surprisingScoresMap.put(6, 3); // 3, 2, 1

      scopesMap.put(5, 2); // 2, 2, 1
      surprisingScoresMap.put(5, 3); // 3, 1, 1

      scopesMap.put(4, 2); // 2, 1, 1
      surprisingScoresMap.put(4, 2); // 2, 2, 0

      scopesMap.put(3, 1); // 1, 1, 1
      surprisingScoresMap.put(3, 2); // 2, 1, 0

      scopesMap.put(2, 1); // 1, 1, 0
      surprisingScoresMap.put(2, 2); // 2, 0, 0

      scopesMap.put(1, 1); // 1, 0, 0

      scopesMap.put(0, 0); // 0, 0, 0
   }

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
            final int result = processCase(in);
            System.out.println("Case #" + test + ": " + result);
         }
      } catch (final FileNotFoundException e) {
         e.printStackTrace();
      }
   }

   private static int processCase(final Scanner in) {
      int result = 0;

      final int N = in.nextInt(); // number of Googlers
      int S = in.nextInt(); // number of surprising triplets of scores
      final int p = in.nextInt(); // best result
      final int[] t = new int[N];
      for (int i = 0; i < t.length; i++) {
         t[i] = in.nextInt();
      }

      for (final int ti : t) {
         if (scopesMap.containsKey(ti) && scopesMap.get(ti) >= p) {
            ++result;
         } else if (S > 0 && surprisingScoresMap.containsKey(ti) && surprisingScoresMap.get(ti) >= p) {
            ++result;
            --S;
         }
      }

      return result;
   }
}
