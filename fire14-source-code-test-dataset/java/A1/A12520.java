import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ClientB {

	public static void main(String args[]) throws Exception {
		ClientB client = new ClientB();
		String[] inputLines = client.getInputLines(args[0]);

		int lineCount = Integer.valueOf(inputLines[0]);

		for(int i = 1; i <= lineCount; i++) {
			String currentLine = inputLines[i];
			String[] currentCase = currentLine.split(" ");
			
			int numOfGooglers = Integer.valueOf(currentCase[0]);
			int numOfSuprisingScoreTriplets = Integer.valueOf(currentCase[1]);
			int numOfBestResultGtEq = Integer.valueOf(currentCase[2]);
			
			//System.out.println("Min or better: " + numOfBestResultGtEq);
			//System.out.println("sup: " + numOfSuprisingScoreTriplets);
			
			List<int[]> baseScores = new ArrayList<int[]>();
			for(int j = 0; j < numOfGooglers; j++) {
				baseScores.add(client.fillScores(Integer.valueOf(currentCase[3+j])));
			}
			
			int[] processedScores = client.categorizeScores(baseScores, numOfBestResultGtEq);
			
			int sol = processedScores[0] + Math.min(numOfSuprisingScoreTriplets, processedScores[1]);
			
			System.out.println("Case #" + i + ": " + sol);
			//System.out.println();
		}
	}

	private int[] categorizeScores(List<int[]> scores, int bar) {
		int[] cat = {0, 0, 0}; //Good, bad, no potential (of being counted)
		
		for(int[] eachScoreSet : scores) {
			int maxScore = eachScoreSet[1]; //by def of fillScores alg
						
			if(maxScore >= bar) {
				cat[0]++;
			} else if(maxScore+1 == bar) {
				int oth = Math.max(eachScoreSet[0], eachScoreSet[2]);
				if(oth-1 >= 0 && (maxScore+1) - (oth-1) <= 2) {
					cat[1]++;
				} else {
					cat[2]++;
				}
			} else { //no hope
				cat[2]++;
			}
		}
		
		return cat;
	}
	
	private int[] fillScores(int maxValue) {
		int[] scores = {0, 0, 0};
		int totScore = 0;
		while(++totScore <= maxValue) {
			scores[totScore % 3]++;
		}
		//System.out.println("maxVal:" + maxValue +" {"+scores[0]+","+scores[1]+","+scores[2]+"}");
		return scores;
		
	}
	
	private String[] getInputLines(String fileName) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		List<String> lines = new ArrayList<String>();
		String nextLine;
		while((nextLine = reader.readLine()) != null) {
			lines.add(nextLine);
		}
		return lines.toArray(new String[lines.size()]);
	}

}
