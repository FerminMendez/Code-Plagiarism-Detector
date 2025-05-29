import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C {

	public void solve() throws FileNotFoundException {
		Scanner in = new Scanner(new File("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter("C-small-attempt0.out");

		int testN = in.nextInt();

		for (int i = 1; i <= testN; i++) {
			out.print("Case #" + i + ": ");
			int a = in.nextInt();
			int b = in.nextInt();
			int recycled = 0;
			StringBuilder sb;

			if (b > 9) {
				for (int x = a; x <= b; x++) {
					sb = new StringBuilder(Integer.toString(x));

					for (int y = 0; y < sb.length() - 1; y++) {
						int v = backToFront(sb);

						recycled += isRecycled(v, x, b);
					}

				}

			}
			out.println(recycled);
		}

		in.close();
		out.close();

	}

	public int backToFront(StringBuilder sb) {

		char c = sb.charAt(sb.length() - 1);

		sb.deleteCharAt(sb.length() - 1);

		sb.insert(0, c);

		int x = Integer.parseInt(sb.toString());

		return x;
	}

	public int isRecycled(int v, int x, int b) {
		int r = 0;

		if (v > x && v <= b)
			for (int i = x; i <= b; i++) {
				if (v == i) {
					r++;
				}
			}

		return r;
	}

	public static void main(String[] args) throws FileNotFoundException {
		new C().solve();
	}
}
