package CaseSolvers;

import java.util.ArrayList;

import Controller.IO;

public class AllYourBaseCase extends CaseSolver {

	private String originalLine;
	private StringBuilder currentLine;
	private long numOfSeconds;

	public AllYourBaseCase(int order, int numberOfLines, IO io) {
		super(order, numberOfLines, io);
	}

	@Override
	public void addLine(String line) {
		this.originalLine = line;
		this.currentLine = new StringBuilder(line);
	}

	@Override
	public void initializeVars() {

	}

	@Override
	public void printSolution() {
		System.err.println("Case #" + getOrder() + ": " + numOfSeconds);
	}

	@Override
	public CaseSolver process() {
		ArrayList<Character> chars = getDifDigits();
		int base = chars.size() > 1 ? chars.size() : 2;
		replaceDigits(chars, base);
		numOfSeconds = getNumberInBase10(base);
		return this;
	}

	private long getNumberInBase10(int originalBase) {
		long num = 0, lenght = currentLine.length();
		for (int i = 0; i < lenght; i++) {
			num += getIntByChar(currentLine.charAt(i))
					* Math.pow(originalBase, lenght - (i + 1));
		}
		return num;
	}

	private int getIntByChar(char charAt) {
		if (charAt <= 58) {
			return charAt - 48;
		}
		return charAt - 96 + 9;
	}

	private void replaceDigits(ArrayList<Character> chars, int base) {
		replace(chars.remove(0), getNumberChar(1));
		if (chars.size() == 0) {
			return;
		}
		replace(chars.remove(0), getNumberChar(0));

		int tmp = 2;
		for (char aaa : chars) {
			replace(aaa, getNumberChar(tmp));
			tmp++;
		}
	}

	private String replace(char a, char b) {
		String temp = null;
		int index = -1;
		do {
			index = originalLine.indexOf(a, index + 1);
			if (index > -1) {
				currentLine.setCharAt(index, b);
			}
		} while (index > -1);

		return temp;
	}

	private char getNumberChar(int number) {
		if (number < 10) {
			return (char) (number + 48);
		}
		return (char) (97 + number - 10);
	}

	private ArrayList<Character> getDifDigits() {
		ArrayList<Character> tmp = new ArrayList<Character>();
		char tempChar;
		for (int i = 0; i < originalLine.length(); i++) {
			tempChar = originalLine.charAt(i);
			if (!tmp.contains(tempChar)) {
				tmp.add(originalLine.charAt(i));
			}
		}
		return tmp;
	}

}
