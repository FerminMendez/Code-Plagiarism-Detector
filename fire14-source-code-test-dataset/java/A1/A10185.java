package codejam;

import codejam.fileHandler;

public class DancingWithTheGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		fileHandler file = new fileHandler("DancingWiththeGooglers.in",
				"DancingWiththeGooglersout.in");
		int noOfCases = file.readCase();
		for (int i = 1; i <= noOfCases; i++) {
			int numberArray[] = file.readIntegers();
			int N = numberArray[0];
			int s = numberArray[1];
			int p = numberArray[2];
			int upperLimit = 3 * p - 2;
			int lowerLimit = 3 * p - 4;
			if(p==0){
				upperLimit = lowerLimit = 0;
			}
			if(p == 1){
				upperLimit = lowerLimit = 1;
			}
			int count = 0;
			for (int j = 3; j < numberArray.length; j++) {
				if (s == 0) {
					if (numberArray[j] >= upperLimit) {
						count++;
					}
				}
				else{
					if(numberArray[j] >= lowerLimit){
						if(numberArray[j] == lowerLimit){
							s--;
						}
						else if(numberArray[j] == (lowerLimit + 1)){
							s--;
						}
						count++;
					}
				}
			}
			String print = "Case #" + i + ": " + count + "\n";
			file.writeToOutput(print);
		}
	}

}
