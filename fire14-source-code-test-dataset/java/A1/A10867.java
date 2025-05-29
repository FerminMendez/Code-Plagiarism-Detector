import java.io.*;
import java.util.*;

public class DanceScore
{
	int score;
	boolean surprise = false;
	boolean madeIt = false;
	
	public DanceScore(int score)
	{
		this.score = score;
	}
	
	private void p(String p)
	{
		//System.out.println(p);
	}
	
	public void process(int bestResult)
	{
		int goal = bestResult-2;
		int lastNumber = score-bestResult-bestResult;
		p("score " + score);
		
		p("goal " + bestResult);
		p("lastNumber " + lastNumber);
		if (lastNumber <0)
		{
			madeIt= false;
			surprise = false;
			return;
		}
		
		if (lastNumber >= goal)
			madeIt = true;
		
		int surpriseNumber = bestResult-4;
		if (lastNumber >= surpriseNumber)
			surprise = true;
			
		p("madeIt " + madeIt);
		p("surprise " + surprise);
	}
	
	public boolean surprise()
	{
		return surprise;
	}
	
	public boolean madeIt()
	{
		return madeIt;
	}
	
	
	public static int maxNumber(int[] scores, int numSurprises, int goal)
	{
		int madeItCount = 0;
		int surpriseCount = 0;
		for (int score : scores)
		{
			DanceScore danceScore = new DanceScore(score);
			danceScore.process(goal);
			if (danceScore.madeIt())
				madeItCount++;
			else if (danceScore.surprise())
				surpriseCount++;
		}
		
		if (surpriseCount > numSurprises)
			madeItCount += numSurprises;
		else madeItCount += surpriseCount;
		
		return madeItCount;
	}

	public static void main (String [] args)
	{
		try
		{
			InputStreamReader converter = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(converter);

			Integer numCases = Integer.valueOf(in.readLine());
			
			for (int i = 0; i < numCases; i ++)
			{
				String input = in.readLine();
				String[] values = input.split(" ");
				int numPeople = Integer.valueOf(values[0]);
				int numSurprises = Integer.valueOf(values[1]);
				int goal = Integer.valueOf(values[2]);
				int[] scores = new int[numPeople];
				for (int j = 0; j < numPeople ; j++)
				{
					scores[j] = Integer.valueOf(values[3+j]);
				}
				int maxNumber = maxNumber(scores, numSurprises, goal);
				System.out.println("Case #" + (i+1) + ": " + maxNumber);
			}
		} catch (Exception e)
		{
			throw new RuntimeException (e);
		}
	}
}