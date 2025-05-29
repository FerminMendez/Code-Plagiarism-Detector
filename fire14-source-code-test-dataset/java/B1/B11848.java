import java.io.*;
import java.util.*;
import java.math.*;

public class C implements Runnable {
	
	private long solve(int A, int B) {
		int pow = 1;
		while (pow <= A/10) {
			pow *= 10;
		}
		HashSet<Long> h = new HashSet<Long>();
		for (int n = A; n <= B; ++n) {
			int nn = n;
			nn = (nn%pow)*10 + (nn/pow);
			
			while (nn != n) {
				if (A <= nn && nn <= B) {
					if (nn < n) {
						h.add(1L*nn*pow*10+n);
					}
					else {
						h.add(1L*n*pow*10+nn);
					}
				}
				nn = (nn%pow)*10 + (nn/pow);
			}
		}
		return h.size();
	}
	
	public void run() {
		int n = nextInt();
		for (int i = 0; i < n; ++i) {
			int A = nextInt();
			int B = nextInt();
			long ans = solve(A, B);
			out.println("Case #"+(i+1)+": "+ans);
		}
		out.flush();
	}
	
	private static BufferedReader br = null;
	private static StringTokenizer stk = null;
	private static PrintWriter out = null;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader(new File("D:\\C.txt")));
		out = new PrintWriter("D:\\CC.txt");
		(new Thread(new C())).start();
	}
	
	public void loadLine() {
		try {
			stk = new StringTokenizer(br.readLine());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String nextLine() {
		try {
			return (br.readLine());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int nextInt() {
		while (stk==null || !stk.hasMoreTokens()) loadLine();
		return Integer.parseInt(stk.nextToken());
	}
	
	public long nextLong() {
		while (stk==null || !stk.hasMoreTokens()) loadLine();
		return Long.parseLong(stk.nextToken());
	}
	
	public double nextDouble() {
		while (stk==null || !stk.hasMoreTokens()) loadLine();
		return Double.parseDouble(stk.nextToken());
	}
	
	public String nextWord() {
		while (stk==null || !stk.hasMoreTokens()) loadLine();
		return (stk.nextToken());
	}
}
