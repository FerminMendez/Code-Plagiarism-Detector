package codejam.surprisingGooglers;

import java.util.List;

public class SurprisingGooglers {

	public static void main(String[] args) {
		if (args.length==0) {
			System.out.println("Argument one should be input filename");
		}
		else {
			Solver solver = new Solver();
			List<ProblemCase> cases = new CaseReader(args[0]).getCases();
			int i = 1;
			for (ProblemCase inputCase : cases) {
				System.out.println("Case #"+(i++)+": "+solver.getMaximumNumberOfPHavers(inputCase.getSurpriseCount(), inputCase.getP(), inputCase.getScores()));
			}
		}

	}
	
}
