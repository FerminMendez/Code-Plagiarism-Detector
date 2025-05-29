import java.util.*;
import java.io.*;

public class Dancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		new Dancing().run();
	}

	Integer[] best = new Integer[31];
	int best(int x) {
		if (best[x] != null)
			return best[x];
		for (int l = 0; l <= Math.min(x, 8); l++) {
			for (int m = l; m <= l + 2 && m + l <= x; m++) {
				int h = l + 2;
				if (l + m + h == x) {
					best[x] = h;
				}
			}
		}
		if (best[x] == null)
			best[x] = -1;
		return best[x];
	}
	
	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		for (int i = 0; i <= 30; i++)
			System.err.println("" + i + "," + best(i) + "," + ((i + 2) / 3));
		
		int T = nextInt();
		for (int tt = 0; tt < T; tt++) {
			int n = nextInt(), s = nextInt(), p = nextInt();
			
			int ans = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				int x = nextInt();
				if (x < 2) {
					if (x >= p)
						ans++;
				} else if (x > 28) {
					ans++;
				} else {
					list.add(x);
				}
			}
			
			Integer[] arr = new Integer[0];
			arr = list.toArray(arr);
			
			Arrays.sort(arr);
			
			int rem = s;
			for (int i = 0; i < arr.length; i++) {
				int x = arr[i];
				if (best(x) >= p && (x + 2) / 3 < p && rem > 0) {
					ans++;
					rem--;
				} else if ((x + 2) / 3 >= p) {
					ans++;
				}
			}
			
			System.out.println("Case #" + (tt + 1) + ": " + ans);
		}
		
		out.close();
	}
	
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	
	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
 	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	
}
