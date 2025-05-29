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

public class RecycledNumbers {

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
		RecycledNumbers cls = new RecycledNumbers();
		String base = "data/2012Q/";
		cls.file = base + generateFilename("C", 1, 1);
		cls.showDebug = true;
		cls.work();
	}
	
	final static int[] P10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000}; 
	
	int leftShift(byte[] nArr) {
		byte t = nArr[0];
		for (int i = 1; i < nArr.length; i++) {
			nArr[i - 1] = nArr[i];
		}
		nArr[nArr.length - 1] = t;
		int m = 0;
		for (int i = 0; i < nArr.length; i++) {
			m = m * 10 + nArr[i];
		}
		return m;
	}
	
	void solveACase() {
		int min = sc.nextInt();
		int max = sc.nextInt();
		int num = 0;
		for (int n = min; n < max; n++) {
			int k = 0;
			while (n >= P10[k]) k++;
			byte[] nArr = new byte[k];
			int t = n;
			while (t > 0) {
				nArr[--k] = (byte)(t % 10);
				t /= 10;
			}
			int m = leftShift(nArr);
			while (m != n) {
				if (m > n && m >= min && m <= max) num++;
				m = leftShift(nArr);
			}
		}
		out(num);
	}
}