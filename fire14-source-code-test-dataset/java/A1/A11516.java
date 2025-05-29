import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 
 * Google Code Jam 2012 Qualification Round - Problem B. Dancing With the Googlers
 * 
 * @author matlock
 *
 */
public class DancingGooglers {

	public static void main(String[] args) {
		DancingGooglers g = new DancingGooglers();
		g.goGo();
	}
	
	public void goGo() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int testCases = Integer.parseInt(in.readLine());
			
			for (int i = 1; i <= testCases; i++) {
				String inputText = in.readLine();
				String[] valueParse = inputText.split(" ");
				int index = 0;
				int numGooglers = Integer.valueOf(valueParse[index++]);
				int numSurprising = Integer.valueOf(valueParse[index++]);
				int targetVal = Integer.valueOf(valueParse[index++]);
				List<Integer> scores = new ArrayList<Integer>();
				
				for (int k = 0; k < numGooglers; k++) {
					scores.add(Integer.valueOf(valueParse[index++]));
				}
				
				int result = runTestCase(scores, numSurprising, targetVal);
				
				System.out.println("Case #" + i + ": " + result);
			}
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	private int runTestCase(List<Integer> scoreList, int numSurprising, int targetVal) {
		Collections.sort(scoreList);
		int targetCount = 0;
		
		if (targetVal == 0) { // if target score is 0 then all work
			return scoreList.size();
		}
		
		for (int score : scoreList) {
			if ((score - targetVal) / 2 < (targetVal - 2) || (score <= 0)) {
				continue; // skip impossible score
			}
			// process surprising score
			if (((score - targetVal) / 2 >= (targetVal - 2)) && (numSurprising > 0)) {
				targetCount++;
				numSurprising--;
			// all of these scores should be valid, within 1
			} else if ((score - targetVal) / 2 >= (targetVal - 1)) {
				targetCount++;
			} else {
				// skip
			}
		}
		
		return targetCount;
	}
	
}
