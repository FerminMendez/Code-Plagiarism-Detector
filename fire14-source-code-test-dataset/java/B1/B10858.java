package be.mokarea.gcj.common;

public abstract class TestCaseReader<T extends TestCase> {
	public abstract T nextCase() throws Exception;

	public abstract int getMaxCaseNumber();
}
