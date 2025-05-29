package com.spelchec.codejam.project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) throws IOException {
		final String outputTemplate = "Case #%d: %d\n";		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int run = Integer.parseInt(br.readLine());
		for (int r = 1; r <= run; r++) {
			Scanner scan = new Scanner(br.readLine());
			int N = scan.nextInt();
			int S = scan.nextInt();
			int p = scan.nextInt();
			int[] results = new int[N];
			for (int i = 0; i < N; i++) {				
				results[i] = scan.nextInt();
			}
			System.out.print(String.format(outputTemplate, r, solve(N, S, p, results)));
		}
	}

	private static int solve(int N, int S, int p, int[] results) {
		int count = 0;
		
		for (int i = 0; i < results.length; i++) {
			int r = results[i];
			int threshold = p*3-2;
			if (r >= threshold) {
				count++;
			} else if (S > 0 && r >= threshold - 2 && r >= 2) {
				count++; S--;
			}
		}
				
		return count;
	}
}
 