import java.util.*;
import java.io.*;

public class C {
	
	private static boolean isRecycledPair(int n, int m) {
		String sn = Integer.toString(n);
		String sm = Integer.toString(m);
		if(sn.length() != sm.length())
			return false;
		int l = sn.length();
		for(int i = l; --i >= 0; ) {
			if(sm.equals(sn.substring(i, l) + sn.substring(0, i)))
				return true;
		}
		return false;
	}
	
	private static long recycledNumbers(String s) {
		StringTokenizer st = new StringTokenizer(s);
		final int A = Integer.parseInt(st.nextToken());
		final int B = Integer.parseInt(st.nextToken());
		long r = 0;
		for(int n = A; n < B; n++)
			for(int m = n; ++m <= B; ) {
				if(isRecycledPair(n, m))
					r++;
			}
		return r;
	}
	
	public static void main(String args[]) throws Exception {
		//String fileName = "C.in";
		String fileName = "C-small-attempt0.in";
		//String fileName = "C-large.in";
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		PrintStream out = new PrintStream(fileName.substring(0, fileName.lastIndexOf('.')) + ".out");
		int T = Integer.parseInt(in.readLine());
		for(int i = 1; i <= T; i++) {
			out.print("Case #" + i + ": ");
			String s = in.readLine();
			out.println(recycledNumbers(s));
		}
		out.close();
		in.close();
	}
}