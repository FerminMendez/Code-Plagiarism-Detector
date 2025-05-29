import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Googlers {

	public static void main(String[] args) throws FileNotFoundException {
		new Googlers().doProcessing(new File("D:\\codejam\\B\\small.txt"));
	}

	public void doProcessing(File inputFile) throws FileNotFoundException {
		Scanner scanner = new Scanner(inputFile).useDelimiter("\n");
		if (scanner != null) {
			int totalCases = Integer.parseInt(scanner.next().trim());
			int k = 1 ;
			if (totalCases > 0) {
				while (scanner.hasNext()) {
					String[] rowValues = scanner.next().trim().split(" ");

					int totalGooglers = Integer.parseInt(rowValues[0]);
					// System.out.println("Total Googlers : " + totalGooglers);
					int totalSuprisingCases = Integer.parseInt(rowValues[1]);
					// System.out.println("Total Surprising Cases : " +
					// totalSuprisingCases);

					int averageScore = Integer.parseInt(rowValues[2]);
					// System.out.println("Total Success Cases : " +
					// averageScore);
					// System.out.println("Total Length : " + rowValues.length);

					int[] totalMarks = new int[totalGooglers];
					int j = 0;
					for (int i = 3; i < rowValues.length; i++) {
						totalMarks[j] = Integer.parseInt(rowValues[i].trim());
						// System.out.println("Value Put : " + totalMarks[j]);
						j++;
					}
					int successCase = getSuccessCase(totalGooglers,
							averageScore, totalSuprisingCases, totalMarks);
					System.out.println("Case #" + k++ + ": " + successCase);
				}

			}
		}
		scanner.close();
	}

	public boolean doNormalCase(int totalScore, int averageScore) {
		boolean success = false;
		int X3value = averageScore * 3;
		if (totalScore >= X3value) {
			success = true;
		} else if ((totalScore >= X3value - 1) || (totalScore >= X3value + 1)) {
			success = true;
		} else if ((totalScore >= X3value - 2) || (totalScore >= X3value + 2)) {
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	public boolean doSurprisingCase(int totalScore, int averageScore) {
		boolean success = false;
		int X3value = averageScore * 3;
		// System.out.println("Total Score : " + totalScore);
		// System.out.println("Average Score : " + X3value);
		if (((totalScore >= X3value - 3) || (totalScore >= X3value + 3))
				&& totalScore > averageScore) {
			success = true;
		} else if (((totalScore >= X3value - 4) || (totalScore >= X3value + 4))
				&& totalScore > averageScore) {
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	public int getSuccessCase(int totalCses, int averageScore,
			int surprisingCase, int[] caseValues) {
		int totalSuccess = 0;
		for (int i = 0; i < totalCses; i++) {
			// System.out.println("----------------------Value Put : " +
			// totalCses);
			boolean normalCaseSuccess = doNormalCase(caseValues[i],
					averageScore);
			if (!normalCaseSuccess) {
				if (surprisingCase > 0) {
					boolean surprisingCaseSuccess = doSurprisingCase(
							caseValues[i], averageScore);
					if (surprisingCaseSuccess) {
						// System.out.println("Surprising Success..." +
						// caseValues[i]);
						totalSuccess++;
						surprisingCase--;
					}
				}
			} else {
				totalSuccess++;
			}
		}
		return totalSuccess;
	}

}
