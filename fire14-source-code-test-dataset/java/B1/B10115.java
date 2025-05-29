import java.util.Scanner;

public class C {

	static boolean iftrue(int n, int m) {
		String aa = n + "";

		if (n == m)
			return false;

		for (int i = 1; i < aa.length(); i++) {
			String ll = aa.substring(i, aa.length());
			String bb = aa.substring(0, i);

			String ss = ll + bb;
			if (ss.equals(m + "") && m > n) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		//System.out.println(iftrue(12, 31));
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {

			int A = in.nextInt();
			int B = in.nextInt();

			int res = 0;

			for (int k = A; k <= B; k++) {
				for (int l = k + 1; l <= B; l++) {
					if (iftrue(k, l))
						res++;
				}
			}
			System.out.format("Case #%d: %s\n", i + 1, res);
		}
	}
}
