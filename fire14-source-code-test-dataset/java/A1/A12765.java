import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// bug eliminator

		Scanner in = new Scanner(new File("d:\\b.small.in"));// new Scanner(new
															// File("d:\\b.small.in"));
		// in = new Scanner(new File("d:\\Minimum Scalar Product-big.in"));

		int people, surp, max,cutter, dangers, certainty;
		int[] scores;

		int testCases = in.nextInt();
		in.nextLine();
		for (int cas = 1; cas <= testCases; cas++) {

			int ans = 0;

			people = in.nextInt();
			scores = new int[people];
			surp = in.nextInt();
			max = in.nextInt();
			cutter = max*3;

			for (int i = 0; i < people; i++)
				scores[i] = in.nextInt();

//			in.nextLine();// eat linedelim

			dangers = 0;
			certainty = 0;
			for (int i = 0; i < people; i++) {
				if (scores[i] >= cutter - 2) {
					certainty++;
				} else if (scores [i] >= cutter - 4&&cutter - 4>=0) {
					dangers++;
				}
			}
//			System.out.println("m"+max+"c"+cutter+"c"+certainty+"d"+dangers+"s"+surp);
			ans = certainty;
			ans+= dangers > surp ? surp : dangers;

			System.out.printf("Case #%d: %d\n", cas, ans);
		}

	}

}
