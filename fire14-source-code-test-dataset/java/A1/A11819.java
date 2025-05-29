


class Triplets
{
	int oldscore[] = new int[3];
	int score[] = new int[3];
	int totalScore;
	
	int first, second;
	
	public Triplets(int a, int b, int c)
	{
		oldscore[0] = score[0] = a;
		oldscore[1] = score[1] = b;
		oldscore[2] = score[2] = c;
		
		totalScore = a + b + c;
	}
	
	public void display()
	{
		System.out.println("(" + score[0] + ", " + score[1] + ", " + score[2] + ")");
	}
	
	public int getMaxScore()
	{
		int max = score[0];
		for(int i=1; i<score.length; i++)
			if(score[i] > max)
				max = score[i];
		
		return max;
	}
	
	public int getMinScore()
	{
		int min = score[0];
		for(int i=1; i<score.length; i++)
			if(score[i] < min)
				min = score[i];
		
		return min;
	}
	
	public boolean isSurprising()
	{
		int max = getMaxScore();
		int min = getMinScore();
		
		return ((max - min) == 2);
	}
	
	public boolean canBeConverted()
	{
		for(int i=0; i<score.length - 1; i++)
		{
			for(int j=i+1; j<score.length; j++)
			{
				if(score[i] == score[j] && score[i] != 0)
				{
					first = i;
					second = j;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public Triplets converted()
	{
		Triplets convertedTriplet = new Triplets(score[0], score[1], score[2]);
		convertedTriplet.score[first]++;
		convertedTriplet.score[second]--;
		
		return convertedTriplet;
	}
}