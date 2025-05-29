package bsevero.codejam.qualification;

import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {
	
	private static Set<String> FOUND_PAIRS = new HashSet<String>();

	public static int recycle(String minStr, String maxStr) {
		FOUND_PAIRS = new HashSet<String>();
		int min = Integer.valueOf(minStr);
		int max = Integer.valueOf(maxStr);
		
		int total = 0;
		for(int i = min; i <= max; i++) {
			total += calculate(i, min, max);
		}
		
		return total;
	}
	
	private static int calculate(int value, int min, int max) {
		String valueStr = String.valueOf(value);
		
		if(valueStr.length() < 2) {
			return 0;
		}
		
		int count = 0;
		for(int numDigits = 1; numDigits < valueStr.length(); numDigits++) {
			String newValueStr = valueStr.substring(valueStr.length() - numDigits, valueStr.length()) + valueStr.substring(0, valueStr.length() - numDigits);
			int newValue = Integer.valueOf(newValueStr);
			if(newValue > value && newValue <= max) {
				if(!FOUND_PAIRS.contains(value + " " + newValue)) {
					FOUND_PAIRS.add(value + " " + newValue);
					count++;
				}
				
			}
		}
		
		return count;
	}
	
	
}

