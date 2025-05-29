/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam.lib.converters;

import com.isotopeent.codejam.lib.InputConverter;

public class DynamicMultiLineConverter implements InputConverter<Object[]> {

	private static final int MAX_PARAM_COUNT = 10;

	private IntArrayLine paramConverter;
	private InputConverter<?> converter;

	private Object[] input;
	private int lineNumber;

	public DynamicMultiLineConverter(InputConverter<?> lineConverter) {
		this(lineConverter, 0);
	}

	public DynamicMultiLineConverter(InputConverter<?> lineConverter, int paramCount) {
		this.converter = lineConverter;
		if (paramCount > 0) {
			paramConverter = new IntArrayLine(paramCount);
		} else {
			paramConverter = new IntArrayLine(new int[MAX_PARAM_COUNT]);
		}
	}

	@Override
	public boolean readLine(String data) {
		if (lineNumber == 0) {
			paramConverter.readLine(data);
			int[] params = paramConverter.generateObject();
			int count = getCount(params);
			input = new Object[count + 1];
			input[lineNumber++] = params;
		} else {
			if (!converter.readLine(data)) {
				input[lineNumber++] = converter.generateObject();
			}
		}

		if (lineNumber >= input.length){
			lineNumber = 0;
		}
		return lineNumber == 0;
	}

	@Override
	public Object[] generateObject() {
		return input;
	}

	/**
	 * default implementation, just uses first parameter value
	 */
	protected int getCount(int[] parameters) {
		return parameters[0];
	}

}
