package recycledNumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class RecycledNumbers {

	private BufferedReader reader;
	private BufferedWriter writer;
	private static String fileName;
	private Map<String, String> twoTongues;

	public static void main(String[] args) throws IOException {
		fileName = args[0];
		RecycledNumbers numbers = new RecycledNumbers();
		numbers.findTheNumbers();
	}
	
	/** 
	 * "Find the numbers, fast as you can
	 * recycling's uncouth, so don't or you'll be banned"
	 */
	public void findTheNumbers() {
		
		try {
			writer = new BufferedWriter(
				      new FileWriter("recycling.txt"));
			
			reader = new BufferedReader(
					new InputStreamReader(
							new DataInputStream(
									new FileInputStream(fileName))));
			
			Integer numTestCases = Integer.parseInt(reader.readLine());

			for(int i = 0; i < numTestCases; ++i) {
				int numNumbers = solve(reader.readLine());
				writer.write("Case #" + (i+1) + ": " + numNumbers + "\n");
			}
			
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Shizzle");
			System.exit(1);
		}
	}

	private int solve(String readLine) {
		Set<Integer> results = new TreeSet<Integer>();
		Scanner scanner = new Scanner(readLine);
		String numberOne = scanner.next();
		String numberTwo = scanner.next();
		int counter = 0;
		
		if(numberOne.length() == 1) {
			return 0;
		}
		//from A - B
		for(int i = Integer.parseInt(numberOne); i < Integer.parseInt(numberTwo); ++i) {
			results.clear();
			String numToSwitch = Integer.toString(i);
			System.out.println("numToSwitch: " + numToSwitch + " and length: " + numToSwitch.length());
			System.out.println("n: " + i);
			//from start of A to end of A
			String numToMove;
			String numToUse;
			String finishedNum = numToSwitch;
			for(int j = 0; j < numToSwitch.length() - 1; ++j) {
				numToMove = finishedNum.substring(finishedNum.length() - 1);
				numToUse = finishedNum.substring(0, finishedNum.length() - 1);
				
				finishedNum = numToMove.concat(numToUse);
				
				System.out.println("n: " + i + " and m: " + finishedNum);
				if(Integer.parseInt(finishedNum) <= Integer.parseInt(numberTwo)) {
					if(i < Integer.parseInt(finishedNum)) {
						System.out.println("got counted");
						results.add(Integer.parseInt(finishedNum));
					}
				}
			}
			counter = counter + results.size();
		}
		System.out.println("counter: " + counter);
		return counter;
	}
}
