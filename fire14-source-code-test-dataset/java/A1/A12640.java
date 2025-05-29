import java.io.File;
import java.util.Scanner;


public class Dance {

	public static void main(String[] args) throws Throwable {
		Scanner scan = new Scanner(new File("dance.in"));
		int t = Integer.parseInt(scan.nextLine());
		for (int i = 1; i <= t; i++) {
			String line = scan.nextLine();
			Scanner token = new Scanner(line);
			int n = token.nextInt();
			int s = token.nextInt();
			int p = token.nextInt();
			int counter = 0;
			for (int j = 0; j < n; j++) {
				int score = token.nextInt();
				int scoreEach = score / 3;
				int remainder = score % 3;
				
				if (scoreEach >= p) {
					counter++;
				} else if (scoreEach + 1 == p && remainder >= 1) {
					counter++;
				} else if (scoreEach + 2 >= p && remainder == 2 && s > 0) {
					s--;
					counter++;
				} else if (scoreEach + 1 == p && remainder == 0 && s > 0 && score > 0) {
					s--;
					counter++;
				}
			}
			System.out.printf("Case #%d: %d\n", i, counter);
		}
	}

}
