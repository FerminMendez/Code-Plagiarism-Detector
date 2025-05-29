package com.edwarddrapkin;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Dancing {
	AtomicInteger possibleNoCheat = new AtomicInteger(0);
	AtomicInteger possibleWithCheatOnly = new AtomicInteger(0);
	AtomicInteger jobsWorking = new AtomicInteger(0);
	
	ExecutorService service = Executors.newFixedThreadPool(4);
	
	private void reset() {
		possibleNoCheat = new AtomicInteger(0);
		possibleWithCheatOnly = new AtomicInteger(0);
	}
	
	private boolean testArray(int[] arr, int input, int maxDist, int minimumPositive) {
		if(arr[0] + arr[1] + arr[2] != input) {
			return false;
		}
		
		int diff1 = Math.abs(arr[0] - arr[1]);
		int diff2 = Math.abs(arr[0] - arr[2]);
		int diff3 = Math.abs(arr[1] - arr[2]);
		
		if( (diff1 > maxDist || diff2 > maxDist || diff3 > maxDist) || (arr[0] < minimumPositive && arr[1] < minimumPositive && arr[2] < minimumPositive)) {
			return false;
		} else {
			return true;
		}
		
	}
	
	
	private void calculatePossibleScores(final int total, final int maxcheat, final int minimumPositive) {
		Runnable r = new Runnable() {
			public void run() {
				int[] working = new int[3];
				
				boolean withCheat = false;
				
				for(int i = 0; i <= 10; i++) {
					working[0] = i;
					
					for(int j = 0; j <= 10; j++) {
						working[1] = j;
						
						for(int k = 0; k <= 10; k++) {
							working[2] = k;
							
							if(working[0] + working[1] + working[2] != total) {
								continue;
							}
							
							if(testArray(working, total, 1, minimumPositive)) {
								//System.out.println(Arrays.toString(working) + " " + maxcheat + " " + total + " " + minimumPositive);
								possibleNoCheat.incrementAndGet();
								jobsWorking.decrementAndGet();
								return;
							} else if (!withCheat) {
								if(testArray(working, total, 2, minimumPositive)) {
									withCheat = true;
								}
							}
						}
					}
				}
			
				if(withCheat) {
					possibleWithCheatOnly.incrementAndGet();
				}
				
				jobsWorking.decrementAndGet();
			}
		};
		
		service.execute(r);
	}
	
	public void doEverything(String file) throws Exception {
		String[] lines = readFile(file);
		
		int casen = 1;
		
		for(String line : lines) {
			reset();
			//System.out.println("\n\n\n");
			String[] sints = line.split("\\s+");
			int[] ints = new int[sints.length];
			
			for(int i = 0; i < sints.length; i++) {
				ints[i] = Integer.parseInt(sints[i]);
			}
			
			int numGooglers = ints[0];
			int start = 3; 
			int maxcheat = ints[1];
			int minPositive = ints[2];
			
//			System.out.println(numGooglers + " " + maxcheat + " " + minPositive);
			
			for(int i = start; i < ints.length; i++) {
//				System.out.println("Testing: " + ints[i]);
				jobsWorking.incrementAndGet();
				
				calculatePossibleScores(ints[i], maxcheat, minPositive);
//				System.out.println();
			}
			
			while(jobsWorking.get() > 0) {
				Thread.sleep(100);
			}
			
			System.out.println("Case #" + casen + ": " + (possibleNoCheat.get() + (possibleWithCheatOnly.get() > maxcheat ? maxcheat : possibleWithCheatOnly.get())));
			casen++;
		}
		
		service.shutdown();
	}
	
	public static void main(String[] args) throws Throwable {
		new Dancing().doEverything("C:/Users/Eddie/Desktop/google_input.txt");
		
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
}
