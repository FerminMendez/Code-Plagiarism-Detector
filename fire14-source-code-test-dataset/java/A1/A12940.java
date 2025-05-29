package dancing.with.the.googlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Scanner;

public class DancingWithTheGooglers {

	private static String INPUT_FILE = "B-small-attempt0.in";
	private static String OUTPUT_FILE = "B-small-attempt0.out";
	
	private static BufferedReader getInput() {
		return new BufferedReader(new InputStreamReader(DancingWithTheGooglers.class.getResourceAsStream(INPUT_FILE)));
	}
	
	private static PrintWriter getOutput() throws URISyntaxException, FileNotFoundException {
		File inputFile = new File(DancingWithTheGooglers.class.getResource(INPUT_FILE).toURI());
		File packageDirectory = inputFile.getParentFile();
		File outputFile = new File(packageDirectory, OUTPUT_FILE);
		return new PrintWriter(outputFile);
	}
	
	
	public static void main(String[] args) throws Throwable {
		BufferedReader br = getInput();
		PrintWriter pw = getOutput();
		
		int numTestCases = new Integer(br.readLine().trim());
		
		for (int testCase = 1; testCase <= numTestCases; testCase++) {
			String line = br.readLine();
			Scanner read = new Scanner(line);
			
			int numGooglers = read.nextInt();
			int numSurprisingTriplets = read.nextInt();
			int bestResult = read.nextInt();
			
			int doesNotRequireSurprising = 0;
			int requiresSurprising = 0;
			int neverMeetsBestResult = 0;
			
			for (int googler = 0; googler < numGooglers; googler++) {
				int total = read.nextInt();
				int avg = total / 3;
				int diff = total - (avg * 3);
				
				if (total == 0 && bestResult > 0) {
					neverMeetsBestResult++;
				}
				else if (bestResult <= avg) {
					doesNotRequireSurprising++;
				}
				else if (bestResult == (avg + 1)) {
					
					switch (diff) {
					case 0:
						requiresSurprising++;
						break;
					case 1:
						doesNotRequireSurprising++;
						break;
					case -1:
						requiresSurprising++;
						break;
					case 2:
						doesNotRequireSurprising++;
						break;
					case -2:
						requiresSurprising++;
						break;
					default:
						neverMeetsBestResult++;
						break;
					}
					
				}
				else if (bestResult == (avg + 2)) {
					
					switch (diff) {
					case 2:
						requiresSurprising++;
						break;
					default:
						neverMeetsBestResult++;
						break;
					}
					
				}
				else {
					neverMeetsBestResult++;
				}
			}
			
			System.out.println("does not requires: " + doesNotRequireSurprising);
			System.out.println("requires: " + requiresSurprising);
			System.out.println("never: " + neverMeetsBestResult);
			
			int maxGooglersWithBestResult = doesNotRequireSurprising;
			if (numSurprisingTriplets < requiresSurprising) {
				maxGooglersWithBestResult += numSurprisingTriplets;
			}
			else {
				maxGooglersWithBestResult += requiresSurprising;
			}
			
			pw.println("Case #" + testCase + ": " + maxGooglersWithBestResult);
			
		}
		
		pw.close();
		br.close();
	}
	
}
