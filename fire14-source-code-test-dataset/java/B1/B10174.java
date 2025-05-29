import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.StringTokenizer;

public class GCJ2012QC {
	static HashSet<Integer> set = new HashSet<Integer>();
	static final int ZERO = 48;

	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st;
		int t = parseInt(r.readLine());
		// long time = new Date().getTime();
		int a, b, result;
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(r.readLine());
			a = parseInt(st.nextToken());
			b = parseInt(st.nextToken());
			result = solve(a, b);
			pw.println("Case #" + i + ": " + result);
		}
		// time = new Date().getTime() - time;
		pw.flush();
		// System.out.println(time / 1000);
	}

	private static int solve(int a, int b) {
		int result = 0;
		for (int i = a; i < b; i++) {
			result += calculate(i, b);
		}
		return result;
	}

	private static int calculate(int k, int b) {
		String s = Integer.toString(k);
		int n = s.length();
		int rotated;
		String s1;
		set.clear();
		for (int i = 1; i < n; i++) {
			s1 = s.substring(i) + s.substring(0, i);
			rotated = parseInt(s1);
			if (rotated > k && rotated <= b && !set.contains(rotated)) {
				set.add(rotated);
			}
		}
		return set.size();
	}

	private static int parseInt(String s) {
		int len = s.length();
		int num = s.charAt(0) - ZERO;
		for (int i = 1; i < len; i++) {
			num = num * 10 + s.charAt(i) - ZERO;
		}
		return num;
	}
}
