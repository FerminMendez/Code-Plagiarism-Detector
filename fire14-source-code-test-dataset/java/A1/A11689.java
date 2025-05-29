package codejam.network172.com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CodeJam {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/home/harry/Downloads/cj.in")));
			PrintWriter out = new PrintWriter(new FileWriter("/home/harry/Downloads/cj.out"));
			jam(in, out);
			out.close();
		} catch (Exception e) {
			System.out.print("Exception thrown: " + e.toString());
		}
	}
	
	private static void jam(BufferedReader in, PrintWriter out) throws NumberFormatException, IOException {
		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			solveCase(i, in, out);
		}
	}
	
	private static void solveCase(int i, BufferedReader in, PrintWriter out) throws NumberFormatException, IOException {
		String[] inStrs = in.readLine().split(" ");
		int googlers = Integer.parseInt(inStrs[0]);
		int surprises = Integer.parseInt(inStrs[1]);
		int p = Integer.parseInt(inStrs[2]);
		int max = 0;
		for (int j = 0; j < googlers; j++) {
			int points = Integer.parseInt(inStrs[j+3]);
			int high = points/3;
			if (3*high < points)
				high++;
			if (high >= p)
				max++;
			else if (((high+1) >= p) && (3*high <= (points+1)) && (points >= 2) && (surprises > 0)) {
				max++;
				surprises--;
			}
		}
		out.printf("Case #%d: %d\n", i+1, max);
	}
}
