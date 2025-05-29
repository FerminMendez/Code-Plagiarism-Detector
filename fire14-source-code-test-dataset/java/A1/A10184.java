package codejam;

import java.util.ArrayList;

import codejam.fileHandler;

public class SpeakingInTongues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		fileHandler file = new fileHandler("input.in", "output.in");
		int noOfCase = file.readCase();
		char abcd[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z' };
		char replacement[] = { 'y', 'n', 'f', 'i', 'c', 'w', 'l', 'b', 'k',
				'u', 'o', 'm', 'x', 's', 'e', 'v', 'z', 'p', 'd', 'r', 'j',
				'g', 't', 'h', 'a', 'q' };
		ArrayList<Character> arrayList = new ArrayList<Character>();
		for(int i=0;i<replacement.length;i++){
			arrayList.add(replacement[i]);
		}
		String string;
		String outputString;
		for (int i = 1; i <= noOfCase; i++) {
			string = file.readLineFromInput();
			outputString = "Case #" + i + ": ";
			for(int j=0;j<string.length();j++){
				if(string.charAt(j) == ' '){
					outputString += " ";
				}
				else{
					int k = arrayList.indexOf(string.charAt(j));
					outputString += abcd[k];
				}
			}
			outputString += "\n";
			file.writeToOutput(outputString);
		}

	}

}
