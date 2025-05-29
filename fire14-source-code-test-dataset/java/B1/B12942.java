package com.menzus.gcj._2012.qualification.c;

import java.util.Iterator;

import com.menzus.gcj.common.InputBlockParser;

public class CInputBlockParser implements InputBlockParser<CInput> {
    @Override
    public CInput parseLineIterator(Iterator<String> lineIterator) {
	String[] lineParts = lineIterator.next().split(" ");
	CInput input = new CInput();
	input.setLowerLimit(Integer.parseInt(lineParts[0]));
	input.setUpperLimit(Integer.parseInt(lineParts[1]));
	return input;
    }
}
