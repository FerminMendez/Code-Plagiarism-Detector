import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class RecycledNumbers {

	public static void main(String[] args) {
		Scanner inputFile = new Scanner(new InputStreamReader(System.in));
		String inputLine = null;
		String[] numberArray;
		int testCaseCount = 0;
		int startNumber = 0;
		int endNumber = 0;
		int recycledPairCount = 0;
		int digitCount = 0;
		StringBuilder recycleNumber = new StringBuilder();
		int newNumber = 0;
		String newNumberString;
		HashSet<String> recycleNumbers = new HashSet<String>();
		while (inputFile.hasNextLine()) {
			inputLine = inputFile.nextLine();
			numberArray = inputLine.split(" ");
			if(numberArray != null && numberArray.length == 1) {
				/*numberOfTestCases = Integer.parseInt(numberArray[0]);*/
			} else if (numberArray != null && numberArray.length == 2) {
				digitCount = numberArray[0].length();
				startNumber = Integer.parseInt(numberArray[0]);
				endNumber = Integer.parseInt(numberArray[1]);
				while(startNumber <= endNumber) {
					newNumberString = "" + startNumber;
					for(int i = 1; i < digitCount; i++) {
						recycleNumber = recycleNumber.append(newNumberString.substring(i) + newNumberString.substring(0, i));
						newNumber = Integer.parseInt(recycleNumber.toString());
						if(newNumber > startNumber && newNumber <= endNumber) {
							recycleNumbers.add(recycleNumber.toString());
						}
						recycleNumber.delete(0, digitCount);
					}
					recycledPairCount = recycledPairCount + recycleNumbers.size();
					startNumber++;
					recycleNumbers.clear();
				}
				System.out.println("Case #" + testCaseCount + ": " + recycledPairCount);
			}
			testCaseCount++;
			recycledPairCount = 0;
			startNumber = 0;
			endNumber = 0;
			digitCount = 0;
			newNumber = 0;
			recycleNumber.delete(0, digitCount);
		}
	}
}
