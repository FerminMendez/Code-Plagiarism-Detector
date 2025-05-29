import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dance {

	private static final int[] maxBestResult = { 0, 1, 2 };
	private static final int[] maxBestResultSurprise = { 0, 1, 2 };
	private static final int[] minBestResult = { 0, 1, 2 };
	private static final int[] minBestResultSurprise = { 0, 1, 2 };

	public static void main(String[] args) throws IOException {
		long t0 = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new FileReader("in.txt"));
		PrintWriter out = new PrintWriter("out.txt");
		int t = Integer.parseInt(in.readLine());
		for (int i = 1; i <= t; i++) {
			String[] ss = in.readLine().split(" ");
			int idx = 0;
			int n = Integer.parseInt(ss[idx++]); // number of Googlers
			int s = Integer.parseInt(ss[idx++]); // number of Surprises
			int p = Integer.parseInt(ss[idx++]); // minimum score
			int[] sums = new int[n];
			for (int j = 0; j < n; j++) {
				sums[j] = Integer.parseInt(ss[idx++]);
			}
			int result = compute(sums, s, p);
			out.println("Case #" + i + ": " + result);
			System.out.println("Case #" + i + ": " + result);
		}
		out.close();
		System.out.println("time: " + (System.currentTimeMillis() - t0));
	}

	private static int compute(int[] sums, int s, int p) {
		if (p == 0)
			return sums.length;
		int pointsRequiredWithOutSurprise = Math.max(1, (p * 3) - 2); // p, p-1, p-1
		int pointsRequiredWithSurprise = Math.max(2, (p * 3) - 4); // p, p-2, p-2
		int result = 0;
		for (int i = 0; i < sums.length; i++) {
			int sum = sums[i];
			if (sum >= pointsRequiredWithOutSurprise) {
				result++;
				// splitStd(sum);
			} else if (s > 0 && sum >= pointsRequiredWithSurprise) {
				s--;
				result++;
				// splitSurprise(sum);
			} else {
				// failed
				// splitStd(sum);
			}
		}
		return result;
	}

	private static void splitStd(int sum) {
		switch (sum % 3) {
		case 0:
			System.out.println(sum + ": " + sum / 3 + "," + sum / 3 + "," + sum / 3);
			break;
		case 1:
			System.out.println(sum + ": " + (1 + sum / 3) + "," + sum / 3 + "," + sum / 3);
			break;
		case 2:
			System.out.println(sum + ": " + (1 + sum / 3) + "," + (1 + sum / 3) + "," + sum / 3);
			break;
		}
	}

	private static void splitSurprise(int sum) {
		switch (sum % 3) {
		case 0:
			System.out.println(sum + ": " + (1 + sum / 3) + "," + sum / 3 + "," + (sum / 3 - 1));
			break;
		case 1:
			System.out.println(sum + ": " + (1 + sum / 3) + "," + (sum / 3 - 1) + "," + (sum / 3 - 1));
			break;
		case 2:
			System.out.println(sum + ": " + (2 + sum / 3) + "," + (sum / 3) + "," + sum / 3);
			break;
		}
	}

}
