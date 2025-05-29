import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;


class Pair
{
	public int low;
	public int high;
	
	public Pair(int l, int h)
	{
		low = l;
		high = h;
	}
	
	public boolean equals(Object o)
	{
		Pair other = (Pair)o;
		
		return other.low == low && other.high == high;
	}
	
	public int hashCode()
	{
		return low * 31 + high; 
	}
}

public class C {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new C();
	}
	
	public C()
	{
		Vector<Pair> pairs = new Vector<Pair>();
		HashSet<Pair> set = new HashSet<Pair>();
		
		int[] powers = new int[8];
		
		int ac = 1;
		for(int i = 0; i < 8; ++i)
		{
			powers[i] = ac;
			ac *= 10;
		}
		
		for(int currentNumber = 10; currentNumber < 10000; ++currentNumber)
		{
			String trick = "" + currentNumber;
			
			int length = trick.length();
			
			int[] digits = new int[trick.length()];
			int[] shuffle = new int[trick.length()];
			
			for(int c = 0; c < length; ++c)
			{
				int digit = trick.charAt(c) - '0';
				
				digits[c] = digit;
				shuffle[c] = digit;
			}
			
			for(int s = 1; s < length; ++s)
			{
				boolean atLeastOneLarger = false;
				
				
				for(int pos = 0; pos < length; ++pos)
				{
					int spos = (pos + s) % length;
					/* Check that position makes the shuffle larger. */
					if(shuffle[spos] < digits[pos])
					{
						break;
					}
					else if(shuffle[spos] > digits[pos])
					{
						atLeastOneLarger = true;
						break;
					}
				}
				
				if(atLeastOneLarger)
				{
					int secondNumber = 0;
					
					/* Generate the larger number. */
					for(int pos = 0; pos < length; ++pos)
					{
						int spos = (pos + s) % length;
						
						secondNumber += shuffle[spos] * powers[length - pos - 1];
					}
					
					if(secondNumber < 2000000 && secondNumber > currentNumber)
					{
						Pair newp = new Pair(currentNumber, secondNumber);
						
						if(!set.contains(newp))
						{
							pairs.add(newp);
							set.add(newp);
						}
						
					}
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();
		
		for(int testCase = 1; testCase <= testCases; ++testCase)
		{
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int lowIndex = binLow(A, pairs);
			int highIndex = binHigh(B, pairs);
			
			if(lowIndex == -1)
				lowIndex = 0;
			
			if(highIndex == -1)
				highIndex = 0;
			
			int ans = 0;
			for(int pair = lowIndex; pair <= highIndex; ++pair)
			{
				Pair p = pairs.elementAt(pair);
				
				if(p.low >= A && p.high <= B)
					ans++;
			}
			
			System.out.printf("Case #%d: %d\n", testCase, ans);
		}
		
		
	}

	private int binHigh(int b, Vector<Pair> pairs) {
		int low = 0;
        int high = pairs.size() - 1;
		
        int mid = (low + high)/2;
		
        while (true) {
        	int number = pairs.elementAt(mid).low;
            if (number == b || number < b) {
                low = mid+1;
                if (high < low)
                    return mid<pairs.size()-1?mid+1:-1;
            } else {
                high = mid-1;
                if (high < low)
                    return mid;
            }
            mid = (low + high)/2;
        }
	}

	private int binLow(int a, Vector<Pair> pairs) {
		int low = 0;
        int high = pairs.size() - 1;
		
        int mid = (low + high)/2;
        while (true) {
        	int number = pairs.elementAt(mid).low;
        	
            if (number == a || number > a) {
                high = mid-1;
                if (high < low)
                    return mid;
            } else {
                low = mid+1;
                if (high < low)
                    return mid<pairs.size()-1?mid+1:-1;
            }
            mid = (low + high)/2;
        }
	}
}
