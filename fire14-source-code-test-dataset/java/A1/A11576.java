package com.google.codejam.qualrnd.dncingglers;


public class DancingGooglersInput {

	private int noOfCases;
	
	private GooglersScoreboard[] scoreboards;
	
	public DancingGooglersInput() {
		
	}

	public DancingGooglersInput(int noOfCases) {
		this.noOfCases = noOfCases;
	}
	
	public DancingGooglersInput(int noOfCases, GooglersScoreboard[] scoreboards) {
		this.noOfCases = noOfCases;
		this.scoreboards = scoreboards;
	}

	public int getNoOfCases() {
		return noOfCases;
	}

	public void setNoOfCases(int noOfCases) {
		this.noOfCases = noOfCases;
	}

	public GooglersScoreboard[] getScoreboards() {
		return scoreboards;
	}

	public void setScoreboards(GooglersScoreboard[] scoreboards) {
		this.scoreboards = scoreboards;
	}
	
}
