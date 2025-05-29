import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
		int a = sc.nextInt();
		int b = sc.nextInt();
		int ans = 0;
		Set<String> checked = new HashSet<String>();

		for (int n = a; n <= b; n++) {
			if (n < 10 || n == 1000) {
				continue;
			}

			char[] charArr = Integer.toString(n).toCharArray();

			if (charArr.length == 2) {
				if (charArr[1] != '0') {
					char[] newChar = { charArr[1], charArr[0] };
					int newInt = Integer.valueOf(String.valueOf(newChar));
					if (!checked.contains(n + " " + newInt) && n < newInt && newInt >= a && newInt <= b) {
						checked.add(n + " " + newInt);
						ans++;
					}
				}
			} else if (charArr.length == 3) {
//				if (charArr[0] != '0') {
//					char[] newChar1 = { charArr[0], charArr[2], charArr[1] };
//					int newInt = Integer.valueOf(String.valueOf(newChar1));
//					if (!checked.contains(n + " " + newInt) && n < newInt && newInt >= a && newInt <= b) {
//						checked.add(n + " " + newInt);
//						ans++;
//					}
//				}
				if (charArr[1] != '0') {
//					char[] newChar2 = { charArr[1], charArr[0], charArr[2] };
//					int newInt = Integer.valueOf(String.valueOf(newChar2));
//					if (!checked.contains(n + " " + newInt) && n < newInt && newInt >= a && newInt <= b) {
//						checked.add(n + " " + newInt);
//						ans++;
//					}
					char[] newChar3 = { charArr[1], charArr[2], charArr[0] };
					int newInt = Integer.valueOf(String.valueOf(newChar3));
					if (!checked.contains(n + " " + newInt) && n < newInt && newInt >= a && newInt <= b) {
						checked.add(n + " " + newInt);
						ans++;
					}
				}
				if (charArr[2] != '0') {
					char[] newChar4 = { charArr[2], charArr[0], charArr[1] };
					int newInt = Integer.valueOf(String.valueOf(newChar4));
					if (!checked.contains(n + " " + newInt) && n < newInt && newInt >= a && newInt <= b) {
						checked.add(n + " " + newInt);
						ans++;
					}
//					char[] newChar5 = { charArr[2], charArr[1], charArr[0] };
//					newInt = Integer.valueOf(String.valueOf(newChar5));
//					if (!checked.contains(n + " " + newInt) && n < newInt && newInt >= a && newInt <= b) {
//						checked.add(n + " " + newInt);
//						ans++;
//					}
				}
			}
		}
		System.out.println(ans);
//		for (String string : checked) {
//			System.out.println(string);
//		}
//		System.out.println(checked.size());
	}
}
