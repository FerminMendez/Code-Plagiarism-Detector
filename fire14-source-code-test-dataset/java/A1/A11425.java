package qualification.B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		int totalCase = 0;
		int supriseCaseNo = 0;
		int googlerNo = 0;
		int p = 0;
		FileInputStream is = null;
		try {
			is = new FileInputStream(args[0]);
			Scanner scan = new Scanner(is);
			totalCase = scan.nextInt();
			for (int i = 0; i < totalCase; i++) {
				googlerNo = scan.nextInt();
				supriseCaseNo = scan.nextInt();
				p = scan.nextInt();
				int[] scores = new int[googlerNo];
				for (int j = 0; j < googlerNo; j++) {
					scores[j] = scan.nextInt();
				}
				solve(i, googlerNo, supriseCaseNo, p, scores);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void solve(int caseNo, int googlerNo, int supriseCaseNo, int p,
			int[] scores) {
		int answer = 0;
		int t = supriseCaseNo;
		for (int i = 0; i < googlerNo; i++) {
			// •½‹Ï’l‚ÌŒvŽZ
			int avg = scores[i] / 3;
			int mod = scores[i] % 3;
			int diff = avg - p;
			if (diff <= -3) { 
				continue;
			} else if (diff >= 0) {
				answer++;
			} else if (diff == -1) {
				if (mod == 0) {
					if (t > 0 && p > 1) {
						t--;
						answer++;
					} else {
						continue;
					}
				} else {
					answer++;
				}
			} else if (diff == -2) {
				if (mod == 0 || mod == 1) {
					continue;
				} else if (mod == 2) {
					if (t > 0) {
						t--;
						answer++;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Case #");
		sb.append(caseNo+1);
		sb.append(": ");
		sb.append(answer);
		System.out.println(sb.toString());
		
	}
}
