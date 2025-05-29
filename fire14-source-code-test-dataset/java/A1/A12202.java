
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Westy92
 */

public class Dancing
{

   private BufferedReader stdin;

   /**
    * This method reads lines of input and sends them to a process method.
    * @throws IOException makes the compiler happy! :)
    */
   public void run() throws IOException
   {
      String line;
      int cases = 0, caseNum = 1;
      boolean done = false;
      stdin = new BufferedReader(new InputStreamReader(System.in));
      line = stdin.readLine();
      cases = Integer.parseInt(line);
      while (!done && cases >= caseNum)
      {
         line = stdin.readLine(); // returns null if end of input reached

         if (line == null)
         {
            done = true;
         }
         else
         {
            int output = readLine(line);
            System.out.println("Case #" + caseNum + ": " + output);
            caseNum++;
         }
      }
   }

   private int readLine(String line)
   {
      int goodCases = 0, keepTrack = 0;
      StringTokenizer st = new StringTokenizer(line);
      //Get num of Googlers
      int googlers = Integer.parseInt(st.nextToken());
      //Get num of Special Cases
      int numSpecial = Integer.parseInt(st.nextToken());
      //Get num to be greater than
      int num = Integer.parseInt(st.nextToken());
      while (st.hasMoreTokens() && keepTrack < googlers)
      {
         int temp = Integer.parseInt(st.nextToken());
         if (temp >= (num*3) - 2)
            goodCases++;
         else if (temp >= (num*3) - 4 && numSpecial > 0 && temp >= num)
         {
            goodCases++;
            numSpecial--;
         }
         keepTrack++;
      }
      return goodCases;
   }


   public static void main(String args[])
   {
      try
      {
         new Dancing().run();
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
      }

   }

}
