package CaseSolvers;

import java.util.ArrayList;

import Controller.IO;

public class DancingGooglersCase extends CaseSolver {

	public DancingGooglersCase(int order, int numberOfLines, IO io) {
		super(order, numberOfLines, io);
	}

	int sTriplets, scoreBase;
	ArrayList<Integer> triplesSum;

	@Override
	public void addLine(String line) {
		String[] temp = line.split(" ");

		sTriplets = Integer.parseInt(temp[1]);
		scoreBase = Integer.parseInt(temp[2]);

		triplesSum = new ArrayList<Integer>(temp.length - 3);
		for (int i = 3; i < temp.length; i++) {
			triplesSum.add(Integer.parseInt(temp[i]));
		}
	}

	private int notSTriplesThatFit() {
		int qt = 0, currentIndex;
		for (int i = 0; i - qt < triplesSum.size(); i++) {
			currentIndex = i - qt;
			if (fitNotSurprising(triplesSum.get(currentIndex))) {
				triplesSum.remove(currentIndex);
				qt++;
			}
		}
		return qt;
	}

	private int surprisingTriplesThatFit() {
		if (sTriplets <= 0) {
			return 0;
		}
		int qt = 0;
		for (Integer num : triplesSum) {
			if (fitSurprising(num)) {
				qt++;
				if (qt >= sTriplets) {
					break;
				}
			}
		}
		return qt;
	}

	public static int getMaxScoreNotSurprising(int num) {
		return num % 3 == 0 ? num / 3 : num / 3 + 1;
	}

	private boolean fitNotSurprising(int num) {
		return getMaxScoreNotSurprising(num) >= scoreBase;
	}

	public static int getMaxScoreSurprising(int num) {
		int maxScore = 0;
		if (num > 0) {
			maxScore = num % 3 == 0 ? num / 3 + 1 : num / 3 + num % 3;
		}
		return maxScore;
	}

	private boolean fitSurprising(int num) {
		return getMaxScoreSurprising(num) >= scoreBase;
	}

	@Override
	public void printSolution() {
		System.err.println("Case #" + getOrder() + ": " + result);
	}

	int result;

	@Override
	public CaseSolver process() {
		result = notSTriplesThatFit() + surprisingTriplesThatFit();
		return this;
	}

	@Override
	public void initializeVars() {
		// TODO Auto-generated method stub

	}

}
