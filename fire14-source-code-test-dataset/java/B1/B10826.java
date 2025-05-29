package com.skidson.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RecycledNumbers {
	private static final File inFile = new File("input");
	private static final File outFile = new File("output");

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(inFile));
		BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
		int numTests = Integer.parseInt(in.readLine());
		
		for (int x = 0; x < numTests; x++) {
			String[] params = in.readLine().split(" ");
			final int A = Integer.parseInt(params[0]);
			final int B = Integer.parseInt(params[1]);
			
			int y = 0;
			for (int n = A; n < B; n++) {
				for (int m = B; m > n; m--) {
					String left = String.valueOf(n);
					for (int i = 1; i < left.length(); i++) {
						int pivot = left.length()-i;
						int temp = Integer.parseInt(left.substring(pivot) + left.substring(0, pivot));
						// Repeating patterns will give us duplicate pairs, e.g. n = 1212
						if (temp == n)
							break;
						if (temp == m)
							y++;
					}
				}
			}
			out.write("Case #" + (x+1) + ": " + y + "\n");
		}
		out.flush();
		out.close();
	}
}
