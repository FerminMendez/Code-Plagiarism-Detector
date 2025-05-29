package Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = 1;
		int a, b;
		ArrayList<Integer>[] v = new ArrayList[2000010];
		for (int i = 0; i < v.length; i++)
			v[i] = new ArrayList<Integer>();
		while (n-- > 0) {
			a = in.nextInt();
			b = in.nextInt();
			int cnt = 0;
			int x;
			String s = a + "";
			int len = s.length();
			int pow = 1;
			for (int i = 0; i < len - 1; i++)
				pow *= 10;
			for (int i = a; i <= b; i++)
				v[i].clear();
			for (int i = a; i <= b; i++) {
				x = i;
				for (int j = 0; j < len; j++) {
					if (x % 10 == 0) {
						int tm = 10;
						while (x % tm == 0) {
							tm *= 10;
						}
						x = (x % tm) * pow / (tm / 10) + x / (tm);
						if (x > i && x <= b && !v[i].contains(x)) {
							cnt++;
							v[i].add(x);
						}
					} else {
						x = (x % 10) * pow + x / 10;
						if (x > i && x <= b && !v[i].contains(x)) {
							cnt++;
							v[i].add(x);
						}
					}
				}
			}
			System.out.printf("Case #%d: %d\n", t++, cnt);
		}
	}

}