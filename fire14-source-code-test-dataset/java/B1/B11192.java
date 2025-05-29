package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class TestCaseReader<T> {

	// public static final String smallSet = "small.txt";
	// public static final String largeSet = "large.txt";

	private BufferedReader reader;

	public TestCaseReader(String file) {
		try {
			File small = new File(file);
			reader = new BufferedReader(new FileReader(small));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getTestCases() {
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (line != null) {
			return Integer.parseInt(line);
		}

		throw new RuntimeException();
	}

	public T getNextTestCase() {
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (line != null) {
			return parseTestCase(line);
		}

		// EOF
		return null;
	}

	protected abstract T parseTestCase(String line);

}
