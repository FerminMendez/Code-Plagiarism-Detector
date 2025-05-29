import java.util.ArrayList;
import java.util.HashMap;

public class Danc3 {
	static ArrayList<Integer> allTheNumbers = new ArrayList<Integer>();
	static HashMap<Long, Long> binomCoeff = new HashMap<Long, Long>();

	public static int solveC(int A, int B)
	{
		allTheNumbers = new ArrayList<Integer>();
		int count = 0;
		String seeds[] = new String[B-A+1];
		for(int i = A, n = 0; n < seeds.length; i++, n++)
		{
			seeds[n] = Integer.toString(i);
		}


		for(int i = 0; i < seeds.length; i++)
		{
			count += binom(CircularStringShift(seeds[i], A, B),2);
		}

		return count;
	}
	public static int CircularStringShift(String s, int lowerLimit, int upperLimit)
	{
		String tmp = s;
		char placeHolder = ' ';
		int count = 0;
		int tmp2;

		for(int i = 0; i < s.length(); i++)
		{
			placeHolder = tmp.charAt(0);
			tmp = tmp.substring(1, tmp.length()) + placeHolder ;
			tmp2 = Integer.parseInt(tmp);
			if(!allTheNumbers.contains(tmp2) && tmp2 >= lowerLimit && tmp2 <= upperLimit && tmp != s)
			{
				count++;
				allTheNumbers.add(tmp2);
			}

		}



		return count;
	}

	static long binom(int n, int k) {
		return ((n-1)*(n) / 2);
	}
 
}