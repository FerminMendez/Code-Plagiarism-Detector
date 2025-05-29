public class RecycledNumbers
{
   public static void main(String[] args)
   {
      java.util.Scanner console = new java.util.Scanner(System.in);

      int T = 0;
      int A = 0, B = 0;

      int numRecycledNumbers = 0;


      T = console.nextInt();
      console.nextLine();

      for (int i = 0; i < T; i++)
      {
         A = console.nextInt();
         B = console.nextInt();
         console.nextLine();

         // do stuff
         numRecycledNumbers = findRecycledNumbers(A, B);

         System.out.println("Case #" + (i + 1) + ": " + numRecycledNumbers);
      }      


      return;
   }


   private static int findRecycledNumbers(int A, int B)
   {
      int n = B;
      int magnitude= 0;
      int pairs = 0;
      boolean alreadySubtractedOne = false;

      String str_m = String.valueOf(A);
      String str_n = String.valueOf(B);

      String firstHalf = "";
      String secondHalf = "";

      // m = x.y * 10^magnitude
      // magnitude 1 less then number of digits
      magnitude = str_n.length() - 1; 


      // halfPower is used to retrieve the first half of m.
      int halfPower = 1;
      for (int i = 0; i < (magnitude + 1) / 2; i++)
         halfPower *= 10;


      for (int m = A; m <= B; m++)
      {
         str_m = String.valueOf(m);

         
         for (int j = magnitude ; j > 0; j--)
         {
            // Substring goes from start to end - 1, hence need to add 1
            // as 'magnitude' already has 1 subtracted from it.
            str_n = str_m.substring(j, magnitude + 1) + str_m.substring(0, j);


            n = Integer.parseInt(str_n);

            if ((n > m) && (n <= B))
            {
               // If m is of even length and first half matches second half
               // two duplicate entries can be generated, so subtract 1 from count
               // ie. xyz|xyZ => Zxyz|xy or z|xyZxy
               if (!alreadySubtractedOne &&
                  (((m % halfPower) * halfPower) == (m - (m % halfPower))))
               {
                  alreadySubtractedOne = true;
                  pairs--;
               }
               
               pairs++;
            }
         }
         
      }

      return pairs;
   }

}
