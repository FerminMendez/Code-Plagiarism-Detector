package year2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class q2 {
	
	public static void main(String[] args) throws Exception {		
		q2 a = new q2();
		a.go();
	}
	
	
	
	int solve(int N, int S, int p, List<Integer>scores) {
		int result = 0;
		int fit = 0;
		int maybefit = 0;
		
		for(int score:scores) {
			if(score >= p) {
				if(score + 2 >= 3*p)
					fit++;
				else if(score + 4 >= 3*p)
					maybefit++;
			}
		}
		if(S < maybefit)
			maybefit = S;
		
		result = fit + maybefit;
		
		return result;
	}
	
	public void go() throws FileNotFoundException {
		Scanner in = new Scanner(new File("inout\\B-small-attempt0.in"));
		PrintWriter out = new PrintWriter("inout\\B-small-attempt0.out");
		int numTests = in.nextInt();
		//in.nextLine();	//eat end line
		
		for(int i=0;i<numTests;i++) {	
			in.nextLine();	//eat end line
			
			int N = in.nextInt();
			int S= in.nextInt();
			int p = in.nextInt();
			
			List<Integer> scores = new ArrayList<Integer>();
			for(int j=0;j<N;j++)
				scores.add(in.nextInt());
			
			
			int result = solve(N, S, p, scores);
			out.println("Case #" + (i+1) + ": " + result);
			System.out.println("Case #" + (i+1) + ": " + result);
		}		
//		System.out.println("Done.");
		in.close();
		out.close();
	}
	

}
