package org.moriraaca.codejam.recyclednumbers;

import java.util.HashSet;

import org.moriraaca.codejam.AbstractSolver;
import org.moriraaca.codejam.OutputDestination;
import org.moriraaca.codejam.SolverConfiguration;

@SolverConfiguration(parser = RecycledNumberDataParser.class, inputFileName = "ultra-large.in", outputDestination=OutputDestination.FILE)
public class RecycledNumbersSolver extends
		AbstractSolver<RecycledNumbersTestCase> {
	
	public static void main(String[] args) {
		new RecycledNumbersSolver().getSolution();
	}
	
	private int digitsNumber;
	
	private int headShift;
	
	private HashSet<Integer> usedNumbers = new HashSet<Integer>();

	@Override
	protected String solveTestCase(RecycledNumbersTestCase testCase) {
		int counter = 0;
		
		digitsNumber = String.valueOf(testCase.A).length();
		
		headShift = 1;
		
		for (int i = 0; i < digitsNumber; i++) {
			headShift *= 10;
		}
		
		for (int i = testCase.A; i <= testCase.B; i++) {
			counter += rotateNumber(i, testCase.B);
		}
		
		return String.valueOf(counter);
	}

	private int rotateNumber(int number, int B) {
		int counter = 0;
		
		int orginalNumber = number;
		
		usedNumbers.clear();
		
		for(int i = 1; i < digitsNumber; i++) {
			number += (number % 10) * headShift;
			number /= 10;
			
			if (number > orginalNumber && number < B && !usedNumbers.contains(number)) {
				counter++;
				usedNumbers.add(number);
			}
		}
		
		return counter;
	}
}
