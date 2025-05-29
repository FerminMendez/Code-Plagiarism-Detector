package com.menzus.gcj._2012.qualification.b;

import java.util.Iterator;

import com.menzus.gcj.common.InputBlockParser;

public class BInputBlockParser implements InputBlockParser<BInput> {
    @Override
    public BInput parseLineIterator(Iterator<String> lineIterator) {
	String[] inputLineParts = lineIterator.next().split(" ");
	int googlersNumber = Integer.parseInt(inputLineParts[0]);
	int surprisingTripletsNumber = Integer.parseInt(inputLineParts[1]);
	int limit = Integer.parseInt(inputLineParts[2]);
	int[] googlerScores = new int[googlersNumber];
	for (int i = 0; i < googlerScores.length; i++) {
	    googlerScores[i] = Integer.parseInt(inputLineParts[i + 3]);
	}
	BInput input = new BInput();
	input.setGooglerScores(googlerScores);
	input.setLimit(limit);
	input.setSurprisingTripletsNumber(surprisingTripletsNumber);
	return input;
    }
}
