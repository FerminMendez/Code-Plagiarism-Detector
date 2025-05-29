package com.anton.codejam.cj2012;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import com.anton.codejam.Solution;

public class Cj2012_Qualification_B implements Solution {

	ArrayList<Integer> points;
	int S;
	int p;
	
	private int f(int i, int su) {
		if (i == -1) {
			if (su > 0)	return -999;
			return 0;
		}
		
		int simple = 0, surp = 0;
		
		if (canMakePointWithSimple(points.get(i), p)) {
			simple = 1;
		}
		
		if (su > 0 && canMakePointWithSurprises(points.get(i), p)) {
			surp = 1;
		}
		
		return Math.max(f(i-1, su-1) + surp, f(i-1, su) +simple);
	}
	
	
	@Override
	public void go(Scanner input, FileWriter output) throws IOException {
		int T = Integer.parseInt(input.nextLine());

		
		for (int i = 1; i <= T; i++) {
			
			String line = input.nextLine();
			StringTokenizer st = new  StringTokenizer(line.trim());
			
			int N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			
			points = new ArrayList<Integer>();
			
			for (int j = 0; j < N; j++) {
				points.add(Integer.parseInt(st.nextToken()));
			}
			
			int res = f(N-1, S);
			
			output.write(String.format("Case #%d: %d\n", i, res));
		}
	}

	private boolean canMakePointWithSimple(Integer point, int lowestElement) {
		
		ArrayList<Integer[]> s = new ArrayList<Integer[]>();
		
		for (int i =0;i<=9;i++) {
			s.add(new Integer[] {i, i, i+1});
			s.add(new Integer[] {i, i+1, i+1});
			s.add(new Integer[] {i, i, i});
		}
		s.add(new Integer[] {10, 10, 10});
		
		for (int i =0; i< s.size();i++) {
			if (s.get(i)[0] + s.get(i)[1] + s.get(i)[2] == point && maxScore(s.get(i)) >= lowestElement) {
				return true;
			}	
		}
		return false;
		
		
	}
	
	private int maxScore(Integer[] s) {
		return Math.max(s[0], Math.max(s[1], s[2]));
	}
	
	private boolean canMakePointWithSurprises(Integer point, int lowestElement) {
		
		ArrayList<Integer[]> surprises = new ArrayList<Integer[]>();
		
		for (int i =0;i<=8;i++) {
			surprises.add(new Integer[] {i, i, i+2});
			surprises.add(new Integer[] {i, i+1, i+2});
			surprises.add(new Integer[] {i, i+2, i+2});
		}
		
		for (int i =0; i< surprises.size();i++) {
			if (surprises.get(i)[0] + surprises.get(i)[1] + surprises.get(i)[2] == point && maxScore(surprises.get(i)) >= lowestElement) {
				return true;
			}
		}
		return false;
	}

}
