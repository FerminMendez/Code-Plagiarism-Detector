/**
 * 
 */
package code.google.codejam;

import java.util.Arrays;

/**
 * @author sunilkumarp
 *
 */
public class Dancing extends Template {
	
	int N = 0;
	
	int S = 0;
	
	int P = 0;
	
	int[] scores = null;
	
	int minscoreReqForP = 0;

	/* (non-Javadoc)
	 * @see code.google.codejam.Template#doSolveProblem()
	 */
	@Override
	protected Object doSolveProblem() throws Exception {
		int cannotGetPButCanGetS = 0;
		
		
		int count = 0;
		int canGetP = 0;
		
		int i = 0;
		for (; i < N; ++i) {
			int score = scores[i];
			if (score >= minscoreReqForP) {
				canGetP = N - i;
				break;
			}
			if (score > 1) {
				cannotGetPButCanGetS++;
			}
		}

		
		
		if (canGetP > 0) {
			int canGetPWithoutSAndWithS = 0;
			int canGetPWithS = 0; //signifies can't get P without S
			int canGetPWithoutS = 0; // signifies can't get P with S // Doesn't matter as doesn't affect 'S'
			//int cantGetPWithoutS = 0;
			for (int j = N -1; j >= N-canGetP; --j) {
				int score = scores[j];
				if (score > 1) {
					int mod = score % 3;
					switch (mod) {
					case 0:
						if (score/3 < P) {
							canGetPWithS++;
						} else {
							canGetPWithoutSAndWithS++;
						}
						break;
					case 1:
						canGetPWithoutSAndWithS++;
						break;
					case 2:
						if (score/3 + 1 < P) {
							if (score/3 + 2 < P) {
								// Not possible
								throw new IllegalStateException("must be something wrong");
							} else {
								canGetPWithS++;
							}
						} else {
							canGetPWithoutSAndWithS++;
						}
						break;
					}
				} else {
					canGetPWithoutS++;
				}
			}
			
			if (canGetPWithS <= S) {
				count = canGetP; 
			} else {
				count = canGetP - (canGetPWithS - S);
				count = count >= 0 ? count : 0;
			}
		}
		
		
		
		return count;
	}

	/* (non-Javadoc)
	 * @see code.google.codejam.Template#printInput()
	 */
	@Override
	protected void printInput() throws Exception {
		System.out.println("N-" + N);
		System.out.println("S-" + S);
		System.out.println("P-" + P);
		System.out.println("Scores-" + Arrays.toString(scores));
	}

	/* (non-Javadoc)
	 * @see code.google.codejam.Template#initializeTestCase()
	 */
	@Override
	protected void initializeTestCase() throws Exception {
		readLine();
		N = readNextInteger();
		S = readNextInteger();
		P = readNextInteger();
		minscoreReqForP = P == 1 ? 1 : (P == 0 ? 0 : 3 * P - 4);
		scores = new int[N];
		for (int i = 0; i < N; ++i) {
			scores[i] = readNextInteger();
		}
		Arrays.sort(scores);
	}

}
