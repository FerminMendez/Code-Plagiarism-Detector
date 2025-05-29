package egWo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Cs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int l = 1; l <= T; l++) {
			in.nextLine();
			int n = in.nextInt();
			int m = in.nextInt();
			int count = 0;

			if ((n % 10 > 0 && n / 10 == 0)) {
				count = 0;
			} else {
				for (int i = n; i < m; i++) {
					if (i / 10 < 10) {
						int u = i % 10;
						int ten = i / 10;
						int revI = (u * 10) + ten;
						if (i < revI && revI < m) {
							count++;
						}
					} else if (i / 10 <= 100 && i / 10 >= 10) {
						int uni = (i % 100) % 10;
						int ten = (i / 10) % 10;
						int per = i / 100;
						ArrayList revI = new ArrayList();
						revI.add(ten * 100 + uni * 10 + per);
						revI.add(uni * 100 + per * 10 + ten);

						Set set = new HashSet(revI);
						for (Object j : set) {							
							if (i < ((Integer) j).intValue()
									&& ((Integer) j).intValue() <= m) {
								count++;
							}
						}
					}
				}
			}
			System.out.format("\nCase #%d: %d", l, count);
		}
	}
}
