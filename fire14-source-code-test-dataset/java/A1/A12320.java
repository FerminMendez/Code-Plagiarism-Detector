package br.com.atama.google.jam.dancing;

public enum Context {
	INSTANCE;

	private int numSurprises;
	private int threshold;

	public int getNumSurprises() {
		return numSurprises;
	}

	public void setNumSurprises(int numSurprises) {
		this.numSurprises = numSurprises;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

}
