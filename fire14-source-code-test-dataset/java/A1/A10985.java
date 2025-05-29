package org.moriraaca.codejam;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;

public abstract class AbstractSolver<TC extends TestCase> {
	protected final String RESOURCE_FOLDER = "src/main/resources/";

	/* Config */
	protected final String defaultInputFileName;

	protected final OutputDestination outputDestination;

	protected final DebugOutputLevel debugOutputLevel;

	protected final Class<? extends AbstractDataParser> dataParserClass;

	protected PrintStream output;

	protected PrintStream getOutput() {
		if (output == null) {
			try {
				switch (outputDestination) {
				case STDOUT:
					output = System.out;
					break;
				case FILE:
					output = new PrintStream(new File(
							defaultInputFileName.replaceAll("\\.in", "\\.out")));
				default:
					break;
				}
			} catch (Exception rethrow) {
				throw new Error("Fatal error on initialization of output",
						rethrow);
			}
		}

		return output;
	}

	public AbstractSolver() {
		try {
			SolverConfiguration config = getClass().getAnnotation(
					SolverConfiguration.class);
			debugOutputLevel = config.debugOutputLevel();
			outputDestination = config.outputDestination();
			defaultInputFileName = config.inputFileName();
			dataParserClass = config.parser();

		} catch (Exception log) {
			log.printStackTrace();
			throw new Error("Fatal error on initialization", log);
		}
	}

	public void write(String msg, DebugOutputLevel level) {
		if (level.ordinal() <= debugOutputLevel.ordinal()) {
			getOutput().print(msg);
		}
	}

	public final String solve() {
		return solve(defaultInputFileName);
	}

	@SuppressWarnings("unchecked")
	public final String solve(String fileName) {
		try {
			AbstractDataParser dataParser = dataParserClass.getConstructor(
					InputStream.class).newInstance(
					getClass().getClassLoader().getResourceAsStream(fileName));

			StringBuilder result = new StringBuilder();

			for (int i = 0; i < dataParser.getTestCases().length; i++) {
				result.append("Case #")
						.append(i + 1)
						.append(": ")
						.append(solveTestCase((TC) dataParser.getTestCases()[i]))
						.append("\n");
			}

			return result.toString();
		} catch (Exception e) {
			throw new Error("Fatal error on solve", e);
		}
	}

	public final void getSolution() {
		write(solve(), DebugOutputLevel.SOLUTION);
	}

	protected abstract String solveTestCase(TC testCase);
}
