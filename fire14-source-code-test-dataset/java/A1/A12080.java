package com.renoux.gael.codejam.fwk;

import java.io.File;

import com.renoux.gael.codejam.utils.FluxUtils;
import com.renoux.gael.codejam.utils.Input;
import com.renoux.gael.codejam.utils.Output;

public abstract class Solver {

	public void run() {
		if (!disableSample())
			runOnce(getSampleInput(), getSampleOutput());
		if (!disableSmall())
			runOnce(getSmallInput(), getSmallOutput());
		if (!disableLarge())
			runOnce(getLargeInput(), getLargeOutput());
	}

	public void runOnce(String pathIn, String pathOut) {
		Input in = null;
		Output out = null;
		try {

			in = Input.open(getFile(pathIn));
			out = Output.open(getFile(pathOut));

			int countCases = Integer.parseInt(in.readLine());
			for (int k = 1; k <= countCases; k++) {
				out.write("Case #", k, ": ");
				solveCase(in, out);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			FluxUtils.closeCloseables(in, out);
		}
	}

	private File getFile(String path) {
		return new File(path);
	}

	protected abstract void solveCase(Input in, Output out);

	private String getFullPath(boolean input, String type) {
		if (input)
			return "D:\\Downloads\\CodeJam\\" + getProblemName() + "\\"
					+ getProblemName() + "_input_" + type + ".txt";
		else
			return "D:\\Downloads\\CodeJam\\" + getProblemName() + "\\"
					+ getProblemName() + "_output_" + type + ".txt";
	}

	protected String getSampleInput() {
		return getFullPath(true, "sample");
	}

	protected String getSmallInput() {
		return getFullPath(true, "small");
	}

	protected String getLargeInput() {
		return getFullPath(true, "large");
	}

	protected String getSampleOutput() {
		return getFullPath(false, "sample");
	}

	protected String getSmallOutput() {
		return getFullPath(false, "small");
	}

	protected String getLargeOutput() {
		return getFullPath(false, "large");
	}

	protected boolean disableSample() {
		return disable()[0];
	}

	protected boolean disableSmall() {
		return disable()[1];
	}

	protected boolean disableLarge() {
		return disable()[2];
	}

	protected boolean[] disable() {
		return new boolean[] { false, false, false };
	}

	protected abstract String getProblemName();
}
