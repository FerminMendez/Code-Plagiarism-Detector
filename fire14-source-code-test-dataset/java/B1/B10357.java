package com.dten.cj.qual;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class C {

	public static int distinctPairs(int start, int end) {
		int count = 0;
		for (int i = start; i <= end; i++)
			for (int j = start; j <= end; j++)
				if (i < j && isPair(i, j))
						count++;
		return count;
	}

	public static boolean isPair(int i, int j) {
		String iStr = String.valueOf(i);
		String jStr = String.valueOf(j);
		if (iStr.length() == 1 || jStr.length() != iStr.length())
			return false;
		int characters = iStr.length();
		while (characters-- > 0)
			if ((iStr = iStr.substring(1) + iStr.charAt(0)).equals(jStr))
				return true;
		return false;
	}
	
	public static String processLine(String line){
		String[] split = line.split(" ");
		return String.valueOf(distinctPairs(Integer.parseInt(split[0]),
				Integer.parseInt(split[1])));
	}

	public static String processFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		int caseCount = 0;
		try {
			for (String line : FileUtils.readLines(new File(fileName)))
				if (caseCount > 0)
					sb.append("Case #").append(caseCount++).append(": ")
							.append(processLine(line)).append("\r\n");
				else if (caseCount++ == 0)
					continue;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString().trim();
		
	}

	public static void main(String[] args) {
		String fileName = "C-small-attempt0";

		try {
			FileUtils.write(new File("outputs/qual/" + fileName + ".out"),
					C.processFile("inputs/qual/" + fileName + ".in"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
