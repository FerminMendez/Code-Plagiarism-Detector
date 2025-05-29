package com.google.jam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.jam.recycled.numbers.RecycledNumberController;

public class Solver {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"src/input.txt"));
		int t = Integer.valueOf(reader.readLine());

		for (int i = 1; i <= t; i++) {
			String[] tokens = reader.readLine().split(" ");
			System.out
					.format("Case #%d: %d\n",
							i,
							new RecycledNumberController(Integer
									.valueOf(tokens[0]), Integer
									.valueOf(tokens[1]))
									.getNumRecycledNumbers());
		}
	}
}
