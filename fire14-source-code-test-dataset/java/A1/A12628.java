package round0.p2;

import java.io.File;
import java.util.Scanner;

public class Main
{  
  public static void main(final String[] args) throws Exception
  {
    Scanner s = new Scanner(new File("D:\\unsorted\\b.in"));
    int T = s.nextInt();
    
    for (int i = 0; i < T; i++)
    {
      int N = s.nextInt();
      int S = s.nextInt();
      int p = s.nextInt();
      int[] t = new int[N];
      for (int j = 0; j < N; j++)
        t[j] = s.nextInt();
      
      int successes = 0;
      for (int j = 0; j < N; j++)
      {
        if (t[j] >= Math.max(p*3-2, p))
          successes++;
        else if (t[j] >= Math.max(p*3-4, p) && S > 0)
        {
          successes++;
          S--;
        }
      }
      
      System.out.println("Case #"+(i+1)+": "+successes);
    }
  }
}