import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/** Main function is "solve" **/
public class CodeJamProblem3 {
	static HashMap<String, String> mappings = null;

	public static void main(String args[]) {
		solve();
	}

	private static void solve() {
		readFromInputAndWriteInOutput();
	}

	private static void readFromInputAndWriteInOutput() {
		try {
			File f = new File("C-small-attempt0.in");
			FileReader fileReader = new FileReader(f);
			BufferedReader buff = new BufferedReader(fileReader);
			String totalTestCases = buff.readLine();
			PrintWriter printWriter = new PrintWriter(
					"C-small-attempt0.out");
			int testCases = Integer.parseInt(totalTestCases);
			for (int i = 1; i <= testCases; i++) {

				String line = buff.readLine();
				String outputLine = "Case #" + i + ": ";
				String result = solveForThisLine(line);
				outputLine = outputLine.concat(result);
				printWriter.println(outputLine);
				//System.out.println(outputLine);
			}
			printWriter.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static String solveForThisLine(String line) {

		String lineSplit[] = line.split(" ");
		int numA = Integer.parseInt(lineSplit[0]);
		int numB = Integer.parseInt(lineSplit[1]);
		int result = 0;
		int length = lineSplit[0].length();
		int tensLength = 1;	
	//	System.out.println();
		for(int i=0;i<length-1;i++)
		{
			tensLength=tensLength*10;
		}
		for (int i = numA; i <= numB; i++) {
			int n = i;
			ArrayList<Integer > list2 = new ArrayList<Integer>();
			for (int j = 0; j <=length; j++) {
				
				int m = reverse(i, j,tensLength);
				if (numA <= n && n < m && m <= numB) {
						if(list2.contains(m))
						{
						   continue;
						}
					list2.add(m);
					result = result + 1;
				}
				
			}
		}
		return result + "";
	}

	private static int reverse(int number, int shiftBy, int tensLength) {
		int temp = 0, reversedNumber = 0;
		for (int i = 0; i <shiftBy; i++) {		
			temp = number % 10;
			number = number / 10;
			reversedNumber = temp *tensLength  + number;
			number= reversedNumber;
		}
		return reversedNumber;
	}

}
