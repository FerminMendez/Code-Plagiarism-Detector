package org.moriraaca.codejam.dancingwithgooglers;

import java.io.InputStream;

import org.moriraaca.codejam.GeneralDataParser;

public class DancingWithTheGooglersDataParser extends GeneralDataParser {

	public DancingWithTheGooglersDataParser(InputStream input) {
		super(input);
	}

	@Override
	protected void doParse() {
		for (int i = 0; i < testCases.length; i++) {
			DancingWithTheGooglersTestCase tc = new DancingWithTheGooglersTestCase();
			tc.scores = new int[scanner.nextInt()];
			tc.S = scanner.nextInt();
			tc.p = scanner.nextInt();
			for (int j = 0; j < tc.scores.length; j++) {
				tc.scores[j] = scanner.nextInt();
			}

			testCases[i] = tc;
		}
	}

}
