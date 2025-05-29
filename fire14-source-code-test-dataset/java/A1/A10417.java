package qualification.taskA;

import java.util.HashMap;
import java.util.Map;

import Parser.MyReader;
import Parser.MyWriter;

public class Main {
	public static void main(String[] args) {
		MyReader myReader = new MyReader(
				"/Users/shami13/Downloads/A-small-attempt0.in");
		MyWriter myWriter = new MyWriter("/Users/shami13/Downloads/A-small-attempt0.out");
		
		Map<Character, Character> dictionary = createDictionary();

		int taskLength = Integer.parseInt(myReader.read());

		
		for (int i = 1; i <= taskLength; i++) {
			String taskString = myReader.read();
			Task task = new Task(dictionary);
			String result = task.execute(taskString);
			myWriter.writeString("Case #" + i + ": " + result);
			System.out.println("Case #" + i + ": " + result);
		}
		myWriter.close();
	}

	private static Map<Character, Character> createDictionary() {
		Map<Character, Character> result = new HashMap<Character, Character>();
		result.put('q', 'z');
		result.put('z', 'q');
		
		
		String[] originals = { "ejp mysljylc kd kxveddknmc re jsicpdrysi",
				"rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd",
				"de kr kd eoya kw aej tysr re ujdr lkgc jv" };

		String[] results = { "our language is impossible to understand",
				"there are twenty six factorial possibilities",
				"so it is okay if you want to just give up" };
	
		for(int i = 0; i < originals.length; i++){
			for(int p = 0; p < originals[i].length(); p++){
				if (!result.containsKey(originals[i].charAt(p))){
					result.put(originals[i].charAt(p), results[i].charAt(p));
				}
			}
		}
		
		return result;
	}
}
