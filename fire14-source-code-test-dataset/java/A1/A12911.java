package com.menzus.gcj._2012.qualification.b;

import com.menzus.gcj.common.OutputEntry;

public class BOutputEntry implements OutputEntry {

    private int maximumGooglersNumber;

    public void setMaximumGooglersNumber(int maximumGooglersNumber) {
	this.maximumGooglersNumber = maximumGooglersNumber;
    }

    @Override
    public String formatOutput() {
	return Integer.toString(maximumGooglersNumber);
    }
}
