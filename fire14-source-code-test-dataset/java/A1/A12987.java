import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DanclingGooglers {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input2.in"));
		int numCases = scanner.nextInt();

		PrintWriter pw = new PrintWriter(new File("output2.txt"));

		for (int i = 1; i <= numCases; i++) {
			int num = scanner.nextInt();
			int surprisingTriplets = scanner.nextInt();
			int bestScore = scanner.nextInt();

			int result = 0;
			
			for (int k = 0; k < num; k++) {
				int score = scanner.nextInt();
				if(bestScore == 0){
					result++;
				} else if(bestScore>=1 && score >= (3* bestScore - 2)){
					result++;
				} else if(bestScore>=2 && score>= (3*bestScore -4) && surprisingTriplets>0){
					result++;
					surprisingTriplets--;
				} 
			}
			pw.println("Case #" + i + ": " + result);			
		}
		scanner.close();
		pw.close();
	}
}
