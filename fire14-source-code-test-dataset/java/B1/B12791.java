import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class  Main
{
	private static int recycled(int n, int m)
	{
		String sN = (new Integer(n)).toString();
		String sM = (new Integer(m)).toString();
		int nL = sN.length();
		int mL = sM.length();
		
		HashMap<Integer, HashSet<Integer>> pairs = new HashMap<Integer, HashSet<Integer>>();
		
		for(int i = 0; i < nL; i++)
		{
			String swap = sN.substring(nL-1-i);
			String test = swap + sN.substring(0, nL-1-i);
			int testS = Integer.parseInt(test);
			if(testS == m)
			{
				if(!pairs.containsKey(testS))
				{
					HashSet<Integer> newSet = new HashSet<Integer>();
					newSet.add(m);
					pairs.put(testS, newSet);
				}
				else
				{
					pairs.get(testS).add(m);
				}
			}
		}
		
		Iterator<Integer> iter = pairs.keySet().iterator();
		int sum = 0;
		while(iter.hasNext())
		{
			sum += pairs.get(iter.next()).size();
		}
		
		return sum;
	}
	
	
	public static void main(String[] args)
	{
		Scanner inScan = new Scanner(System.in);
		
		int T = inScan.nextInt();
		//System.out.println(T);
		
		for(int t = 0; t < T; t++)
		{
			int A, B;
			
			A = inScan.nextInt();
			B = inScan.nextInt();
			//System.out.println(A);
			//System.out.println(B);
			int sum = 0;
			for(int n = A; n <= B; n++)
			{
				for(int m = B; m > n; m--)
				{
					sum += recycled(n, m);
					//System.out.println("LOOP");
				}
			}
			
			System.out.println("Case #" + (t+1) + ": " + sum);
		}
	}
}