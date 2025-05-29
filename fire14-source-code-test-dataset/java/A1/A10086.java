package codeJam2012_Qualification;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DancingWithTheGooglers {
	private String FILE_NAME = "2012_QB_dancing_B-small-attempt0";
	
	private int solve(String input) {
		Scanner sc = new Scanner(input);
		
		int googlers = sc.nextInt();
		int surprising = sc.nextInt();
		int best = sc.nextInt();
		
		int ok = 0;
		int surprises = 0;
		
		for (int i=0;i<googlers;i++) {
			int points = sc.nextInt();
			
			if (points<=30) {
				if (points>=best+Math.max(0, 2*(best-1)))
					ok++;
				else if (points>=best+Math.max(0,2*(best-2)))
					surprises++;
			}
		}
		
		return ok+(Math.min(surprises,surprising));
	}
	
	public void run() throws IOException {
		Scanner sc = new Scanner(new FileReader(FILE_NAME+".in"));
		PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME+".out"));
		
		int cases = Integer.valueOf(sc.nextLine());
		for (int i=1;i<=cases;i++) {
			String input = sc.nextLine();
			System.out.println("Input #"+i+": "+input);

			String output = "Case #"+i+": "+solve(input);
			pw.println(output);
			System.out.println(output);
		}
		
		pw.flush();
		pw.close();
		sc.close();
	}
	public static void main(String[] args) throws IOException {
		new DancingWithTheGooglers().run();
	}
}
