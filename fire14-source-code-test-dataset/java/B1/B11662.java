package codejam2012Qualification;

import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) throws IOException {
		boolean large = false;
		//large = true;
		String dir = "C://Users//Aayush//Desktop//";
		String InputFile = dir + (large ? "C-large.in" : "C-small-attempt0.in");
		String OutputFile = dir + (large ? "C-large.out" : "C-small.out");
		File file = new File(InputFile);
		Scanner st = new Scanner(file);
		FileWriter fw = new FileWriter(OutputFile);
		int T = st.nextInt();
		for(int cases = 1; cases <= T; cases++){
			int A = st.nextInt();
			int B = st.nextInt();
			int digits = 0;
			int A1 = A;
			while(A1 > 0){
				A1 /= 10;
				digits++;
			}
			//Efficient solution
			int count = 0;
			for(int n = A; n < B; n++){
				for(int i = 1; i < digits; i++){
					int d = (int) Math.pow(10, i);
					int d1 = (int) Math.pow(10, digits - i);
					int r = n % d;
					int m = d1 * r + n / d;
					if(m > n && m <= B){ 
						count++;
					}
				}
			}
			System.out.print("Case #" + cases + ": " + count);
			fw.write("Case #" + cases + ": " + count);

			System.out.println();
			fw.write("\n");
		}
		fw.flush();
		fw.close();

	}
}
