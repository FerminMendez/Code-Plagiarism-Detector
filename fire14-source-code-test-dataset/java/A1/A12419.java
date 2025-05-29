import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) throws IOException {
               	//variable initialization
                String inFile = args[0];
		String outFile = inFile.split("\\.")[0] + ".out";

                //file reading...
                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                PrintWriter writer = new PrintWriter(new FileWriter(outFile));

		//get input data
		int T = Integer.valueOf(reader.readLine());
		for (int i = 0; i < T; i++) {
			String[] str_nums = reader.readLine().split(" ");
			int[] nums = new int[str_nums.length];
			int n = 0;
			for (String str : str_nums) {
				nums[n++] = Integer.valueOf(str);
			}
			
			int N = nums[0];
			int S = nums[1];
			int p = nums[2];
			int res = 0;

			for (n = 0; n < N; n++) {
				int total = nums[n+3];
				int k = total / 3;
				int k2 = total % 3;
				if (k >= p) res++;
				else if (p-k == 1 && k2 > 0) res++;
				else if (S > 0)
					if (k2 >= p-k || (k2 == 0 && k != 0 && p-k == 1)) {
						S--;
						res++;
						// System.out.println("Surpraise: (" + k + "," + k + "," + (k+k2) + ") p=" + p);
					}
				
			}
			String result = "Case #" + (i+1) + ": " + res;
			writer.println(result);
			// char[] line = readerReal.readLine().toCharArray();
			// for (char c : line) {
			// 	if (dict.containsKey(c)) {
			// 		writer.write(dict.get(c));
			// 	} else {
			// 		writer.write(c);
			// 	}
			// }
			// writer.write('\n');

			// System.out.println(Arrays.toString(nums));
			// System.out.println(result);

		}
		reader.close();
		writer.close();		
	}
}
