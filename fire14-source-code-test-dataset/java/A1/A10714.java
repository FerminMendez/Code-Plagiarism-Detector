import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
	static BufferedReader br;
	static PrintWriter pw;
	static StringTokenizer st;
	static int k, ch, v = 0;
	static int t, n, s, p, tmp;
	static String str;
	static String[] stray = new String[110];
	static int[] intray = new int[100];

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	char nextChar() throws IOException {
		return (char) br.read();
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("input.in"));
		pw = new PrintWriter("output.out");

		t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " \t\n\r,.");
			while (st.hasMoreTokens()) {
				stray[k] = st.nextToken();
				k++;
			}

			n = Integer.parseInt(stray[0]);
			s = Integer.parseInt(stray[1]);
			p = Integer.parseInt(stray[2]);

			for (int j = 3; j < k; j++) {
				intray[j - 3] = Integer.parseInt(stray[j]);
			}

			for (int j = 0; j < n; j++) {
				if (intray[j] == 0) {
					if (p == 0) {
						continue;
					} else {
						ch++;
						continue;
					}
				}
				if (intray[j] % 3 == 0) {
					tmp = intray[j] / 3;
					if (tmp >= p) {
						continue;
					} else {
						if (p - tmp <= 1) {
							if (s != 0) {
								s--;
								continue;
							} else {
								ch++;
								continue;
							}
						} else {
							ch++;
							continue;
						}
					}
				} else {
					tmp = (int) (intray[j] / 3 + 0.5);
					if (intray[j] % 3 == 1) {
						if (tmp + 1 >= p) {
							continue;
						} else {
							ch++;
							continue;
						}
					} else {
						if (tmp + 1 >= p) {
							continue;
						}
						if (tmp + 2 >= p) {
							if (s != 0) {
								s--;
								continue;
							} else {
								ch++;
								continue;
							}
						} else {
							ch++;
							continue;
						}
					}
				}
			}

			v++;
			pw.println("Case #" + v + ": " + (n - ch));

			ch = 0;
			k = 0;
		}

		br.close();
		pw.close();
	}
}