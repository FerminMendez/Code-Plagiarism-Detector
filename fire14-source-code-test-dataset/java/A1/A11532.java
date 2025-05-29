import java.util.Scanner;
import java.io.File;

public class dancing
{
   Scanner in;
   int p;
   int s;
   int[] scores;
   int minScore;
   int minSurpScore;

   public dancing()
   {
      try
      {
         in = new Scanner(new File("input.txt"));
         in.nextLine();
         int count = 1;

         while(in.hasNextLine())
         {
            String line = in.nextLine();
            String[] inputCrap = line.split(" ");

            s = Integer.parseInt(inputCrap[1]);
            p = Integer.parseInt(inputCrap[2]);

            scores = new int[Integer.parseInt(inputCrap[0])];

            for(int i = 0; i < scores.length; i++)
            {
               scores[i] = Integer.parseInt(inputCrap[i+3]);
            }

            minScore = calcMinScore();
            minSurpScore = calcMinSurpScore();
            int total = countScores();

            System.out.println("Case #" + count + ": " + total);
            count++;
         }
      }

      catch(Exception e)
      {
         System.out.println("You messed up.");
         e.printStackTrace();
      }
   }

   public int calcMinSurpScore()
   {
      if(p < 2)
         return p;
      return 2 * (p-1) + (p-2);
   }

   public int calcMinScore()
   {
      if(p<2)
         return p;
      return 2 * (p-1) + p;
   }

   public int countScores()
   {
      int count = 0;

      for(int i = 0; i < scores.length; i++)
      {
         if(scores[i] >= minScore)
            count++;
         else if(scores[i] >= minSurpScore && s > 0)
         {
            count++;
            s--;
         }
      }

      return count;
   }

   public static void main(String[] args)
   {
      dancing d = new dancing();
   }

}
