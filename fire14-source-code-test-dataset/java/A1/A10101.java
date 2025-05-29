import java.util.*;

public class Main
{

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    Integer numCases = Integer.parseInt(in.nextLine());
    
    for (int i = 0; i < numCases; i++)
    {
      int num = in.nextInt();
	  int[] dancers = new int[num];
	  int surp = in.nextInt();
	  int p = in.nextInt();
	  
	  int count = 0;
	  
	  for (int k = 0; k < num; k++)
		dancers[k] = in.nextInt();
	  
	  for (int k = 0; k < num; k++)
	  {
		if (dancers[k] != 0)
		{
			int score = 0;
			if (dancers[k]/3 >= p)
				count++;
			else
			{
				score = (dancers[k]-p)/2;
				if (!(p-score > 2 || score-p > 2)) //Necessary?
				{
					if (p-score == 2 || score-p == 2)
					{
						if (surp != 0)
						{
							surp--;
							count++;
						}
					}
					else count++;
				}
			}
		}
		else
		{
			if (p == 0 && dancers[k] == 0)
				count++;
		}
	  }
	  
      System.out.println("Case #"+(i+1)+": "+count);
    }
  }

}