package org.moriraaca.codejam.recyclednumbers;

import java.io.InputStream;

import org.moriraaca.codejam.GeneralDataParser;

public class RecycledNumberDataParser extends GeneralDataParser {

	public RecycledNumberDataParser(InputStream input) {
		super(input);
	}

	@Override
	protected void doParse() {
		for (int i = 0; i < testCases.length; i++) {
			RecycledNumbersTestCase tc = new RecycledNumbersTestCase();

			tc.A = scanner.nextInt();
			tc.B = scanner.nextInt();

			testCases[i] = tc;
		}
	}

}
