package com.brianghig.gcj.recyclednumbers;

public class Pair {
	
	private long n;
	private long m;
	
	public Pair() {
		//default, empty constructor
	}
	
	public Pair(long n, long m) {
		// A <= n < m <= B
		assert( m > n );
		
		this.n = n;
		this.m = m;
	}
	
	public long getN() {
		return n;
	}
	public void setN(long n) {
		this.n = n;
	}
	public long getM() {
		return m;
	}
	public void setM(long m) {
		this.m = m;
	}
	
}
