/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam.lib.converters;

import com.isotopeent.codejam.lib.InputConverter;
import com.isotopeent.codejam.lib.Utils;

public class IntArrayLine implements InputConverter<int[]> {

	private int length;
	private int[] input;
	private int[] inputBuffer;

	/**
	 * fixed length arrays
	 */
	public IntArrayLine(int length) {
		this.length = length;
	}

	/**
	 * dynamic length arrays
	 */
	public IntArrayLine(int[] buffer) {
		inputBuffer = buffer;
	}

	@Override
	public boolean readLine(String data) {
		if (length > 0) {
			input = new int[length];
			input = Utils.convertToIntArray(data, length);
		} else {
			int count = Utils.convertToIntArray(data, inputBuffer);
			input = new int[count];
			System.arraycopy(inputBuffer, 0, input, 0, count);
		}
		return false;
	}

	@Override
	public int[] generateObject() {
		return input;
	}

}
