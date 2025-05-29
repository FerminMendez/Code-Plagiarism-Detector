import java.util.*;
import java.io.*;

public class B {
	
	private static int googlers(String s) {
		StringTokenizer st = new StringTokenizer(s);
		final int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int score[] = new int[N];
		int r = 0;
		for(int i = 0; i < N; i++) {
			int z = score[i] = Integer.parseInt(st.nextToken());
			int a = z / 3;
			int bn, bs;
			switch(z % 3) {
				case 0:
					bn = a;
					bs = a == 0 ? a : a + 1;
					break;
				case 1:
					bn = a + 1;
					bs = a + 1;
					break;
				//case 2:
				default:
					bn = a + 1;
					bs = a + 2;
					break;
			}
			if(bn >= p)
				r++;
			else if(bs >= p && S > 0) {
				r++;
				S--;
			}
		}
		return r;
	}
	
	public static void main(String args[]) throws Exception {
		//String fileName = "B.in";
		String fileName = "B-small-attempt0.in";
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		PrintStream out = new PrintStream(fileName.substring(0, fileName.lastIndexOf('.')) + ".out");
		int T = Integer.parseInt(in.readLine());
		for(int i = 1; i <= T; i++) {
			out.print("Case #" + i + ": ");
			String s = in.readLine();
			out.println(googlers(s));
		}
		out.close();
		in.close();
	}
}