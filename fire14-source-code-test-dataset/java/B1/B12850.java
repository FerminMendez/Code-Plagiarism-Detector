import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class RecycledNumbersSmall {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		int noTestcases;
		
		FileInputStream fis = new FileInputStream("D:/Eclipse Workspaces/ws_hyperbola/Recycled Numbers/src/example.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String sLine = br.readLine();
		noTestcases = Integer.parseInt(sLine);
		
		StringBuffer sb = new StringBuffer();
		List<String> outputList = new ArrayList<String>();
		
		for(int i = 1; i <= noTestcases && (sLine = br.readLine()) != null; i++) {
			String[] numLimits = sLine.split(" ");
			int lowerLimit = Integer.parseInt(numLimits[0]);
			int upperLimit = Integer.parseInt(numLimits[1]);
			int noRecycledPairs = getRecycledpairsCount(lowerLimit, upperLimit);
			System.out.println("Case #" + i + ": " + noRecycledPairs);
			outputList.add("Case #" + i + ": " + noRecycledPairs);
		}
		
		
		writeOutput(outputList);
		
		br.close();
		fis.close();
		
	}
	
	private static void writeOutput(List<String> lines) throws Exception {
		FileWriter fw = new FileWriter("D:/Eclipse Workspaces/ws_hyperbola/Recycled Numbers/src/output.txt");
		PrintWriter pw = new PrintWriter(fw);
		for(String line : lines) {
			pw.println(line);
		}
		pw.flush();
		pw.close();
	}

	private static int getRecycledpairsCount(int smallerNumber, int biggerNumber) {
		int result = 0;
		
		if(biggerNumber < 10) return 0;	// 1 digit numbers
		
		
		if(isBetween(smallerNumber, 10, 99) && isBetween(biggerNumber, 10, 99)) {	// 2 digit numbers
			Set<RecycledPair> setPair = new HashSet<RecycledPair>();
			for(int num = smallerNumber; num <= biggerNumber; num++) {
				int recycledNum = shiftDigit(num, 1);
				if(recycledNum != num && isBetween(recycledNum, smallerNumber, biggerNumber)) {
					setPair.add(new RecycledPair(num, recycledNum));
				}
			}
			//System.out.println(setPair.toString());
			result = result + setPair.size();
		}
		
		else if(isBetween(smallerNumber, 100, 999) && isBetween(biggerNumber, 100, 999)) {	// 3 digit numbers
			Set<RecycledPair> setPair = new HashSet<RecycledPair>();
			
			/* one digit shift */
			for(int num = smallerNumber; num <= biggerNumber; num++) {
				int recycledNum = shiftDigit(num, 1);
				if(recycledNum != num && isBetween(recycledNum, smallerNumber, biggerNumber)) {
					setPair.add(new RecycledPair(num, recycledNum));
				}
			}
			
			/* two digit shift */
			for(int num = smallerNumber; num <= biggerNumber; num++) {
				int recycledNum = shiftDigit(num, 2);
				if(recycledNum != num && isBetween(recycledNum, smallerNumber, biggerNumber)) {
					setPair.add(new RecycledPair(num, recycledNum));
				}
			}
			
			//System.out.println(setPair.toString());
			result = result + setPair.size();
		}
		
		else if(isBetween(smallerNumber, 1000, 9999) && isBetween(biggerNumber, 1000, 9999)) {	// 3 digit numbers
			Set<RecycledPair> setPair = new HashSet<RecycledPair>();
			
			/* 1 digit shift */
			for(int num = smallerNumber; num <= biggerNumber; num++) {
				int recycledNum = shiftDigit(num, 1);
				if(recycledNum != num && isBetween(recycledNum, smallerNumber, biggerNumber)) {
					setPair.add(new RecycledPair(num, recycledNum));
				}
			}
			
			/* 2 digit shift */
			for(int num = smallerNumber; num <= biggerNumber; num++) {
				int recycledNum = shiftDigit(num, 2);
				if(recycledNum != num && isBetween(recycledNum, smallerNumber, biggerNumber)) {
					setPair.add(new RecycledPair(num, recycledNum));
				}
			}
			
			
			/* 3 digit shift */
			for(int num = smallerNumber; num <= biggerNumber; num++) {
				int recycledNum = shiftDigit(num, 3);
				if(recycledNum != num && isBetween(recycledNum, smallerNumber, biggerNumber)) {
					setPair.add(new RecycledPair(num, recycledNum));
				}
			}
			
			//System.out.println(setPair.toString());
			result = result + setPair.size();
		}
		
		return result;
	}
	
	private static boolean isBetween(int number, int lowerLimit, int upperLimit) {
		return number >= lowerLimit && number <= upperLimit;
	}
	
	private static int shiftDigit(int number, int digitsNo) {
		String sNum = String.valueOf(number);
		int index = sNum.length() - digitsNo;
		String sNewNumber = sNum.substring(index) + sNum.substring(0, index);
		return Integer.parseInt(sNewNumber);
	}
	

}
