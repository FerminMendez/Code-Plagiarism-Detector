package google.codejam.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {

		BufferedReader f = null;
		PrintWriter out = null;
		try {
			f = new BufferedReader(new FileReader("in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			// SOLUTION STARTS HERE

			int count = new Integer(f.readLine());
			for (int i = 1; i <= count; i++) {
				long sum = 0L;
				String[] in = f.readLine().split(" ");
				int from = new Integer(in[0]);
				int to = new Integer(in[1]);

				for (int num = from; num <= to; num++) {
					String toStr = new Integer(to).toString();
					String numStr = new Integer(num).toString();
					sum += getSum(numStr, toStr);

				}

				out.write("Case #" + i + ": " + sum + "\n");
				System.out.println("Case #" + i + ": " + sum);

			}

			// SOLUTION ENDS HERE

			out.flush();
			out.close();
			f.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static long getSum(String numStr, String toStr) {
		String conn = "";
		conn = numStr + numStr;
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < numStr.length(); i++) {
			String cand = conn.substring(i, i + numStr.length());
			if(cand.compareTo(numStr) > 0 && cand.compareTo(toStr) <= 0)
				set.add(cand);
		}
		
		return set.size();
	}

}
