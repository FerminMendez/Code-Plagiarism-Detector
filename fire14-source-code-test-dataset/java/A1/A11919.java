import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Dancing2
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Scanner in = new Scanner(new File("222.in"));
		int numOfTests = Integer.parseInt(in.nextLine());
		
		for(int tests = 0; tests < numOfTests; tests++)
		{
			int googlers = in.nextInt();
			int specials = in.nextInt();  //Number of special cases
			int lookingFor = in.nextInt();  //Number it must contain at least
			
			int found = 0;
			int foundSpecials = 0;
			int[] googScores = new int[googlers];
			for(int googs = 0; googs < googlers; googs++)
			{
				googScores[googs] = in.nextInt();
			}
			Arrays.sort(googScores);
			for(int i = 0; i < googlers; i++)
			{
				
				int score = googScores[i];
				boolean completed = false;
				
				int[] scores = {lookingFor,lookingFor,lookingFor};
				if(scores[0] == 1)
				{
					scores[1] = 1;
					scores[2] = 1;
				}
				if(scores[0] == 0)
				{
					scores[1] = 0;
					scores[2] = 0;
				}
				while(!completed && specials != foundSpecials)
				{
					if((scores[0] + (scores[1]-2) + (scores[2]-2)) > score && scores[0] > 1)
						break;
					if(scores[0] < 2)
					{
						if(scores[0] > score)
							break;
					}
					if((scores[0] + (scores[1]-2) + (scores[2]-2)) == score && scores[0] > 1)
					{
						found += 1;
						foundSpecials += 1;
						completed = true;
						break;
					}
					if((scores[0] + (scores[1]-2) + (scores[2]-1)) == score && scores[0] > 1)
					{
						found += 1;
						foundSpecials += 1;
						completed = true;
						break;
					}
					if((scores[0] + (scores[1]-2) + (scores[2])) == score && scores[0] > 1)
					{
						found += 1;
						foundSpecials += 1;
						completed = true;
						break;
					}
					if((scores[0] + (scores[1]-1) + (scores[2]+1)) == score && scores[0] >= 1)//102
					{
						found += 1;
						foundSpecials += 1;
						completed = true;
						break;
					}
					if((scores[0] + (scores[1]) + (scores[2]+2)) == score ) //002
					{
						found += 1;
						foundSpecials += 1;
						completed = true;
						break;
					}
					if((scores[0] + (scores[1]+1) + (scores[2]+2)) == score) //012
					{
						found += 1;
						foundSpecials += 1;
						completed = true;
						break;
					}
					if((scores[0] + (scores[1]+2) + (scores[2]+2)) == score) //022
					{
						found += 1;
						foundSpecials += 1;
						completed = true;
						break;
					}
					scores[0] += 1;
					if (scores[0] >= 2)
					{
						scores[1] = (scores[0]);
						scores[2] = (scores[0]);
					}
					else
					{
						scores[1] = 1;
						scores[2] = 1;
					}
				}//end of while
				if((scores[0] + (scores[1]-1) + (scores[2]-1)) <= score && specials == foundSpecials && !completed)
				{
					found += 1;
				}
			}//end for(goog)
			System.out.println("Case #" + (tests+1) + ": " + found);
		}//end for(tests)
	}//end method
}//end class
					
				
				