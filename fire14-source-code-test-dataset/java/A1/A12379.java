package blacky.codejam.qualifications;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class DancingGoogler {

	public static void main(String args[]) throws NumberFormatException, IOException {
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int numberOfTestCases = Integer.parseInt(reader.readLine());
		for(int i = 0; i < numberOfTestCases; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int minimumerGooglers = 0;
			int usedSurprisingTriplets = 0;
			final int numberOfGooglers = Integer.parseInt(tokenizer.nextToken());
			final int surprisingTriplets = Integer.parseInt(tokenizer.nextToken());
			final int bestResultMinimum = Integer.parseInt(tokenizer.nextToken());
			int results[] = new int[numberOfGooglers];
			for(int j = 0; j < numberOfGooglers; j++) {
				results[j] = Integer.parseInt(tokenizer.nextToken()); 
			}
			for(int j = 0; j < numberOfGooglers; j++) {
				boolean possibleSurprising = false;
				boolean possibleNonSurprising = false;
				enumarate:
				for(int judge1 = 0; judge1 <= 10; judge1++) {
					for(int judge2 = judge1 - 2; judge2 <= judge1 + 2; judge2++) {
						for(int judge3 = judge1 - 2; judge3 <= judge1 + 2; judge3++) {
							if(judge1 + judge2 + judge3 == results[j]) {
								if(judge1 < 0 || judge2 < 0 || judge3 < 0) {
									continue; // Illegal case
								} else if(2 < Math.abs(judge1 - judge2) || 2 < Math.abs(judge1 - judge3)|| 2 < Math.abs(judge2 - judge3)) {
									continue; // Illegal case
								} else if (bestResultMinimum <= judge1 || bestResultMinimum <= judge2 || bestResultMinimum <= judge3) {
									if(Math.abs(judge1 - judge2) == 2 || Math.abs(judge1 - judge3) == 2 || Math.abs(judge2 - judge3) == 2) {
										possibleSurprising = true;
									} else {
										possibleNonSurprising = true;
										break enumarate;
									}
								}
							}
						}
					}
				}
				if(possibleNonSurprising) {
					minimumerGooglers++;
				} else if (possibleSurprising && usedSurprisingTriplets < surprisingTriplets) {
					minimumerGooglers++;
					usedSurprisingTriplets++;
				}
			}
			System.out.println(String.format("Case #%d: %d", i + 1, minimumerGooglers));
		}
	}
	
}
