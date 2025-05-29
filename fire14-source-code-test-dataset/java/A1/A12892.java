package Qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class B {
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Users\\braidon\\Desktop\\CodeJam\\D-large.in")));
		//FileWriter out = new FileWriter(new File("C:\\Users\\braidon\\Desktop\\CodeJam\\D-large.out"));
		BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Users\\braidon\\Desktop\\CodeJam\\B-small.in")));
		FileWriter out = new FileWriter(new File("C:\\Users\\braidon\\Desktop\\CodeJam\\B-small.out"));
		
		int N = new Integer(in.readLine());
		
		for(int c = 1; c <= N; c++){
			int resp = 0;
			String[] sin = in.readLine().split(" ");
			int n = Integer.parseInt(sin[0]);
			int s = Integer.parseInt(sin[1]);
			int p = Integer.parseInt(sin[2]);
			int[] t = new int[n];
			int[] m = new int[n];
			for(int c1 = 3; c1 <= sin.length-1; c1++){
				t[c1-3] = Integer.parseInt(sin[c1]);
			}
			Arrays.sort(t);
			for(int c1 = 3; c1 <= sin.length-1; c1++){
				int ti = t[c1-3];
				m[c1-3] = 0;
				if(ti != 0){
					if(s > 0){
						int a1 = ti/3;
						int a2 = 0;
						if(a1 + 2 <= 10){
							a2 = a1 + 2;
						}else{
							a2 = 10;
							a1 = 8;
						}
						if((a1+a2+a1 == ti)||
								(a1+a2+a2 == ti)||
								(a1+a2+a2-1 == ti)){
							m[c1-3] = a2;
							if(a2 < p){
								m[c1-3] = 0;
							}else{
								s -= 1;
							}
						}
						if(m[c1-3] == 0){
							a1 -= 1;
							a2 = a1 + 2;
							if((a1+a2+a1 == ti)||
									(a1+a2+a2 == ti)||
									(a1+a2+a2-1 == ti)){
								m[c1-3] = a2;
								if(a2 < p){
									m[c1-3] = 0;
								}else{
									s -= 1;
								}
							}
						}
					}
					if(m[c1-3] == 0){
						int a1 = ti/3;
						if(ti%3 == 0){
							m[c1-3] = a1;
						}
						else{
							m[c1-3] = a1+1;
						}
					}
				}
				if(m[c1-3] >= p){
					resp += 1;
				}
			}
			out.write("Case #" + c + ": " + resp + "\n");
		}
		out.flush();
		out.close();
	}
	static void inverter(int[] b){
		int left = 0;
	    int right = b.length-1;
	  
	    while (left < right) {
	      int temp = b[left]; 
	      b[left]  = b[right]; 
	      b[right] = temp;
	     
	      left++;
	      right--;
	    }
	}
}
