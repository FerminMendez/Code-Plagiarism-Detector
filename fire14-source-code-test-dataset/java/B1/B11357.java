import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		int T = Integer.valueOf(str);
		int[] A = new int[T];
		int[] B = new int[T];
		int[] res = new int[T];
		for (int i = 0; i < T; i++) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}

		for (int i = 0; i < T; i++) {
			
			for (int n = A[i]; n < B[i]; n++) {
				Set<String> pairs = new HashSet<String>();
				String jstr = String.valueOf(n);
				for (int j = 0; j < jstr.length() - 1; j++) {

					jstr = jstr.charAt(jstr.length() - 1)
							+ jstr.substring(0, jstr.length() - 1);
					int m = Integer.valueOf(jstr);

					if (n < m && m <= B[i]) {
						if (!pairs.contains(n + "," + m)) {
							pairs.add(n + "," + m);
							res[i]++;
						}
					}
				}

			}
			System.out.println("Case #" + (i + 1) + ": " + res[i]);
		}
	}

}
