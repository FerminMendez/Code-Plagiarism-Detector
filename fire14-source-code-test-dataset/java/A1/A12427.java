package com.google.codejam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Dancing {	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("B-small-attempt0.in")));
		PrintWriter writer = new PrintWriter("output.txt");
		int n = Integer.parseInt(reader.readLine());
		for(int i = 1; i <= n; i++) {
			writer.print("Case #" + i + ": " + solve(reader.readLine()));
			writer.println();
		}
		reader.close();
		writer.close();
	}
	
	private static int solve(String line) {
		String[] datas = line.split(" ");
		int n = Integer.parseInt(datas[0]);
		int s = Integer.parseInt(datas[1]);
		int p = Integer.parseInt(datas[2]);
		int count = 0;		
		for (int i = 3; i < n + 3; ++i) {
			int t = Integer.parseInt(datas[i]);
			if (t >= p * 3) {
				++count;
				continue;
			}
			if (t < p) {
				continue;
			}
			int diff = (t - p) / 2;
			if (p - diff <= 1) {
				++count;
				continue;
			}
			if (p - diff == 2 && s > 0) {
				--s;
				++count;
			}
		}
		return count;
	}

}
