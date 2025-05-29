package codejam.surprisingGooglers;

import java.util.Arrays;

public class ProblemCase {

	private Integer[] scores;
	private int p;
	private int surpriseCount;
	
	
	public Integer[] getScores() {
		return scores;
	}
	public int getP() {
		return p;
	}
	public int getSurpriseCount() {
		return surpriseCount;
	}
	
	public ProblemCase(Integer[] scores, int p, int surpriseCount) {
		super();
		this.scores = scores;
		this.p = p;
		this.surpriseCount = surpriseCount;
	}
	@Override
	public String toString() {
		return "ProblemCase [scores=" + Arrays.toString(scores) + ", p=" + p
				+ ", surpriseCount=" + surpriseCount + "]";
	}
	
	
	
}
