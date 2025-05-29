public class Googler {
	private int totalScore;
	private int[] scores;
	private boolean isWeird;	// scores of the judge

	public Googler(int totalScore) {
		scores = new int[3];
		this.totalScore = totalScore;
		isWeird = false;
		setMins();
	}

	private void setMins() {
		int copyTotal = this.totalScore;
		int i = 0;	// start at first index
		if (copyTotal == 0) {
			this.scores[0] = 0;
			this.scores[1] = 0;
			this.scores[2] = 0;
		}
		while (copyTotal > 0) {
			this.scores[i] = this.scores[i] + 1;	// index 0 will have highest score
			i = (i + 1) % 3;
			copyTotal--;
		}
	}

	public boolean hasHighScore(int p) {
		int i;
		for (i = 0; i < 3; i++) {
			if (this.scores[i] >= p) {
				return true;
			}
		}
		return false;
	}
	private boolean canBeWeird() {
		if (this.totalScore <= 1 || this.totalScore > 27 || this.totalScore % 3 == 1) {
			return false;
		}
		return true;
	}
	public boolean weirdHighScore(int p) {
		if (canBeWeird() && this.scores[0] + 1 >= p) {
			this.isWeird = true;
			this.scores[0] = this.scores[0] + 1;
			this.scores[1] = this.scores[1] - 1;
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		String s = this.isWeird ? "W" : "";
		s = s + "[" + this.scores[0] + "," + this.scores[1] + "," + this.scores[2] + "] tot=" + this.totalScore;
		return s;
	}
}
