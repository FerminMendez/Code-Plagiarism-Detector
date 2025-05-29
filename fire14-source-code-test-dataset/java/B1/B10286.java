package Qualification;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ProblemC {

	// brute force approach
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String output = "./result.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(output));
		int T = in.nextInt();
		
		for (int caseNum = 1; caseNum <= T; caseNum++) {
			int A = in.nextInt();
			int B = in.nextInt();
			
			int count = 0;
			for (int m = A + 1; m <= B; m++) {
				for (int n = A; n < m; n++) {
					if (isRecycledPair(n + "", m + ""))
						count++;
				}
			}
			String toPrint = "Case #" + caseNum + ": " + count;
			System.out.println(toPrint);
			writer.write(toPrint + "\r\n");
		}
		writer.flush();
		writer.close();
	}
	
	private static boolean isRecycledPair(String n, String m) {
		int sizeDiff = Math.abs(n.length() - m.length());
		for (int i = 0; i < sizeDiff; i++) {
				n = "0" + n;
		}
		
		int size = n.length();
		if (n.equals(m))
			return true;
		for (int i = 1; i < size; i++) {
			n = n.substring(1, size) + n.charAt(0);
			if (n.equals(m))
				return true;
		}
		return false;
	}
}
