import java.util.HashMap;
import java.util.Scanner;


public class RecycledNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			
			int numberOfRecycledPairs = findNumberOfRecycledPairs(A, B);
			System.out.format("Case #%d: %d\n", i, numberOfRecycledPairs);
		}
	}
	
	private static int findNumberOfRecycledPairs(int start, int end)
	{
		HashMap<String, String> recycledPairs = new HashMap<String, String>();
		for(int i = start; i <= end; i++)
		{
			int originalNumber = i;
			String numberStr = originalNumber + "";
			int numberLength = numberStr.length();
			for(int j = 1; j < numberLength; j++)
			{
				String newNumberStr = numberStr.substring(numberLength - j) + numberStr.substring(0, numberLength - j);
				int newNumber = Integer.parseInt(newNumberStr);
				if(newNumber >= start && newNumber <= end && newNumber > originalNumber)
					recycledPairs.put(originalNumber + "::" + newNumber,"");
			}
		}
		return recycledPairs.size();
	}

}
