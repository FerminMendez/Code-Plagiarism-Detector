package com.menzus.gcj._2012.qualification.c;

import com.menzus.gcj.common.OutputEntry;

public class COutputEntry implements OutputEntry {
    private long recycledPairNumber;

    public void setRecycledPairNumber(long recycledPairNumber) {
	this.recycledPairNumber = recycledPairNumber;
    }

    @Override
    public String formatOutput() {
	return Long.toString(recycledPairNumber);
    }
}
