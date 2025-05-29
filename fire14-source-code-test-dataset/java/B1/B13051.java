package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class RecycleNumbers {

	private static FileReader fr;
	private static BufferedWriter bw;
	private static List<String> output = new ArrayList<String>();
	private static Map<Integer, String> input;

	public static void main(String args[]) {

		try {
			RecycleNumbers.fileRead();
			RecycleNumbers.coreLogic();
			RecycleNumbers.fileWrite();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void fileRead() throws IOException {
		try {
			fr = new FileReader("D:/data/C-small-attempt0.in");
			BufferedReader br = new BufferedReader(fr);
			input = new HashMap<Integer, String>();
			String line;
			int counter = 1;
			while ((line = br.readLine()) != null) {
				input.put(counter, line);
				counter++;
			}
			System.out.println(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			fr.close();
		}

	}

	private static void fileWrite() throws IOException {
		int counter = 1;
		try {
			bw = new BufferedWriter(new FileWriter(new File("D:/data/output.txt"), true));
			for (String writeLine : output) {
				bw.write("Case #" + counter + ": ");
				bw.write(writeLine);
				bw.newLine();
				counter++;
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void coreLogic() {
		int noOfCases = Integer.valueOf(input.remove(Integer.valueOf("1")));
		System.out.println("Number of Cases: " + noOfCases);
		StringBuffer outputString;
		for (int counter = 2; counter <= noOfCases + 1; counter++) {
			outputString = new StringBuffer();
			String processLine = input.get(Integer.valueOf(counter));
			if (processLine != null) {
				while (processLine != null) {
					System.out.println("################Case #: " + (counter - 1) + "########################################");
					System.out.println("Processing line: " + processLine);
					outputString.append(processString(processLine));
					break;
				}
				output.add(outputString.toString());
			}

		}
	}

	private static String processString(String processLine) {
		StringTokenizer strToken = new StringTokenizer(processLine, " ");
		String start = "";
		String end = "";
		int output = 0;
		start = strToken.nextToken();
		end = strToken.nextToken();
		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		int modulus = 10;
		int length = start.length();
		int counterLength = start.length();
		int startNumber = Integer.parseInt(start);
		int endNumber = Integer.parseInt(end);
		List<Integer> finalOutput = new ArrayList<Integer>();
		//Set<Integer> finalOutput = new HashSet<Integer>();
		if (startNumber >= 10) {
			while (true) {
				System.out.println("Length : " + length);
				System.out.println("Modulus Length : " + String.valueOf(modulus).length());
				if (length >= String.valueOf(modulus).length()) {
					for (int counter = startNumber; counter <= endNumber; counter++) {
						int numberA = counter;
						int calculation = (int) (((numberA % modulus) * Math.pow(10, counterLength -  1)) + (numberA / modulus));
						if ((calculation > numberA) && (calculation <= endNumber)) {
							System.out.println("@@@Number a: " + numberA + "  Calculation: " + calculation + "    Ouput: " + (output++));
							finalOutput.add(numberA);
						}
					}
				} else {
					break;
				}
				modulus = modulus * 10;
				counterLength = counterLength - 1;
			}

		}
		return String.valueOf(finalOutput.size());
	}
}
