package be.mokarea.gcj.common;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;


public abstract class GoogleCodeJamBase<T extends TestCase> {
	protected abstract Transformation<T> createTransformation(TestCaseReader<T> testCaseReader, PrintWriter outputWriter) throws Exception;
	protected abstract String getOutputFileName() throws Exception;
	protected abstract TestCaseReader<T> getTestCaseReader() throws Exception;
	
	public void execute() {
		try {
			PrintWriter outputWriter = null;
			try {
				outputWriter = new PrintWriter(new FileWriter(getOutputFileName()));
				Transformation<T> transformation = createTransformation(getTestCaseReader(),outputWriter);
				transformation.transformAll();
				outputWriter.flush();
			} finally {
				closeQuietly(outputWriter);
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	private void closeQuietly(Writer outputWriter) {
		if (outputWriter != null) {
			try {
				outputWriter.close();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}
}
