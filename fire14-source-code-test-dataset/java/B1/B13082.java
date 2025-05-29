package qualification;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
	static final int MAX = 3000;
	static Set<Integer> dic[] = new HashSet[MAX];

	public static void main(String[] args) {
		for (int i = 1; i < MAX; i++) {
			dic[i] = new HashSet<Integer>();
			String s = i + "";
			for (int j = 1; j < s.length(); j++) {
				String a = s.substring(0, j);
				String b = s.substring(j);
				String c = b + a;
				if (c.charAt(0) == '0') {
					continue;
				}
				int p = Integer.parseInt(c);
				if (p > i) {
					dic[i].add(p);
				}
			}
		}
		try {
			Scanner scanner = new Scanner(System.in);
			int lp = scanner.nextInt();
			for (int loop = 0; loop < lp; loop++) {
				int ans = 0;
				int A = scanner.nextInt();
				int B = scanner.nextInt();
				for (int i = A; i < B; i++) {
					for (Integer j : dic[i]) {
						if (j <= B) {
							ans++;
						}
					}
				}
				System.out.println("Case #" + (loop + 1) + ": " + ans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
