package com.nitrous.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class CodeJamProblem3 {
	public static void readFile(String inputFile) throws IOException {
		File in = new File(inputFile);
		File dir = in.getParentFile();
		File outFile = new File(dir, in.getName()+".out");
		System.out.println("Output file is "+outFile.getAbsolutePath());
		PrintWriter out = new PrintWriter(outFile);
		BufferedReader reader = new BufferedReader(new FileReader(in));
		
		String line = null;
		
		int testCaseCount = Integer.parseInt(reader.readLine().trim());
		System.out.println("Read count="+testCaseCount);
		for (int testCase = 0 ; testCase < testCaseCount; testCase++) {
			line = reader.readLine();
			
			String[] numStrArr = line.split(" ");
			int min = Integer.parseInt(numStrArr[0]);
			int max = Integer.parseInt(numStrArr[1]);
			int count = 0;
			for (int current = min; current <= max; current++) {
				count += countRecycled(current, max);
			}
			
			out.println("Case #"+(testCase+1)+": "+count);
		}
		out.flush();
		out.close();
	}

	private static int countRecycled(int current, int maxValue) {
		String curAsStr = String.valueOf(current);
		int maxLen = curAsStr.length();
		HashSet<Integer> unique = new HashSet<Integer>();
		for (int len = 1; len < maxLen; len++) {
			String move = curAsStr.substring(0, len);
			String mid = curAsStr.substring(len);
			String newStr = mid + move;
			while (newStr.length() > 1 && newStr.startsWith("0")) {
				newStr = newStr.substring(1);
			}
			int newNum = Integer.parseInt(newStr);
			if (newNum > current && newNum <= maxValue) {
				unique.add(newNum);
			}
		}
		return unique.size();
	}
	
	public static void main (String[] args) throws IOException {
		readFile("D:/workspace/CodeJam/data/C-small-attempt0.in");
	}
}
