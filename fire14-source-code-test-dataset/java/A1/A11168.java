package codezam.exercise.WR1B2012;

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
 * Google Code Jam - 2012 DancingWiththeGooglers
 * 
 * @author Ryan
 * @since 2012.4.14
 */
public class DancingWiththeGooglers {

	private List lines = new ArrayList();
	
	public DancingWiththeGooglers() {
		String filename = "C:/eclipse/eclipse.test/workspace/CodeZam-Exercise/app/src/codezam/exercise/WR1B2012/test.in";
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
		
		int n = new Integer(lineSplit[0]);
		int s = new Integer(lineSplit[1]);
		int p = new Integer(lineSplit[2]);
		int[] t = new int[n];
		
		TripletSet[] googlerTripletSets = new TripletSet[n];
		
		for (int i=0; i<n; i++) {
			t[i] = new Integer(lineSplit[3+i]);
			
			googlerTripletSets[i] = new TripletSet(t[i]);//사람 별로 받을 수 있는 점수 세트
		}
		
		//경우의 수
		tripletSetTrace(googlerTripletSets, n, s, p, 0, 0, 0);
		String result = Long.toString(maxNumberEqualsOrMoreThanP);
		maxNumberEqualsOrMoreThanP = 0;
		
		return result;
	}
	
	static long maxNumberEqualsOrMoreThanP = 0;
	
	private void tripletSetTrace(TripletSet[] tripletSets, int n, int s, int p, int currentGooglerIndex, int surpriseCount, int numberEqualsOrMoreThanP) {
		long result = 0;
		
		//int surpriseCount = new Integer(surpriseCount).intValue();
		
		if (currentGooglerIndex > n ) {
			//System.out.println("! currentGooglerIndex "+currentGooglerIndex+"> n "+n);
			return;
		}
		if (surpriseCount > s) {
			//System.out.println("! surpriseCount "+surpriseCount+"> s "+s);
			return;
		}
		
		if (currentGooglerIndex == n) {
			if (maxNumberEqualsOrMoreThanP <= numberEqualsOrMoreThanP) {
				maxNumberEqualsOrMoreThanP = numberEqualsOrMoreThanP;
				//System.out.println("maxNumberEqualsOrMoreThanP="+maxNumberEqualsOrMoreThanP);
			}
			
		} else {
			for (int i=0; i<tripletSets[currentGooglerIndex].size(); i++) {
				int surpriseCountNew = tripletSets[currentGooglerIndex].isSurprising(i) ? surpriseCount+1 : surpriseCount;
				int numberEqualsOrMoreThanPNew = (p <= tripletSets[currentGooglerIndex].maxValue(i)) ? numberEqualsOrMoreThanP+1 : numberEqualsOrMoreThanP;
				
				//System.out.println(currentGooglerIndex+","+i+"->surpriseCountNew="+surpriseCountNew);
				//System.out.println(currentGooglerIndex+","+i+"->numberEqualsOrMoreThanPNew="+numberEqualsOrMoreThanPNew);
				
				tripletSetTrace(tripletSets, n, s, p, currentGooglerIndex+1, surpriseCountNew, numberEqualsOrMoreThanPNew);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DancingWiththeGooglers question = new DancingWiththeGooglers();

		question.solve();
	}
		
}
