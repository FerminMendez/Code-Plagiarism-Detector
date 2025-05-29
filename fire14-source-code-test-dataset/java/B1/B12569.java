package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecycledNumbers {

	private static int noOfCases;
	private static String[] result;
	private static List<Integer> listOfNumbers;
	private static String inputFile = "C-small-attempt0.in";
	private static String outputFile = "C-small-attempt0.out";
	
	public static void main(String[] args) {
		
		readInputFile();
		
		
		writeToFile(result);
	}
	
	public static void writeToFile(String args[]) {
		try {
			FileWriter fstream = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fstream);
			for (int i = 0; i < args.length; i++) {
				out.write(args[i]);
				if (i != args.length - 1)
					out.newLine();
			}
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream(inputFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];
			for (int i = 0; i < noOfCases; i++) {
				listOfNumbers = new ArrayList<Integer>();
				
				strLine = br.readLine();
				String[] temp = strLine.split(" ");
				int start = Integer.parseInt(temp[0]);
				int end = Integer.parseInt(temp[1]);
				System.out.println("start: "+start+".. end: "+end);
				
				int totalSum = getResult(start,end);
				System.out.println("Case #" + (i + 1) + ": " + totalSum);
				result[i] = "Case #" + (i + 1) + ": " + totalSum;
			}

			for(int x=0;x<listOfNumbers.size();x++){
				System.out.println(listOfNumbers.get(x));
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static int getResult(int start, int end) {
		int totalSum = 0;
		for(int i=start;i<=end;i++){
			if(listOfNumbers.contains(i)){
				continue;
			}
			String number = String.valueOf(i);
			char[] numberArray = number.toCharArray();
			if(sameDigit(numberArray)){
				continue;
			}
			//System.out.println(number);
			totalSum = totalSum + getCount (numberArray,i,start,end);
		}
		//System.out.println(totalSum);
		return totalSum;
	}

	private static boolean sameDigit(char[] numberArray) {
		
		if(numberArray.length <=1){
			return true;
		}
		for(int i=0;i<numberArray.length-1;i++){
			if(numberArray[i] != numberArray[i+1]){
				return false;
			}
		}
		return true;
	}

	private static int getCount(char[] arr, int currentNumber,int start, int end) {
		int count=0;
		int nc2Count=0;
		char[][] tempNumbers = new char[arr.length][arr.length];
		int[] numberArray = new int[arr.length];
		List<Integer> localList  = new ArrayList<Integer>();
		//System.out.println("current number: "+currentNumber);
		
		// Getting different combination of char arrays//
		// Duplicate the first array
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				tempNumbers[i][j] = arr[j];
			}
		}
		
		// Rest of the combinations
		for(int i=1;i<arr.length;i++){
			char a = tempNumbers[i-1][0];
			int j = 0;
			for(j=0;j<arr.length-1;j++){
				tempNumbers[i][j] = tempNumbers[i-1][j+1];
				//System.out.println("temp["+i+"]["+j+"] = "+tempNumbers[i-1][j+1]);
			}
			tempNumbers[i][j] = a;
		}
		// End of combinations//
		
		//Converting the char array of diff combinations to String and then to Integer
		// Also add the number to the count of valid combinations
		for(int i=0;i<arr.length;i++){
			String num = String.valueOf(tempNumbers[i]);
			numberArray[i] = Integer.parseInt(num);
			System.out.println(numberArray[i]);
			if((numberArray[i]>=start && numberArray[i]<=end) && (!localList.contains(numberArray[i]))){
				localList.add(numberArray[i]);
				count++;
				listOfNumbers.add(numberArray[i]);
			}
		}
		
		
		//Calculate the nc2 for the numbers
		nc2Count = (count * (count-1))/2;
		if(nc2Count!=0){
			System.out.println("current number: "+currentNumber+". count: "+count+". nc2 count: "+nc2Count);
		}
		System.out.println();
		return nc2Count;
	}
}
