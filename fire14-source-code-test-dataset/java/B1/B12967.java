package qualification.recycled.numbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {

	private static String PREFIX = "C-small-attempt0";
	private static String INPUT_FILE = PREFIX + ".in";
	private static String OUTPUT_FILE = PREFIX + ".out";
	
	private static BufferedReader getInput() {
		return new BufferedReader(new InputStreamReader(RecycledNumbers.class.getResourceAsStream(INPUT_FILE)));
	}
	
	private static PrintWriter getOutput() throws URISyntaxException, FileNotFoundException {
		File inputFile = new File(RecycledNumbers.class.getResource(INPUT_FILE).toURI());
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
			
			Set<RecycledPair> pairs = new HashSet<RecycledPair>();
			int a = read.nextInt();
			int b = read.nextInt();
			int digits = Integer.toString(a).length();
			int lastDigitMultiplier = 1;
			for (int i = 1; i < digits; i++) {
				lastDigitMultiplier = lastDigitMultiplier * 10;
			}
			
			for (int num = a; num <= b; num++) {
			
				int recycledNum = num;
				for (int recycles = 1; recycles < digits; recycles++) {
					
					int lastDigit = recycledNum % 10;
					recycledNum = recycledNum / 10;
					recycledNum = (lastDigit * lastDigitMultiplier) + recycledNum;
					
					if (a <= recycledNum && recycledNum <= b && num != recycledNum && num < recycledNum) {
						RecycledPair pair = new RecycledPair(num, recycledNum);
						pairs.add(pair);
					}
				}
				
			}
			
			pw.println("Case #" + testCase + ": " + pairs.size());
			
		}
		
		pw.close();
		br.close();
	}
	
	
}
