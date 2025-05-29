import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

   class Pair {
      int a;
      int b;

      Pair(int a, int b) {
         this.a = a;
         this.b = b;
      }

      @Override
      public int hashCode() {
         final int prime = 31;
         int result = 1;
         result = prime * result + getOuterType().hashCode();
         result = prime * result + a;
         result = prime * result + b;
         return result;
      }

      @Override
      public boolean equals(Object o) {
         Pair second = (Pair) o;
         if (second == null) {
            return false;
         }
         return this.a == second.a && this.b == second.b || this.a == second.b && this.b == second.b;
      }

      private Main getOuterType() {
         return Main.this;
      }

   }

   Scanner in;
   PrintWriter out;

   void asserT(boolean e) {
      if (!e) {
         throw new Error();
      }
   }

   int maxDigitAtSurprise[] = new int[31];
   int maxDigitAtNotSurprise[] = new int[31];

   void solve() {

      for (int sum = 0; sum <= 30; sum++) {
         for (int c = 0; c <= 10; c++) {
            for (int p = 0; p <= 10; p++) {
               if (2 * c + p + 1 == sum && c + 1 <= 10 && Math.abs(c - p) <= 1 && Math.abs(c + 1 - p) <= 1) {
                  maxDigitAtNotSurprise[sum] =Math.max(maxDigitAtNotSurprise[sum],Math.max(c + 1, p));
               }
               if (3*c==sum){
                  maxDigitAtNotSurprise[sum] =Math.max(maxDigitAtNotSurprise[sum],c);
               }
            }
         }
         for (int c = 0; c <= 10; c++) {
            for (int p = 0; p <= 10; p++) {
               if (2 * c + p + 2 == sum && c + 2 <= 10 && Math.abs(c - p) <= 2 && Math.abs(c + 2 - p) <= 2) {
                  maxDigitAtSurprise[sum] =Math.max( maxDigitAtSurprise[sum],  Math.max(c + 2, p));
               }
            }
         }
      }
      int nTests = in.nextInt();
      for (int i = 1; i <= nTests; i++) {
         out.println("Case #" + i + ": " + solveOne());
      }
   }

   long solveOne() {
      int n = in.nextInt();
      int nSurp = in.nextInt();
      int minMax = in.nextInt();
      Set<Integer> surpIds = new TreeSet<Integer>();
      Set<Integer> notSuriIds = new TreeSet<Integer>();
      Set<Integer> bad = new TreeSet<Integer>();
      int cnt = 0;
      int nums[] = new int[n];
      for (int i = 0; i < n; i++) {
         nums[i] = in.nextInt();
         int sum = nums[i];
         if (maxDigitAtNotSurprise[sum] >= minMax && maxDigitAtSurprise[sum] >= minMax) {
            cnt++;
         }else if (maxDigitAtSurprise[sum]>=minMax){
            surpIds.add(i);
         }else if (maxDigitAtNotSurprise[sum]>=minMax){
            notSuriIds.add(i);
         }else{
            bad.add(i);
         }
      }
      
         cnt+=Math.min(surpIds.size(),nSurp )+notSuriIds.size();
      
      return cnt;

   }

   void run() {
      try {
         in = new Scanner(new FileReader("B-small-attempt1.in"));
       //  in = new Scanner(System.in);
         out = new PrintWriter("output.txt");
      } catch (Exception e) {
         // TODO: handle exception
      }
      try {
         solve();
      } finally {
         out.close();
      }
   }

   public static void main(String[] args) {
      new Main().run();
   }
}