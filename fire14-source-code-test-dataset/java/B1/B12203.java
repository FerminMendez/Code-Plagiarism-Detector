package com.google.codejam;

import java.util.ArrayList;

public class RecycledNumber {
	private static ArrayList<String> getRandomCombinations(String number) {
		ArrayList<String> combinations = new ArrayList<String>();
		String temp = null;
		for (int i = 1; i < number.length(); i++) {
			temp = String.valueOf(number.charAt(i));
			if (temp.equals("0")) {
				continue;
			}
			temp = temp + number.substring(i+1, number.length()) + number.substring(0, i);
			combinations.add(temp);
		}
		return (combinations);
	}
	
	private static boolean checkAllCharactersSame(String s) {
		char charToCheck = s.charAt(0);
		boolean oneCharactersSame = true;
		for (int i=1; i < s.length(); i++) {
			if (charToCheck != s.charAt(i)) {
				oneCharactersSame = false;
				break;
			}
		}
		
		return (oneCharactersSame);
	}
	
	public static long countRandomNumbers(long A, long B) {
		long randomNumberCount = 0;
		ArrayList<String> combinations = null;
		ArrayList<String> mnMap = new ArrayList<String>();
		String temp = null, reverseTemp = null;
		for (long i = A; i <= B; i++) {
			if (checkAllCharactersSame(String.valueOf(i))) {
				continue;
			}
			combinations = getRandomCombinations(String.valueOf(i));
			if (combinations.size() == 0) {
				continue;
			}
			for (String number: combinations) {
				if ((Long.parseLong(number) >= A) && (Long.parseLong(number) <= B)) {
					temp = String.valueOf(i)+"-"+number;
					reverseTemp = number+"-"+String.valueOf(i);
					if ((! number.equals(String.valueOf(i))) && (! mnMap.contains(temp)) && (! mnMap.contains(reverseTemp))) {
						mnMap.add(temp);
						randomNumberCount++;
					}
				}
			}
		}
		
		return (randomNumberCount);
	}
	
	public static void main(String[] args) {
		ArrayList<String> testCases = ContentReader.getContents("RecycledNumber.txt");
		long A, B;
		for (int i = 1; i <= Integer.valueOf(testCases.get(0)); i++) {
			A = Integer.valueOf(testCases.get(i).split(" ")[0]);
			B = Integer.valueOf(testCases.get(i).split(" ")[1]);
			System.out.println("Case #"+i+": "+countRandomNumbers(A, B));
		}		
	}
}