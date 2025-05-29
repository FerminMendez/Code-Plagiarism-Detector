package com.techy.rajeev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Recycled {
	public static int[] toIntArray(String line){
		String[] p = line.trim().split("\\s+");
		int[] out = new int[p.length];
		for(int i=0;i<out.length;i++) out[i] = Integer.valueOf(p[i]);
		return out;
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new FileReader("techyrajeev.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("myoutput.out"));
		int num=Integer.valueOf(br.readLine().trim());
		int k=1,count=0;
		while(num>0){
			int arr[]=toIntArray(br.readLine());
			int x=arr[0];
			int y=arr[1];
			String past="";
			for(int i=x;i<=y;i++){
				String temp=i+"";
				for(int j=temp.length()-1,m=1;j>0;j--,m++){
				String test=temp.substring(m)+temp.substring(0,m);
				if(test.equals(past)){
					break;
				}
				int lk=Integer.parseInt(test);
				if(lk>i&&lk<=y){
					count++;
					past=test;
				}
				}
			}
			bw.write("Case #"+k+": "+count);
			bw.newLine();
			count=0;
			num--;
			k++;
		}
		br.close();
		bw.close();
		
	}

}
