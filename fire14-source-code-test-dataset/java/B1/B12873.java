package br.com.luan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.valueOf(line);

		// Process which number from stdin
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(line.length()+11);
			sb.append("Case #");
			sb.append(i+1);
			sb.append(": ");
			
			line = br.readLine();
			String[] split = line.split(" ");
			Integer a = Integer.parseInt(split[0]);
			Integer b = Integer.parseInt(split[1]);
			
			int result = processAB(a, b); 
					
			sb.append(result);
			
			sb.append('\n');
			System.out.print(sb.toString());
			
		}
	}

	private static int processAB(Integer a, Integer b) {
		return method2(a,b);
	}

	@SuppressWarnings("unused")
	private static int method1(Integer a, Integer b) {
		// Trying the simple approach: to substrings and look up. This might be
		// enough to pass the small set, but not the big one
		
		int result = 0;
		String aString = a.toString();
		String bString = b.toString();
		int bDiffA = b.intValue() - a.intValue() +1;
		
		
		Map<String, Map<String,Boolean>> occurences = new HashMap<String, Map<String,Boolean>>(bDiffA);
		for (int i = 0; i < bDiffA; i++) {
			occurences.put(String.valueOf(a.intValue()+i), new HashMap<String,Boolean>());
		}
		
		for(String key : occurences.keySet()){
			result += macthOccurences(key, occurences, a, b, aString, bString);
		}
		
		return result;
	}

	private static int macthOccurences(String key, Map<String, Map<String,Boolean>> occurences, Integer a, Integer b, String aString, String bString) {
		int result = 0;
		
		for(int i = key.length(); --i > 0;){
			String toFront = key.substring(i, key.length());
			String toBack = key.substring(0, i);
			String full = toFront + toBack;
			
			Map<String, Boolean> secMap = occurences.get(full);
			if(secMap != null && !key.equals(full)){
				Boolean boolean1 = secMap.get(key);
				if (boolean1 == null){
					result=+1;
					secMap.put(key, Boolean.TRUE);
					Map<String, Boolean> secMap2 = occurences.get(key);
					if(secMap2 != null){
						secMap2.put(full, Boolean.TRUE);
					}
				}
			}
		}
		
		return result;
	}


	private static int method2(Integer a, Integer b) {
		String aString = a.toString();
		String bString = b.toString();
		int bDiffA = b.intValue() - a.intValue() + 1;
		
		
		Map<String, Boolean> occurences = new HashMap<String, Boolean>(bDiffA);
		Map<String, Boolean> matches =  new HashMap<String, Boolean>(bDiffA);
		for (int i = 0; i < bDiffA; i++) {
			occurences.put(String.valueOf(a.intValue()+i), Boolean.FALSE);
		}
		
		for(String key : occurences.keySet()){
			macthOccurences2(key, occurences, matches, a, b, aString, bString);
		}
		
		return matches.size();
	}



	private static void macthOccurences2(String key, Map<String, Boolean> occurences, Map<String, Boolean> matches, Integer a, Integer b, String aString, String bString) {
		int kInt = Integer.valueOf(key);

		for (int i = key.length(); --i > 0;) {
			String toFront = key.substring(i, key.length());
			String toBack = key.substring(0, i);
			String full = toFront + toBack;

			Boolean boo = occurences.get(full);
			if (boo != null && !key.equals(full)) {
				String first;
				String second;
				if (full.charAt(0) != '0') {
					int fInt = Integer.valueOf(full);

					if (kInt > fInt) {
						first = String.valueOf(fInt);
						second = String.valueOf(kInt);
					} else {
						first = String.valueOf(kInt);
						second = String.valueOf(fInt);
					}

					matches.put(first + " " + second, Boolean.FALSE);
				}
			}
		}
	}

	
}
