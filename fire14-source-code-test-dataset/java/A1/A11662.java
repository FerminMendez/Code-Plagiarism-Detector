import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public final class DancingWithTheGooglers {

	private static String solve(final int N, int S, final int p, int points[]) {
		int res = 0;
		for (int t:points) {
			switch (t%3) {
			case 0:
				if (t/3>=p) res++;
				else if (t >= 3 && t<30 && t>=3 && t/3+1>=p && S>0) { res++; S--; }
				break;
			case 1:
				if (t/3+1>=p) res++;
				break;
			case 2:
				if (t/3+1>=p) res++;
				else if (t<29 && t/3+2>=p && S>0) { res++; S--; }
				break;
			}
		}
		return ""+res;
	}

	public static void main(String[] args) throws FileNotFoundException {
		//String filename = "B-test.in";
		String filename = "B-small-attempt0.in";
		assert filename.endsWith(".in");
		Scanner in = new Scanner(new File(filename));
		Formatter out = new Formatter(new File(filename.replace(".in", ".out")));

		assert in.hasNext();
		int T = in.nextInt();
		in.nextLine();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int points[] = new int[N];
			for (int i = 0; i < N; i++)
				points[i] = in.nextInt();

			String ans = solve(N, S, p, points);

			String result;
			if (t < T - 1)
				result = String.format("Case #%d: %s%n", t + 1, ans);
			else
				result = String.format("Case #%d: %s", t + 1, ans);
			out.format(result);
			System.out.format(result);
		}

		out.flush();
		out.close();
	}

}
