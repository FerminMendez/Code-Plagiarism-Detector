import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Paul LaMotte
 *
 */
public class GooglerDance {

	public static void main(String[] args) {
		
		Scanner in;
		try {
			System.setOut(new PrintStream(new File("qualB.out")));
			in = new Scanner(new File("B-small-attempt2.in"));
			int lines = Integer.parseInt(in.nextLine());
			for (int i = 0; i < lines; i++) {
				int googlers = in.nextInt();
				int trips = in.nextInt();
				int best = in.nextInt();
				int count = 0;
				ArrayList<Integer> scores = new ArrayList<Integer>();
				for (int j = 0; j < googlers; j++) {
					int score = in.nextInt();
					int rem = score - best;
					int tmp = (int)Math.floor(rem / 2);
					if (score < best) {
						continue;
					}
					if (best - tmp <= 1) {
						count++;
					} else if (best - tmp <= 2 && trips > 0) {
						trips -= 1;
						count++;
					}
				}
				
				System.out.printf("Case #%d: %d\n", i + 1, count);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}
}
