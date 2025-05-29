import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeJam {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			int testCaseCount = scanner.nextInt();
			for (int i = 0; i < testCaseCount; i++) {
				int A = scanner.nextInt();
				int B = scanner.nextInt();

				int counter = 0;

				Set<String> pairs = new HashSet<String>();
				for (int n = A; n < B; n++) {
					String startString = String.valueOf(n);
					for (int k = 1; k < startString.length(); k++) {
						int startPos = startString.length() - k;
						if (startString.charAt(startPos) == '0') {
							continue;
						}

						StringBuilder sb = new StringBuilder(startString);
						char[] chars = new char[k];
						sb.getChars(startPos, startString.length(), chars, 0);
						sb.delete(startPos, startString.length());
						sb.insert(0, chars);

						int m = Integer.valueOf(sb.toString());
						if (n < m && m <= B) {
							pairs.add(String.format("%d %d", n, m));
						}
					}
				}

				System.out.println(String.format("Case #%d: %d", i + 1, pairs.size()));
			}
		} finally {
			scanner.close();
		}
	}

}
