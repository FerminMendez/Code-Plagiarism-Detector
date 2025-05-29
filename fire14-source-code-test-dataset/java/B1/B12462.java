import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) throws IOException {
               	//variable initialization
                String inFile = args[0];
		String outFile = inFile.split("\\.")[0] + ".out";

                //file reading...
                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                PrintWriter writer = new PrintWriter(new FileWriter(outFile));

		//get input data
		int T = Integer.valueOf(reader.readLine());
		for (int t = 0; t < T; t++) {
			String[] str_nums = reader.readLine().split(" ");
			int A = Integer.valueOf(str_nums[0]);
			int B = Integer.valueOf(str_nums[1]);
			int count = 0;
			// for (int i = 1; i < 5; i++) {
			// 	for (int j = i+1; j < 5; j++) {
			// 		for (int k = 0; k < 10; k++) {
			// 			if (k == i || k == j) continue;
			// 			int shift = 1;
			// 			int n = i*100 + k*10 + j;
			// 			int m = n % (int)Math.pow(10, shift) * (int)Math.pow(10, 3 - shift)
			// 			      + n / (int)Math.pow(10, shift); 	
			// 			count++;
			// 			System.out.print(n + "->" + m + ", ");

			// 			shift = 2;
			// 			n = i*100 + j*10 + k;
			// 			m = n % (int)Math.pow(10, shift) * (int)Math.pow(10, 3 - shift)
			// 			      + n / (int)Math.pow(10, shift); 	
			// 			count++;
			// 			System.out.print(n + "->" + m + ", ");
			// 			
			// 		}
			// 		System.out.println();
			// 	}
			// }
			int digits = String.valueOf(A).length();
			for(int i = A; i < B; i++) {
				//Set<Character> chars = new HashSet<Character>();
				//for (char c : String.valueOf(i).toCharArray()) chars.add(c);
				//if (chars.size() != digits) continue;
				Set<Integer> olds = new HashSet<Integer>();
				for (int shift = 1; shift < digits; shift++) {
					int n = i;
					int m = n % (int)Math.pow(10, shift) * (int)Math.pow(10, digits - shift)
					      + n / (int)Math.pow(10, shift); 	
					if (m < A || m > B || n >= m) continue;
					if (olds.contains(m)) continue;
					olds.add(m);
					count++;
					// if (t == 3) System.out.print(n + "->" + m + ", ");
				}
			}
			String result = "Case #" + (t+1) + ": " + count;
			writer.println(result);
			System.out.println(result);
		}
		reader.close();
		writer.close();		
	}
}
