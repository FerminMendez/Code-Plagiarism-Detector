import java.util.*;
import java.lang.Math;

public class RecycledNumbers {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int numCases, currentCase, A, B, n, m, answer, currentNum;
      ArrayList<Integer> recycles;

      numCases = scan.nextInt();
      currentCase = 0;
      while (currentCase < numCases) {
         currentCase++;
         A = scan.nextInt();
         B = scan.nextInt();
         answer = 0;
         for (int j = A; j <= B; j++) {
            recycles = new ArrayList<Integer>();
            n = currentNum = j;
            while (currentNum > 0) {
               recycles.add(0, currentNum % 10);
               currentNum = currentNum / 10;
            }
            for (int k = 1; k < recycles.size(); k++) {
               m = 0;
               for (int l = 0; l < recycles.size(); l++) {
                  m += (recycles.get((k + l) % recycles.size()) * Math.pow(10, recycles.size() - l - 1));
               }
               if (m > n && m <= B) {
                  answer++;
               }
            }
         }
         System.out.printf("Case #%d: %d\n", currentCase, answer);
      }
   }
}
