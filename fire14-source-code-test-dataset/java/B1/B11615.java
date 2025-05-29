package quiz2012.quiz3;

import java.util.HashSet;
import java.util.Set;

import domain.QuizSolver;
import domain.QuizTestCaseInput;
import domain.QuizTestCaseOutput;

public class Quiz3Solver implements QuizSolver {
	@Override
	public QuizTestCaseOutput solve(QuizTestCaseInput testCaseInput) {
		Quiz3TestCaseInput input = (Quiz3TestCaseInput) testCaseInput;

		int numberOfRecycledPairs = 0;

		int n = input.getN();
		String nAsString = String.valueOf(n);
		int numberOfDigitsOfN = nAsString.length();
		int m = input.getM();

		// TODO: Remove if the following case can be generalized.
		if (numberOfDigitsOfN == 1) {
			return new Quiz3TestCaseOutput(numberOfRecycledPairs);
		}

		for (int i = n; i < m; i++) {
			Set<Integer> recycledValueSet = new HashSet<Integer>();
			for (int j = 1; j < numberOfDigitsOfN; j++) {
				int recycledValue = shiftDigitsLeft(i, j);
				if (recycledValue > i && recycledValue <= m) {
					recycledValueSet.add(recycledValue);
					System.out.println(i + ", " + recycledValue);
				}
			}

			numberOfRecycledPairs += recycledValueSet.size();
		}
		return new Quiz3TestCaseOutput(numberOfRecycledPairs);
	}

	public int shiftDigitsLeft(int n, int numberOfShifts) {
		String nAsString = String.valueOf(n);
		StringBuffer sb = new StringBuffer();
		int numberOfDigitsOfN = nAsString.length();
		for (int i = 0; i < numberOfDigitsOfN; i++) {
			sb.append(nAsString.charAt((numberOfDigitsOfN + i - numberOfShifts)
					% numberOfDigitsOfN));
		}
		return Integer.valueOf(sb.toString());
	}
}
