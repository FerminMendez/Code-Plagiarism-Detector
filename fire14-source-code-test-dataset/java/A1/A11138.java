import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Dance {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input.in");
		Scanner in = new Scanner(file);
		
		int cases = in.nextInt();
		
		for (int i = 0; i < cases; i++) {
			int N = in.nextInt(); //googlers
			int S = in.nextInt(); //surprising scores
			int p = in.nextInt();
			int [] scores = new int[N];
			for (int j = 0; j < scores.length; j++) {
				scores[j] = in.nextInt();
			}
			int max = 0;
			
			for (int j = 0; j < scores.length; j++) {
				if (scores[j] >= (3*p-2)) {
					max++;
				} else if (scores[j] >= (3*p-4) && S > 0 && !((3*p-4) <= 0) ) {
					max++;
					S--;
				}
			}
			System.out.println("Case #"+ (i+1) + ": " + max);	
		}
	}
}
