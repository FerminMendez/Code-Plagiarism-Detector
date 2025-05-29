package codejam2012;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class QualB {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream(new File("/home/rush/sample-in.txt")));
		PrintWriter out = new PrintWriter(new FileOutputStream("/home/rush/sample-out.txt"));
		
//		Scanner in = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				int ti = in.nextInt();
				if (ti % 3 == 1) {
					if (ti / 3 + 1 >= p)
						cnt++;
				} else {
					if (ti % 3 == 0) {
						if (ti / 3 >= p) {
							cnt++;
						} else if (ti != 0 && s > 0 && ti / 3 + 1 == p) {
							cnt++;
							s--;
						}
					}
					if (ti % 3 == 2) {
						if (ti / 3 + 1 >= p) {
							cnt++;
						} else if (s > 0 && ti / 3 + 2 == p) {
							cnt++;
							s--;
						}
					}
				}
			}
			out.printf("Case #%d: %d", (i+1), cnt);
			out.println();
		}
		out.flush();
	}
}
