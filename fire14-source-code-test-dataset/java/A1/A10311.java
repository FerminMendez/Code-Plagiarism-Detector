package com.eduardcapell.gcj2012.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Vector;

public class B {

	public static void main(String[] args) throws Exception {
		B a = new B();
		a.run();
	}

	
	public void run() throws Exception {
		String fileName = "/Users/edu/Dropbox/google_code_jam/2012/B-small-attempt0.in";
		File f = new File(fileName);
		List<String> rows = getLines(f);
		
		for (int i=1; i < rows.size(); i++) {
			String line = rows.get(i);
			int result = processLine(line);
			print("Case #" + i + ": " + result);
		}
	}
	
	private int processLine(String line) {
		String[] values = line.split(" ");
		int n = Integer.parseInt(values[0]);
		int surprising = Integer.parseInt(values[1]);
		int p = Integer.parseInt(values[2]);
		
		int[] scores = new int[n];
		for (int i=0; i < n; i++) {
			scores[i] = Integer.parseInt(values[i + 3]);
		}

		int could = 0;
		int mustBeSurprising = 0;
		
		for (int i=0; i < scores.length; i++) {
			int score = scores[i];
			if (score < p) {
				continue;
			}
			int exact = p * 3;
			int diff = score - exact;
			if (diff >= 0) {
				could++;
			} else if (diff >= -2) {
				could++;
			} else if (diff >= -4) {
				mustBeSurprising++;
				could++;
			}
		}
		
		if (mustBeSurprising < surprising) {
			// Set as surprising the cases that originally were not flagged as such.
			mustBeSurprising = surprising;
		}
		could = could - (mustBeSurprising - surprising);
		
		return could;
	}


	private void print(Object o) {
		System.out.println(o);
	}


	public List<String> getLines(File f) throws Exception {
		List<String> lines = new Vector<String>();
		
		BufferedReader in = new BufferedReader(new FileReader(f));
		String line = null;
		while ((line = in.readLine()) != null) {
			lines.add(line);
		}
		
		return lines;
	}
}
