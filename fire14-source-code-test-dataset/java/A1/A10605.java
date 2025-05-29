package assignments;

import java.util.Scanner;

import base.Assignment;

public class AssignmentB implements Assignment {
	int bestResult;
	int numberOfGooglers;
	int numberOfSurprises;
	int[] test;
	@Override
	public String solve() {
		int minNeeded = 3*bestResult - 2;
		int minNeededWithSurprise = 3*bestResult - 4;
		int total = 0;
		for (int i : test) {
			if (i >= minNeeded) {
				total++;
			} else if (i >= minNeededWithSurprise && numberOfSurprises > 0 && bestResult > 1) {
				total++;
				numberOfSurprises--;
			}
			
		}
		return "" + total;
	}

	public static Assignment createFromScanner(Scanner scanner) {
		AssignmentB assignment = new AssignmentB();
		assignment.numberOfGooglers = scanner.nextInt();
		assignment.numberOfSurprises = scanner.nextInt();
		assignment.bestResult = scanner.nextInt();
		assignment.test = new int[assignment.numberOfGooglers];
		for (int i = 0; i < assignment.numberOfGooglers; i++) {
			assignment.test[i] = scanner.nextInt();
		}
		return assignment;
	}
}
