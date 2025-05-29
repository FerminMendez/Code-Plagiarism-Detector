package com.menzus.gcj._2012.qualification.b;

import com.menzus.gcj.common.Input;

public class BInput implements Input {
    private int surprisingTripletsNumber;
    private int limit;
    private int[] googlerScores;

    public int getSurprisingTripletsNumber() {
	return surprisingTripletsNumber;
    }

    public void setSurprisingTripletsNumber(int surprisingTripletsNumber) {
	this.surprisingTripletsNumber = surprisingTripletsNumber;
    }

    public int getLimit() {
	return limit;
    }

    public void setLimit(int limit) {
	this.limit = limit;
    }

    public int[] getGooglerScores() {
	return googlerScores;
    }

    public void setGooglerScores(int[] googlerScores) {
	this.googlerScores = googlerScores;
    }
}
