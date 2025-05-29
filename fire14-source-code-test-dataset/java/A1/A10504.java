package gcj2012.qualification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GooglerDance {
	public static void main(String[] args) throws Exception {
		GooglerDance main = new GooglerDance(args[0]);
		main.solve();
	}

	private final BufferedReader in;

	public GooglerDance(String input) throws Exception {
		in = new BufferedReader(new FileReader(this.getClass().getResource(input).getFile()));
	}

	private void solve() throws Exception {
		int T = getInt();
		for (int c = 1; c <= T; c++) {
			List<Integer> n = getIntegers();
			long ans = solveOne(n);
			System.out.println("Case #" + c + ": " + ans);
		}
	}

	private int solveOne(List<Integer> n) {
		int sum = 0;
		int N = n.remove(0).intValue();
		int S = n.remove(0).intValue();
		int p = n.remove(0).intValue();

		for (Integer candid : n) {
			if (candid.intValue() >= p * 3 - 2) {
				sum++;
			} else if (candid.intValue() >= p * 3 - 4 && S > 0 && p >= 2) {
				S--;
				sum++;
			}
		}

		return sum;
	}

	/*
	 * File processing
	 */
	private int getInt() throws Exception {
		return Integer.valueOf(in.readLine()).intValue();
	}

	private List<Integer> getIntegers() throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		for (String s : getStrs()) {
			list.add(Integer.valueOf(s));
		}
		return list;
	}

	private List<String> getStrs() throws Exception {
		return Arrays.asList(in.readLine().split(" "));
	}

}
