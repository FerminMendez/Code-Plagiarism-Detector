


import java.io.*;
import java.util.*;

public class DG {
	private static String fileName = DG.class.getSimpleName().replaceFirst("_.*", "");
	private static String inputFileName = "D:\\cj12\\"+fileName + ".in";
	private static String outputFileName = "D:\\cj12\\"+fileName + ".out";
	private static Scanner in;
	private static PrintWriter out;
	 
	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		if (args.length >= 2) {
			inputFileName = args[0];
			outputFileName = args[1];
		}
		in = new Scanner(new FileReader(inputFileName));
		out = new PrintWriter(outputFileName);
		int tests = in.nextInt();
		//in.nextLine();
		for (int t = 1; t <= tests; t++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int res = 0;
			for(int i=0;i<n;i++) {
				int tot = in.nextInt();
				if(tot >= ((3*p)-2))
					res++;
				else if(tot > 0 && s > 0 && (tot >= ((3*p)-4))) {
					res++;
					s--;
				}
			}
			System.out.println("Case #" + t + ": "+res);
			out.println("Case #" + t + ": "+res);
		}
		in.close();
		out.close();
	}
}


