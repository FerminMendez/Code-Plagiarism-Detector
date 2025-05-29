package codejam;

public class Triplet {

	private int total;
	private int mod3;
	private int div3;
	private int maxNormal;
	private int maxSurprise;

	public Triplet(int totalPoints) {
		init(totalPoints);
	}

	private void init(int totalPoints) {
		total = totalPoints;
		mod3 = total % 3;
		div3 = total / 3;
		maxNormal = calcMaxNormal();
		maxSurprise = calcMaxSurprise();
	}

	public int calcMaxSurprise() {
		if ( total == 0 ) return 0;
		return (mod3 == 2) ? div3 + 2 : div3 + 1;
	}

	public int calcMaxNormal() {
		if ( total == 0 ) return 0;
		return (mod3 == 0) ? div3 : div3 + 1;
	}

	public int getMaxNormal() {
		return maxNormal;
	}

	public int getMaxSurprise() {
		return maxSurprise;
	}

	public static void main(String[] args){
		System.out.println("Testing Triplet");
		for ( int i=0; i<6; i++ ) {
			Triplet t = new Triplet(i);
			System.out.println(i+" n:"+t.calcMaxNormal() + " s:" + t.calcMaxSurprise());
		}
	}
}
