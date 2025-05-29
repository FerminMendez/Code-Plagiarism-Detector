import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;



public class RN {
	
	public static void main(String[] args) {
		Integer caseNum = 0;
		/*if(args.length == 0) {
			return;
		}*/
		ArrayList<String> argList = new ArrayList<String>();
		
		String line=null;
		File inputFile = new File("RNData.txt");
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			while ((line=reader.readLine()) != null) {
				argList.add(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		caseNum = Integer.parseInt(argList.get(0));
		
		for(int caseIndex=0; caseIndex < caseNum.intValue(); caseIndex++) {
			String input = argList.get(caseIndex+1);
			System.out.println("Case #" + (caseIndex+1) + ": " + countRecycledPairs(input));
		}
	}
	
	private static int countRecycledPairs(String input) {
		int numOfPairs = 0;
		String[] inputData = input.split(" ");
		if(inputData.length == 2 && inputData[0].length() == inputData[1].length()) {
			int A = Integer.parseInt(inputData[0]);
			int B = Integer.parseInt(inputData[1]);
			numOfPairs = totalPairsBetweenBig(A, B);
			
			
		}
		
		return numOfPairs;
	}
	
	private static int totalPairsBetween(int A, int B) {
		int digitLength = Integer.toString(A).length();
		if(digitLength <= 1 || Integer.toString(B).length() != digitLength || A >= B)
			return 0;
		
		int pairsOnA = 0;
		int[] pairsOfA = new int[digitLength];
		for(int i=1; i<digitLength; i++) {
			String recycleString = Integer.toString(A).substring(i, digitLength) + Integer.toString(A).substring(0, i);
			int recycleInt = Integer.parseInt(recycleString);
			if(recycleInt > A && recycleInt <= B) {
				
				int pairIndex = 0;
				while(pairsOfA[pairIndex] != 0) {
					//System.out.println("The recycleInt is " + recycleInt + " value is " + pairsOfA[pairIndex]);
					if(pairsOfA[pairIndex] == recycleInt)
						break;
					
					pairIndex++;
				};
				
				if(pairsOfA[pairIndex] == 0) {
					pairsOfA[pairIndex] = recycleInt;
					//System.out.println("save " + pairsOfA[pairIndex]);
					pairsOnA++;
				}
			}

		}
		
		return pairsOnA + totalPairsBetween(A+1, B);
	}
	
	private static int totalPairsBetweenBig(int A, int B) {
		int digitLength = Integer.toString(A).length();
		if(digitLength <= 1 || Integer.toString(B).length() != digitLength || A >= B)
			return 0;
		
		int totalPairs = 0;
		
		while(A < B) {
			int pairsOnA = 0;
			int[] pairsOfA = new int[digitLength];
			
			for(int i=1; i<digitLength; i++) {
				String recycleString = Integer.toString(A).substring(i, digitLength) + Integer.toString(A).substring(0, i);
				int recycleInt = Integer.parseInt(recycleString);
				if(recycleInt > A && recycleInt <= B) {
					
					int pairIndex = 0;
					while(pairsOfA[pairIndex] != 0) {
						//System.out.println("The recycleInt is " + recycleInt + " value is " + pairsOfA[pairIndex]);
						if(pairsOfA[pairIndex] == recycleInt)
							break;
						
						pairIndex++;
					};
					
					if(pairsOfA[pairIndex] == 0) {
						pairsOfA[pairIndex] = recycleInt;
						//System.out.println("save " + pairsOfA[pairIndex]);
						pairsOnA++;
					}
				}

			}
			
			totalPairs += pairsOnA;
			A++;
		}
		
		return totalPairs;
	}
}
