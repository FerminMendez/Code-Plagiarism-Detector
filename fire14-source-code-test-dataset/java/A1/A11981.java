import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class DWG {
	public static void main(String[] args) {
		Integer caseNum = 0;
		/*if(args.length == 0) {
			return;
		}
		caseNum = Integer.parseInt(args[0]);*/
		ArrayList<String> argList = new ArrayList<String>();
		
		String line=null;
		File inputFile = new File("DWGData.txt");
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
			System.out.println("Case #" + (caseIndex+1) + ": " + countGooglers(input));
		}
	}
	
	private static int countGooglers(String input) {
		int numOfWiners = 0;
		String[] inputData = input.split(" ");
		if(inputData.length >=4) {
			int numOfGooglers = Integer.parseInt(inputData[0]);
			int numOfSurprise = Integer.parseInt(inputData[1]);
			int score = Integer.parseInt(inputData[2]);
			
			int minWithSurprise = ((score > 2) ? (score-2) : 0)*2 + score;
			int minWithoutSurprise = ((score > 1) ? (score-1) : 0)*2 + score;
			
			if((inputData.length-3) == numOfGooglers) {
				int[] scoreOfGooglers = new int[numOfGooglers];
				for(int i=0; i < numOfGooglers; i++) {
					scoreOfGooglers[i] = Integer.parseInt(inputData[i+3]);
					if(scoreOfGooglers[i] >= minWithoutSurprise) {
						numOfWiners++;
					}else if(scoreOfGooglers[i] >= minWithSurprise) {
						if(numOfSurprise > 0) {
							numOfWiners++;
							numOfSurprise--;
						}
					}
				}
				
			}
		}
		
		return numOfWiners;
	}
}
