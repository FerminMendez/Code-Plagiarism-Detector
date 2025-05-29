package be.mokarea.gcj.recyclednumbers;

import be.mokarea.gcj.common.TestCase;

public class RecycledNumbersTestCase extends TestCase {
	private final int a;
	private final int b;

	protected RecycledNumbersTestCase(int caseNumber, int a, int b) {
		super(caseNumber);
		this.a = a;
		this.b = b;
	}
	
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
}
