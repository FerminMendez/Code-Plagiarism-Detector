package google.codejam.recyclednumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Hashtable;


public class Main {

	public static void main(String[] args) throws Exception {
		String[] files = {
				"Data/C-small-attempt0"
				};


		for (int f = 0; f < files.length; f++) {
			BufferedReader in = new BufferedReader(new FileReader(files[f] + ".in"));
			BufferedWriter out = new BufferedWriter(new FileWriter(files[f] + ".out"));

			int T = Integer.parseInt(in.readLine()); // number of test cases

			for (int i = 1; i <= T; i++) {
				String[] input = in.readLine().split(" ");
				int A = Integer.parseInt(input[0]);
				int B = Integer.parseInt(input[1]);
				
				int result = getResult(A, B); 
				
			
				out.write(String.format("Case #%d: %d\n", i, result));
			}

			out.close();
			in.close();

		}
		
	}

	private static int getResult(int A, int B) {
		Hashtable <String, String> pair = new Hashtable <String, String> ();
		
		for (int n = A; n <= B; n++) {
			String number = String.valueOf(n);
			for (int pos = 1; pos < number.length(); pos++)
			{
				String rotatedNumber = number.substring(pos, number.length());
				if (!rotatedNumber.substring(0).equals("0"))
				{
					rotatedNumber += number.substring(0, pos);
					int m = Integer.parseInt(rotatedNumber);
					if (n < m && m <= B && pair.get(number+rotatedNumber) == null)
							pair.put(number+rotatedNumber, "");
				}
			}
		}

		return pair.size();

	}

}
