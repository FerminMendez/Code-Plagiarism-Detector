package world2012.qualification;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class C {

	public static int countRecycled(int A, int B) {
		int count = 0;
		for (int n = A; n <= B; n++) {
			for (int m = n + 1; m <= B; m++) {
				String nStr = "" + n + n;
				String mStr = "" + m;
				if (nStr.contains(mStr))
					count++;
			}
		}
		
		return count;
	}
	

	static PrintWriter out;

	public static void parseInput() throws Exception {
		String file = "world2012/qualification/C-small-attempt0.in";
//		String file = "world2012/qualification/B-large.in";
//		String file = "input.in";
		Scanner scanner = new Scanner(new File(file));
		out = new PrintWriter(new FileWriter((file.replaceAll(".in", ""))));
		
		int T = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < T; i++) {
			String[] in = scanner.nextLine().split("\\s");
			int A = Integer.parseInt(in[0]);
			int B = Integer.parseInt(in[1]);
						
			int r = countRecycled(A, B);
			out.println("Case #"+(i+1)+": "+r+"");
		}
	}
	
	public static void main(String[] args) throws Exception {
		parseInput();
		out.close();
		System.out.println("Done!");
	}

}
