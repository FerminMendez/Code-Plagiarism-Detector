package com.google.codejam.qualrnd.dncingglers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GooglersScoreboard {

	private int noOfGooglers;
	
	private int bestScore;
	
	private int noOfSurprisingScores;
	
	private List<Integer> scores;

	public GooglersScoreboard() {

	}

	public GooglersScoreboard(int noOfGooglers, int bestScore,
			int noOfSurprisingScores, List<Integer> scores) {
		this.noOfGooglers = noOfGooglers;
		this.bestScore = bestScore;
		this.noOfSurprisingScores = noOfSurprisingScores;
		this.scores = scores;
	}
	
	public int getNoOfGooglers() {
		return noOfGooglers;
	}

	public void setNoOfGooglers(int noOfGooglers) {
		this.noOfGooglers = noOfGooglers;
	}

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}

	public int getNoOfSurprisingScores() {
		return noOfSurprisingScores;
	}

	public void setNoOfSurprisingScores(int noOfSurprisingScores) {
		this.noOfSurprisingScores = noOfSurprisingScores;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		Collections.sort(scores, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
//		Collections.sort(scores);
		this.scores = scores;
	}
	
}
