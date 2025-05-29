import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * GoogleDancers Class
 * 
 * @author ndiwan
 * 
 */
public class GoogleDancers {

	/**
	 * Main method for calculating best results of Google dancers
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int testCases;
		int googlers;
		int surprising;
		int cutOff;
		int[] marks;
		int bestResult = 0;

		BufferedWriter bw = null;
		Scanner scan = null;

		try {

			bw = new BufferedWriter(new FileWriter("Output.txt"));
			scan = new Scanner(new File("Input.txt"));

			testCases = scan.nextInt();

			for (int i = 1; i <= testCases; i++) {

				googlers = scan.nextInt();
				surprising = scan.nextInt();
				cutOff = scan.nextInt();
				bestResult = 0;

				marks = new int[googlers];

				// storing marks for googlers
				for (int j = 0; j < googlers; j++) {
					marks[j] = scan.nextInt();
				}

				// processing marks in triplets
				for (int k = 0; k < marks.length; k++) {

					int div = marks[k] / 3;
					int rem = marks[k] % 3;

					if (div != 0) {
						if (div >= cutOff) {
							++bestResult;
						} else {
							if (cutOff - div == 1) {
								if (rem >= 1) {
									++bestResult;
								} else if (surprising > 0) {
									++bestResult;
									--surprising;
								}
							}
							if (cutOff - div == 2 && rem > 1 && surprising > 0) {
								++bestResult;
								--surprising;
							}
						}
					}
					else {
						if (cutOff == 0 || rem >= cutOff){
							++bestResult;
						}
						else if (rem >= cutOff && surprising > 0) {
							++bestResult;
							--surprising;
						}
					}
				}

				bw.write("Case #" + i + ": " + bestResult + "\n");
			}

		} catch (Exception e) {
			System.out.println("Exception " + e);
			e.printStackTrace();
			
		} finally {
			scan.close();
			try {
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}