import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Dancing {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("dancing.in"));
		PrintWriter out = new PrintWriter(new FileWriter("dancing.out"));

		String lineStr;
		int T, N, S, P, ti, result;

		T = Integer.parseInt(in.readLine());
		System.out.println(T + " test cases");

		for (int line = 1; line <= T; line++) {

			lineStr = in.readLine();
			String[] fields = lineStr.split(" ");
			N = Integer.parseInt(fields[0]);
			S = Integer.parseInt(fields[1]);
			P = Integer.parseInt(fields[2]);

			System.out.println("N=" + N + " S=" + S + " P=" + P);

			result = 0;
			for (int i = 0; i < N; i++) {
				ti = Integer.parseInt(fields[3 + i]);
				if (ti > (3 * (P - 1))) {
					// Guaranteed to have at least P and without surprise
					result++;
				} else if (ti >= 2 && ti <= 28 && ti >= (3 * (P - 1) - 1)) {
					// Have p but with surprise
					if (S > 0) {
						result++;
						// reduce available surprise
						S = S - 1;
					}
				}
			}

			out.println("Case #" + line + ": " + result);
			System.out.println(lineStr + " : " + result);
		}

		in.close();
		out.close();
	}

}
