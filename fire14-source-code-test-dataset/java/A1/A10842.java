import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Dancing {

	public static void main(String[] args) {
		int numTestCases;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			numTestCases = Integer.parseInt(in.readLine());
			for (int i = 0; i < numTestCases; i++) {
				String line = in.readLine();
				String[] ints = line.split(" ");
				int numGooglers = Integer.parseInt(ints[0]);
				int numSurprising = Integer.parseInt(ints[1]);
				int p = Integer.parseInt(ints[2]);
				int numSuccess = 0;
				
				for (int j = 3; j < ints.length; j++) {
					int score = Integer.parseInt(ints[j]);
					// special case
					if (score == 0 && p > 0) {
						continue;
					}
					
					// trivial case
					if (score/3 >= p) {
						numSuccess++;
						continue;
					}
					
					int remainingTwoScoresSum = score - p;
					if (remainingTwoScoresSum >= (p-1)*2) {
						numSuccess++;
						continue;
					}
					
					if (remainingTwoScoresSum >= (p-2)*2 && numSurprising > 0) {
						numSuccess++;
						numSurprising--;
						continue;
					}
				}
				
				System.out.println("Case #"+(i+1)+": "+numSuccess);
			}
		} catch (IOException e) {
//				System.out.println("oh noes");
		}
	}

}
