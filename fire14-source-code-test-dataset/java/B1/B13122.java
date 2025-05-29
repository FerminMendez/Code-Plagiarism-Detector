import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// open file and create a buffered reader
		FileReader input = new FileReader(args[0]);
		BufferedReader buffer = new BufferedReader(input);
		
		//read the number of testcases
		int max = Integer.parseInt(buffer.readLine().trim());
		
		// read a line and call the solving procedure for a single test case.  We expect back the result as a string
		for (int i = 1; i <= max; i++) {
			System.out.println("Case #"+i+": " + solve(buffer.readLine()));
		}

	}
	
	private static long solve(String input) {
		String[] split = input.split(" ");
		int A = Integer.parseInt(split[0]);
		int B = Integer.parseInt(split[1]);
		long count = 0;
		if (A < 10)
		{
			return 0;
		}
		for(int i = A; i < B; i++)
		{
			String str = Integer.toString(i);
			HashSet<Integer> all = new HashSet<Integer>();
			for(int j = 1; j < str.length(); j++)
			{
				String cycle = str.substring(j)+str.substring(0, j);
				int value = Integer.parseInt(cycle);
				if (value > i && value <= B && !all.contains(value))
				{
					all.add(value);
					count++;
				}
			}
		}
		return count;
	}
	
}
