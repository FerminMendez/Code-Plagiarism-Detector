import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;


public class RecycledNumbers {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadFile.read("C:\\test\\input.txt");
		ArrayList<String> elements = ReadFile.getElements();
		//Number of cases to test
		int numberCases = Integer.valueOf(elements.get(0));
		if(numberCases > elements.size()) {
			System.out.println("Error in number of tests");
			System.exit(-1);
		}
		elements.remove(0);// remove the first element, so only lines to translate are left in the file
		
		StringBuilder outputFile = new StringBuilder();
		for(int i = 1; i <= elements.size(); i++){
			String[] numbers = elements.get(i-1).split(" ");
			outputFile.append("Case #" + i + ": " + countRecycledNumbers(new Integer(numbers[0]), new Integer(numbers[1]) ) );
			outputFile.append("\r\n");
		}
		WriteFile.write("C:\\test\\output.txt", outputFile.toString());
		
	}

	private static int countRecycledNumbers(Integer integer1, Integer integer2) {
		int countRecycled = 0;
		for(int i = integer1; i<integer2; i++){
			int countRecyclablePerNumber = countRecyclablePerNumber(i, integer1, integer2);
			if(countRecyclablePerNumber > 0)
				countRecycled+=countRecyclablePerNumber;
		}
		
		return countRecycled;
	}

	private static int countRecyclablePerNumber(int number, int min, int max) {
		if(number < 10 ) return 0;
		int count = 0;
		String value = String.valueOf(number);
		char[] charValues = value.toCharArray();
		Vector<Integer> vectorRecycledNumbers = new Vector<Integer>();
		for(int i=0; i<value.length()-1; i++){
			String newValue = "";
			for(int j=value.length()-1-i; j<value.length(); j++){
				newValue += charValues[j];
			}
			for(int j=0; j<value.length()-1-i; j++){
				newValue += charValues[j];
			}	
			int newIntValue = Integer.valueOf(newValue);
			if(newIntValue <= max && newIntValue >= min && number < newIntValue 
					&& !vectorRecycledNumbers.contains(newIntValue)){
				count++;
				vectorRecycledNumbers.add(newIntValue);
			}
		}
		vectorRecycledNumbers.clear();
		return count;
	}

	
}
