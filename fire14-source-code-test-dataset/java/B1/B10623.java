package CaseSolvers;

import Controller.IO;

public class RecycledNumbersCase extends CaseSolver {

	public RecycledNumbersCase(int order, int numberOfLines, IO io) {
		super(order, numberOfLines, io);
	}

	int a, b;

	@Override
	public void addLine(String line) {
		String[] str = line.split(" ");
		a = Integer.parseInt(str[0]);
		b = Integer.parseInt(str[1]);
	}

	@Override
	public void printSolution() {
		System.err.println("Case #" + getOrder() + ": " + cont);
	}

	int cont;

	@Override
	public CaseSolver process() {
		for (int m = a; m < b; m++) {
			for (int n = m + 1; n <= b; n++) {
				//System.err.println(m + " e " + n);
				if (isRecycled(m, n)) {
					cont++;
				}
			}
		}

		return this;
	}

	private boolean isRecycled(int m, int n) {
		StringBuilder a = new StringBuilder("" + m);
		String b = "" + n;

		for (int i = 0; i < a.length() - 1; i++) {
			a.insert(0, a.charAt(a.length() - 1)).deleteCharAt(a.length() - 1);
			if (a.toString().equals(b)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void initializeVars() {
		// TODO Auto-generated method stub

	}

}
