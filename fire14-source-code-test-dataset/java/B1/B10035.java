package com.google.cj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Recycling {
	public static void main(String[] args) {
		List<String> fileContents = IOHandler
				.readInput("/home/wzedan/cj/input/recycling.in");

		List<String> output = getPairs(fileContents);
		IOHandler.writeOutput(output, "/home/wzedan/cj/output/recycling.out");
	}

	private static List<String> getPairs(List<String> fileContents) {
		List<String> output = new ArrayList<String>();

		for (String line : fileContents) {
			StringTokenizer st = new StringTokenizer(line);
			String lowerLimit = st.nextToken();
			String upperLimit = st.nextToken();

			if (lowerLimit.length() == 1 && upperLimit.length() == 1) {
				output.add("" + 0);
				continue;
			}
			int maxShiftFactor = upperLimit.length() - 1;
			List<String> refCharacters = new ArrayList<String>();
			buildRefCharacters(lowerLimit, upperLimit, refCharacters);
			int noOfPairs = 0;
			List<Entry> shiftedList = new ArrayList<Entry>();
			for (int distance = 1; distance <= maxShiftFactor; distance++) {
				System.out.println("Distance = [" + distance + "]");
				shiftedList.addAll(shiftList(refCharacters, distance,
						Integer.valueOf(upperLimit) , Integer.valueOf(lowerLimit)));
				Set<Entry> s = new HashSet<Entry>(shiftedList);
				shiftedList.clear();
				shiftedList.addAll(s);
				System.out.println("ShiftedList length [" + shiftedList.size() + "]");
				System.out.println(shiftedList);
				
				
			}
			System.out.println("No of pairs [" + shiftedList.size()
					+ "] for lowerLimit [" + lowerLimit
					+ "] and upperLimt [" + upperLimit + "]");

			output.add("" + shiftedList.size());
		}
		return output;
	}

	private static int findMatches(List<String> refCharacters,
			List<Entry> shiftedList) {
		int noOfPairs = 0;
//		for (int i = 0; i < shiftedList.size(); i++) {
//			if (refCharacters.contains(shiftedList.get(i).value)) {
//				noOfPairs +=1;
//			}
//		}
		return shiftedList.size();
	}

	private static void buildRefCharacters(String lowerLimit,
			String upperLimit, List<String> refCharacters) {
		for (int i = Integer.valueOf(lowerLimit); i <= Integer
				.valueOf(upperLimit); i++) {
			refCharacters.add("" + i);
		}
	}

	private static List<Entry> shiftList(List<String> refCharacters,
			int distance, int upperLimit , int lowerLimit) {
		List<Entry> shiftedList = new ArrayList<Entry>();
		for (int i = 0; i < refCharacters.size(); i++) {
			Entry entry = shift(refCharacters.get(i), i, distance, upperLimit , lowerLimit);
			if (entry != null) {
				shiftedList.add(entry);
			}
		}
		return shiftedList;
	}

	public static Entry shift(String n, int index, int distance, int upperLimit , int lowerLimit) {
		String nCopy = n;
		if (!hasAllSameDigit(n)) {
			//System.out.println("Shifting [" + n + "] distance [" + distance + "]");
			String shiftPattern = n
					.substring(n.length() - distance);
			int shiftPatternIndex = n.length() - shiftPattern.length();
					
			String modifiedN = n.substring(0, shiftPatternIndex);
			n = shiftPattern + modifiedN;
			if (n.startsWith("0")) {
				n = nCopy;
			}
			
			int nInteger = Integer.valueOf(n);
			// A <= n < m <= B
			if(nInteger < lowerLimit){
				n = nCopy;
			}
			if (nInteger > upperLimit) {
					n = nCopy;
			}
			if(Integer.valueOf(nCopy) > nInteger ){
				n = nCopy;
			}
		}
		return !n.equals(nCopy) ? new Entry(nCopy, n) : null;
	}

	private static boolean hasAllSameDigit(String n) {
		char c = n.charAt(0);
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) != c) {
				return false;
			}
		}
		return true;
	}
}
