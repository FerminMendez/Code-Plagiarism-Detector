package com.edwarddrapkin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
	
	private boolean isRecylced(int m, int n) {
		String sm = m + "";
		String sn = n + "";
		
		//eliminate some common cases
		
		// same number apparently doesn't count...
		
		if(sm.equals(sn)) {
			return false;
		}
		
		//not the same length
		while(sm.length() < sn.length()) {
			sm = "0" + sm;
		}
		
		while(sn.length() < sm.length()) {
			sn = "0" + sn;
		}
		
		//chars in m not in n
		for(char c : sm.toCharArray()) {
			if(!sn.contains("" + c)) {
				return false;
			}
		}
		
		//vice versa
		for(char c : sn.toCharArray()) {
			if(!sm.contains("" + c)) {
				return false;
			}
		}
		
		for(int i = 1; i < sm.length(); i++) {
			String slice = sm.substring(i) + sm.substring(0, i);
			if(slice.equals(sn)) {
				return true;
			}
		}
		
		return false;
	}
	
	private static String[] readFile(String file) throws IOException {
		Scanner scanner = new Scanner(new File(file));
		
		String numLines = scanner.nextLine();
		
		int nl = Integer.parseInt(numLines);
		
		String[] lines = new String[nl];
		int i = 0;
		
		while(scanner.hasNextLine() && i < nl) {
			lines[i] = scanner.nextLine();
			++i;
		}
		
		return lines;
	}
	
	public static void main(String[] args) throws Exception {
		Numbers num = new Numbers();

		String[] lines = readFile("C:/Users/Eddie/Desktop/google_input.txt");
		
		int i = 1;
		for(String line : lines) {
			Scanner lScanner = new Scanner(line);
			int low = lScanner.nextInt();
			int high = lScanner.nextInt();
			
			int numPossible = 0;
			for(int idx = low; idx <= high; idx++) {
				for(int inner = idx; inner <= high; inner++) {
					if(num.isRecylced(idx, inner)) {
						//System.out.println(high + " " + low + " " + idx + " " + inner);
						numPossible++;
					}
				}
				
			}
			
			System.out.println("Case #" + i + ": " + numPossible);
			i++;
		}
	}
}













