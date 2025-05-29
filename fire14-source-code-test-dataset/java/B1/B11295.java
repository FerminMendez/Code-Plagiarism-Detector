import java.util.Scanner;

public class prob_3 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();

		for (int index = 0; index < cases; index++) {
			int A = in.nextInt();
			int B = in.nextInt();
			int possiblePermutations = (A + "").length() - 1;

			String parse;
			int count = 0;
			int m;

			int[] perms;
			for (int n = A; n < B; n++) {
				perms = new int[possiblePermutations];
				for (int i = 0; i < possiblePermutations; i++) {
					parse = n + "";
					parse = parse.substring(i + 1) + parse.substring(0, i + 1);
					m = Integer.parseInt(parse);
					perms[i] = m;
					if ((n < m) && (m <= B))
						if (counted(perms, i))
							count++;
				}
			}
			System.out.println("Case #" + (index + 1) + ": " + count);
		}
	}

	private static boolean counted(int[] perms, int i) {
		for (int j = 0; j < i; j++)
			if (perms[i] == perms[j])
				return false;

		return true;
	}
}