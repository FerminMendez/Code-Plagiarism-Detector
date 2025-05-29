package com.silverduner.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class RecycledNumbers {
	public static boolean isRecycledPair(int n, int m) {
		int digits = 1 + (int)Math.floor(Math.log10(n));
		int t = n;
		for(int i=1;i<=digits;i++) {
			
			t =  ((t%10)*(int)Math.pow(10,digits-1) + (t/10));
			if(t==m)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		File input = new File("C-small-attempt0.in");
		BufferedReader in = new BufferedReader(new FileReader(input));

		File output = new File("1.out");
		BufferedWriter out = new BufferedWriter(new FileWriter(output));

		// parse input
		int N = Integer.parseInt(in.readLine());
		for(int i=0;i<N;i++) {
			String str = in.readLine();
			out.write("Case #"+(i+1)+": ");
			String[] words = str.split(" ");
			int A = Integer.parseInt(words[0]);
			int B = Integer.parseInt(words[1]);
			int count = 0;
			for(int n=A; n<B; n++) {
				for(int m=n+1;m<=B;m++) {
					if(isRecycledPair(n,m)){
//						System.out.println(n+","+m);
						count++;			
					}
				}
			}
//			System.out.println();
			out.write(count+"\n");
		}
		out.flush();
		out.close();
		in.close();
	}
}
