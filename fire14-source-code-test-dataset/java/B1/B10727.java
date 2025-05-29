package com.hingom.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RecycledNumbers {
	
	private boolean pairs(String sn, String sm) {
		char[] cn = sn.toCharArray();
		char[] cm = sm.toCharArray();
		char[] temp = new char[cm.length];
		
		for (int i = 0; i < cn.length; i++) {
			if (cn[0] == cm[i]) {
				int p = 0;
				for (int s = i; s < cn.length; s++) {
					temp[p++] = cm[s];
				}
				for (int s = 0; s < i; s++) {
					temp[p++] = cm[s];
				}
				if (sn.equals(new String(temp))) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void run() {
		File input = new File("resources/C-small-attempt0.in");
		File output = new File("resources/output");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader(input));
			writer = new BufferedWriter(new FileWriter(output));

			int testCases = Integer.parseInt(reader.readLine());
			
			StringBuilder o = new StringBuilder();
			
			for (int loop = 1; loop <= testCases; loop++) {
				String line = reader.readLine();
				String[] numbers = line.split(" ");
				
				int a = Integer.parseInt(numbers[0]);
				int b = Integer.parseInt(numbers[1]);
				
				int count = 0;
				o.delete(0, o.length());
				for (int n = a; n < b; n++) {
					for (int m = n + 1; m <= b; m++) {
						String sn = Integer.toString(n);
						String sm = Integer.toString(m);

						if (pairs(sn, sm)) {
							count++;
						}
					}
				}
				
				writer.write(String.format("Case #%d: %d", loop, count));
				writer.newLine();
			}
			
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { if (reader != null) reader.close(); } catch (Exception e) {}
			try { if (writer != null) writer.close(); } catch (Exception e) {}
		}
	}

	public static void main(String[] args) {
		RecycledNumbers recycledNumbers = new RecycledNumbers();
		recycledNumbers.run();
	}
}
