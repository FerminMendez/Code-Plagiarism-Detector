package qualificationround;

import java.io.*;
import java.util.Scanner;

public class ProblemB {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new FileReader("B.in"));
		PrintWriter out = new PrintWriter(new FileWriter("B.out"));
		int t = sc.nextInt();
		for (int caseNum = 1; caseNum <= t; caseNum++)
		{
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int count = 0;
			for (int i = 0; i<n; i++)
			{
				int pscore = sc.nextInt();
				int score = getScore(pscore);
				if (score>=p)
					count++;
				else if (p-score == 1 && s>0 && pscore >=2)
				{
					s--;
					count++;
				}
			}
			out.println("Case #"+caseNum+": "+count);
		}
		out.close();
	}
	
	public static int getScore(int num)
	{		
		if (num % 3 == 0)
			return num/3;
		else
			return num/3+1;
	}

}
