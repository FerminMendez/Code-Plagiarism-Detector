/*
PROG: ProbB
2012 Google CodeJam Qualification Round
Problem B
*/

import java.io.*;
import java.util.*;

public class Prob1B{

	public static void main(String [] args) throws IOException {
		//long start = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("Prob1B.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Prob1B.txt")));
		int[] normal = {0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10};
		int[] suprising = {0,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10,10,10};
		int N = Integer.parseInt(f.readLine());
		for(int i = 0; i < N; i++){
			int countn = 0;
			int counts = 0;
			String[] input = (f.readLine()).split(" ");
			int M = Integer.parseInt(input[0]);
			int S = Integer.parseInt(input[1]);
			int P = Integer.parseInt(input[2]);
			for(int j = 0; j < M; j++){
				int x = Integer.parseInt(input[3+j]);
				//System.out.println(x + " " + normal[x] + " " + suprising[x]);
				if(normal[x] >= P)
					countn++;
				else if(suprising[x] >= P)
					counts++;
			}
			int ans = countn + Math.min(counts, S);
			out.println("Case #" + (i+1) + ": " + ans);
		}
		//long end = System.currentTimeMillis();
		//System.out.println(end - start);
		out.close();
	}
	

}
