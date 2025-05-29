import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Run3 {
	class ll {
		public lln f;
		public lln l;
	}

	class lln {
		public Object v;
		public lln n;
	}

	private static Scanner sc;

	public static int gi() {
		return Integer.parseInt(sc.next());
	}

	public static String gn() {
		return sc.next();
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("B-small-attempt8.in"));
		System.setOut(new PrintStream("output.txt"));

		sc = new Scanner(System.in);

		int T = gi();

		for (int z = 0; z < T; z++) {

			int N = gi();
			int S = gi();
			int P = gi();

			int[] ti = new int[N];
			for(int i = 0; i < N; i++) {
				ti[i] = gi();
			}

			int c = 0;
			int[][] sc = new int[N][3];
			//System.out.println("z: " + z);
			//System.out.println("N: " + N);
			//System.out.println("S: " + S);
			//ystem.out.println("P: " + P);
			//System.out.println(/*N + " " + */S + " " + P /*+ ' ' + z + " "*/);

			int temp = 0;
			for(int i = 0; i < N; i++) {
				temp = ti[i];
				for(int j = 2; j >= 0; j--) {
					sc[i][j] = temp/(j+1);
					temp -= temp/(j+1);
				}
				Arrays.sort(sc[i]);
				//System.out.println(ti[i] + "\t" + sc[i][0] + "," + sc[i][1] + ","  + sc[i][2] + "\t" + (sc[i][0] + sc[i][1] + sc[i][2]));
			}

			int c2 = 0;
			boolean incc2;

			for (int i = 0; i < N; i++) {
				incc2 = false;
				if(c2 < S) {
					if(sc[i][2] < P && sc[i][2] + 1 == P) {
						/*if(sc[i][2] - sc[i][0] == 1 && sc[i][2] - sc[i][1] == 0) {
							sc[i][2] += 1;
							sc[i][1] -= 1;
							incc2 = true;
						}
						else */
						if(sc[i][0] > 0 && sc[i][2] - sc[i][0] == 0) {
							sc[i][2] += 1;
							sc[i][0] -= 1;
							incc2 = true;
						}
						else if(sc[i][1] > 0 && sc[i][2] - sc[i][0] == 1 && sc[i][2] - sc[i][1] == 0) {
							sc[i][2] += 1;
							sc[i][1] -= 1;
							incc2 = true;
						}
					}
					if(incc2) {
						c2++;
					}
				}
				if(sc[i][2] >= P) {
					c++;
				}
			}

			System.out.format("Case #%d: %d\r\n", z + 1, c);
		}
	}

}
