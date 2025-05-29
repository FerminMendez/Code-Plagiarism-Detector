import java.util.Scanner;


public class ProblemC {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int lineCount = Integer.valueOf(in.nextLine());
		int[] T = new int[lineCount];

		for(int t = 0; t < lineCount; t++) {
			int A = in.nextInt(),
				B = in.nextInt(),
				count = 0;

			for (int n = A; n <= B; n++) {
				int digits = String.valueOf(n).length() - 1;
				String m = "" + n,
					   lastAdded = "";

				for (int i = 0; i < digits; i++) {
					int mi = Integer.valueOf(m = m.charAt(digits) + m.substring(0, digits));

					if (mi <= B && mi > n && !lastAdded.contains("" + mi)) {
						lastAdded += mi + " ";
						count++;
					}
				}
			}
			T[t] = count;
		}
		
		for(int i = 1; i <= lineCount; i++) {
			System.out.println("Case #" + i + ": " + T[i-1]);
		}
	}
}
