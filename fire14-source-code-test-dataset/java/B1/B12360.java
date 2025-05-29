package codejam.qualification;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("input.txt"));
		FileWriter out = new FileWriter("output.txt");
		
		// ignore test cases
		in.nextLine();
		
		int count = 1;
		while (in.hasNext()) {
			out.write("Case #" + count++ + ": " + calc(in.nextLong(), in.nextLong()) + "\n");
		}
		
		out.flush();
		out.close();
		in.close();
	}
	
	public static long calc(long A, long B) {
		long count = 0;
		
		for (long n=A; n<B; n++) {
			String sNum = Long.toString(n);
			
			for (int x=1; x<sNum.length(); x++) {
				String sCan = sNum.substring(sNum.length() - x) + sNum.substring(0, sNum.length() - x);
				long m = Long.parseLong(sCan);
				
				if (A <= n && n < m && m <= B) {
					System.out.println(n + " " + sCan + " " + sNum.substring(sNum.length() - x));
					count++;
				}
			}
		}
		
		return count;
	}
}
