package be.mokarea.gcj.common;

public abstract class TestCase {
	private final int caseNumber;
	
	protected TestCase(int caseNumber) {
		this.caseNumber = caseNumber;
	}
	
	public int getCaseNumber() {
		return caseNumber;
	}
}
