/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class InputReader<T> extends BufferedReader {

	private final InputConverter<T> converter;

	public InputReader(File file, InputConverter<T> converter) throws FileNotFoundException {
		super(new FileReader(file));
		this.converter = converter;
	}

	public T readInput() {
		String data;
		try {
			do {
				data = readLine();
				if (data == null) {
					return null;
				}
			} while (converter.readLine(data));
		} catch (IOException e) {
			// do nothing
		}
		return converter.generateObject();
	}

}
