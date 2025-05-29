import java.util.Vector;


public class ScoreSet implements Runnable
{
	int NumGooglers;
	int NumSuprises;
	int BestResult;
	int[] Totals;
	int Result;
	public ScoreSet(String line)
	{
		String[] fields = line.split(" ");
		NumGooglers = Integer.parseInt(fields[0]);
		NumSuprises = Integer.parseInt(fields[1]);
		BestResult = Integer.parseInt(fields[2]);
		Totals = new int[NumGooglers];
		for(int g = 0; g < NumGooglers; g ++)
		{
			Totals[g] = Integer.parseInt(fields[3 + g]);
		}
	}

	@Override
	public void run() 
	{
		int[][][] ScoreSet = new int[NumGooglers][][];
		for(int g = 0; g < NumGooglers; g ++)
		{
			ScoreSet[g] = GenerateScore(Totals[g]);
		}
		int[] Tracker = new int[NumGooglers];
		int Best = 0;
		do
		{
			int supprise = 0;
			for(int g = 0; g < NumGooglers; g ++)
			{
				if(isSuprise(ScoreSet[g][Tracker[g]]))
				{
						supprise ++;
				}
			}
			if(supprise == NumSuprises)
			{
				int thisBest = 0;
				for(int g = 0; g < NumGooglers; g ++)
				{
					for(int s = 0; s < 3; s ++)
					{
						if(getBest(ScoreSet[g][Tracker[g]]) >= BestResult)
						{
							thisBest ++;
							break;
						}
					}
				}
				if(thisBest > Best)
					Best = thisBest;
			}
		}while(incrementTracker(Tracker, ScoreSet, NumGooglers -1));
		Result = Best;
		
	}
	
	public int getResult()
	{
		return Result;
	}
	private boolean isValid(int[] Score)
	{
		if(Math.abs(Score[0] - Score[1]) > 2)
			return false;
		else if(Math.abs(Score[0] - Score[2]) > 2)
			return false;
		else if(Math.abs(Score[1] - Score[2]) > 2)
			return false;
		else 
			return true;
	}
	
	private boolean isSuprise(int[] Score)
	{
		if(Math.abs(Score[0] - Score[1]) > 1)
			return true;
		else if(Math.abs(Score[0] - Score[2]) > 1)
			return true;
		else if(Math.abs(Score[1] - Score[2]) > 1)
			return true;
		else 
			return false;
	}
	
	private int getBest(int[] Score)
	{
		int b = Score[0];
		for(int i = 1; i < Score.length; i ++)
		{
			if( b < Score[i])
				b = Score[i];
		}
		return b;
	}
	
	
	private int[][] GenerateScore(int _Total)
	{
		Vector<int[]> Scores = new Vector<int[]>();
		int[][] S;
		for(int a = 0; a < 11; a ++)
		{
			for(int b = 0; b < 11; b ++)
			{
				for(int c = 0; c < 11; c ++)
				{
					if(a + b + c == _Total)
					{
						int[] s = new int[] {a,b,c};
						if(isValid(s))
							Scores.add(s);
					}
				}
			}
		}
		S = new int[Scores.size()][3];
		Scores.toArray(S);
		return S;
	}
	
	private boolean incrementTracker(int[] Track, int[][][] ScoreSet, int index)
	{
		if(index < 0)
			return false;
		Track[index] ++;
		if(Track[index] == ScoreSet[index].length)
		{
			Track[index] = 0;
			return incrementTracker(Track, ScoreSet, index - 1);
		}
		else
			return true;
			
	}
	
}
