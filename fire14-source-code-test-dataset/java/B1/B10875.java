package de.at.codejam.problem3.util;

import de.at.codejam.problem3.Problem3Case;
import de.at.codejam.util.AbstractCaseSolver;
import de.at.codejam.util.TaskStatus;

public class Problem3CaseSolver extends AbstractCaseSolver<Problem3Case> {

	@Override
	public String solveCase(TaskStatus taskStatus, Problem3Case caseToSolve) {

		StringBuilder resultBuilder = new StringBuilder(" ");

		String numberA = caseToSolve.getNumberA();
		String numberB = caseToSolve.getNumberB();

		int length = numberA.length();

		Integer numberN = Integer.parseInt(numberA);
		Integer numberM = Integer.parseInt(numberB);

		int numberRecycled = 0;

		while (numberN.intValue() < numberM.intValue()) {

			while (numberN.intValue() < numberM.intValue()) {

				for (int i = 1; i < length; i++) {

					String substringStartNumberN = numberN.toString()
							.substring(length - i);
					String substringEndNumberM = numberN.toString().substring(
							0, (length - i));

					log(LOGLEVEL_TRACE, numberN + ", " + numberM + ", "
							+ substringStartNumberN + ", "
							+ substringEndNumberM);

					if (numberM.toString().startsWith(substringStartNumberN)
							&& numberM.toString().endsWith(substringEndNumberM)) {

						log(LOGLEVEL_TRACE, "Found: " + numberN + "," + numberM);
						numberRecycled++;
						break;
					}
				}
				numberM = numberM.intValue() - 1;
			}

			numberM = Integer.parseInt(numberB);
			numberN = numberN.intValue() + 1;
		}

		resultBuilder.append(numberRecycled);
		return getDefaultResultBegin(taskStatus) + resultBuilder.toString();
	}
}
