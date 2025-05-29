package de.johanneslauber.codejam;

import java.io.IOException;

/**
 * 
 * @author Johannes Lauber - joh.lauber@googlemail.com
 * 
 */
public class Main {

	/**
	 * @author Johannes Lauber - joh.lauber@googlemail.com
	 * @param Args
	 */
	public static void main(String[] Args) {
		long millis = System.currentTimeMillis();

		// solveProblem("input/A-small-practice.in", "StoreCredit");
		// solveProblem("input/A-large-practice.in", "StoreCredit");
		// solveProblem("input/B-small-practice.in", "ReverseWords");
		// solveProblem("input/B-large-practice.in", "ReverseWords");
		// solveProblem("input/C-small-practice.in", "T9Spelling");
		// solveProblem("input/C-large-practice.in", "T9Spelling");
		// solveProblem("input/A-small-practice.in", "SpeakinginTongues");
		// solveProblem("input/B-large.in", "DancingGooglers");
		solveProblem("input/C-small-attempt.in", "RecycledNumbers");

		System.out.println(System.currentTimeMillis() - millis);
	}

	/**
	 * 
	 * @author Johannes Lauber - joh.lauber@googlemail.com
	 * @param fileName
	 * @param problemName
	 */
	private static void solveProblem(String fileName, String problemName) {
		CaseProvider caseProvider = new CaseProvider();
		try {
			try {
				caseProvider.importFile(
						fileName,
						Class.forName("de.johanneslauber.codejam.model.impl."
								+ problemName + "Case"));

				caseProvider.solveCases(Class
						.forName("de.johanneslauber.codejam.model.impl."
								+ problemName + "Problem"));
			} catch (ClassNotFoundException e) {
				System.out.println("Error finding implemented Case: "
						+ e.getMessage());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}