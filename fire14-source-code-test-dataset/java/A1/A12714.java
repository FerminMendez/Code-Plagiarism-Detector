package google.codejam.dancingwithgooglers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Main {

	public static void main(String[] args) throws Exception {
		String[] files = {
				"Data/B-small-attempt1"
				};


		for (int f = 0; f < files.length; f++) {
			BufferedReader in = new BufferedReader(new FileReader(files[f] + ".in"));
			BufferedWriter out = new BufferedWriter(new FileWriter(files[f] + ".out"));

			int T = Integer.parseInt(in.readLine()); // number of test cases

			for (int i = 1; i <= T; i++) {
				String[] input = in.readLine().split(" ");
				int googlers = Integer.parseInt(input[0]);
				int suprizing = Integer.parseInt(input[1]);
				int p = Integer.parseInt(input[2]);
				int [] t = new int[googlers];
				
				for (int j = 0; j < input.length - 3; j++)
					t[j] = Integer.parseInt(input[j+3]);
				
				int m = getBest(googlers, suprizing, p, t); 
				
			
				out.write(String.format("Case #%d: %d\n", i, m));
			}

			out.close();
			in.close();

		}
		
	}

	private static int getBest(int N, int S, int p, int[] t) {
		int output = 0;

		System.out.println(String.format("%d %d %d", N, S, p));
		
		for (int i = 0; i < t.length; i++) {
			System.out.println(String.format("%d", t[i]));

			if (t[i] >= (3*p - 2) && t[i] > 0 || p == 0) output++;
			else if (t[i] >= (3*p - 4) && t[i] > 0 && S > 0)
			{
				System.out.println(String.format("%d %d", t[i], (3*p - 4) ));
				System.out.println("surprise");
				S--;
				output++;
			}
		
		}
		
		return output;

	}

}
