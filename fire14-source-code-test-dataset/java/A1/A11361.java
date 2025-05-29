/**
 * Written By Kylin
 * Last modified: 2012-4-15
 * State: Pending
 */
package me.kylin.gcj.c2012Q;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DancingWithTheGooglers {

	String file;

	Scanner sc;

	PrintWriter pr;

	int caseNO;

	boolean showDebug;

	void out(Object str) {
		str = "Case #" + caseNO + ": " + str;
		System.out.println(str);
		if (pr != null)
			pr.println(str);
	}

	void outNoPre(Object str) {
		System.out.println(str);
		if (pr != null)
			pr.println(str);
	}

	void debug(Object str) {
		if (showDebug)
			System.out.printf("DEBUG - Case #%d: %s\n", caseNO, str);
	}

	void work() {
		if (file != null) {
			try {
				sc = new Scanner(new FileInputStream(new File(file + ".in")));
				pr = new PrintWriter(new File(file + ".out"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.exit(1);
			}
		} else {
			sc = new Scanner(System.in);
		}
		int tc = sc.nextInt();
		sc.nextLine();
		for (caseNO = 1; caseNO <= tc; caseNO++) {
			solveACase();
			if (pr != null)
				pr.flush();
		}
		if (pr != null)
			pr.close();
	}

	static String generateFilename(String x, int scale, int t) {
		String fn = x.toUpperCase();
		if (scale == 0)
			return "sample";
		if (scale == 1)
			fn += "-small";
		if (scale == 2)
			fn += "-large";
		if (t < 0)
			return fn + "-practice";
		if (t > 0) {
			if (scale == 1)
				fn += "-attempt" + (t - 1);
			return fn;
		}
		return fn;
	}

	public static void main(String[] args) {
		DancingWithTheGooglers cls = new DancingWithTheGooglers();
		String base = "data/2012Q/";
		cls.file = base + generateFilename("B", 1, 1);
		cls.showDebug = true;
		cls.work();
	}

	void solveACase() {
		int n = sc.nextInt();
		int s = sc.nextInt();
		int p = sc.nextInt();
		int max = 0;
		int n_least = 3 * p - 2;
		int s_least = n_least - 2;
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			if (t >= n_least) { 
				max += 1;
			}
			else if (p >= 2 && t >= s_least && s > 0){
				max += 1;
				s -= 1;
			}
		}
		out(max);
	}
}
