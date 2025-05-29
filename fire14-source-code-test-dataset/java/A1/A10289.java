package qualification.b;

import java.util.Scanner;

import common.ISolver;
import common.QuestionHandler;

public class GoggleDancing implements ISolver {

	@Override
	public String solve(String problem) {
		Scanner scan = new Scanner(problem);
		int nGogglers = scan.nextInt();
		int suprising = scan.nextInt();
		int pLeastBest = scan.nextInt();
		int maxWithLeastBest = 0;
		
		int minScoreSum = pLeastBest + 2*(Math.max(pLeastBest-1, 0));
		int minScoreSumWithSurprise = pLeastBest + 2*(Math.max(pLeastBest-2, 0));
		for (int i=0; i<nGogglers; ++i) {
			int sumScore = scan.nextInt();
			if (sumScore >= minScoreSum) {
				++maxWithLeastBest;
			} else if (suprising > 0 && sumScore >= minScoreSumWithSurprise) {
				++maxWithLeastBest;
				--suprising;
			}
		}
		return String.valueOf(maxWithLeastBest);
	}

	@Override
	public void addCase(String problem, String answer) {
		String myAnswer = solve(problem);
		if (!myAnswer.equals(answer)) {
			throw new RuntimeException("Invalid prediction");
		}
		
	}

	public static void main(String[] args) {
		QuestionHandler questionHandler = new QuestionHandler(new GoggleDancing());
		questionHandler.addResource("sample.in", "sample.out");
		
		System.out.println("Sample input:");
		questionHandler.solve("sample.in", "sample.out");
		
		System.out.println("\nSmall input:");
		questionHandler.solve("small.in", "small.out");
	}
}
