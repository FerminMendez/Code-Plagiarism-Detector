package br.com.atama.google.jam.dancing;

public class TripletScore implements Comparable<TripletScore> {

	private final int threshold = Context.INSTANCE.getThreshold();
	private final int total;
	private final int mod;
	private final int gap;
	private int potential = 0;
	private int numGoodScore = 0;
	private boolean isSurprise = false;

	public TripletScore(int total) {
		this.total = total;
		final int div = total / 3;
		mod = total % 3;
		gap = threshold - div;

		calculateGoodScore();
	}

	private void calculateGoodScore() {
		if (total == 0) {
			numGoodScore = 0;
			isSurprise = false;
			
			if (gap <= 0)
				numGoodScore = 3;
			
			potential = Integer.MIN_VALUE;
		} else if (isSurprise) {
			numGoodScore = 0;
			if (mod == 0) {
				if (gap == 1) {
					numGoodScore = 1;
					potential = -1;
				} else if (gap == 0) {
					numGoodScore = 2;
					potential = 1;
				} else if (gap < 0) {
					numGoodScore = 3;
					potential = 0;
				}
			} else if (mod == 1) {
				if (gap == 1) {
					numGoodScore = 2;
					potential = -1;
				} else if (gap == 0) {
					numGoodScore = 2;
					potential = 1;
				} else if (gap < 0) {
					numGoodScore = 3;
					potential = 0;
				}
			} else if (mod == 2) {
				if (gap == 2) {
					numGoodScore = 1;
					potential = -1;
				} else if (gap == 1) {
					numGoodScore = 1;
					potential = 1;
				} else if (gap <= 0) {
					numGoodScore = 3;
				}
			} else {
				assert false;
			}
		} else {
			numGoodScore = 0;
			if (mod == 0) {
				if (gap == 1) {
					potential = 1;
				} else if (gap == 0) {
					numGoodScore = 3;
					potential = -1;
				} else if (gap < 0) {
					numGoodScore = 3;
				}
			} else if (mod == 1) {
				if (gap == 1) {
					numGoodScore = 1;
					potential = 1;
				} else if (gap == 0) {
					numGoodScore = 3;
					potential = -1;
				} else if (gap < 0) {
					numGoodScore = 3;
					potential = 0;
				}
			} else if (mod == 2) {
				if (gap == 2) {
					potential = 1;
				} else if (gap == 1) {
					numGoodScore = 2;
					potential = -1;
				} else if (gap <= 0) {
					numGoodScore = 3;
					potential = 0;
				}
			} else {
				assert false;
			}
		}
	}

	@Override
	public int compareTo(TripletScore o) {
		if (numGoodScore == 0) {
			if (o.numGoodScore == 0)
				return potential - o.potential;
			return 1;
		} else {
			if (o.numGoodScore == 0)
				return -1;
			return potential - o.potential;
		}
	}

	public boolean isSurprise() {
		return isSurprise;
	}

	public void setSurprise(boolean b) {
		isSurprise = b;
		calculateGoodScore();
	}

	public int getNumGoodScore() {
		return numGoodScore;
	}

	public boolean isZero() {
		return total == 0;
	}

}
