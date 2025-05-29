import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P03 {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int t = inp.nextInt();
		inp.nextLine();
		int i = 1;
		while (t > 0) {
			int a = inp.nextInt();
			int b = inp.nextInt();

			System.out.println("Case #" + i + ": " + find(a, b));

			--t;
			++i;
		}

	}

	private static long find(int a, int b) {
		long ret = 0;
		boolean[] done = new boolean[b + 1];
		for (int i = a; i <= b; i++) {
			if (!done[i]) {
				Set<Integer> vals = new HashSet<Integer>();
				String is = String.valueOf(i);
				if (is.length() > 1) {
					vals.add(i);
					for (int j = 1; j < is.length(); j++) {
						String newS = is.substring(j) + is.substring(0, j);
						int newInt = Integer.parseInt(newS);
						if (newInt >= a && newInt <= b) {
							vals.add(newInt);
						}
					}
				}
				if (vals.size() > 1) {
					for (int val : vals) {
						done[val] = true;
					}
					ret += (vals.size() * (vals.size() - 1)) / 2;
				}
			}
		}
		return ret;
	}
}
