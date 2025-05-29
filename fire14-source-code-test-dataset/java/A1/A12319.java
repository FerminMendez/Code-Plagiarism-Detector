package br.com.atama.google.jam.dancing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Show {

	private List<TripletScore> scores = new ArrayList<TripletScore>();

	public Show(int[] totalScores) {
		for (int total : totalScores)
			scores.add(new TripletScore(total));
	}

	public int getNumSurprises() {
		int count = 0;
		for (TripletScore score : scores)
			if (score.isSurprise())
				count++;
		return count;
	}

	public void addSurprises(int n) {
		if (n == 0)
			return;

		int count = 0;
		Collections.sort(scores);
		Collections.reverse(scores);

		for (TripletScore score : scores) {
			if (!score.isSurprise() && !score.isZero()) {
				score.setSurprise(true);

				if (++count >= n)
					break;
			}
		}

		if (count < n)
			throw new RuntimeException();
	}

	public int getTotalGoodScores() {
		int sum = 0;
		for (TripletScore score : scores)
			sum += score.getNumGoodScore() > 0 ? 1 : 0;

		return sum;
	}

}
