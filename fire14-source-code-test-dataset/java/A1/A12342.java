package teardrop.jam2012.qr.dancing;

import org.testng.annotations.Test;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class SetSolverTest {
	private static final String testInput =
		"4\n" +
        "3 1 5 15 13 11\n" +
        "3 0 8 23 22 21\n" +
        "2 1 1 8 0\n" +
        "6 2 8 29 20 8 18 18 21";
	private static final String testOutput =
		"Case #1: 3\n" +
        "Case #2: 2\n" +
        "Case #3: 1\n" +
        "Case #4: 3\n";

	@Test
	public void testSolve() throws Exception {
		Reader reader = new StringReader(testInput);
		Writer writer = new StringWriter();
		SetSolver solver = new SetSolver(reader, writer);
		solver.solve();
		String result = writer.toString();
		assert testOutput.equals(result) : String.format("Got \n%s\ninstead of \n%s\n", result, testOutput);
	}
}
