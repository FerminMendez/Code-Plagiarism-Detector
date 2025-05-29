import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class DancingGooglers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			List<Integer> scores = new ArrayList<Integer>();
			for (int j = 0; j < N; j++)
				scores.add(in.nextInt());
			System.out.println("Case #" + i + ": " + result(S, p, scores));
		}
	}

	private static int result(int S, int p, List<Integer> scores) {
		Integer[] v = scores.toArray(new Integer[0]);
		Arrays.sort(v);
		int res = 0;
		int nosup = p + 2*(Math.max(p-1, 0));
		int sup = p + 2*(Math.max(p-2, 0));
		for (int i = v.length-1; i >= 0; i--)
			if (v[i] >= nosup)
				res++;
			else if (v[i] >= sup && S > 0) {
				res++;
				S--;
			}
			else
				return res;
		return res;
	}
	
}
