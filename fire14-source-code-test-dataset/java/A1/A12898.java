import java.io.*;
import java.util.Scanner;

public class dancingWithTheGooglers
{
  
  public static void main (String[] args) throws IOException
  {
    
    File file = new File("in.txt");
    Scanner input = null;
    try
    {
      input = new Scanner(file);
    }
    catch(IOException e){}
    
    int T = input.nextInt();
    int N, S, p, t[];
    int scoreDiv, scoreMod;
    int score[] = new int[3];
    int solution;
    for (int i = 0; i < T; i++)
    {
      N = input.nextInt();
      S = input.nextInt();
      p = input.nextInt();
      t = new int[N];
      solution = 0;
      
      for (int j = 0; j < N; j++)
      {
        t[j] = input.nextInt();
        scoreDiv = t[j] / 3;
        scoreMod = t[j] % 3;
        
        score[0] = scoreDiv;
        score[1] = scoreDiv;
        score[2] = scoreDiv;
        for (int k = 0; k < scoreMod; k++)
        {
          score[k]++;
        }
        if(score[0] >= p || score[1] >= p || score[2] >= p)
          solution++;
        else
        {
          if (S > 0)
          {
            if (scoreMod == 0 || scoreMod == 2)
            {
              if (score[1] > 0)
              {
                score[0]++;
                score[1]--;
              }
              if (score[0] >= p)
              {
                solution++;
                S--;
              }
            }
            else if (scoreMod == 1)
            {
              if (score[2] > 0)
              {
                score[1]++;
                score[2]--;
              }
              if (score[0] >= p)
              {
                solution++;
                S--;
              }
            }
          }
        }
      }
      
      System.out.println("Case #" + (i + 1) + ": " + solution);
    }
    
  }
  
}