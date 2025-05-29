import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 1; i <= t; ++ i) {
			int n = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();
			int[] max = new int[n];
			for (int j = 0; j < n; ++ j) {
				max[j] = scan.nextInt();
			}
			boolean[] surprising = new boolean[n];
			for (int j = 0; j < s; ++ j) {
				surprising[j] = true;
			}
			int out = 0;
			do {
				out = Math.max(out, solve(max, surprising, p));
				surprising = next(surprising, surprising.length);
			} while (surprising != null);
			System.out.printf("Case #%d: %d\n", i, out);
		}
	}

	private static boolean[] next(boolean[] old, int end) {
		int index = 0;
		for (index = end - 1; index >= 0; -- index) {
			if (old[index]) {
				break;
			}
		}
		if (index == -1) {
			return null;
		}
		if (index == end - 1) {
			boolean[] ret = next(old, index);
			if (ret == null) {
				return null;
			}
			ret[index] = false;
			for (index = index - 1; index >= 0; -- index) {
				if (ret[index]) {
					break;
				}
			}
			ret[index + 1] = true;
			return ret;
		}
		old[index] = false;
		old[index + 1] = true;
		return old;
	}

	public static int solve(int[] max, boolean[] surprising, int p) {
		int ret = 0;
		for (int i = 0; i < max.length; ++ i) {
			if (surprising[i]) {
				if (max[i] < 2) {
					return 0;	// impossible
				}
				if (max[i] % 3 <= 1) {
					if (max[i] / 3 + 1 >= p) {
						ret ++;
					}
				} else {
					if (max[i] / 3 + 2 >= p) {
						ret ++;
					}
				}
			} else {
				if ((int)Math.ceil(max[i] / 3.0) >= p) {
					ret ++;
				}
			}
		}
		return ret;
	}
}
