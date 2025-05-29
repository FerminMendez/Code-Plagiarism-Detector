package org.moriraaca.codejam;

import java.io.InputStream;

public abstract class GeneralDataParser extends AbstractDataParser {
	public GeneralDataParser(InputStream input) {
		super(input);
	}

	@Override
	protected void parse() {
		testCases = new TestCase[scanner.nextInt()];
		super.parse();
	}
}
