package Qualification;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String output = "./result.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(output));
		int T = in.nextInt();
		
		for (int numCase = 1; numCase <= T; numCase++) {
			int N = in.nextInt(); // num of googlers
			int S = in.nextInt(); // num of surprising triplets
			int p = in.nextInt(); // threshold
			int[] totalPts = new int[N];
			for (int i = 0; i < N; i++)
				totalPts[i] = in.nextInt();
			
			int count = 0;
			for (int total : totalPts) {
				int minPt = total/3;
				int remainder = total % 3;
				if (minPt >= p || (remainder > 0 && minPt + 1 >= p)) {
					count++;
					continue;
				}
				
				// might be a surprising triplets
				if (S > 0 && remainder >= 2 && minPt + 2 >= p) {
					count++;
					S--;
					continue;
				}
				
				if (S > 0 && remainder == 0 && minPt + 1 >= p && minPt > 0) {
					count++; S--;
					continue;
				}
			}
			String toPrint = "Case #" + numCase + ": " + count;
			System.out.println(toPrint);
			writer.write(toPrint + "\r\n");
		}
		writer.flush();
		writer.close();
	}
}
