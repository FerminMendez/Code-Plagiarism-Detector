package com.google.codejam.p3;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem3 {

	ArrayList<Point> cases = new ArrayList<Point>();

	public void loadInput() {
		try{
			FileInputStream fstream = new FileInputStream("input3.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = br.readLine(); //read number of lines
			while ((strLine = br.readLine()) != null) {
				String[] info = strLine.split(" ");
				int A = Integer.parseInt(info[0]);
				int B = Integer.parseInt(info[1]);
				cases.add(new Point(A,B));
			}
			in.close();
		}
		catch (Exception e) { }
	}
	
	public static boolean isRecycled(int a, int b) {

		String s1 = Integer.toString(a);
		String s2 = Integer.toString(b);
		for (int i=0; i<s1.length(); i++) {
			String tmpS = s2.substring(0, s2.length()-1); 
			char lastC = s2.charAt(s2.length()-1);
			s2 = lastC + tmpS;
			if (s2.equals(s1))
				return true;
		}
		return false;
	}
	
	public void getOutput() {
		for (int x=0; x<cases.size(); x++) {
			int A = cases.get(x).x;
			int B = cases.get(x).y;
			int total = 0;
			for (int i=A; i<B; i++) 
				for (int j=i+1; j<=B; j++)
					if (isRecycled(i, j))
						total++;
			System.out.println("Case #" + (x+1) + ": " + total);
		}
	}
	
	
	public static void main(String[] args) {
		Problem3 p = new Problem3();
		p.loadInput();
		p.getOutput();
	}

}
