import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Submission
{
	public static final int numJudges = 3;
	
	public static void main(String[] args)
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
			
			int numCases = Integer.parseInt(in.readLine());
			
			for (int i=0; i<numCases; i++)
			{
				if (i != 0) { out.println(); }
				out.print("Case #"+(i+1)+": ");
				
				String s = in.readLine();
				String[] tokens = s.split(" ");
				if (tokens.length < 3) { throw new IllegalArgumentException("Bad input!"); }
				
				int remainingScoreRaises = Integer.parseInt(tokens[1]);
				final int requiredScore = Integer.parseInt(tokens[2]);
				
				int highScoringGooglers = 0;
				
				for (int j=3; j<tokens.length; j++)
				{
					final int totalScore = Integer.parseInt(tokens[j]);
					//maxScore = ceil (totalScore / numJudges)
					final int maxScore = (totalScore + numJudges - 1) / numJudges;
					
					if (maxScore >= requiredScore)
					{
						highScoringGooglers++;
					}
					else if (maxScore == requiredScore - 1 && totalScore%numJudges != 1
							&& remainingScoreRaises != 0 && maxScore >= 1 && maxScore <= 9)
					{
						highScoringGooglers++;
						remainingScoreRaises--;
					}					
				}
				
				out.print (highScoringGooglers);				
			}
			
			out.close();
		}
		catch (IOException e)
		{
			System.out.println ("Problem with file!");
		}
	}

}
