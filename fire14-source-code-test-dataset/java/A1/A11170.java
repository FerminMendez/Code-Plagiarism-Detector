package codezam.exercise.WR1B2012;

public class Triplet {
	long numberA;
	long numberB;
	long numberC;
	boolean isSurprising = false;
	long numberMax;
	
	public Triplet(long numberA, long numberB, long numberC) {
		this.numberA = numberA;
		this.numberB = numberB;
		this.numberC = numberC;
		
		//Valid 하게 들어온다고 가정
		if (numberA==numberB+2 || numberA==numberC+2 
				|| numberB==numberA+2 || numberB==numberC+2
				|| numberC==numberA+2 || numberC==numberB+2) {
			isSurprising = true;
		}
		
		if (numberA>=numberB && numberA>=numberC) {
			numberMax = numberA;
		} else if (numberB>=numberA && numberB>=numberC) {
			numberMax = numberB;
		} else if (numberC>=numberA && numberC>=numberB) {
			numberMax = numberC;
		} else {
			numberMax = numberA;//수학적으로 이런 경우는 없음
		}
		
	}
	
	public long getNumberA() {
		return numberA;
	}
	public void setNumberA(long numberA) {
		this.numberA = numberA;
	}
	public long getNumberB() {
		return numberB;
	}
	public void setNumberB(long numberB) {
		this.numberB = numberB;
	}
	public long getNumberC() {
		return numberC;
	}
	public void setNumberC(long numberC) {
		this.numberC = numberC;
	}
	public boolean isSurprising() {
		return isSurprising;
	}
	public void setSurprising(boolean isSurprising) {
		this.isSurprising = isSurprising;
	}
	public long getNumberMax() {
		return numberMax;
	}
	public void setNumberMax(long numberMax) {
		this.numberMax = numberMax;
	}
		
}

