package com.silverduner.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Dancing {
	public static void main(String[] args) throws Exception {
		File input = new File("B-small-attempt0.in");
		BufferedReader in = new BufferedReader(new FileReader(input));

		File output = new File("1.out");
		BufferedWriter out = new BufferedWriter(new FileWriter(output));

		// parse input
		int N = Integer.parseInt(in.readLine());
		for(int i=0;i<N;i++) {
			String str = in.readLine();
			out.write("Case #"+(i+1)+": ");
			System.out.println("-------");
			String[] words = str.split(" ");
			int n = Integer.parseInt(words[0]);
			int suprise = Integer.parseInt(words[1]);
			int threshold = Integer.parseInt(words[2]);
			int[] scores = new int[n];
			for(int j=0;j<n;j++) {
				scores[j] = Integer.parseInt(words[3+j]);
			}
			int count = 0;
			for(int score : scores) {
				int a,b,c;
				boolean find = false;
				boolean sfind = false;
				for(a = 10; a>=0 && !find; a--) {
					if(3*a-4>score)
						continue;
					for(b = a; b>=0 && b >=a-2 && !find; b--) {
						for(c = b; c>=0 && c >=b-2 && c >=a-2 && !find; c--) {
							System.out.println(a+","+b+","+c);
							if(a+b+c==score) {
								if(a >= threshold) {
									if(a-c <= 1){
										count++;
										find = true;
										System.out.println("find!");
									}
									else if(a-c == 2){
										sfind = true;
										System.out.println("suprise!");
									}
								}
							}
							
						}
					}
				}
				if(!find && sfind && suprise > 0)
				{
					count++;
					suprise --;
				}
			}
			int maxCount = count;
			out.write(maxCount+"\n");
		}
		out.flush();
		out.close();
		in.close();
	}
}
