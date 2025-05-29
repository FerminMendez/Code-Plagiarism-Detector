/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam.lib.converters;

import com.isotopeent.codejam.lib.InputConverter;


public class IntLine implements InputConverter<Integer> {

	private int input;

	@Override
	public boolean readLine(String data) {
		input = Integer.parseInt(data);
		return false;
	}

	@Override
	public Integer generateObject() {
		return input;
	}

}
