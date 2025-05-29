package com.techy.rajeev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DancingGame2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("techyrajeev.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("myoutput.out"));
		int num=Integer.valueOf(in.readLine().trim());
		int count = 0, l = 1;
		while (num > 0) {
			int arrtemp[]=toIntArray(in.readLine());
			int N = arrtemp[0];
			int S = arrtemp[1];
			int p=arrtemp[2];
			for(int i=3;i<arrtemp.length;i++){
				int base=arrtemp[i]/3;
				switch(arrtemp[i]%3){
				case 0:{
						if(base>=p){
							count++;
						}else{
							if(S>0 && base>0 && base+1>=p){
								count++;
								S--;
							}
						}
					}break;
				case 1:{
					if(base>=p || base+1>=p){
						count++;
					}else{
						if(S>0 && base+1>=p){
							count++;
							S--;
						}
					}
				}break;
				case 2:{
					if(base+1>=p || base>=p){
						count++;
					}else{
						if(S>0 && base+2>=p){
							count++;
							S--;
						}
					}
				}break;
				}
			}
			num--;
			System.out.println("Case #"+l+": "+count);
			bw.write("Case #"+l+": "+count);
			bw.newLine();
			count=0;
			l++;
		}
		in.close();
		bw.close();
	}
	public static int[] toIntArray(String line){
		String[] p = line.trim().split("\\s+");
		int[] out = new int[p.length];
		for(int i=0;i<out.length;i++) out[i] = Integer.valueOf(p[i]);
		return out;
	}


}
