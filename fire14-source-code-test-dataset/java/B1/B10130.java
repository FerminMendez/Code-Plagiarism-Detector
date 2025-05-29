import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

   // class Scanner {
   // StreamTokenizer in;
   //
   // Scanner(InputStream stream) {
   // in = new StreamTokenizer(new BufferedReader(new
   // InputStreamReader(stream)));
   // in.resetSyntax();
   // in.whitespaceChars(0, 32);
   // in.wordChars(33, 255);
   // }
   //
   // String next() {
   // try {
   // in.nextToken();
   // return in.sval;
   // } catch (Exception e) {
   // throw new Error();
   // }
   // }
   //
   // long nextLong() {
   // return Long.parseLong(next());
   // }
   //
   // int nextInt() {
   // return Integer.parseInt(next());
   // }
   // }

   void asserT(boolean e) {
      if (!e) {
         throw new Error();
      }
   }

   void solve() {
      int nTests = in.nextInt();
      for (int i = 1; i <= nTests; i++) {
         out.println("Case #" + i + ": " + solveOne());
      }
   }

   long solveOne() {
      int a = in.nextInt();
      int b = in.nextInt();
      int size = (a + "").length();
      Set<Pair> set = new HashSet<Pair>();
      for (int i = a; i <= b; i++) {
         String temp = i + "";
         for (int j = 1; j < size; j++) {
            temp = temp.charAt(size - 1) + temp.substring(0, size - 1);
            int m = Integer.parseInt(temp);
            if (a <= m && m <= b && (m + "").length() == (i + "").length() && i != m) {
               Pair p = new Pair(i, m);
               set.add(p);
            }
         }

      }
      return set.size() / 2;
   }

   void run() {
      try{
         in = new Scanner(new FileReader("C-small-attempt0.in"));
         out = new PrintWriter("output.txt");
      }catch (Exception e) {
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