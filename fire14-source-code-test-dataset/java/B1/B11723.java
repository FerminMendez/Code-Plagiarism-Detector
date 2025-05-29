import java.lang.*;
import java.io.*;
import java.util.*;

public class Solution {
	public static BufferedReader br;
	public static PrintWriter out;
	public static StringTokenizer stk;

	// ///////////////// TO CHANGE ///////////////////////////
	public static boolean isServer = false;

	// ///////////////// TO CHANGE ///////////////////////////

	public static void main(String[] args) throws IOException {
		if (isServer) {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		} else {
			br = new BufferedReader(new FileReader("in.txt"));
			out = new PrintWriter(new File("out.txt"));
		}

		(new Solution()).run();
	}

	public void loadLine() {
		try {
			stk = new StringTokenizer(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String nextLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String nextWord() {
		while (stk == null || !stk.hasMoreTokens())
			loadLine();
		return stk.nextToken();
	}

	public Integer nextInt() {
		while (stk == null || !stk.hasMoreTokens())
			loadLine();
		return Integer.valueOf(stk.nextToken());
	}

	public Long nextLong() {
		while (stk == null || !stk.hasMoreTokens())
			loadLine();
		return Long.valueOf(stk.nextToken());
	}

	public Double nextDouble() {
		while (stk == null || !stk.hasMoreTokens())
			loadLine();
		return Double.valueOf(stk.nextToken());
	}

	public Float nextFloat() {
		while (stk == null || !stk.hasMoreTokens())
			loadLine();
		return Float.valueOf(stk.nextToken());
	}
	
	public void run() {
		int tt = nextInt();
		for (int t = 0; t < tt; t++) {
			int a = nextInt();
			int b = nextInt();
			long ans = 0;
			for (int i = a; i <= b; i++) {
				String s = Integer.toString(i);
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(i);
				for (int j = 1; j < s.length(); j++) {
					StringBuilder ss = new StringBuilder();
					for (int k = 0; k < s.length(); k++) {
						ss.append(s.charAt((j+k)%s.length()));
					}
					int y = Integer.parseInt(ss.toString(), 10);
					if (y >= a && y <= b) {
						set.add(y);
					}
				}
				ans += set.size()-1;
			}
			out.printf("Case #%d: ", t+1);
			out.println(ans/2);
		}
		out.flush();
	}
}
