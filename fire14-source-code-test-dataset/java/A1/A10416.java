package qualification.taskA;

import java.util.Map;

public class Task {

	private Map<Character, Character> dictionary ;

	public Task(Map<Character, Character> dictionary ) {
		this.dictionary = dictionary;
	}

	public String execute(String original) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < original.length(); i++){
			result.append(dictionary.get(original.charAt(i)));
		}
		return result.toString();
	}

}
