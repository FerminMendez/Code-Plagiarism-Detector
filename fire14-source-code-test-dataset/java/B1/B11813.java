/**
 * Google CodeJam 2012
 * Qualification round - Problem C
 * Recycled Numbers
 * 
 * Solved by Üllar Soon <positivew@gmail.com>
 */
package eu.positivew.codejam.recycled;


/**
 * Recycled Numbers integer pair (m, n).
 * 
 * @author Üllar Soon <positivew@gmail.com>
 */
public class IntPair {
	
	private int n, m;
	
	public IntPair(int n, int m) {
		this.n = n;
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}
	
	@Override
	public boolean equals(Object o) {
		IntPair compTo = (IntPair)o;
		
		if(n == compTo.getN() && m == compTo.getM())
			return true;
		else
			return false;
	}

}
