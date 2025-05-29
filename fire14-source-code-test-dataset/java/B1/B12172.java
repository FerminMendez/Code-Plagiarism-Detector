import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Runner {

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
		System.setIn(new FileInputStream("C-small-attempt2.in"));
		System.setOut(new PrintStream("output.txt"));

		sc = new Scanner(System.in);

		int N = gi();

		for (int z = 0; z < N; z++) {

			int o = gi();
			int t = gi();

			int c = 0;

			for (int m = o + 1; m <= t; m++) {
				for (int n = o; n < m; n++) {
					String ms = new Integer(m).toString();
					String ns = new Integer(n).toString();

					ns = ns.substring(ns.length() - 1) + ns.substring(0, ns.length() - 1);

					for (int i = 0; i < ms.length() - 1; i++) {
						//System.out.println("M: " + ms + " N: " + ns);
						if(ns.equals(ms)) {
							c++;
							break;
						}
						//System.out.println("Pre: " + ns + " ms: " + ms);
						ns = ns.substring(ns.length() - 1) + ns.substring(0, ns.length() - 1);
						//System.out.println("Post: " + ns + " i: " + i);
					}
				}
			}

			System.out.format("Case #%d: %d\r\n", z + 1, c);
		}
	}

}
