import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dancing {
	public static void main (String[] args) throws IOException {
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		int s, p, countBR = 0, casenum = 1;
	
		Scanner fileScan = new Scanner(new BufferedReader(
			new FileReader("B-small-attempt2.in")));
		Scanner lineScan;
		String theLine;
		
		Integer.parseInt(fileScan.nextLine());
		
		while (fileScan.hasNextLine()) {
         theLine = fileScan.nextLine();
         lineScan = new Scanner(theLine);
         lineScan.useDelimiter(" ");
			
			Integer.parseInt(lineScan.next());
			s = Integer.parseInt(lineScan.next());
			p = Integer.parseInt(lineScan.next());
			
         for (int i = 0; lineScan.hasNext(); i++) {
            scoreList.add(Integer.parseInt(lineScan.next()));
         }
			
			for (int t : scoreList) {
				if (p <= t) {
					if (t/3 >= p) {
						countBR++;
					}
					else {
						if ((t - p) >= ((p - 2) * 2)) {
							if ( ((2 * (p - 1)) + p) <= t) {
								countBR++;
							}
							else if ( (((2 * (p - 2)) + p) <= t) && s > 0) {
								countBR++;
								s--;
							}
						}
					}
				}
			}
			System.out.println("Case #" + casenum + ": " + countBR);
			casenum++;
			countBR = 0;
			scoreList.clear();
		}
	}
}
