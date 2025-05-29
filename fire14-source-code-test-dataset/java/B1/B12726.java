package com.develog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C {
	final int A = 0;
	final int B = 1;
	
	BufferedReader reader;
	BufferedWriter writer;
	String buf;
	String numStr[];
	
	public C() throws IOException{
		reader = new BufferedReader(new FileReader("C-small-attempt0.in"));
		writer = new BufferedWriter(new FileWriter("output.txt"));
		
		reader.readLine(); // # of case
		int cnt;
		
		for(int n=1; (buf = reader.readLine()) != null;	n++){
			numStr = getToken(buf);
			cnt = solve(numStr);
//			System.out.println(cnt);
			writer.write(String.format("Case #%d: %d\n", n, cnt));
		}
		reader.close();
		writer.close();
	}
	
	public String[] getToken(String sentence){
		String ret[] = new String[2];
		StringTokenizer token = new StringTokenizer(sentence, " \t");
		int i=0;
		while(token.hasMoreTokens()){
			ret[i++] = token.nextToken();
		}
		return ret;
	}
	
	public int solve(String str[]){
		long num[] = new long[2];
		long m;
		int cnt=0;
		ArrayList<Long> arNum;
		num[A] = Integer.parseInt(str[A]);
		num[B] = Integer.parseInt(str[B]);
		
		for(long a=num[A], b=num[B]; a<=b; a++){
			StringBuilder builder = new StringBuilder(String.valueOf(a));
			int len = builder.length();
			arNum = new ArrayList<Long>();
			for(int i=0; i<len-1; i++){
				builder.append(builder.charAt(0));
				builder.delete(0, 1);
				m = Long.parseLong(builder.toString());
				if(!arNum.contains(m) && a < m && m <= b){
					cnt++;
					arNum.add(m);
				}
			}
			
//			for(long v : arNum){
//				arNum.remove(v);
//			}
		}
		return cnt;
	}
}
