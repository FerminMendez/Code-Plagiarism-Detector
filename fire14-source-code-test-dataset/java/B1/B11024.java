package org.moriraaca.codejam;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public abstract class AbstractTest {
	private final static String TEST_RESOURCE_DIR = "src/test/resources";

	@Parameters
	public static Collection<Object[]> getFileNames() {
		String[] fileNames = new File(TEST_RESOURCE_DIR)
				.list(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.endsWith(".in");
					}
				});

		List<Object[]> result = new LinkedList<Object[]>();
		for (String fileName : fileNames) {
			result.add(new Object[] { fileName.substring(0,
					fileName.length() - 3) });
		}

		return result;
	}

	protected String fileName;

	protected String getInputFileName() {
		return String.format("%s.in", fileName);
	}

	protected String getOutputFileName() {
		return String.format("%s.out", fileName);
	}

	public AbstractTest(String fileName) {
		this.fileName = fileName;
	}

	@Test
	public void testSolver() {
		TestConfiguration config = getClass().getAnnotation(
				TestConfiguration.class);
		try {
			System.err.println(String.format("Testing with file %s", fileName));

			assertEquals(getExpectedOutput(), config.solverClass()
					.newInstance().solve(getInputFileName()));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	private String getExpectedOutput() throws Exception {
		StringBuilder result = new StringBuilder();

		char[] cbuf = new char[1024];
		Reader r = new BufferedReader(new InputStreamReader(getClass()
				.getClassLoader().getResourceAsStream(getOutputFileName())));
		int numRead = 0;
		while ((numRead = r.read(cbuf)) != -1) {
			result.append(String.valueOf(cbuf, 0, numRead));
		}

		r.close();

		return result.toString();
	}
}
