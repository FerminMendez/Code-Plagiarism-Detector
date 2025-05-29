/*
PROG: ProbC
2012 Google CodeJam Qualification Round
Problem C
*/

import java.io.*;
import java.util.*;

public class Prob1C{

	public static void main(String [] args) throws IOException {
		//long start = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("Prob1C.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Prob1C.txt")));
		int N = Integer.parseInt(f.readLine());
		for(int i = 0; i < N; i++){
			String[] str = (f.readLine()).split(" ");
			int A = Integer.parseInt(str[0]);
			int B = Integer.parseInt(str[1]);
			int m = (int)Math.log10(A);
			int count = 0;
			for(int j = A; j <= B; j++){
				Set<Integer> set = new HashSet<Integer>();
				for(int k = 1; k <= m; k++){
					int mod = (int)Math.pow(10, k);
					int lod = (int)Math.pow(10, m - k + 1);
					int r = j % mod;
					int l = j / mod;
					int trans = r * lod + l;
					if(A <= trans && trans <= B && trans != j){
						if(set.add(trans))
							count++;
					}
				}
			}
			out.println("Case #" + (i+1) + ": " + count/2);
		}
		//long end = System.currentTimeMillis();
		//System.out.println(end - start);
		out.close();
	}
	

}
