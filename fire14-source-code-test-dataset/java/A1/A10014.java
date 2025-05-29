package com.codejam.solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class GoogleDance {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader=new BufferedReader(new FileReader(new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"input.txt")));
		PrintWriter output=new PrintWriter(new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"output.txt"));
		int cases=Integer.parseInt(reader.readLine());
		for(int i=0;i<cases;i++){
			output.print("Case #"+(i+1)+": ");
			String[] params=reader.readLine().split("\\s");
			int N=Integer.parseInt(params[0]);
			int S=Integer.parseInt(params[1]);
			int p=Integer.parseInt(params[2]);
			int[] totals=new int[N];
			for(int j=0;j<N;j++){
				totals[j]=Integer.parseInt(params[j+3]);
			}
			Arrays.sort(totals);
			int found=0;
			int track=0;
			int qualified=0;
			while(found<S && track<N){
				if(totals[track]>0){
					if(totals[track]%3==2){
						if((totals[track]/3)+2>=p){
							qualified++;
							found++;
						}
					}else if(totals[track]%3==0){
						if((totals[track]/3)+1>=p){
							qualified++;
							found++;
						}
					}else{
						if(totals[track]/3+1>=p){
							qualified++;
						}
					}
				}
				else{
					if(p==0){
						qualified++;
					}else{
						if(totals[track]%3==1){
							if(totals[track]/3+1>=p){
								qualified++;
							}
						}
					}
				}
				track++;
			}
			while(track<N){
				if(totals[track]>0){
					if(totals[track]%3>=1){
						if(totals[track]/3+1>=p){
							qualified++;
							track++;
							break;
						}
					}else{
						if(totals[track]/3>=p){
							qualified++;
							track++;
							break;
						}
					}
				}else{
					if(p==0){
						qualified++;
						track++;
						break;
					}
				}
				track++;
			}
			if(track<N){
				qualified+=N-track;
			}
			output.print(qualified);
			output.println();
		}
		output.close();
		reader.close();
	}
}