package codezam.exercise.WR1C2012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import codezam.util.InputFile;

/**
 * Google Code Jam - 2012 RecycledNumbers
 * 
 * Using Frequency analysis method
 * 
 * @author Ryan
 * @since 2012.4.14
 */
public class RecycledNumbers {

	private List lines = new ArrayList();
	
	public RecycledNumbers() {
		String filename = "C:/eclipse/eclipse.test/workspace/CodeZam-Exercise/app/src/codezam/exercise/WR1C2012/C-small-attempt1.in";
		InputFile inputFile = new InputFile();
		inputFile.setFile(filename);

		int numberOfInput = Integer.parseInt(inputFile.readLine());
		
		for (int i = 0; i < numberOfInput; i++) {
			String input = inputFile.readLine();
			lines.add(input);
		}
	}

	public void solve() {
		
		//String output = getOutputForOneLine((String)lines.get(0));
		
		for (int i = 0; i < lines.size(); i++) {
			String output = getOutputForOneLine((String)lines.get(i));

			System.out.println("Case #" + (i + 1) + ": " + output.toLowerCase());
		}
	}

	private String getOutputForOneLine(String line) { 

		String[] lineSplit = line.split(" ");
		
		Long a = new Long(lineSplit[0]);
		Long b = new Long(lineSplit[1]);
		int digit = a.toString().length();
				
		PairNumbers pairNumbers = new PairNumbers();
		
		long from = a.longValue();
		long to = b.longValue();

		int total = 0;
		//System.out.println("from "+a+" to "+b);
		for (long i=from; i<=to; i++) {
			if (i>=449) {
				boolean aa = true;
			}
			String number = new Long(i).toString();
			for (int j=1; j<digit; j++) {
				String checker = number.substring(j,digit)+number.substring(0,j);
				if (!checker.equals(number) && new Long(checker).longValue() >=a && new Long(checker).longValue() <= b 
						&& !pairNumbers.containsKey(number, checker)) {
					pairNumbers.put(number, checker);

					//System.out.print(number+"->"+checker+", ");

					//if (++total%10==0) {
					//	System.out.println();
					//}
				}
			}
		}

		//System.out.println();
		//System.out.println();
		
		return Integer.toString(pairNumbers.size());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RecycledNumbers question = new RecycledNumbers();

		question.solve();

	}
		
}
