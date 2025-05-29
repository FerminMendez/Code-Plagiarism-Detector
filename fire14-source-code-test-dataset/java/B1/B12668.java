import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeSet;

public class RecycleNumber {

	private static TreeSet<String> result = new TreeSet<String>();
	private static Hashtable<Integer, Integer> resultingString ;
	private static Hashtable<Integer, ArrayList<Integer>> reverseMapping ;
	private static ArrayList<Integer> values = new ArrayList<Integer>();
	private static int totalCount = 1 ;

	public static void main(String[] args) throws FileNotFoundException {
		new RecycleNumber().doProcessing(new File("D:\\codejam\\C\\sample.txt"));
		//reverseString("1512", "5121",100,500);

	}

	public void doProcessing(File inputFile) throws FileNotFoundException {
		Scanner scanner = new Scanner(inputFile).useDelimiter("\n");
		if (scanner != null) {
			int totalCases = Integer.parseInt(scanner.next().trim());
			int k = 1;
			if (totalCases > 0) {
				while (scanner.hasNext()) {
					String[] rowValues = scanner.next().trim().split(" ");

					int lowerLimit = Integer.parseInt(rowValues[0].trim());
					int upperLimit = Integer.parseInt(rowValues[1].trim());

					int successCase = getReverCount(lowerLimit, upperLimit);


					// System.out.println("Case #Lower Limit ; " + lowerLimit +
					// " : Upper Limit = " + upperLimit + "  " + k++ + ": " +
					// successCase);
					System.out.println("Case #" + k++ + ": " + successCase);
				}

			}
		}
		scanner.close();
	}

	public int getReverCount(int lowerNumber, int upperLimit) {
		//int count = 0;
		//int nums = 0;
		resultingString = new Hashtable<Integer, Integer>();
		reverseMapping = new Hashtable<Integer, ArrayList<Integer>>();
		values = new ArrayList<Integer>();
		for (int i = lowerNumber; i <= upperLimit; i++) {
			//System.out.println("@@@@@@@@@@" + i);
			//showPattern("", String.valueOf(i),i,lowerNumber,upperLimit);
			String val = String.valueOf(i);
			//System.out.println("String value of " + i + " is " + val);
			char firstChar = val.charAt(val.length() - 1);
			//	System.out.println("First Char = " + firstChar);
			String subString = val.substring(0, val.length() - 1);
			//	System.out.println("Sub String = " + subString);
			reverseString(val, new String(firstChar + subString), upperLimit, lowerNumber);

		}
		//System.out.println("Possibilities = " + result.size() + " Lower Num = " + lowerNumber + " : Upper Lim " + upperLimit  + "\n " + resultingString + "\n Reverse Mappings : " + reverseMapping);
		result = new TreeSet<String>();
		//System.out.println("Total Counts : " + values.size());
		// System.out.println("Numbers : " + nums);

		return resultingString.size();
	}

	public static boolean containsReverseEntry(int key, int val){
		boolean contains = false ;
		ArrayList<Integer> arrayList = reverseMapping.get(key);
		if (arrayList != null){
			
			contains = arrayList.contains(val);
		}
		return contains ;
	}

	public static void makeReverseEntry(int key, int value){
		ArrayList<Integer> arrayList = reverseMapping.get(key);
		if (arrayList == null){
			arrayList = new ArrayList<Integer>();
		}
		arrayList.add(value);
		reverseMapping.put(key, arrayList);
		//System.out.println("List " + reverseMapping);
	}

	public static void reverseString(String orgString, String val, int upperLimit, int lowerLimit){

		if (orgString.equals(val)){
			return ;
		}else{
			int formatedValue = Integer.parseInt(val);
			//	System.out.println("Original Value = " + orgString + " : Formated Value = " + formatedValue + " Upper Limit = " + upperLimit + " : Lower Limit - " + lowerLimit );
			if (formatedValue >= lowerLimit && formatedValue <= upperLimit){
				int integer = 0 ;

				int orgValue = Integer.parseInt(orgString);
				boolean containsReverseEntry = containsReverseEntry(orgValue,formatedValue);

				if ( !containsReverseEntry){

					values.add(formatedValue);
					//System.out.println("Placing Value - (" + orgString + "," + formatedValue + ") " + totalCount++);
					resultingString.put(orgValue, formatedValue);
					//reverseMapping.put(formatedValue, orgValue);
					makeReverseEntry(formatedValue, orgValue);
					//	System.out.println("Placing Value - (" + orgString + "," + formatedValue + ") Total Count " + totalCount );
					//System.out.println("Placing Reverse Value - (" + formatedValue + "," + orgString + ") Total Count " + totalCount++ );
				}
			}
			char firstChar = val.charAt(val.length() - 1);
			//	System.out.println("First Char = " + firstChar);
			String subString = val.substring(0, val.length() - 1);
			//	System.out.println("Sub String = " + subString);
			reverseString(orgString, new String(firstChar + subString), lowerLimit, upperLimit);
		}
	}

	public void showPattern(String st, String chars, int baseString, int lowerLimit, int upperLimit) {
		if (chars.length() <= 1){
			result.add(st + chars);
			int palString = Integer.parseInt(st + chars);
			if (palString < upperLimit && palString != baseString && palString > lowerLimit && resultingString.get(palString) == null ){
				resultingString.put(baseString, palString);
				values.add(palString);
			}
			System.out.println(st + chars);
		}else
			for (int i = 0; i < chars.length(); i++) {
				try {
					String newString = chars.substring(0, i) + chars.substring(i + 1);
					showPattern(st + chars.charAt(i), newString,baseString,lowerLimit,upperLimit);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}

	public int reverseInteger(int number) {
		int reverse = 0;
		while (number != 0) {
			reverse = reverse * 10;
			reverse = reverse + number % 10;
			number = number / 10;
		}
		return reverse;
	}
}
