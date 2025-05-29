package codejam2012;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QualB {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream(new File("/home/rush/sample-in.txt")));
		PrintWriter out = new PrintWriter(new FileOutputStream("/home/rush/sample-out.txt"));
		
//		Scanner in = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		
		for (int i = 0; i < t; i++) {
			int total = 0;
			
			int s = in.nextInt();
			int e = in.nextInt();
			for (int j = s; j <= e; j++) {
				String num = j + "";
				Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
				for (int k = 1; k < num.length(); k++) {
					String pre = num.substring(0, k);
					String post = num.substring(k);
					String tnum = post + pre;
					int tn = Integer.parseInt(tnum);
					if (j < tn && tn <= e && !map.containsKey(tn)) {
						total++;
						map.put(tn, true);
					}
				}
			}
			
			out.printf("Case #%d: %d", (i+1), total);
			out.println();
		}
		out.flush();
	}
}
