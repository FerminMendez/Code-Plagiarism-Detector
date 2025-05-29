import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class GoogleDancing {
	public static void main(String [] args) throws IOException {
		Scanner fileScan = new Scanner(new File("B-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("B-small-attempt0.out"));
		
		int n = Integer.parseInt(fileScan.nextLine());
		for (int i = 0; i < n; i++) {
			int numDancers = fileScan.nextInt();
			int surprises = fileScan.nextInt();
			int p = fileScan.nextInt();
			int max = 0;
			
			for (int j = 0; j < numDancers; j++) {
				int score = fileScan.nextInt();
				if (score >= p*3-2) {
					max++;
				}
				else if (score > 0 && score >= p*3-4 && surprises > 0) {
					surprises--;
					max++;
				}
			}
			
			int temp = i + 1;
			out.write("Case #" + temp + ": " + max + "\n");
		}
		
		out.close();
	}
}
