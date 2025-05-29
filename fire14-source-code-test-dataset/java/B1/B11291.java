package qualifyingRound;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecycledNumbers 
{
	public static void main (String [] args) throws FileNotFoundException
	{
		Scanner in = new Scanner (new File ("input.txt"));
		int numLines = Integer.parseInt(in.nextLine());
		int i = 1;
		while (in.hasNextLine())
		{	
			System.out.print("Case #" + i + ": ");
			int low = in.nextInt();
			int high = in.nextInt();
			int count = 0;
			for (int c = low; c < high; c++)
			{	
//				int temp = computePermutations(c,high);
//				System.out.println(c + " " + temp);
//				count+=temp;
				count += computePermutations(c,high);
			}
			System.out.println(count);
			i = i+1;
		}
//		System.out.println(computePermutations(2212,2222));
	}
	private static int computePermutations (int low, int high)
	{
		String str = "" + low;
		int length = str.length();
		int count = 0;
		int temp = low;
		for (int i = 0; i < length; i++)
		{
			int last = temp % 10;
			temp = temp/10 + last * pow10(length - 1);
//			System.out.println(low + " " + temp);
			if (temp > low && temp <= high)
			{
//				System.out.println(low + " " + temp);
				count++;
			}
		}
		return count;
		
	}
	private static int pow10 (int pow)
	{
		int toReturn = 1;
		for (int i = 0; i < pow; i++)
		{
			toReturn *= 10;
		}
		return toReturn;
	}
}
