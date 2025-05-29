import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class DancingWithTheGooglers {


	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new FileReader("B-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("outputB0.txt"));

		int caseCount = sc.nextInt();
		sc.nextLine();

		for (int caseNum = 0; caseNum < caseCount; caseNum++) {

			//System.out.println(caseNum);
			int dancerCount = sc.nextInt();
			int surprisingCount = sc.nextInt();


			int p = sc.nextInt();
			int pCount = 0;
			int sCount = 0;

			for (int dancerNum = 0; dancerNum < dancerCount; dancerNum++) {
				int score = sc.nextInt();
				int d = checkScore(score, p);
				if (d == 1) 
					pCount++;
				else if (d == 2)
					sCount++;
			}

			//System.out.println(pCount + " " + sCount + " " + surprisingCount);
			int count = pCount;
			if (sCount < surprisingCount) {
				count += sCount;
			}
			else {
				count += surprisingCount;
			}

			pw.write("Case #" + (caseNum + 1) + ": ");
			pw.write(count + "\n");
		}

		pw.flush();
		pw.close();
		sc.close();
	}

	private static int checkScore(int score, int p) {
		
		boolean sScore = false;

		for (int a = 0; a <= 10; a++) {
			for (int b = 0; b <= 10; b++) {
				for (int c = 0; c <= 10; c++) {
					
					if (a + b + c == score &&
							(a >= p || b >= p || c >= p)) {

						int ab = Math.abs(a-b);
						int ac = Math.abs(a-c);
						int bc = Math.abs(b-c);

						if (ab < 2 && ac < 2 && bc < 2) {
							//System.out.println("P " + a + " " + b + " " + c);
							return 1;
						}
						else if (ab < 3 && ac < 3 && bc < 3) {
							//System.out.println("S " + a + " " + b + " " + c);
							sScore = true;
						}
					}

				}
			}
		}
		
		if(sScore == true) {
			return 2;
		}

		return 0;
	}
}
