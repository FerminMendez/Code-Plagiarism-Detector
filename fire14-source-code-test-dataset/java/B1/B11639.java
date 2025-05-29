import java.util.*;

public class RecycledNumbers extends Thread
{
	private int bottom;
	private int top;
	private static int numCases;
	private static int caseIndex = 0;
	private static int lower[];
	private static int upper[];
	private long thisCount = 0;
	
	public static void main(String[] args) 
	{
		
		int n = 1;

		long startTime = System.currentTimeMillis();

		for (int i = 1; i < args.length; i++)
		{
			if(args[i - 1].equals("-n"))
			{
				try
				{
					n = Integer.parseInt(args[i]);
				}
				catch (Exception e)
				{

				}
			}
		}
		
		//System.out.println(n + " threads will be used.\n");

		//GATHER INPUT
		Scanner sc = new Scanner(System.in);
		 numCases = sc.nextInt();
		 int currentCaseNum = 1;
		 String[] outputBuffer = new String[numCases];
		 
		 lower = new int[numCases];
		 upper = new int[numCases];
		 
		 sc.nextLine();
		 for(int i = 0; i < numCases; i++)
		 { 
			 lower[i] = sc.nextInt();
			 upper[i] = sc.nextInt();
			 			 
		 }

		for(int m = 0; m < numCases; m++)
		{
			Thread[] threadArray = new Thread[n];
			RecycledNumbers[] speedupArray = new RecycledNumbers[n];

			int nextLower = lower[m];
			int nextUpper = ((upper[m] - lower[m]) / n) + lower[m];
			for (int j = 0; j < n; j++)
			{
				speedupArray[j] = new RecycledNumbers(nextLower, nextUpper);
				threadArray[j] = new Thread(speedupArray[j]);
				threadArray[j].start();
				nextLower = nextUpper + 1;
				nextUpper = ((j + 2) * (upper[m] - lower[m]) / n) + lower[m];
			}

			for (int k = 0; k < threadArray.length; k++)
			{
				try
				{
					threadArray[k].join();
				} 
				catch (InterruptedException e) {}
			}
			
			int totalCount = 0;
			
			for (int k = 0; k < threadArray.length; k++)
			{
				totalCount += speedupArray[k].thisCount;
			}

			System.out.println("Case #" + (m + 1) + ": " + totalCount);
			//System.out.println("");
		}
		
		//System.out.println("\nDONE!  Execution time of " + ((double)(System.currentTimeMillis() - startTime) / 1000) + " seconds.");
	}
	
	
	public RecycledNumbers(int rangeBottom, int rangeTop)
	{
		bottom = rangeBottom;
		top = rangeTop;
		//System.out.println("This class instance will handle " + bottom + " to " + top + ".");
	}

	private long countDistinct(int lowerBound, int upperBound)
	{
		long count = 0;
		
		for(int i = lowerBound; i < upperBound; i++)
		{
			count += countUniquePermutations(i, upperBound);
		}

		return count;
	}
	
	private int countUniquePermutations(int subject, int topBound)
	{
		int count = 0;
		String intString = Integer.toString(subject);
		String tempNewString = "";
		int tempNewInt = 0;
		int tempIntLength = 0;
		int[] distinctInt = new int[intString.length() - 1];
		
		for(int j = 1; j < intString.length(); j++)
		{
			tempNewString = intString.substring(j, intString.length()) + intString.substring(0, j);
			tempNewInt = Integer.parseInt(tempNewString);
			tempIntLength = Integer.toString(tempNewInt).length();
			
			if((intString.length() == tempIntLength) && (subject != tempNewInt) && (tempNewInt >= subject) && (tempNewInt <= topBound))
			{
				distinctInt[j -1] = tempNewInt;				
			}
			
			Set<Integer> s = new HashSet<Integer>();
			for (int i : distinctInt)
			{
				if(i != 0)
				{
					s.add(i);
				}
			}
			count = s.size();
		}
		
		return count;
	}
	
	public void run()
	{
		thisCount = countDistinct(bottom, top);
	}

}
