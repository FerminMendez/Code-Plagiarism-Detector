/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam.lib.converters;

import com.isotopeent.codejam.lib.InputConverter;

public class MultiLineConverter implements InputConverter<Object[]> {

	private InputConverter<?>[] converters;
	private int count;

	private Object[] input;
	private int lineNumber;

	public MultiLineConverter(InputConverter<?> lineConverter, int count) {
		this.converters = new InputConverter<?>[count];
		this.count = count;
		for (int i = 0; i < count; i++) {
			converters[i] = lineConverter;
		}
	}

	public MultiLineConverter(InputConverter<?>[] lineConverters) {
		this.converters = lineConverters;
		this.count = lineConverters.length;
	}

	@Override
	public boolean readLine(String data) {
		if (lineNumber == 0) {
			input = new Object[count];
		}
		InputConverter<?> converter = converters[lineNumber];
		if (!converter.readLine(data)) {
			input[lineNumber++] = converter.generateObject();
		}

		if (lineNumber >= input.length){
			lineNumber = 0;
		}
		return lineNumber != 0;
	}

	@Override
	public Object[] generateObject() {
		return input;
	}

}
