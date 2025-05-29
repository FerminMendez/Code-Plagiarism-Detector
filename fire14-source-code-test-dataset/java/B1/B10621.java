package CaseSolvers;

import Controller.IO;

public class GooglereseCase extends CaseSolver {

	static Character[] opa;
	static {
		opa = new Character[26];
		opa['a' - 97] = 'y';
		opa['b' - 97] = 'h';
		opa['c' - 97] = 'e';
		opa['d' - 97] = 's';
		opa['e' - 97] = 'o';
		opa['f' - 97] = 'c';
		opa['g' - 97] = 'v';
		opa['h' - 97] = 'x';
		opa['i' - 97] = 'd';
		opa['j' - 97] = 'u';
		opa['k' - 97] = 'i';
		opa['l' - 97] = 'g';
		opa['m' - 97] = 'l';
		opa['n' - 97] = 'b';
		opa['o' - 97] = 'k';
		opa['p' - 97] = 'r';
		opa['q' - 97] = 'z';
		opa['r' - 97] = 't';
		opa['s' - 97] = 'n';
		opa['t' - 97] = 'w';
		opa['u' - 97] = 'j';
		opa['v' - 97] = 'p';
		opa['w' - 97] = 'f';
		opa['x' - 97] = 'm';
		opa['y' - 97] = 'a';
		opa['z' - 97] = 'q';
	}

	StringBuilder line;

	public GooglereseCase(int order, int numberOfLines, IO io) {
		super(order, numberOfLines, io);
	}

	@Override
	public void addLine(String line) {
		this.line = new StringBuilder(line);
	}

	@Override
	public void printSolution() {
		System.err.println("Case #" + getOrder() + ": " + line);
	}

	@Override
	public CaseSolver process() {
		for (int i = 0; i < line.length(); i++) {
			char temp = line.charAt(i);
			if (temp != ' ')
				line.setCharAt(i, opa[temp - 97]);
		}
		return this;
	}

	@Override
	public void initializeVars() {
		// TODO Auto-generated method stub

	}

}
