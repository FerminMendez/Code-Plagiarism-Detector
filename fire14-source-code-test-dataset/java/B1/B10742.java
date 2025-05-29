import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
	static BufferedReader br;
	static PrintWriter pw;
	static StringTokenizer st;
	static int k, ch, chmp, btmp, bchmp = 0;
	static int n, tmp;
	static String str, ch1, ch2;
	static String[] stray = new String[2];
	static int[] intray = new int[2];
	static String[] copy = new String[2000001];

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

		n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " \t\n\r,.");
			while (st.hasMoreTokens()) {
				stray[k] = st.nextToken();
				k++;
			}

			for (int j = 0; j < 2; j++) {
				intray[j] = Integer.parseInt(stray[j]);
			}

			for (int j = intray[0]; j < intray[1] - 1; j++) {
				for (int p = j + 1; p <= intray[1]; p++) {
					ch1 = Integer.toString(j);
					ch2 = Integer.toString(p);
					if (ch1.length() != ch2.length()) {
						continue;
					}
					tmp = ch1.length();
					for (int k1 = 0; k1 < tmp; k1++) {
						ch1 = ch1.charAt(tmp - 1) + ch1;
						for (int k2 = 0; k2 < tmp; k2++) {
							if (ch1.charAt(k2) == ch2.charAt(k2)) {
								chmp++;
							} else {
								break;
							}
						}
						if (chmp == tmp) {
							for (int j1 = 0; j1 < btmp; j1++) {
								bchmp = 0;
								for (int k2 = 0; k2 < tmp; k2++) {
									if (ch1.charAt(k2) == copy[j1].charAt(k2)) {
										bchmp++;
									} else {
										continue;
									}
								}
							}

							if (bchmp == tmp) {
								chmp = 0;
								break;
							}

							str = "";
							for (int j1 = 0; j1 < tmp; j1++) {
								str += ch1.charAt(j1);
							}
							copy[btmp] = str;
							btmp++;
							ch++;
						}
						chmp = 0;
					}
					bchmp = 0;
				}
			}
			btmp = 0;
			pw.println("Case #" + i + ": " + ch);
			ch = 0;
			k = 0;
		}

		br.close();
		pw.close();
	}
}