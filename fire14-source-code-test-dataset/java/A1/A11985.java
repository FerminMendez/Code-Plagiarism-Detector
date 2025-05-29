import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class CodejamB {

	public static final String TEST = "test.in", SMALL = "B-small-attempt0.in", LARGE = "B-large.in";
	public static final String OUTPUT = "out.txt";
	
	public static Map<Integer, List<Triplet>> triplets;
	
	public static void main(String[] args) throws Exception
	{
	
		solve(SMALL);
	}
	
	public static void makeAllTriplets()
	{
		triplets = new HashMap<Integer, List<Triplet>>();
		for(int i =0; i <= 10; i++)
		{
			for(int j = 0; j <= 10; j++)
			{
				for(int k = 0; k <= 10; k++)
				{
					Triplet trip = new Triplet(i, j, k);
					if(trip.legal())
					{
						int sum = i + j + k;
						if(!triplets.containsKey(sum))
							triplets.put(sum, new LinkedList<Triplet>());
						triplets.get(sum).add(trip);
					}
				}
			}
		}
	}

	public static void solve(String filename) throws Exception
	{
		makeAllTriplets();
		
		Scanner in = new Scanner(new File(filename));
		
		int cases = in.nextInt();
		in.nextLine();
		
		PrintWriter out = new PrintWriter(new File(OUTPUT));
		
		for(int num = 1; num <= cases; num++)
		{
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int result = 0;
			int[] googlers = new int[N];
			for(int i =0; i < N; i++)
			{
				boolean unsurprised = false;
				boolean valid = false;
				int sum = in.nextInt();
				List<Triplet> poss = triplets.get(sum);
				for(Triplet t: poss)
				{
					if(t.best() >= p && !t.surprising())
					{
						unsurprised = true;
						valid = true;
						System.out.println("UNSURPRISING " + Arrays.toString(t.scores) + "= " + sum);
					}
					else if(t.best() >= p)
					{
						valid = true;
					}
					
				}
				if(!unsurprised && S > 0 && valid)
				{
					S--;
					result++;
				}
				else if(unsurprised)
				{
					result++;
				}
			}
			
			
			in.nextLine();
		
			
			
			out.println("Case #"+num+": "+result);
			System.out.println("Case #"+num+": "+result);
		}
		
		out.close();
	}
	
}

class Triplet
{
	int[] scores;
	
	public Triplet(int a, int b, int c)
	{
		scores = new int[]{a,b,c};
		Arrays.sort(scores);
	}
	
	public int best()
	{
		return scores[2];
	}
	
	public boolean legal()
	{
		return Math.abs(scores[2] - scores[0]) <= 2;
	}
	
	public boolean surprising()
	{
		return Math.abs(scores[2] - scores[0]) == 2;
	}
}
