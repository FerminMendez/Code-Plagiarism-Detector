package com.clausewitz.codejam;

import com.clausewitz.codejam.qr2012.Recycled;



public class CodeJam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Solver s = new Googlerese();
		//s.solve("res/qr2012/A-small-attempt.in");
		Solver s = new Recycled();
		s.solve("res/qr2012/small.in");

	}
}
