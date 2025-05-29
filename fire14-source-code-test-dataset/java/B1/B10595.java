import java.util.Scanner;

public class Recycled {
	private static Scanner stdIn = new Scanner(System.in);
	
	public static String removeLeadingZeroes(String number)
	{
		// index of first non-zero digit
		int index = 0;
		// locate first non-zero digit
		while (number.charAt(index) == 0)
		{
			index++;
		}
		// return string starting at first non-zero digit
		return number.substring(index);
	}
	
	public static String duplicateString(String x)
	{
		return x + x;
	}
	
	public static boolean areRecycled(String n, String m)
	{
		// remove leading zeroes from numbers
		n = removeLeadingZeroes(n);
		m = removeLeadingZeroes(m);
		
		// check if they're same length
		if (n.length() != m.length())
		{
			return false; // numbers must have same length
		}
		
		// duplicate n to check if they're recycled
		n = duplicateString(n);
		
		// check if m is a substring of duplicated n
		if (n.contains(m))
		{
			return true;
		}
		
		// not recycled
		return false;
	}
	
	public static void main(String args[])
	{
		int T; // number of test cases
		int caseNo = 1; // number of current case
		
		// scan number of test cases
		T = stdIn.nextInt();
		
		// while there's cases to process
		while (T-- != 0)
		{
			// case variables
			int A, B, recycled;
			
			// read A and B
			A = stdIn.nextInt();
			B = stdIn.nextInt();
			
			// start with zero recycled numbers
			recycled = 0;
			
			for (int n = A; n < B; n++)
			{
				for (int m = n + 1; m <= B; m++)
				{
					// convert integers to String representaion
					String N = Integer.toString(n);
					String M = Integer.toString(m);
					
					// if they're recycled, add to total
					if (areRecycled(N, M))
					{
						recycled++;
					}
				}
			}
			
			// print results
			System.out.println("Case #" + caseNo++ + ": " + recycled);
		}
	}
}
