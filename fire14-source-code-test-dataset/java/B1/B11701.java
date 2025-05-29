package com.sokamura.gcj2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {
	public int solve(int n1, int n2) {
		int ans = 0;
		for(int i=n1; i<n2; ++i) {
			Set<Integer> list = generate(i);
			for(int n : list) {
				if(n <= n2){ ans++; }
			}
		}
		return ans;
	}
	
	private Set<Integer> generate(int n) {
		String s = String.valueOf(n);
		Set<Integer> list = new HashSet<Integer>();
		for(int i=1; i<s.length(); ++i) {
			int n2 = Integer.parseInt(s.substring(i) + s.substring(0, i));
			if(n < n2) {
				list.add(n2);
			}
		}
		return list;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		RecycledNumbers rn = new RecycledNumbers();
		try {
			FileReader fr = new FileReader("C-small-attempt1.in");
			BufferedReader br = new BufferedReader(fr);
			String lineNum;
			lineNum = br.readLine();
			for(int i=1; i<=Integer.parseInt(lineNum); ++i) {
				String line = br.readLine();
				String[] array = line.split(" ");
				int n1 = Integer.parseInt(array[0]);
				int n2 = Integer.parseInt(array[1]);
				System.out.println("Case #" + i + ": " + rn.solve(n1,n2));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
