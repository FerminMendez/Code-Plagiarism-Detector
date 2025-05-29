/*
ID: 14vikra1
LANG: JAVA
TASK: recycled
*/
import java.io.*;
import java.util.*;

class recycled {
	public static void main (String [] args) throws IOException {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("recycled.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recycled.out")));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int pairs = 0;
			int size = (int)(Math.floor(Math.log(A)/Math.log(10)))+1;
			for (int j = A; j < B; j++) {
				pairs += checkPairs(j, A, B, size);
			}
			out.println("Case #" + (i+1) + ": " + pairs);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		out.close();
		System.exit(0);        
	}
	public static int checkPairs(int num, int A, int B, int size) {
		int numpairs = 0;
		ArrayList used = new ArrayList();
		for (int i = 1; i < size; i++) {
			int move = (int)(num%Math.pow(10, i));
			int test = (int)((num)/Math.pow(10,size-i+1));
			if (move >= test) {
				int newnum = (int)((num - move)/Math.pow(10,i));
				newnum = newnum + move*(int)(Math.pow(10,size-i));
				if (newnum > num && newnum <= B && !used.contains(newnum)) {
					numpairs++;
					used.add(newnum);
				}
			}
		}
		return numpairs;
	}
}

