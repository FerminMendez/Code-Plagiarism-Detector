package br.com.atama.google.jam.dancing;

public class ScoreCalculator {

	private final Show show;

	public ScoreCalculator(int numSurprises, int scoreThreshold,
			int[] totalScores) {
		Context.INSTANCE.setNumSurprises(numSurprises);
		Context.INSTANCE.setThreshold(scoreThreshold);

		show = new Show(totalScores);
	}

	public int calculate() {
		show.addSurprises(Context.INSTANCE.getNumSurprises());

		return show.getTotalGoodScores();
	}

}
