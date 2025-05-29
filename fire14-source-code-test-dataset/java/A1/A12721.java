import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class B {


	private static void solve(String[] inp) {
		int n = Integer.parseInt(inp[0]);
		int s = Integer.parseInt(inp[1]);
		int p = Integer.parseInt(inp[2]);
		
		int[] mas = new int[n];
		int countSure = 0;
		int countUnsure = 0;
		for(int i = 0; i<n; i++) {
			mas[i] = Integer.parseInt(inp[i+3]);
			
			boolean isSure = false;
			boolean isUnsure = false;
			
			m:for(int i1 = 0; i1<=10; i1++) {
				for(int i2 = i1; i2<=10; i2++) {
					int i3 = mas[i] - i1 - i2;
					if(i3 < i2)continue;					
					
					if(i3 - i1 > 2)continue;
						
					if(i3 >= p) {
						if(i3 - i1 == 2) {
							isUnsure = true;
						} else {
							isUnsure = isSure = true;
							break m;
						}
							
					}
				}
			}
			
			if(isSure)countSure++;
			if(isUnsure)countUnsure++;
		}
		
		out.println(Math.min(countSure + s, countUnsure));
		
	}
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(inB.readLine());
		for(int _ = 0; _<t; _++) {
			out.print("Case #" + (_+1) + ": ");
			solve(inB.readLine().split(" "));
		}
		out.flush();
	}

	// ///////////////////////////////////////////////////////////////
	// IO
	// ///////////////////////////////////////////////////////////////
	private static StreamTokenizer in;
	private static PrintWriter out;
	private static BufferedReader inB;

	private static boolean FILE = true;

	private static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	private static String nextString() throws Exception {
		in.nextToken();
		return in.sval;
	}

	static {
		try {
			out = new PrintWriter(FILE ? (new FileOutputStream("output.txt"))
					: System.out);
			inB = new BufferedReader(new InputStreamReader(
					FILE ? new FileInputStream("B-small-attempt0.in") : System.in));
		} catch (Exception e) {
			e.printStackTrace();
		}
		in = new StreamTokenizer(inB);
	}

	// ///////////////////////////////////////////////////////////////

	// ///////////////////////////////////////////////////////////////
	// pre - written
	// ///////////////////////////////////////////////////////////////
	private static void println(Object o) throws Exception {
		out.println(o);
		out.flush();
	}

	private static void exit(Object o) throws Exception {
		println(o);
		exit();
	}

	private static void exit() {
		System.exit(0);
	}

	private static final int INF = Integer.MAX_VALUE;
	private static final int MINF = Integer.MIN_VALUE;
	// ////////////////////////////////////////////////////////////////
}
