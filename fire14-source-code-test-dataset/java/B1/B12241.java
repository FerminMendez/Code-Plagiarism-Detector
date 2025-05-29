package com.google.codejam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumberSolver {

	public static int countRecycledNumber(int start, int end) {
		int count = 0;
		int numOfDigits = String.valueOf(start).length();
		Set<String> numberSet = new HashSet<String>(end - start + 1);
		
		for (int i = start; i <= end; i++) {
			numberSet.add(String.valueOf(i));
		}
		
		while(numberSet.isEmpty() == false) {
			Set<String> rotateList = new HashSet<String>(numOfDigits);
			String targetValue = numberSet.iterator().next();
			rotateList.add(targetValue);
			
			char[] buf = new char[numOfDigits * 2];		
			for (int i = 0; i < numOfDigits; i++) {
				buf[i] = buf[i + numOfDigits] = targetValue.charAt(i);
			}
			
			for (int i = 1; i < numOfDigits; i++) {
				if (buf[i] != '0') {
					String rotateValue = String.valueOf(buf, i, numOfDigits);
					int value = Integer.parseInt(rotateValue);
					if (value >= start && value <= end) {
						rotateList.add(rotateValue);
					}
				}
			}
			
			numberSet.removeAll(rotateList);
			if (rotateList.size() > 1) {
//				System.err.printf("rotate set: %s%n", rotateList.toString());
				count += rotateList.size() * (rotateList.size() - 1) / 2;
			}
		}
		
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println("answer = " + RecycledNumberSolver.countRecycledNumber(10, 40));
		
		Scanner scanner = new Scanner(System.in);
		int totalCount = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < totalCount; i++) {
			String[] inputs = scanner.nextLine().split(" ");
			int answer = RecycledNumberSolver.countRecycledNumber(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
			System.out.printf("Case #%d: %d%n", i+1, answer);
		}
		
	}

}
