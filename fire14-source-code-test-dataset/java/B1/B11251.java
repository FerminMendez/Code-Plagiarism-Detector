import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class RecycledNumbers {
	private static int T;
	private static ArrayList<Integer> lowerLimit, upperLimit;
	private static ArrayList<Integer> numOfPairs;
	
	public static void main(String[] args) {
		readInputFile ();
		
		getNumberOfRecycledPairs ();
		
		writeOutputFile ();
	}
	
	private static void readInputFile () {
		numOfPairs = new ArrayList<Integer> ();
		lowerLimit = new ArrayList<Integer> ();
		upperLimit = new ArrayList<Integer> ();
		String line = "";
		
		try {
			BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (new FileInputStream ("input/C-small-attempt0.in")));
			
			line = bufferedReader.readLine ();
			T = Integer.parseInt (line);
			
			while ((line = bufferedReader.readLine ()) != null) {
				String [] dataSet = line.split (" ");
				
				lowerLimit.add (Integer.parseInt (dataSet [0]));
				upperLimit.add (Integer.parseInt (dataSet [1]));
			}
			
			System.out.println (lowerLimit + "\n" + upperLimit);
			bufferedReader.close ();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void getNumberOfRecycledPairs () {
		for (int i = 0; i < T; i++) {
			int numOfValidPairs = 0;
			
			for (int j = lowerLimit.get (i); j < upperLimit.get (i); j++) {				
				int numOfDigits = String.valueOf (j).length ();
				//int num = j;
				
				for (int k = 1; k < numOfDigits; k++) {					
					//num = ((num % (int)Math.pow (10, numOfDigits - 1)) * 10 + 
					//		(num / (int)Math.pow (10, numOfDigits - 1)));
					int num = ((j % (int)Math.pow (10, k)) * (int)Math.pow (10, numOfDigits - k)) + (j / (int)Math.pow (10, k));
					
					//if (num / (int)Math.pow (10, numOfDigits - 1) > 0) {
					if (String.valueOf (num).length() == String.valueOf (j).length()) {
						if (j < num && num <= upperLimit.get (i)) {
							numOfValidPairs++;
						}
					}
				}
			}
			numOfPairs.add (numOfValidPairs);
		}
	}
	
	private static void writeOutputFile () {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter (new OutputStreamWriter (new FileOutputStream ("output/output.out")));
			
			for (int i = 0; i < numOfPairs.size (); i++) {
				bufferedWriter.write ("Case #" + (i + 1) + ": " + numOfPairs.get (i) + "\n");
			}
			
			bufferedWriter.close ();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
