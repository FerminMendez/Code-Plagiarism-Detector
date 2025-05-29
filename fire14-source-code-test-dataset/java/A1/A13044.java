package gcj2012.Qual.B;

import gcj2011.common.CommonCombinatorics;
import gcj2011.common.InOut;
import gcj2011.common.InOut.debug;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solver {

	private int N, S, P;
	private int[] googlers;

	public String solve() {
		N = InOut.readInt();
		S = InOut.readInt();
		P = InOut.readInt();

		googlers = new int[N];
		for (int i = 0; i < N; ++i)
			googlers[i] = InOut.readInt();

		List<Integer> listN = new ArrayList<Integer>();
		for (int i = 0; i < N; ++i)
			listN.add(i);

		int result = 0;

		for (int i = 0; i < (1 << N); ++i) {
			Set<Integer> subset = CommonCombinatorics.getSubset(listN, i);
			if (subset.size() != S)
				continue;

			if (isPossible(subset))
				result = Math.max(result, getResult(subset));
		}

		return "" + result;
	}

	private int getResult(Set<Integer> subset) {
		int result = 0;
		for (int i = 0; i < N; ++i) {
			int g = googlers[i];
			int x = subset.contains(i) ? 2 : 1;
			
			if (g==0)
				x = 0;
			
			result += ((g - x) / 3 + x >= P) ? 1 : 0;
		}
		return result;
	}

	private boolean isPossible(Set<Integer> subset) {
		for (int i : subset)
			if (googlers[i] < 2 || googlers[i] > 28)
				return false;
		return true;
	}

	/************************************/

	public static void main(String[] args) {
		InOut.setPrintDebug(debug.out);
		long time0 = System.currentTimeMillis();

		InOut.readInput(pathIn);
		int D = InOut.readInt();
		for (int d = 1; d <= D; ++d)
			InOut.writeLnString("Case #" + d + ": " + new Solver().solve());
		InOut.writeFile(pathMyOut);
		CompareOut();

		long time1 = System.currentTimeMillis();
		double t = (int) ((time1 - time0) / 100) / 10.0;
		System.out.println("TIME: " + t);
	}

	private static void CompareOut() {
		try {
			String[] pass = InOut.compareFilesCharByChar(pathOut, pathMyOut);

			if (pass == null)
				System.out.println("PASSED");
			else
				System.out.println("FAILED!\n\nexpected	" + pass[0] + "\nreceived	" + pass[1]);
		} catch (FileNotFoundException e) {
			System.out.println("hopefully ok");
		}
	}

	private final static String testPath = "src/" + Solver.class.getPackage().getName().replace(".", "/") + "/";
	private final static String testName = "B-small-attempt0";
	private final static String pathIn = testPath + testName + ".in";
	private final static String pathOut = testPath + testName + ".out";
	private final static String pathMyOut = testPath + testName + ".myout";
}
