package com.niall.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class ProbC {
	
	String english, goglish;
	
	public ProbC(){
	}
	
	public int solve(int a, int b){
		int count = 0;
		HashSet<Integer> set;
		for(int n = a; n<= b; n++){
			String x = n + "";
			set = new HashSet<Integer>();
			for(int j = 0; j < x.length() - 1; j++){
				x = push(x);
				int m = Integer.parseInt(x);
				if(n < m && m <=b ){
					set.add(m);
				}
			}
			count += set.size();
		}
		return count;
		
	}

	public String push(String x){
		return x.substring(1) + x.charAt(0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String infile = "probCin";
		String outfile = "probCans";
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(infile)));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(outfile)));
			ProbC p1 = new ProbC();
			
			br.readLine();
			int i = 1;
			String s;
			while((s=br.readLine())!= null){
				String[] ss = s.split(" ");
				int a = Integer.parseInt(ss[0]);
				int b = Integer.parseInt(ss[1]);
				bw.write("Case #" + i + ": " + p1.solve(a,b));
				bw.newLine();
				i++;
			}
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
