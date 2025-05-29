package qualificationRound;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class DancingWithTheGooglers {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("D:/in.in"));
		PrintStream out = new PrintStream(new File("D:/out.txt"));
		int round = in.nextInt();
		for (int z = 1; z <= round; z++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int count = 0;
			for (int i = 0; i < n; i++) {
				int tmp = in.nextInt();
				int mod = tmp % 3;
				int avg = tmp / 3;
				if (avg >= p) {
					count++;
				} else if (mod == 2) {
					if (avg == p - 1) {
						count++;
					} else if (avg == p - 2 && s != 0) {
						count++;
						s--;
					}
				} else if (mod == 1) {
					count += (avg == p - 1)? 1: 0;
				} else if (mod == 0 && s != 0 && avg != 0) {
					if (avg == p - 1) {
						count++;
						s--;
					}					
				}
			}
			out.println("Case #" + z + ": " + count);
		}
		in.close();
		out.close();
	}
}
