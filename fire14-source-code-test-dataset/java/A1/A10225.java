import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemB {
	public static void main(String[]args) throws FileNotFoundException {
		File file = new File("test.txt");
		Scanner scan = new Scanner(file);
		
		int cases = Integer.parseInt(scan.nextLine());
		
		for(int i=1;i <= cases;i++) {
			int dancers = scan.nextInt();
			int surprise = scan.nextInt();
			int minscore = scan.nextInt();
			int winner = 0;
			for(int j=0;j<dancers;j++) {
				int score = scan.nextInt();
				if(score >= (minscore*3-2)) winner++;
				else if(score >= (minscore*3-4) && surprise!=0 && score!=0) { winner++; surprise--; }
				else;
			}
			if (scan.hasNextLine()) scan.nextLine();
			System.out.println("Case #" + i + ": " + winner);
		}
			
	}
}
