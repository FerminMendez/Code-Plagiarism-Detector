/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam.lib.converters;

import com.isotopeent.codejam.lib.InputConverter;


public class StringLine implements InputConverter<String> {

	private String input;

	@Override
	public boolean readLine(String data) {
		input = data;
		return false;
	}

	@Override
	public String generateObject() {
		return input;
	}

}
