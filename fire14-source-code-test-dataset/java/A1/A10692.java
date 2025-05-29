import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;


public class Dancing {

	
	public static void main(String [] args) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new StringReader(args[0]));
		int rows = Integer.parseInt(in.readLine());
		for ( int i = 1; i <= rows; i++)
		{
			String line = in.readLine();
			String[] vals = line.split(" ");
			int googlers = Integer.parseInt(vals[0]);
			int surprising = Integer.parseInt(vals[1]);
			int score = Integer.parseInt(vals[2]);
			int [] googlerScores = new int[googlers];
			
			for ( int j = 0; j < googlerScores.length; j++)
			{
				googlerScores[j]=Integer.parseInt(vals[3+j]);
			}
			
			//System.out.println("Surprising: " + surprising);
			int maxCount = 0;
			for ( int j = 0; j < Math.pow(2, googlers); j++)
			{
				if ( instanceCount(j) == surprising )
				{
					//System.out.println("Case: " + Integer.toBinaryString(j));
					int count = 0;
					for ( int k = 0; k < googlers; k++ )
					{
						int pow = (int) Math.pow(2,k);
						boolean normal = (pow & j) == 0;
						//System.out.println(k+": "+ normal);
						if ( normal && getBestRegularScore(googlerScores[k])>=score )
						{
							count++;
						}
						else if ( !normal && getBestSurprisingScore(googlerScores[k])>=score )
						{
							count++;
						}
					}
					if ( count >= maxCount )
					{
						maxCount = count;
					}
					
				}
			}
			
			System.out.println("Case #"+i+": " + maxCount);
		}
	}
	
	public static int instanceCount(int number)
	{
		int count = 0;
		for ( char c : Integer.toString(number, 2).toCharArray() )
		{
			if ( c == '1' )
			{
				count++;
			}
		}
		return count;
	}
	
	public static int getBestRegularScore(int totalScore)
	{
		int bestScore = totalScore/3;
		if ( totalScore%3>0)
		{
			bestScore++;
		}
		return bestScore>10?10:bestScore;
	}
	
	public static int getBestSurprisingScore(int totalScore)
	{
		if ( totalScore == 0 )
		{
			return 0;
		}
		int ret = (totalScore+4)/3; 
		return ret>10?10:ret;
	}
}
