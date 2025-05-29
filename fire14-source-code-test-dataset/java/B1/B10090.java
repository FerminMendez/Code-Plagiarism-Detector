package codeJam;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i=1; i<=testCases; i++)
		{
			int lowerBound = s.nextInt();
			int upperBound = s.nextInt();
			int midway = (upperBound+lowerBound)/2;
			int cases=0;
			for(int j=0; j<=upperBound; j++)
			{
				int num = lowerBound+j;
				String temp = "" + num;
				for(int k=1; k<temp.length(); k++)
				{
					String test = temp.substring(k)+temp.substring(0,k);
					int check = Integer.parseInt(test);
					if(check>=lowerBound && check<=upperBound && check!=num && check>num)
					{
						cases++;
					}
				}
			}
			System.out.println("Case #" + i + ": " + cases);
		}
	}
}
