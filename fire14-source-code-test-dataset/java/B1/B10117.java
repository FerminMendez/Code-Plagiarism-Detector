import java.util.*;

public class Recycle {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int T = s.nextInt();

		List<Integer> ms = new LinkedList<Integer>();

		for (int t = 0; t < T; t++) {
			int A = s.nextInt();
			int B = s.nextInt();

			int digits = String.valueOf(A).length();

			int total = 0;
			for (int i = A; i < B; i++) {
				String num = String.valueOf(i);
				ms.clear();
				for (int j = 1; j < digits; j++) {
					int r = Integer.parseInt(num.substring(j) + num.substring(0, j));
					if (r > i && r <= B && !ms.contains(r)) {
						total++;
						ms.add(r);
					}
				}
			}

			System.out.printf("Case #%d: %d\n", t + 1, total);
		}
	}
}
