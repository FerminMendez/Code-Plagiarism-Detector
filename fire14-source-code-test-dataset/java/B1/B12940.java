package com.menzus.gcj._2012.qualification.c;

import com.menzus.gcj.common.Input;

public class CInput implements Input {
    private int upperLimit;
    private int lowerLimit;

    public int getUpperLimit() {
	return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
	this.upperLimit = upperLimit;
    }

    public int getLowerLimit() {
	return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit) {
	this.lowerLimit = lowerLimit;
    }
}
