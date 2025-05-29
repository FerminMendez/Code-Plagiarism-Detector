import java.io.*;
import java.util.*;

public class B
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numCases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < numCases; i++) {
			solveCase(i+1, br.readLine());
		}
	}
	
	private static void solveCase(int caseNum, String line) {
		String[] parts = line.split(" ");
		int numGooglers = Integer.parseInt(parts[0]);
		int numSurprising = Integer.parseInt(parts[1]);
		int minScore = Integer.parseInt(parts[2]);
		
		ArrayList<Integer> scores = new ArrayList<Integer>(numGooglers);
		for(int i = 0 ;i < numGooglers; i++) {
			scores.add(Integer.parseInt(parts[i+3]));
		}
		
		//System.out.println(numSurprising +" surprising");
		//System.out.println("scores: "+ scores);
		
		System.out.println("Case #"+caseNum+": "+solve(minScore, scores, 0, numSurprising, 0));
	}
	
	private static int solve(int minScore, ArrayList<Integer> scores, int index, int surprisesRemaining, int result) {
		if(index == scores.size()) {
			return result;
		}
		
		if(solveWithoutSurprise(minScore, scores.get(index))) {
			result++;
		} else if(surprisesRemaining > 0 && solveWithSurprise(minScore, scores.get(index))) {
			result++;
			surprisesRemaining--;
		}
		
		return solve(minScore, scores, index + 1, surprisesRemaining, result);
	}
	
	private static boolean solveWithoutSurprise(int minScore, int totalScore) {
		if(minScore ==0) {
			return true;
		}
		if(totalScore == 0) {
			return false;
		}
		
		int scoresTo = totalScore - 1;
		int each = scoresTo / 3;
		if(each + 1 >= minScore) {
			return true;
		}
		return false;
	}
	
	private static boolean solveWithSurprise(int minScore, int totalScore) {
		if(totalScore == 0) {
			return false;
		}
		
		int scoresTo = totalScore - 2; // if total score was < 2, would have been true from WithoutSurprise
		int each = scoresTo / 3;
		int remainder = scoresTo % 3;
		if(remainder == 0 || remainder == 1) {
			if(each + 2 >= minScore) {
				return true;
			}
			return false;
		} else { // remainder ==2 
			//System.out.println("totalScore="+totalScore+": SHOULD NEVER HAPPEN!!!!!!!!!!!! SHOULD ALWAYS BE ABLE TO SOLVE WIHTOUT SURPIRSE!!!");
		}
		return false;
	}
}