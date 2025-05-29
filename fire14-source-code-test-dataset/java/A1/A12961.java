import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
	FileScanner in;
	PrintWriter out;
	String Filename = "trie";

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	public void run() throws Exception {
		Locale.setDefault(Locale.US);
		in = new FileScanner("input");
		out = new PrintWriter("output");

		solve();

		out.close();
	}
	
	void solve() throws Exception {
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			out.print("Case #" + (i + 1) + ": ");
			int num = in.nextInt();
			int sup = in.nextInt();
			int p = in.nextInt();
			int ans = 0;
			int mayBe = 0;
			for (int j = 0; j < num; j++) {
				int temp = in.nextInt();
				if (temp % 3 == 0) {
					if (temp / 3 >= p) {
						ans++;
						continue;
					}
					if ((temp / 3 + 1 >= p) && (temp / 3 - 1 >= 0)) {
						mayBe++;
						continue;
					}
					continue;
				}
				
				if (temp % 3 == 1) {
					if (temp / 3 + 1 >= p) {
						ans++;
						continue;
					}
					continue;
				}
				
				if (temp % 3 == 2) {
					if (temp / 3 + 1 >= p) {
						ans++;
						continue;
					}
					if ((temp / 3 + 2 >= p) && (temp / 3 + 2 < 11)) {
						mayBe++;
						continue;
					}
					continue;
				}
			}
			ans += Math.min(sup, mayBe);
			out.println(ans);
		}
	}
	
	class FileScanner {
		BufferedReader br;
		StringTokenizer st;

		public FileScanner(String File) throws Exception {
			br = new BufferedReader(new FileReader(File));
		}
		
		String nextLine() throws Exception {
			return br.readLine();
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(next());
		}
	}
}