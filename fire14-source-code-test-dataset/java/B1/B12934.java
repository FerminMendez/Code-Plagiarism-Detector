package com.embege.codejam;

import java.util.Arrays;
import java.util.Scanner;

public class CJ2012QualiCRecycled
{

	static int len(int n)
	{
		int c = 1;
		while ((n = n/10) > 0) c++;
		return c;
	}
	
	static boolean checkDigits(int a, int b)
	{
		if (len(a) != len(b)) return false;
		
		String sa = Integer.toString(a);
		String sb = Integer.toString(b);
		
		char []ca = sa.toCharArray();
		char []cb = sb.toCharArray();
		
		Arrays.sort(ca);
		Arrays.sort(cb);
		int len = ca.length;

		for(int i = 0; i < len; i++)
		  if(cb[i] != ca[i])
		    return false;

		return true;
		/*
		for (int i=0; i<sa.length();++i)
		{
			if (!sb.contains( sa.substring(i,i+1)  )) return false;
			if (!sa.contains( sb.substring(i,i+1)  )) return false;
		}
		
		return true;
		*/
	}
	
	static boolean permut(int a, int b)
	{
		String sa = ""+a;
		String sb = ""+b;
		
		for (int x = 1; x<sa.length()+1; x++)
		{
			String part1 = sa.substring(0, x);
			String part2 = sa.substring(x, sa.length());
			
			String n = part2+part1;
			if (n.equals(sb)) return true;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		final Scanner in = new Scanner(System.in);
		final int T = in.nextInt();
		for (int t = 0; t < T; t++)
		{
			int A = in.nextInt();
			int B = in.nextInt();			
			int x = 0;
			
			for (int i=A; i<B;++i) 
			{
				for (int j=i+1; j<=B;++j) 
				{
					if (checkDigits(i, j))
					{
						if (permut(i, j))
						{
							x++;
						}
					}
				}
			}
			

			System.out.format("Case #%d: %d\n", (t+1), x );
		}
	}

}
