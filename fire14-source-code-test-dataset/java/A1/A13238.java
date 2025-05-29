import java.util.Scanner;


public class Dancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner readStuff = new Scanner(System.in);
		
		int numCases, numGooglers, numSurprises, numTarget;
		int scores, results = 0;
		
		numCases = readStuff.nextInt();
		
		for (int i = 0; i< numCases; i++) {
			numGooglers = readStuff.nextInt();
			numSurprises = readStuff.nextInt();
			numTarget = readStuff.nextInt();

			for (int j=0; j<numGooglers; j++) {
				scores = readStuff.nextInt();
				if (scores >= (3*numTarget - 2) && scores > 0) {
					results++;
				}
				else if (scores >= (3*numTarget-4) && scores > 0 && numSurprises > 0) {
					results++;
					numSurprises--;
				}
				if (scores == 0 && numTarget == 0) {
					results++;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + results);
			results = 0;
		}
	}

}
