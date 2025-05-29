/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam.lib;

public interface InputConverter<T> {

	boolean readLine(String data);
	T generateObject();

}
