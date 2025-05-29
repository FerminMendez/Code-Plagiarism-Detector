import java.io.BufferedReader;
import java.io.FileReader;


public class DancingTest {

	public static void main(String[] args) {
		int numCase = 0;
		int caseIndex = 0;
		int[] numGooglers = null;
		int[] numSurprises = null;
		int[] bestResult = null;
		int[][] scores = null;
		int maxNumScores = 30;
		
		try {
			FileReader reader = new FileReader("C:\\Users\\CheeMeng\\Downloads\\B-small-attempt1.in");
			BufferedReader br = new BufferedReader(reader);
			String s = br.readLine();
			numCase = new Integer(s).intValue();
			numGooglers = new int[numCase];
			numSurprises = new int[numCase];
			bestResult = new int[numCase];
			scores = new int[numCase][maxNumScores];
			while((s = br.readLine()) != null) {
				String s1[] = s.split(" ");
				numGooglers[caseIndex] = new Integer(s1[0]).intValue();
				numSurprises[caseIndex] = new Integer(s1[1]).intValue();
				bestResult[caseIndex] = new Integer(s1[2]).intValue();
				for (int i = 3; i < s1.length; i++)  {
					scores[caseIndex][i - 3] = new Integer(s1[i]).intValue();
				}
				caseIndex++;
			} 
			reader.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 1; i <= numCase; i++)  {
			System.out.println("Case #" + i + ": " + dancingTest(numGooglers[i - 1], numSurprises[i - 1], bestResult[i - 1], scores[i - 1]));
		}
	}
	
	public static int dancingTest(int numGooglers, int numSurprises, int bestResult, int[] scores)  {
		int count = 0;
		int nearMisses = 0;
		for (int i = 0; i < numGooglers; i++)  {
			int best = 0;
			if ((scores[i] % 3) == 0)  {
				// Assume scores are (x, x, x), so best score will be the average
				best = scores[i] / 3;
				// Specially consider the case where scores are (x - 1, x, x + 1)
				if ((best == bestResult - 1) && (best >= 1) && (best <= 9)) {
					nearMisses++;
				}
			}
			else if ((scores[i] % 3) == 2)  {
				// Assume scores are (x - 1, x, x), so best score will be the average
				best = (scores[i] + 1) / 3;
				// Specially consider the case where scores are (x - 1, x - 1, x + 1)
				if ((best == bestResult - 1) && (best >= 1) && (best <= 9)) {
					nearMisses++;
				}
			}
			else if ((scores[i] % 3) == 1)  {
				// Scores will be either (x - 1, x - 1, x) or (x - 2, x, x)
				// doesn't matter if any of them is marked surprising
				best = (scores[i] + 2) / 3;
			}
			if (best >= bestResult)  {
				count++;
			}
		}
		
		count = count + Math.min(nearMisses, numSurprises);
		return count;
	}
}
