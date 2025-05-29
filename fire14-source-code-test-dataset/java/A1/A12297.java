package com.google.codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DancingGooglers {
	public static void main(String[] args) throws FileNotFoundException {
		new DancingGooglers().run();
	}
	
	private static class Data {
		@Override
		public String toString() {
			return "Data [googlers=" + googlers + ", surprisingTriplets="
					+ surprisingTriplets + ", p=" + p + ", totals="
					+ Arrays.toString(totals) + "]";
		}
		public int googlers;
		public int surprisingTriplets;
		public int p;
		public Integer[] totals;
		
	}

	private void run() throws FileNotFoundException {
		Data[] data = parseInput("input");
		Integer[] result = solve(data);
		printResult(result, "output");
	}
	
	private Integer[] solve(Data[] data) {
		Integer[] result = new Integer[data.length];
		for (int i = 0; i < data.length; i++) {
			result[i] = solve(data[i]);
//			System.out.println("Max number of Googlers with p: " + result[i]);
		}
		return result;
	}

	private Integer solve(Data data) {
//		System.out.println(data);
		
		int counter = 0;
		int availableSurpises = data.surprisingTriplets;
		
		for (Integer total : data.totals) {
			if (data.p == 0) {
//				System.out.println("Googler with total=" + total + " has scored minimum of " + data.p);
				counter++;
			} else  
			if (total >= Math.max(1, data.p*3 - 2)) {
//				System.out.println("Googler with total=" + total + " has scored minimum of " + data.p);
				counter++;
			} else if (availableSurpises > 0 && total >= Math.max(1, data.p*3 - 4)){
//				System.out.println("Googler with total=" + total + " might scored minimum of " + data.p + " with suprising score");
				counter++; availableSurpises--;
			} else {
//				System.out.println("Googler with total=" + total + " couldn't score minimum of " + data.p);
			}
		}
		
		return counter;
	}

	private void printResult(Integer[] result, String path) throws FileNotFoundException {
		PrintWriter p = new PrintWriter(new File(path));
		try { 
			for (int i = 1; i < result.length+1; i++) {
				p.format("Case #%d: %d\n", i, result[i-1]);
			}
		} finally {
			p.close();
		}
	}

	private Data[] parseInput(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		try {
			Data[] input = new Data[scanner.nextInt()];
			for (int i = 0; i < input.length; i++) {
				scanner.nextLine(); // skip to the next line
				Data data = new Data();
				data.googlers = scanner.nextInt();
				data.surprisingTriplets = scanner.nextInt();
				data.p = scanner.nextInt();

				data.totals = new Integer[data.googlers];
				for (int g = 0; g < data.googlers; g++) {
					data.totals[g] = scanner.nextInt();
				}
				input[i] = data;
			}
			return input;
		} finally {
			scanner.close();
		}
	}
}
