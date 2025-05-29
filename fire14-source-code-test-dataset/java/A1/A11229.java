package qualifyingRound;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DancingWithGooglers {
	public static void main (String [] args) throws FileNotFoundException
	{
		Scanner in = new Scanner (new File ("input.txt"));
		int numLines = Integer.parseInt(in.nextLine());
		int caseNum = 1;
		for (int j = 0; j < numLines; j++)
		{	
			System.out.print("Case #" + caseNum + ": ");
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int noSup = 0;
			int sup = 0;
			for (int i = 0; i < n; i++)
			{
				int total = in.nextInt();
				int maxNoSup = maxNoSup(total);
				int maxSup = maxSup(total);
//				System.out.println(total + " " + maxNoSup + " " + maxSup);
				if (maxNoSup >= p)
					noSup++;
				else if (maxSup >= p)
					sup++;
			}
			int temp = s - sup;
			if (temp <= 0)
				System.out.println((noSup + s));
			else
				System.out.println((noSup + (sup)));
			caseNum++;
		}
	}
	private static int maxNoSup(int totalScore)
	{
		int i = totalScore % 3;
		switch (i)
		{
		case 0: return totalScore/3;
		case 1: return totalScore/3 + 1;
		default: return totalScore/3 + 1;
		}
	}
	private static int maxSup(int totalScore)
	{
		if (totalScore == 0)
			return 0;
		int i = totalScore % 3;
		switch (i)
		{
		case 0: return totalScore/3 + 1;
		case 1: return totalScore/3 + 1;
		default: return totalScore/3 + 2;
		}
	}
}
