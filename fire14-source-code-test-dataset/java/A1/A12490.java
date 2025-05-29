import java.io.*;
import java.util.Scanner;

public class Dance
{
  public static void main(String[] args)
    throws IOException
  {
    //new FileReader("dancing.in")
    Scanner input = new Scanner(System.in);
    int next = Integer.parseInt(input.nextLine());
    // PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("dancing.out")));
    
    for (int i = 1; i <= next; i++)
    {
      
      System.out.print("Case #" + i + ": ");
      int totalNums = input.nextInt();
      int numSurprises = input.nextInt();
      int bestScore = input.nextInt();
      
      int recordedSurprisesWithP = 0;
      int notSurprisesWithP = 0;
      for (int k = 0; k < totalNums; k++)
      {
        int temp = input.nextInt();
        if (temp == ((3 * bestScore) - 3) || temp == ((3 * bestScore) - 4))
        {
          if (bestScore != 1)
            recordedSurprisesWithP++;
        }
        else if (temp > (3 * bestScore) - 3)
          notSurprisesWithP++;
      }
      
      System.out.println(notSurprisesWithP + Math.min(numSurprises, recordedSurprisesWithP));
    }
  }
}