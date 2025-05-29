import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Recycled {

	public static void main(String[] args) throws Exception {
		
//		if(true){
//			System.out.println(recycle("12345", 4));
//			return;
//		}

		BufferedReader in = new BufferedReader(new FileReader("recycled.in"));
		PrintWriter out = new PrintWriter(new FileWriter("recycled.out"));

		String lineStr;
		int T;
		long A, B, result, n, m;

		T = Integer.parseInt(in.readLine());

		for (int line = 1; line <= T; line++) {
			// get input
			lineStr = in.readLine();
			String[] fields = lineStr.split(" ");
			A = Long.parseLong(fields[0]);
			B = Long.parseLong(fields[1]);

			// compute result
			result = 0;
			for (n = A; n < B; n++) {
				for (m = A + 1; m <= B; m++) {
					if (isRecyled(n, m)) {
						result++;
					}
				}
			}

			// edit result
			out.println("Case #" + line + ": " + result);
			System.out.println(lineStr + " : " + result);
		}

		in.close();
		out.close();
	}

	private static boolean isRecyled(long n, long m) {
		// condition n<m
		if (m <= n) {
			return false;
		}
		String strN = String.valueOf(n);
		String strM = String.valueOf(m);
		// condition more than one digit
		if (strN.length() == 1 || strM.length() == 1) {
			return false;
		}
		int digitCount = strN.length();
		for (int i = 1; i < digitCount; i++) {
			String recycledN = recycle(strN, i);
			if (recycledN.equals(strM)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Move i digits from back of X to the front
	 * 
	 * @param X
	 * @param i
	 * @return
	 */
	private static String recycle(String X, int i) {
		int len = X.length();
		String head = X.substring(0, len - i);
		String tail = X.substring(len - i, len);
		//System.out.println(X+" = "+head+" + "+tail + " len="+len);
		return tail.concat(head);
	}
}
