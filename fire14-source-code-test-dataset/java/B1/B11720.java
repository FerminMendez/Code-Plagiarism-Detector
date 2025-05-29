package codejam.network172.com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

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
		int a = Integer.parseInt(inStrs[0]);
		int b = Integer.parseInt(inStrs[1]);
		int cnt = 0;
		LinkedList<Integer> seen = new LinkedList<Integer>();
		for (int j = a; j < b; j++) {
			String n = Integer.toString(j);
			seen.clear();
			for (int k = 1; k < n.length(); k++) {
				int r = Integer.parseInt(n.substring(k) + n.substring(0, k));
				if ((r > j) && (r <= b) && !seen.contains(r)) {
					seen.add(r);
					cnt++;
				}
			}
		}
		out.printf("Case #%d: %d\n", i+1, cnt);
	}
}
