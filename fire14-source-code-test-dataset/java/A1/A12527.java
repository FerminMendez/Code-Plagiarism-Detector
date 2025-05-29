package qualificationRound;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q2Dancing {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("qualificationRound/B-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new File("qualificationRound/out.txt"));
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc <= T; tc++) {
			out.print("Case #"+tc+": ");
			
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int lowerBound = Math.max(p,3*p-2);
			int lowerSurprise = Math.max(p,3*p-4);
			int count = 0;
			for (int i=0; i<N; i++) {
				int t = sc.nextInt();
				if (t >= lowerBound)
					count++;
				else if (t >= lowerSurprise && S > 0) {
					count++;
					S--;
				}
			}
			
			out.println(count);
			out.flush();
		}
		out.close();
	}

}