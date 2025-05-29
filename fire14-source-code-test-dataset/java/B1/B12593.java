package google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.ArrayList;

public class Interview {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		

		
		BufferedReader file = new BufferedReader(new FileReader(args[0]));
		
		String line = file.readLine();
		
		PrintStream z = new PrintStream("output.txt");
		
		
		while (line != null && !line.equals("0")) {
			line = file.readLine();
			
			if (line == null) {
				break;
			}
			String[] input = line.split(" ");
			System.out.println("Case: " + caseNum);
			int numUniquePairs = processInput(input);
		
			z.println("Case #" + caseNum + ": " + numUniquePairs);
			System.out.println("Case #" + caseNum + ": " + numUniquePairs);
			caseNum++;
			uniqueTable.clear();
			
		}
		System.out.println("finished");

	}
	private static int caseNum = 1;
	private static HashSet<String> uniqueTable = new HashSet<String>();
	
	private static int processInput(String[] input) throws FileNotFoundException {
		
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		int numUniquePairs = 0;
		for (int i=A; i < B; ++i) {
			for (int j=i+1; j <= B; ++j) {
				if (uniqueTable.add(""+i +","+j)) {
					if (isRecyclePair(i, j)) {
						numUniquePairs++;
					}
				}
			}
		}
		return numUniquePairs;
	}


	private static boolean isRecyclePair(Integer x, Integer y) {
		
		if (x.equals(y)) {
			return false;
		}
		String xStr = x.toString();
		String yStr = y.toString();
		
		for (int i=0; i<xStr.length(); ++i) {
			if (xStr.equals(yStr)) {
				return true;
			}
			char c = xStr.charAt(0);
			if (i < xStr.length() - 1) {
				xStr = xStr.substring(1) + c;
			}
		}
		for (int i=0; i<yStr.length(); ++i) {
			if (xStr.equals(yStr)) {
				return true;
			}
			char c = yStr.charAt(0);
			if (i < yStr.length() - 1) {
				yStr = yStr.substring(1) + c;
			}
		}
		return false;
	}
	
}



