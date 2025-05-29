
import java.util.*;

public class QualB12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int g = 0;

			for (int j = 1; j <= N; j++) {
				int a = in.nextInt();
				if (a/3 >= p) ++g;
				else if (a/3 >= p-2) {
					if (a/3 == p-1) {
						if (a%3 == 2) {
							++g;
						} 
						else if (a%3 == 1) {
							++g;
						}
						else if (a%3 == 0) {
							if (S > 0 && a/3 > 0) {
								++g;
								--S;
							}
						}
					}
					else if (a/3 == p-2) {
						if (a%3 == 2) {
							if (S > 0){
								++g;
								--S;
							}
						} 
					}
					else {
						System.out.println("a is " + a + " and p is " + p);
						assert false;
					}
				}
			}
			System.out.println("Case #" + i + ": " + g);

		}
	}

	/* Self-Made Test Cases

	  4
	  3 0 5 0 0 0
	  3 1 6 14 13 12
	  2 0 10 30 30
	  4 1 5 13 12 11 11

		Case #1: 0
		Case #2: 1
		Case #3: 2
		Case #4: 2

	 */
}

