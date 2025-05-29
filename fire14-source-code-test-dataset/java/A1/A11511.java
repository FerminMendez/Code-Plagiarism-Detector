package Qualification;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProblemB {
	int good;
	int needsSuprise;
	int bad;
	int p;
	public ProblemB() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("out.txt")));
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		for(int i=1;i<=T;i++) {
			good = needsSuprise = bad = 0;
			StringTokenizer tokens = new StringTokenizer(scanner.nextLine());
			int numGooglers = Integer.parseInt(tokens.nextToken());
			int suprises = Integer.parseInt(tokens.nextToken());
			p = Integer.parseInt(tokens.nextToken());
			for(int j=0;j<numGooglers;j++) {
				int totalPoints = Integer.parseInt(tokens.nextToken());
				analyze(totalPoints);
			}
			
			int solution = good + Math.min(needsSuprise,suprises);
			System.out.println("Case #" + i + ": " + solution);
			out.write("Case #" + i + ": " + solution + "\n");
		}
		out.close();
	}
	
	public void analyze(int totalPoints) {
		int score = (totalPoints+1)/3;
		int diffScore = totalPoints - score*2;
		if(score>=p || diffScore>=p) {
			good++;
			return;
		}
		if(totalPoints>=2 && (score+1>=p || diffScore+1>=p)) {
			needsSuprise++;
			return;
		}
		bad++;
	}
	
	public static void main(String args[]) throws IOException {
		new ProblemB();
	}
}
