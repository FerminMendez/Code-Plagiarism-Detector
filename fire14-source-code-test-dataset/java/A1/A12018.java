package com.google.codejam2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class BDancingWithTheGooglers {
	private void go() throws IOException {
		String fileIn = "resources/codejam2012/B-small-attempt0.in";
		String fileOut = fileIn.replace(".in", ".out");
		
		init();
		
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOut))); 
		
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn)));
		int count = Integer.parseInt(r.readLine());
		for(int i = 0; i < count; i++) {
			String out = processCase(r.readLine());
			out = "Case #" + (i + 1) + ": " + out;
			System.out.println(out);
			w.write(out + "\n");
		}		

		getPossiblePoints(21);
		w.close();
		r.close();
	}
	

	private static final class Result {
		private int [] results;
		private boolean surprising;
		
		public Result(boolean surprising, int ... results) {
			this.results = results;
			this.surprising = surprising;
		}
		
		public int getMax() {
			return results[2];
		}
		
		@Override
		public String toString() {
			return "Result(" + surprising + ", " + Arrays.toString(results) + ")";
		}
	}

	int [] i = new int[1];
	private ArrayList<List<Result>> results = new ArrayList<List<Result>>();
			
	private void init() {
		for(int i = 0; i <= 30; i++) {
			results.add(getPossiblePoints(i));
		}
	}
	
	private List<Result> getPossiblePoints(int sum) {
		List<Result> results = new LinkedList<BDancingWithTheGooglers.Result>();
		
		for(int a = 0; a<=10 ; a++) {
			for(int b = a; b <= 10; b++) {
				int c = sum - a - b;
				if ((c < 0) || (c > 10)) continue;
				if (c >= b) {
					if ((Math.abs(a - b) > 2) || (Math.abs(b -c) > 2) || (Math.abs(c-a) > 2)) continue;
					
					if ((Math.abs(a - b) < 2) && (Math.abs(b -c) < 2) && (Math.abs(c-a) < 2)) {
						results.add(new Result(false, a, b, c));
					}  else {
						results.add(new Result(true, a, b, c));
					} 					
				}
			}
		}
		return results;
		
	}
	
	private int [] points;
	int n;
	int s;
	int p;
	
	int max = 0;
	
	private String processCase(String text) {
		Scanner scanner = new Scanner(text);
		n = scanner.nextInt();
		s = scanner.nextInt();
		p = scanner.nextInt();
		
		points = new int[n];
		for(int i = 0; i<n; i++) points[i] = scanner.nextInt();

		max =0;
		
		recursion(0, 0, 0);
		
		return String.valueOf(max);
	}

	private void recursion(int nr, int supprising, int sum) {
		for(Result result : results.get(points[nr])) {
			int delta = (result.getMax() >= p) ? 1 : 0;
			if (nr == n - 1) {
				if (result.surprising) supprising++;
				if (supprising == s) {
					max = Math.max(max, sum + delta);
				}
				if (result.surprising) supprising--;
			} else {
				if (result.surprising && (supprising == s)) continue;
				
				if (result.surprising) {
					recursion(nr + 1, supprising + 1, sum + delta);
				} else {
					recursion(nr + 1, supprising, sum + delta);
				}
			}
		}
	}

	
	public static void main(String[] args) throws Exception {
		long now = System.currentTimeMillis();
		new BDancingWithTheGooglers().go();
		System.out.println(String.valueOf(System.currentTimeMillis() - now) + "ms");
	}
}