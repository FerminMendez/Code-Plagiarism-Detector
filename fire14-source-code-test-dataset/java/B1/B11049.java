package com.clausewitz.codejam.qr2012;

import java.io.IOException;
import java.util.StringTokenizer;

import com.clausewitz.codejam.Solver;

public class Recycled extends Solver {
	private int A = 0;
	private int B = 0;
	@Override
	public void readProblem() throws IOException {
		String line = fileIn.readLine();
		StringTokenizer st = new StringTokenizer(line);
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}

	@Override
	public void algorithm(int idx) {
		int count = 0;
		
		for(int i=A;i<=B;++i) {
			String original = "" + i;
			String candidate = original;

			while(true) {
				candidate = rotate(candidate);
				if(candidate.equalsIgnoreCase(original)) break;
				int n = Integer.parseInt(candidate);
				if(n>=A && n<=B) ++count;
			}
		}
		
		answer[idx] = "" + count/2;
	}

	private String rotate(String s) {
		if(s.length()==1) return s;
		return s.substring(1, s.length()) + s.charAt(0);
	}
}
