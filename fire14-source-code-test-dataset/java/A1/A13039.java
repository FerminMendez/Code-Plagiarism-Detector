/*
 * Patrick Bonnell
 * Google Code Jam 2012
 * Qualification Round
 * Dancing With the Googlers
 */


import java.io.*;
import java.util.*;


public class DancingSolution
{
	String filename;
	Case[] cases;
	
	private class Case
	{
		int s, p;
		int totals[];
		
		public Case(int n, int s, int p)
		{
			totals = new int[n];
			this.s = s;
			this.p = p;
		}
		
		public boolean hasBestResult(int i, boolean canBeSurprising)
		{
			int currentBest = 10;
			int remainder, min, max;
			
			while(currentBest >= p)
			{
				remainder = totals[i] - currentBest;
				
				if(canBeSurprising)
				{
					if((currentBest - 2) > -1) min = currentBest - 2;
					else min = currentBest;
					
					if((currentBest + 2) < 11) max = currentBest + 2;
					else max = currentBest;
				}
				else
				{
					if((currentBest - 1) > -1) min = currentBest - 1;
					else min = currentBest;
					
					if((currentBest + 1) < 11) max = currentBest + 1;
					else max = currentBest;
				}
				
				if(remainder >= (min * 2) && remainder <= (max * 2)) return true;
				
				currentBest--;
			}
			
			return false;
		}
	}
	
	public DancingSolution(String filename) throws FileNotFoundException
	{
		this.filename = filename;
		Scanner sc = new Scanner(new File(filename));
		
		cases = new Case[sc.nextInt()];
		
		for(int i=0; i<cases.length; i++)
		{
			cases[i] = new Case(sc.nextInt(), sc.nextInt(), sc.nextInt());
			
			for(int j=0; j<cases[i].totals.length; j++)
				cases[i].totals[j] = sc.nextInt();
		}
	}
	
	public void solve() throws IOException
	{
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(filename.replace("in", "out"))));
		for(int i=0; i<cases.length; i++)
			out.write("Case #"+(i+1)+": "+solveCase(i)+"\n");
		out.close();
	}
	
	private int solveCase(int n)
	{
		int withBestResult = 0;
		int suprisingResults = 0;
		
		for(int i=0; i<cases[n].totals.length; i++)
		{
			if(cases[n].hasBestResult(i, false))
				withBestResult++;
			else if(suprisingResults < cases[n].s && cases[n].hasBestResult(i, true))
			{
				withBestResult++;
				suprisingResults++;
			}
		}
		
		return withBestResult;
	}
	
	public static void main(String[] args)
	{
		System.out.print("Input file: ");
		try
		{
			DancingSolution sol = new DancingSolution(new Scanner(System.in).nextLine());
			System.out.println("Running...");
			sol.solve();
			System.out.println("Done.");
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
}
