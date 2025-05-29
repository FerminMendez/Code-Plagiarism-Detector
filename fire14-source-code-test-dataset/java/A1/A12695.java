import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public Scanner sc;
	public Map<Character, Character> mapping = new HashMap<Character, Character>();

	public static void main(String[] args) {
		Main m = new Main();
		m.start();
	}

	public void start() {
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}

	public void solve() {
		int ans = 0;
		int n = sc.nextInt();
		int s = sc.nextInt();
		int p = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			if (calcMax(t, false) >= p) {
				ans++;
				continue;
			}

			if (s > 0 && calcMax(t, true) >= p) {
				ans++;
				s--;
				continue;
			}
		}
		System.out.println(ans);
	}

	public int calcMax(int t, boolean suprising) {

		if (t == 0) {
			return 0;
		}

		int max = 0;
		switch (t % 3) {
		case (0):
			max = t / 3;
			if (suprising) {
				max++;
			}
			break;
		case (1):
			max = (int) t / 3 + 1;
			break;
		case (2):
			max = (int) t / 3 + 1;
			if (suprising) {
				max++;
			}
			break;
		}
		return max;
	}
}
