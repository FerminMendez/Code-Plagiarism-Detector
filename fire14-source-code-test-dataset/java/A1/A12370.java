import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("in"));

		scan.nextLine();// removes int at start

		int counter = 0;

		while (scan.hasNextInt()) {
			
			counter++;
			
			// initialize
			int numDancers = scan.nextInt();
			int numSurp = scan.nextInt();
			int best = scan.nextInt();

			int[] dancers = new int[numDancers];

			for (int i = 0; i < numDancers; i++) {
				dancers[i] = scan.nextInt();
			}

			// do the checks
			
			if (best==0) {
				System.out.println("Case #"+counter+": "+numDancers);
				
			}
			else if (best==1){
				int cnt = 0;
				for (int i = 0; i < numDancers; i++){
					if (dancers[i]!=0) {
						cnt++;
					}
				}
				System.out.println("Case #"+counter+": "+cnt);
			}
			else{

			int count1 = 0, count2 = 0;

			for (int i = 0; i < numDancers; i++) {
				int score = dancers[i];
				if (score >= 3 * best - 2 && 3*best - 2>=0) {
					count1++;
				} else if (score >= 3 * best - 4 && 3*best-4>=0) {
					count2++;
				}
			}

			if (count2 <= numSurp) {
				System.out.println("Case #"+counter+": "+ (int)(count1 +count2));
			}
			else{
				System.out.println("Case #"+counter+": "+ (int)(count1+numSurp));
			}

		}

	}
	}

}
