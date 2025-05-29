import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class DancingGooglers
{
	static BufferedReader br;
	static PrintWriter pw;
	
	
	public static void main(String args[])throws IOException
	{
		initFiles();
		readFile();	
		
	}
	
	
	private static void readFile()throws IOException
	{
		int numCases = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=numCases; i++)
		{
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int s = Integer.parseInt(tokens.nextToken());
			int p = Integer.parseInt(tokens.nextToken());
			
			int scores[] = new int[n];
			
			int j = 0;
			while(tokens.hasMoreTokens())
				scores[j++] = Integer.parseInt(tokens.nextToken());
			
			Triplets triplets[] = findTriplets(scores);
			display(triplets);
			
			int currentSurprises = findSurprises(triplets);
			
			ArrayList<Integer> possibilities = new ArrayList<Integer>();
			findSolution(triplets, (s - currentSurprises), p, 0, possibilities);
			int maxNumOfGooglers = findMaxNumOfGooglers(possibilities);
			System.out.println("Max Num of Googlers = " + maxNumOfGooglers);
			
			pw.println("Case #" + i + ": " + maxNumOfGooglers);
		}
		
		pw.close();
		br.close();
	}
	
	
	private static int findMaxNumOfGooglers(ArrayList<Integer> possibilities)
	{
		int max = possibilities.get(0);
		for(int i=1; i<possibilities.size(); i++)
		{
			if(possibilities.get(i) > max)
				max = possibilities.get(i);
		}
		
		return max;
	}
	
	private static void findSolution(Triplets triplets[], int surprises, int p, int startLimit, ArrayList<Integer> possibilities)
	{
		if(surprises == 0)
		{
//			System.out.println("Possibility: ");
//			display(triplets);
			int numOfGooglers = findNumOfBestResult(triplets, p);
//			System.out.println("Num of Googlers = " + numOfGooglers);
			possibilities.add(new Integer(numOfGooglers));
			return;
		}
		
		else
		{
			for(int i=startLimit; i<triplets.length; i++)
			{
				if(triplets[i].isSurprising())
					continue;
				
				if(!triplets[i].canBeConverted()) //Can't be converted
					continue;
				
				Triplets oldTriplet = triplets[i];
				triplets[i] = triplets[i].converted();
				findSolution(triplets, surprises-1, p, startLimit + 1, possibilities);
				
				triplets[i] = oldTriplet;
			}
		}
	}
	
	private static int findNumOfBestResult(Triplets triplets[], int p)
	{
		int count = 0;
		for(int i=0; i<triplets.length; i++)
		{
			if(triplets[i].getMaxScore() >= p)
				count++;
		}
		return count;
	}
	
	private static int findSurprises(Triplets triplets[])
	{
		int count = 0;
		for(int i=0; i<triplets.length; i++)
		{
			if(triplets[i].isSurprising())
				count++;
		}
		return count;
	}
	
	private static void display(Triplets triplets[])
	{
		for(int i=0; i<triplets.length; i++)
		{
			triplets[i].display();
		}
	}

	private static Triplets[] findTriplets(int scores[])
	{
		Triplets triplets[] = new Triplets[scores.length];
		
		for(int i=0; i<scores.length; i++)
		{
			int a = (int)Math.ceil(scores[i]/3);
			int b = (int)Math.ceil((scores[i] - a)/2);
			int c = (int)Math.ceil((scores[i] - a - b));
			
			triplets[i] = new Triplets(a, b, c);
		}
		
		return triplets;
	}
	
	private static void initFiles()throws IOException
	{
		br = new BufferedReader(new FileReader("Dance.in"));
		pw = new PrintWriter(new FileWriter("Dance.out"));
	}
}
