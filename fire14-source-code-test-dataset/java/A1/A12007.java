package test.qual;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.utility.FileReader;
import com.utility.FileWriterUtility;

public class SpeakInTongues {
	public static void main(String[] args) throws IOException {
		BufferedReader inputBufReader = FileReader.getBufferedReader("sample.txt");
		BufferedReader br = FileReader.getBufferedReader("A-small-attempt1.in");
		BufferedWriter bw = FileWriterUtility.getBufferedWriter("output.txt");
		
		Map<Character, Character> wordMap = getWordMap(inputBufReader);
		
		wordMap.put('y', 'a');
		wordMap.put('e', 'o');
		wordMap.put('z', 'q');
		
		if (wordMap.keySet().size() == 25) {
			List<Character> alphabets1 = new ArrayList<Character>();
			List<Character> alphabets2 = new ArrayList<Character>();
			for (int i = 0; i < 26; i++) {
				alphabets1.add((char) ('a'+i));
				alphabets2.add((char) ('a'+i));
			}
			
			alphabets1.removeAll(wordMap.keySet());
			alphabets2.removeAll(wordMap.values());
			wordMap.put(alphabets1.get(0), alphabets2.get(0));
		}
		
		int n = Integer.valueOf(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			char[] chars = input.toCharArray();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Case #" + (i+1) + ": ");
			
			for (int j = 0; j < chars.length; j++) {
				if (chars[j] == ' ') {
					stringBuilder.append(' ');
				}
				else if (wordMap.get(chars[j]) != null) {
					stringBuilder.append(wordMap.get(chars[j]));
				}
				else {
					stringBuilder.append(chars[j]);
				}
			}
			
			bw.write(stringBuilder.toString());
			bw.newLine();
		}
		bw.close();
	}

	private static Map<Character,Character> getWordMap(BufferedReader inputBufReader)
			throws IOException {
		List<Character> input = new ArrayList<Character>();
		List<Character> output= new ArrayList<Character>();
		
		for (int i = 0; i < 3; i++) {
			String[] strArray = inputBufReader.readLine().split(" ");
			for (int j = 0; j < strArray.length; j++) {
				char[] temp = strArray[j].toCharArray();
				for (int k = 0; k < temp.length; k++) {
					input.add(temp[k]);
				}
			}
		}
		
		for (int i = 0; i < 3; i++) {
			String[] strArray = inputBufReader.readLine().split(" ");
			for (int j = 0; j < strArray.length; j++) {
				char[] temp = strArray[j].toCharArray();
				for (int k = 0; k < temp.length; k++) {
					output.add(temp[k]);
				}
			}
		}
		
		if (input.size() != output.size()) {
			throw new RuntimeException("Invalid word mapping");
		}
		
		Map<Character, Character> wordMapping = new HashMap<Character, Character>();
		
		for (int i = 0; i < input.size(); i++) {
			wordMapping.put(input.get(i), output.get(i));
		}
		return wordMapping;
	}
	
	
//	List<Character> alphabets1 = new ArrayList<Character>();
//	List<Character> alphabets2 = new ArrayList<Character>();
//	for (int i = 0; i < 26; i++) {
//		alphabets1.add((char) ('a'+i));
//		alphabets2.add((char) ('a'+i));
//	}
//	
//	System.out.println(wordMapping.keySet().size());
//	 alphabets1.removeAll(wordMapping.keySet());
//	 alphabets2.removeAll(wordMapping.values());
//	System.out.println();
//	System.out.println('z' - 'a');
}
