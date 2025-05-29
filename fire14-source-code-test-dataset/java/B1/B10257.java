package com.numbers.recycle.main;

import com.numbers.recycle.orchestrator.NumberRecycler;


public class NumberRecyclerMain {

	/**
	 * @param args
	 */
	private NumberRecycler reverser = new NumberRecycler();
	
	public static void main(String[] args) {
		new NumberRecyclerMain().recycle();
	}
	
	private void recycle(){
		reverser.solveAndWriteToOutputFile("C:/Documents and Settings/Administrator/My Documents/Code Jam/C-sample.in");
	}
	
}
