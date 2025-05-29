import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class DancingWithTheGooglers {

	public static void main(String[] args) throws Exception {
		DancingWithTheGooglers speakingInTougues = new DancingWithTheGooglers();
		// file name
		String fileName = "dancing_with_the_googlers";
		
		// file variable
		File inputFile = new File(fileName + ".in");
		File outputFile = new File(fileName + ".out");
		Scanner scanner = new Scanner(inputFile);
		FileWriter writer = new FileWriter(outputFile);


		// problem variable
		int totalCase;
	
		// get total case
		totalCase = Integer.parseInt(scanner.nextLine());
		//System.out.println("Total case:"+totalCase);
		//totalCase = 2;
		//HashMap< String, String> dictionaryMap = speakingInTougues.constructDataDictionary();
		
		for (int caseIndex = 1; caseIndex <= totalCase; caseIndex++) {

			String lineDetail = scanner.nextLine();
			String[] inputArray = lineDetail.split(" ");
			int playerAmount = Integer.parseInt( inputArray[0] );
			int surprisingCaseAmount = Integer.parseInt( inputArray[1] );
			int bestResultNo = Integer.parseInt( inputArray[2] );
			
			int[] playerScores = new int[playerAmount];
			int idx = 0;
			for(int pAmount = 3; pAmount<(3+playerAmount); pAmount++){
				playerScores[idx] = Integer.parseInt(inputArray[pAmount]);
				idx++;
			}
			int maximumPossible = speakingInTougues.classfiedGoogler(playerScores, surprisingCaseAmount, bestResultNo);
			String output = "Case #" + caseIndex + ": " + maximumPossible;		
			System.out.println(output);

			writer.write(output + "\n");
		}
		
		scanner.close();
		writer.close();
	}
	
	private int classfiedGoogler(int[] playerScores, int suprisingResultAmount, int threshold){
		int maximumPossible = 0;
		int totalScore = 0;
		int playerAmount = playerScores.length;
		int [][] playerTableScore = new int[playerAmount*2][4];
		
		int startVal = 0;
		int maxNormal, maxSurprise = 0;
		int minNormal = 0;
		int minSurprise = 0;
		List<Integer> normalPassList = new ArrayList<Integer>();
		List<Integer> normalNoSpecialPass = new ArrayList<Integer>();
		
		//System.out.println("Player Score:"+playerScores.length);
		for(int i=0; i<playerScores.length; i++){
			maxNormal = 0;
			maxSurprise = 0;
			totalScore = playerScores[i];
			//findPossibleCases(playerScores[i]);
			if(totalScore%3 == 0)
			{
				startVal = totalScore/3;
				//normal case
				playerTableScore[(i*2)][0] = startVal;
				playerTableScore[(i*2)][1] = startVal;
				playerTableScore[(i*2)][2] = startVal;
				playerTableScore[(i*2)][3] = 1;
				maxNormal = startVal;
				minNormal = startVal;
				
				//suprising case
				playerTableScore[(i*2)+1][0] = startVal-1;
				playerTableScore[(i*2)+1][1] = startVal;
				playerTableScore[(i*2)+1][2] = startVal+1;
				playerTableScore[(i*2)+1][3] = 2;
				maxSurprise = startVal+1;
				minSurprise = startVal-1;
				
			}else if( totalScore%3 == 1)
			{
				startVal = (totalScore-1)/3;
				//normal case
				playerTableScore[(i*2)][0] = startVal;
				playerTableScore[(i*2)][1] = startVal;
				playerTableScore[(i*2)][2] = startVal+1;
				playerTableScore[(i*2)][3] = 3;
				maxNormal = startVal+1;
				minNormal = startVal;
				
				//suprising case
				playerTableScore[(i*2)+1][0] = startVal-1;
				playerTableScore[(i*2)+1][1] = startVal+1;
				playerTableScore[(i*2)+1][2] = startVal+1;
				playerTableScore[(i*2)+1][3] = 4;
				maxSurprise = startVal+1;
				minSurprise = startVal-1;
				
			}else if( totalScore%3 == 2)
			{
				startVal = (totalScore-2)/3;
				//normal case
				playerTableScore[(i*2)][0] = startVal;
				playerTableScore[(i*2)][1] = startVal+1;
				playerTableScore[(i*2)][2] = startVal+1;
				playerTableScore[(i*2)][3] = 5;
				maxNormal = startVal+1;
				minNormal = startVal;
				
				//suprising case
				playerTableScore[(i*2)+1][0] = startVal;
				playerTableScore[(i*2)+1][1] = startVal;
				playerTableScore[(i*2)+1][2] = startVal+2;	
				playerTableScore[(i*2)+1][3] = 6;	
				maxSurprise = startVal+2;
				minSurprise = startVal;
				
			}		
			
			if(maxNormal >= threshold )
			{ 
				if( minNormal >= 0){
					normalPassList.add(i);
				}
			}else if( maxSurprise >= threshold && maxNormal < threshold){
				if( minSurprise >= 0){
					normalNoSpecialPass.add(i);
				}
			}
			
		}

		
		if(suprisingResultAmount > 0)
		{
			if( suprisingResultAmount >= normalNoSpecialPass.size())
			{
				maximumPossible += normalNoSpecialPass.size();
			}else{
				maximumPossible += suprisingResultAmount;
			}			
		}
		maximumPossible += normalPassList.size();
		
		return maximumPossible;
		
	}
	
	
}
