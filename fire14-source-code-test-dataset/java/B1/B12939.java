package com.menzus.gcj._2012.qualification.c;

import java.util.HashSet;
import java.util.Set;

import com.menzus.gcj.common.OutputProducer;

public class COutputProducer implements OutputProducer<CInput, COutputEntry> {

    @Override
    public COutputEntry produceOutput(CInput input) {
	int lowerLimit = input.getLowerLimit();
	int upperLimit = input.getUpperLimit();
	long recycledPairNumber = 0;
	Set<Integer> pairs = new HashSet<Integer>();
	for (int i = lowerLimit; i < upperLimit; i++) {
	    pairs.clear();
	    int numberLength = getNumberLength(i);
	    int numberMajor = getMajorNumber(i);
	    int rotatedNumber = i;
	    for (int j = 0; j < numberLength - 1; j++) {
		rotatedNumber = rotateNumber(rotatedNumber, numberMajor);
		if (numberLength == getNumberLength(rotatedNumber)) {
		    if (rotatedNumber >= lowerLimit && rotatedNumber <= upperLimit && rotatedNumber > i) {
			if (!pairs.contains(rotatedNumber)) {
			    recycledPairNumber++;
			    pairs.add(rotatedNumber);
			}
		    }
		}
	    }
	}
	COutputEntry outputEntry = new COutputEntry();
	outputEntry.setRecycledPairNumber(recycledPairNumber);
	return outputEntry;
    }

    //
    // private int rotateNumber(int i, int majorNumber) {
    // return (i / 10) + ((i % 10) * majorNumber);
    // }

    private int rotateNumber(int i, int majorNumber) {
	return ((i % majorNumber) * 10) + (i / majorNumber);
    }

    private int getMajorNumber(int i) {
	if (i < 10) {
	    return 1;
	} else if (i < 100) {
	    return 10;
	} else if (i < 1000) {
	    return 100;
	} else if (i < 10000) {
	    return 1000;
	} else if (i < 100000) {
	    return 10000;
	} else if (i < 1000000) {
	    return 100000;
	} else {
	    return 1000000;
	}
    }

    private int getNumberLength(int i) {
	if (i < 10) {
	    return 1;
	} else if (i < 100) {
	    return 2;
	} else if (i < 1000) {
	    return 3;
	} else if (i < 10000) {
	    return 4;
	} else if (i < 100000) {
	    return 5;
	} else if (i < 1000000) {
	    return 6;
	} else {
	    return 7;
	}
    }
}
