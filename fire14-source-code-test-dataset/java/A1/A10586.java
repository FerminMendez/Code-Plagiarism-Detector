import java.util.*;

class Dancing
{
  public static int compute(int numGooglers, int numSurprising, int targetScore, int[]scores)
  {
    int count = 0;
    
    for(int i = 0; i < numGooglers; i++)
    {
      if(scores[i] >= targetScore && scores[i]/3 >= targetScore)
        count++;
      else if(scores[i] >= targetScore && scores[i]%3 > 0 && scores[i]/3 + 1 >= targetScore)
        count++;
      else if(scores[i] >= targetScore && numSurprising > 0 && scores[i]%3 == 0 && scores[i]/3 + 1 >= targetScore)
      {
        count++;
        numSurprising--;
      }
      else if(scores[i] >= targetScore && numSurprising > 0 && scores[i]%3 > 1 && scores[i]/3 + 2 >= targetScore)
      {
        count++;
        numSurprising--;
      }
    }
    
    return count;
  }
  
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int numCase, numSurprising, numGooglers, targetScore;
    int[] totalScores;
    
    numCase = sc.nextInt();
    
    for(int i = 0; i < numCase; i++)
    {
      numGooglers = sc.nextInt();
      numSurprising = sc.nextInt();
      targetScore = sc.nextInt();
      totalScores = new int[numGooglers];
      for(int j = 0; j < numGooglers; j++)
        totalScores[j] = sc.nextInt();
      
      System.out.println("Case #"+(i+1)+": "+compute(numGooglers, numSurprising, targetScore, totalScores));
    }
  }
}