import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem B. Dancing With the Googlers
 */

/**
 * @author zdenda
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		in.nextLine();

		for (int i = 1; i <= t; i++) {
			
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			List<Integer> ti = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				ti.add(in.nextInt());
			}
			//in.nextLine();

			int result = compute(s, p, ti);

			System.out.println("Case #"+ i + ": " + result);
			
		}

	}

	/**
	 * computes the maximum number of Googlers that could have had a best result of at least p
	 * 
	 * @param s - the number of surprising triplets of scores
	 * @param p
	 * @param ti - the total points of the Googlers
	 * @return the maximum number of Googlers that could have had a best result of at least p
	 */
	public static int compute(int s, int p, List<Integer> ti) {
		
		// limit for not surprising
		int nsLimit = p + 2 * (Math.max(0, (p-1)));
		// limit for surprising
		int sLimit = p + 2 * (Math.max(0, (p-2)));
		
		// not surprising counter
		int nsCount = 0;
		// surprising counter
		int sCount = 0;
		
		for (Integer score : ti) {
			if(score >= nsLimit) {
				++nsCount; // if it's over not surprising limit
			} else if (score >= sLimit) {
				++sCount; // if it's at over surprising limit, but under not surprising limit 
			}
		}
		
		// max number of surprising scores is S, so we take the smaller number
		sCount = Math.min(s, sCount);
		
		return nsCount + sCount;
		
	}

}
