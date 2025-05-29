import java.io.*;
import java.util.HashSet;
import java.util.Scanner;


public class RecycledNumbers {

	static String outputFile, inputFile;
	public static void main(String[] args) throws IOException   {
		if (args.length != 2)
			return;
		inputFile = args[0];
		outputFile = args[1];

		// Create FileReader Object
		FileReader inputFileReader = new FileReader(inputFile);
		FileWriter outputFileReader = new FileWriter(outputFile);

		// Create Buffered/PrintWriter Objects
		BufferedReader inputStream = new BufferedReader(inputFileReader);
		PrintWriter outputStream = new PrintWriter(outputFileReader);
		
		Scanner scanner;
		String inLine = null;
		int cases = Integer.parseInt(inputStream.readLine().trim());
		int a, b;
		for (int i = 1; i < cases + 1; i++) {
			inLine = inputStream.readLine().trim();
			scanner = new Scanner(inLine);
			
			a = scanner.nextInt();
			b = scanner.nextInt();
			outputStream.println("Case #"+i+": "+getNumRecycledNumbers(a,b));
		}
		
		
		outputStream.close();
	}
	
	private static int getNumRecycledNumbers(int a, int b){
		boolean[] isChecked = new boolean[b-a+1];
		String numStr, newNumStr;
		int totalPairs = 0, newNum, numPairs=1;
		
		for (int t = a; t <= b; t++){
			if (isChecked[t-a])continue;
			
			isChecked[t-a]=true;
			numStr = "" + t ;
			numPairs = 1;
			for (int i = numStr.length()-1; i>0; i--){
				newNumStr = numStr.substring(i)+numStr.substring(0, i);
				newNum = Integer.parseInt(newNumStr);
				if (newNum < a || newNum > b ||isChecked[newNum-a]) continue;
				else {
					isChecked[newNum-a] = true;
					numPairs++;
				}
			}
			if (numPairs >2){
				numPairs = getFactorial(numPairs) / ((getFactorial(numPairs-2)*2));
			}else if (numPairs ==2){
				numPairs = 1;
			} else {
				numPairs = 0;
			}
			totalPairs += numPairs;
		}
		
		
		return totalPairs;
	}
	
	private static int getFactorial(int n){
		int result = 1;
		while (n > 1){
			result *= n;
			n--;
		}
		return result;
	}

}
