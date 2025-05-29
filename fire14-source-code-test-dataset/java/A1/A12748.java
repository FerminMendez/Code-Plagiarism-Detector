/**
 * 
 * @author slerig
 *
 */

import java.io.*;
import java.util.*;

public class ScoreChecker {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File inFile = new File("B-small.in");
		PrintWriter outFile = new PrintWriter("B-small.out");
		Scanner in = new Scanner(inFile);
		
		int cases = in.nextInt();
		for(int i = 1; i <= cases; i++)
		{
			int googlers = in.nextInt();
			int surprising = in.nextInt();
			int minScore = in.nextInt();
			int googlersWithMin = 0;
			int[][] scores = new int[googlers][3];
			
			// Determining individual scores from total scores; before
			// surprising scores are taken into account.
			for(int j = 0; j < googlers; j++)
			{
				float score = in.nextLong();
				float ftemp = score / 3;
				int temp = (int)ftemp;
				if(ftemp - temp > 0.5)
				{
					scores[j][0] = temp + 1;
					scores[j][1] = temp + 1;
					scores[j][2] = temp;
				}
				else if(ftemp - temp > .25)
				{
					scores[j][0] = temp + 1;
					scores[j][1] = temp;
					scores[j][2] = temp;
				}
				else
				{
					for(int k = 0; k < 3; k++)
					{
						scores[j][k] = temp;
					}
				}
			}
			
			// Editing for surprising scores.
			for(int j = 0; j < googlers; j++)
			{
				// Very complicated way of deciding which scores are the surprising scores.
				if(surprising > 0 && scores[j][0] != 0 && scores[j][1] != 0 && scores[j][2] != 0)
					if(scores[j][0] != 10 && (scores[j][0] >= minScore-1 && scores[j][0] < minScore))
						if((scores[j][0] == scores[j][1]))
						{
							scores[j][0]++;
							scores[j][1]--;
							surprising--;
						}
			}
			
			// Checking for googlers with min score.
			for(int j = 0; j < googlers; j++)
			{
				if(scores[j][0] >= minScore)
					googlersWithMin++;
			}
			
			outFile.println("Case #" + i + ": " + googlersWithMin);
			
			/* Debugging code
			outFile.println();
			for(int j = 0; j < googlers; j++)
			{
				for(int k = 0; k < 3; k++)
				{
					outFile.print(scores[j][k] + " ");
				}
				outFile.println();
			}
			*/
		}
		outFile.close();
	}

}
