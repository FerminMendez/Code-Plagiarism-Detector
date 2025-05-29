import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DancingWithTheGooglers {

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
	
	private static int solve(String input) {
		String[] split = input.split(" ");
		int n = Integer.parseInt(split[0]);
		int s = Integer.parseInt(split[1]);
		int p = Integer.parseInt(split[2]);
		int normal = 0;
		int special = 0;
		for(int i = 0; i < n; i++)
		{
			int t = Integer.parseInt(split[i+3]);
			if (t > 3 * (p - 1))
			{
				normal++;
			} else {
				if(t > Math.max(1, 3 * (p - 2)+1))
				{
					special++;
				}
			}
		}
		return normal + Math.min(special, s);
	}
	
}
