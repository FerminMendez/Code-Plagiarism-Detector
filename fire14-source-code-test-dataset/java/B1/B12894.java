import java.util.Scanner;

public class RecycledNumbers {

   public static void main(String[] argv) {

      int lineCount,counter,mHold;
      int n,m,recycledNumbers;
      Scanner input = null;
      try { input = new Scanner(System.in); }
      catch (Exception e) { System.err.println("FileNotFoundException: " + e.getMessage()); }

      lineCount = input.nextInt();

      for (counter = 0; counter < lineCount; counter++) {
         recycledNumbers = 0;
         input.nextLine();
         n = input.nextInt();
         mHold = input.nextInt();
         m = mHold;

         for (; n < m; n++) {
            for (; m > n; m--) {
               if (Integer.toString(n).length() == Integer.toString(m).length()) {
                  if (checkRecycled(n,m))
                     recycledNumbers++;
               }
            }
            m = mHold;
         }
         
         System.out.printf("Case #%d: %d\n",counter+1,recycledNumbers);
      }
   }

   public static boolean checkRecycled(int n, int m) {
      int check,cursor;
      String toCheck;
      String holder = Integer.toString(n);

      for (cursor = holder.length() - 1; cursor > 0; cursor--) {
         toCheck = "";
         toCheck += holder.substring(cursor,holder.length());         
         toCheck += holder.substring(0,cursor);
         check = Integer.valueOf(toCheck);
         if (check == m)
            return true;
      }
      return false;
   }

}
