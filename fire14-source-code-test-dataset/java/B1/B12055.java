package com.google.codejam2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class CRecycledNumbers {
	private void go() throws IOException {
		String fileIn = "resources/codejam2012/C-small-attempt0.in";
		String fileOut = fileIn.replace(".in", ".out");
		
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOut))); 
		
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn)));
		int count = Integer.parseInt(r.readLine());
		for(int i = 0; i < count; i++) {
			String out = processCase(r.readLine());
			out = "Case #" + (i + 1) + ": " + out;
			System.out.println(out);
			w.write(out + "\n");
		}		

		w.close();
		r.close();
	}
	

	private Set<Integer> getRecycled(int n) {
		Set<Integer> recycled = new HashSet<Integer>();
		
		String sn = String.valueOf(n);

		for(int i = 1; i < sn.length(); i++) {
			String newN = sn.substring(i) + sn.substring(0, i);
			if (!newN.startsWith("0") && !newN.equals(sn)) {
				recycled.add(Integer.parseInt(newN));
			}
		}
		
		return recycled;
	}
	
	private String processCase(String text) {
		Scanner scanner = new Scanner(text);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		int out = 0;
		
		for(int i = a; i < b; i++) {
			Set<Integer> recycled = getRecycled(i);
			for(Integer rec : recycled) {
				int r = rec;
				if ((r >i) && (r <= b)) out++;
			}
		}
		
		return String.valueOf(out);
	}



	public static void main(String[] args) throws Exception {
		long now = System.currentTimeMillis();
		new CRecycledNumbers().go();
		System.out.println(String.valueOf(System.currentTimeMillis() - now) + "ms");
	}
}