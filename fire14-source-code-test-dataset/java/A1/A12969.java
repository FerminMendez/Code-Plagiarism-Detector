package mgg.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author manolo
 * @date 13/04/12
 */
public class StringUtils {

	public static List<Integer> stringWithIntegersToList(String str, int numItems, String delim){

		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer tokenizer = new StringTokenizer(str, delim);
		if (tokenizer.countTokens() != numItems){
			throw new RuntimeException("EXCEPTION: The string \"" + str 
					+ "\" has more tokens (" + tokenizer.countTokens()
					+ ") than you said (" + numItems + ")");
		}
		for	(int i = 0; i < numItems; i++) {
			list.add(Integer.parseInt(tokenizer.nextToken()));
		}

		return list;
	}
	
	public static List<Integer> stringWithIntegersToList(String str, String delim){

		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer tokenizer = new StringTokenizer(str, delim);
		int numOfTokens = tokenizer.countTokens();
		for	(int i = 0; i < numOfTokens; i++) {
			list.add(Integer.parseInt(tokenizer.nextToken()));
		}

		return list;
	}

	public static List<String> stringWithStringsToList(String str, int numItems, String delim){

		ArrayList<String> list = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(str, delim);
		if (tokenizer.countTokens() != numItems){
			throw new RuntimeException("EXCEPTION: The string \"" + str 
					+ "\" has more tokens (" + tokenizer.countTokens()
					+ ") than you said (" + numItems + ")");
		}
		for	(int i = 0; i < numItems; i++) {
			list.add(tokenizer.nextToken());
		}

		return list;
	}
	
	public static List<String> stringWithStringsToList(String str, String delim){

		//System.out.println("String: " + str);
		
		ArrayList<String> list = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(str, delim);
		
		//System.out.println("tokenizer.countTokens() = " + tokenizer.countTokens());
		
		int numOfTokens = tokenizer.countTokens();
		for	(int i = 0; i < numOfTokens; i++) {
			list.add(tokenizer.nextToken());
		}

		return list;
	}

	public static List<Character> allCharactersToList(String str) {
		
		System.out.println("String: " + str);
		
		ArrayList<Character> list = new ArrayList<Character>();
		
		for	(int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		System.out.println("List of characters: " + list);
		
		return list;
	}
}
