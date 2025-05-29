package qualification.c;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import common.ClockWatch;
import common.ISolver;
import common.QuestionHandler;

public class RecycledNumbers implements ISolver {

	private int addCountSign(Set<Integer> signatures, Set<Integer> tmpSig,
			int val, int min, int max) {
		String valStr = String.valueOf(val);
		int len = valStr.length();
		char[] chars = new char[len * 2];
		for (int i = 0; i < len; ++i) {
			chars[i] = valStr.charAt(i);
			chars[i + len] = valStr.charAt(i);
		}
		int presentSigCount = 0;
		tmpSig.clear();
		for (int i = 1; i < len; ++i) {
			if (chars[i] != '0') {
				Integer sig = Integer.valueOf(new String(chars, i, len));
				if (sig >= min && sig <= max) {
					if (tmpSig.add(sig) && signatures.contains(sig)) {
						++presentSigCount;
					}
				}
			}
		}
		signatures.add(val);
		return presentSigCount;
	}

	@Override
	public String solve(String problem) {
		Scanner scan = new Scanner(problem);
		int min = scan.nextInt();
		int max = scan.nextInt();

		Set<Integer> signatures = new HashSet<Integer>();
		Set<Integer> tmpSig = new HashSet<Integer>();
		int result = 0;
		for (int i = min; i <= max; ++i) {
			result += addCountSign(signatures, tmpSig, i, min, max);
		}

		return String.valueOf(result);
	}

	@Override
	public void addCase(String problem, String answer) {
		String myAnswer = solve(problem);
		if (!myAnswer.equals(answer)) {
			throw new RuntimeException("Invalid prediction for '" + problem
					+ "'. Expected '" + answer + "' got '" + myAnswer + "'");
		}

	}

	public static void main(String[] args) {
		ClockWatch watch = new ClockWatch();
		QuestionHandler questionHandler = new QuestionHandler(
				new RecycledNumbers());
		questionHandler.addResource("sample.in", "sample.out");

		watch.tic();
		// System.out.println("Sample input:");
		// questionHandler.solve("sample.in", "sample.out");

		System.out.println("\nSmall input:");
		questionHandler.solve("small.in", "small.out");

		// System.out.println("\nLarge input:");
		// questionHandler.solve("large.in", "large.out");
		watch.printTocSecs();
	}
}
