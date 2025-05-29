package gcj2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Google Code Jam 2012 B - Dancing With the Googlers
 * 
 * @author Ruli Manurung (maruli@cs.ui.ac.id)
 */
public class QB
{
	public static void main(String[] args) throws FileNotFoundException,
			IOException
	{
		String fileName = args[0];
		BufferedReader input = new BufferedReader(new FileReader(fileName));

		StringTokenizer token = new StringTokenizer(input.readLine());
		int t = Integer.parseInt(token.nextToken());

		for (int ii = 0; ii < t; ii++)
		{
			token = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(token.nextToken());
			int S = Integer.parseInt(token.nextToken());
			int p = Integer.parseInt(token.nextToken());
			int[] googlers = new int[N];
			for(int jj=0; jj<N; jj++)
				googlers[jj] = Integer.parseInt(token.nextToken());
			System.out.println("Case #" + (ii + 1) + ": "
					+ genMask("",S,googlers,p));
		}
		input.close();
	}
	
	static int genMask(String mask, int S, int[] googlers, int p)
	{
		if(mask.length() == googlers.length) // base case, compute!
		{
			return countP(mask,googlers,p);
		}
		else
		{
			int pad=googlers.length-mask.length();
			
			if(S==0)
			{
				for (int ii=0; ii<pad; ii++)
					mask+='0';
				return countP(mask,googlers,p);
			}
			else if(pad==S)
			{
				for (int ii=0; ii<pad; ii++)
					mask+='1';
				return countP(mask,googlers,p);
			}
			else
			{
				if(googlers[mask.length()]<2 || googlers[mask.length()]>28)
					return genMask(mask+"0",S, googlers, p);
				else
					return Math.max(genMask(mask+"1",S-1,googlers,p),
							genMask(mask+"0",S,googlers,p));
			}
		}
	}
	
	static int countP(String mask, int[] googlers, int p)
	{
		int count=0;
		for(int ii=0; ii<mask.length(); ii++)
		{
			if(max(googlers[ii],mask.charAt(ii)=='1')>=p)
				count++;
		}
		return count;
	}
	
	static int max(int tot, boolean spc)
	{
		switch(tot)
		{
			case 0: return 0; 
			case 1: return 1;
			case 2: return spc ? 2 : 1; 
			case 3: return spc ? 2 : 1; 
			case 4: return 2; 
			case 5: return spc ? 3 : 2; 
			case 6: return spc ? 3 : 2; 
			case 7: return 3; 
			case 8: return spc ? 4 : 3; 
			case 9: return spc ? 4 : 3; 
			case 10: return 4; 
			case 11: return spc ? 5 : 4; 
			case 12: return spc ? 5 : 4; 
			case 13: return 5; 
			case 14: return spc ? 6 : 5; 
			case 15: return spc ? 6 : 5; 
			case 16: return 6; 
			case 17: return spc ? 7 : 6; 
			case 18: return spc ? 7 : 6; 
			case 19: return 7; 
			case 20: return spc ? 8 : 7; 
			case 21: return spc ? 8 : 7; 
			case 22: return 8; 
			case 23: return spc ? 9 : 8; 
			case 24: return spc ? 9 : 8; 
			case 25: return 9; 
			case 26: return spc ? 10 : 9; 
			case 27: return spc ? 10 : 9; 
			case 28: return 10; 
			case 29: return 10; 
			case 30: return 10; 
		}
		return -1;
	}
}
