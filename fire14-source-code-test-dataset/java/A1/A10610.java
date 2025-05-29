import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemB {
	public static int solve(String line) {
		String[] s = line.split(" ");
		int len = Integer.valueOf(s[0]);
		int S = Integer.valueOf(s[1]);
		int th = Integer.valueOf(s[2]);
		int[] a = new int[len];
		for (int i = 3 ; i < s.length ; i++) {
			a[i-3] = Integer.valueOf(s[i]);
		}
		
		int min_spr = th + (th - 2) * 2;
		int min_nonspr = th + (th - 1) * 2;
		if (th == 0) {
			min_spr = 0;
			min_nonspr = 0;
		} else if (th == 1) {
			min_spr = 1;
			min_nonspr = 1;
		}
		
		int cnt = 0;
		for (int i = 0 ; i < len ; i++) {
			if (a[i] >= min_nonspr) {
				cnt++;
			} else if (a[i] >= min_spr) {
				if (S >= 1) {
					S--;
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(reader.readLine());
		for (int t = 1 ; t <= T ; t++) {
			String line = reader.readLine();
			System.out.println("Case #" + t + ": " + solve(line));
		}
	}
}
