package com.nolmecolindor.gcj2012.round0;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Problem_B_0 {
	
	private int solve(final Scanner input) {
		final int N = input.nextInt();
		final int S = input.nextInt();
		final int P = input.nextInt();
		final int[] points = new int[31];
		for (int i = 0; i < N; i++) points[input.nextInt()]++;
//		System.out.println("Point distribution: ");
//		for (int i = 0; i <= 30; i++) System.out.println(points[i] + " dancers got " + i + " points.");

		int remainingSurprises = S;
		
		int result = 0;
		for (int i = 30; i >= 0; i--) {
			if (points[i] == 0) continue;
			final int min;
			final int max;
			switch (i % 3) {
			case 0:
				min = i / 3;
				max = min;
				if (max >= P) { // We reach the limit by default
					result += points[i];
				} else if ((max + 1 == P) && (min > 0) && (max < 10)) { // We can reach the limit with surprises
					final int useSurprises = Math.min(points[i], remainingSurprises);
					remainingSurprises -= useSurprises;
					result += useSurprises;
				} else { // We can not reach the limit anyway
					// We are not interested
				}
				break;
			case 1:
				max = (i - 1) / 3 + 1;
				if (max >= P) result += points[i];
				break;
			case 2:
				min = (i - 2) / 3;
				max = min + 1;
				if (max >= P) { // We reach the limit by default
					result += points[i];
				} else if ((max + 1 == P) && (max < 10)) { // We can reach the limit with surprises
					final int useSurprises = Math.min(points[i], remainingSurprises);
					remainingSurprises -= useSurprises;
					result += useSurprises;
				} else { // We can not reach the limit anyway
					// We are not interested
				}
				break;
			}
			
		}
		return result;
	}
	
	
	private void solveAll(final Scanner input) throws NumberFormatException, IOException {
		final int cases = input.nextInt();
		input.nextLine();
		for (int caseNum = 1; caseNum <= cases; caseNum++) {
			System.out.println("Case #" + caseNum + ": " + solve(input));
		}
	}
	
	public static void main(final String[] args) {
		try {
			final Scanner input = new Scanner(((args.length == 2) && args[0].equals("--input")) ? new FileInputStream(args[1]) : System.in);
			new Problem_B_0().solveAll(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
