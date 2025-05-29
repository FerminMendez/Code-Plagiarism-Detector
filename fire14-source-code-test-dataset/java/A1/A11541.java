import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class DancingWithGooglers {

	public static void main(String[] args) throws FileNotFoundException {
		int cases;
		
		Scanner scan = new Scanner(new File("B.small.in"));
		cases = scan.nextInt();
		
		for (int i = 1; i <= cases; i++) {
			int googlers = scan.nextInt();
			int surprising = scan.nextInt();
			int p = scan.nextInt();
			int totals[] = new int[googlers];
			
			for (int j = 0; j < googlers; j++) {
				totals[j] = scan.nextInt();
			}
			
			int isSurprising = 0;
			int possible = 0;
			
			for (int j = 0; j < googlers; j++) {
				if (p - (totals[j] / 3) <= 0) {
					possible++;
				} else if (p - (totals[j] / 3) == 1) { /* avg = 5, p = 6 */
					if (totals[j] % 3 == 0 && totals[j] > 0) {
						possible++; /* 0 */
						isSurprising++;
					} else if (totals[j] % 3 == 1) {
						possible++;
					} else if (totals[j] % 3 == 2) {
						possible++;
					}
				} else if (p - (totals[j] / 3) == 2) {
					if (totals[j] % 3 == 0) {
						
					} else if (totals[j] % 3 == 1) {
						
					} else if (totals[j] % 3 == 2) {
						possible++;
						isSurprising++;
					}
				}
			}
			
			if (isSurprising > surprising) {
				possible -= isSurprising - surprising;
			}
			
			System.out.println("Case #" + i + ": " + possible);
		}
	}

}
