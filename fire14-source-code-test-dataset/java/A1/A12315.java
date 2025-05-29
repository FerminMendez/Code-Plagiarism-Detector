package gcj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Dancing {
	Scanner sc;
	PrintWriter pw;
	
	int t, n, y, p, s;
	int[] scores;
	
	Dancing() {
		try {
			sc = new Scanner(new File("B-small-attempt0.in"));
			pw = new PrintWriter(new FileWriter("out.txt"));
		} catch (IOException e) { 
			
		}
		
		t = sc.nextInt();
		
		int caseNum = 1;
		
		while (caseNum <= t) {
			n = sc.nextInt();
			s = sc.nextInt();
			p = sc.nextInt();
			y = 0;
			
			scores = new int[n];
			for (int i = 0; i < n; i++)
				scores[i] = sc.nextInt();
			
			// start algorithm
			if (p == 0)
				y = n;
			else {
				for (int score : scores) {
					if ( score >= 3*p-2 ) {
						y++;
					} else if (s > 0 && score >= Math.abs(3*p-4)) {
						y++;
						s--;
					}
				}
			}
			pw.println("Case #" + caseNum + ": " + y);
			caseNum++;
		}
		pw.flush();
		pw.close();
	}
	
	public static void main(String[] args) {
		new Dancing();
	}

}
