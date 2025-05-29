package com.google.codejam.qualrnd.recyclednums;


public class RecycledNumbersInput {

	private int noOfCases;
	
	private long[][] numPairs;
	
	public RecycledNumbersInput() {

	}

	public RecycledNumbersInput(int noOfCases) {
		this.noOfCases = noOfCases;
	}

	public RecycledNumbersInput(int noOfCases, long[][] numPairs) {
		this.noOfCases = noOfCases;
		this.numPairs = numPairs;
	}

	public int getNoOfCases() {
		return noOfCases;
	}

	public void setNoOfCases(int noOfCases) {
		this.noOfCases = noOfCases;
	}

	public long[][] getNumPairs() {
		return numPairs;
	}

	public void setNumPairs(long[][] numPairs) {
		this.numPairs = numPairs;
	}

}
