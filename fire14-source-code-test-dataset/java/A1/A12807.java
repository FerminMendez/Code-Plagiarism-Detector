/*
ID: 14vikra1
LANG: JAVA
TASK: dancescore
*/
import java.io.*;
import java.util.*;

class dancescore {
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("dancescore.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dancescore.out")));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int surprise = 0;
			int work = 0;
			for (int j = 0; j < N; j++) {
				int current = Integer.parseInt(st.nextToken());
				if (current%3 != 0 && current >= 2) {
					if (Math.ceil(current/3) + 1 >= p) {
						work++;
					} else if (Math.ceil(current/3) + 2 >= p) {
						surprise++;
					}
				} else if (current >= 2) {
					if (Math.ceil(current/3) >= p) {
						work++;
					} else if (Math.ceil(current/3) + 1 >= p) {
						surprise++;
					}
				} else {
					if (current == 1 && p <= 1) {
						work++;
					} else if (current == 1 && p == 2) {
						surprise++;
					} else if (current == 0 && p == 0) {
						work++;
					}
				}
			}
			int answer = work + Math.min(S, surprise);
			out.println("Case #" + (i+1) + ": " + answer);
		}
		out.close();
		System.exit(0);        
	}
}

