import java.io.*;
import java.util.*;

public class DancingWithTheGooglers
{
   static int surprise, target;
   static int [] scores;
   static int numGooglers;
   
   static int [][] matrix;
   public static void main(String[] args) throws IOException
   {
      Scanner scan = new Scanner(new File("b_small.in"));
      
      int numCases = scan.nextInt();
      for (int z = 1; z <= numCases; z++)
      {
         numGooglers = scan.nextInt();
         surprise = scan.nextInt();
         target = scan.nextInt();
         
         scores = new int[numGooglers];
         for (int i = 0; i < numGooglers; i++)
            scores[i] = scan.nextInt();
         
         matrix = new int[numGooglers][surprise+1];
         for (int [] arr : matrix)
            Arrays.fill(arr, -1);
         
         int max = magic(0, surprise);
         
         System.out.println("Case #"+z+": " + max);
      }
   }
   
   static int magic(int pos, int surpriseLeft)
   {
      if (surpriseLeft < 0)
         return -1000000;
      if (pos == numGooglers)
      {
         if (surpriseLeft != 0)
            return -1000000;
         else
            return 0;
      }
      
      if (matrix[pos][surpriseLeft] >= 0)
         return matrix[pos][surpriseLeft];

      int best = 0;
      for (int i = 0; i <= 10; i++)
      {
         for (int j = Math.max(i-2, 0); j <= Math.min(10,i+2); j++)
         {
            for (int k = Math.max(i-2, 0); k <= Math.min(10,i+2); k++)
            {
               if (Math.abs(i-j) > 2 || Math.abs(j-k) > 2 || Math.abs(i-k) > 2)
                  continue;
               if (i + j + k != scores[pos])
                  continue;

               int score = 0;
               if (i >= target || j >= target || k >= target)
                  score = 1;
               
               if (Math.abs(i-j) > 1 || Math.abs(j-k) > 1 || Math.abs(i-k) > 1)
                  best = Math.max(best, score+magic(pos+1, surpriseLeft-1));
               else
                  best = Math.max(best, score+magic(pos+1, surpriseLeft));
            }
         }
      }
      matrix[pos][surpriseLeft] = best;
      return best;
   }
}
