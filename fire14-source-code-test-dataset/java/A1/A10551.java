package com.gao.t2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String args[]){
		try{
			FileInputStream fin=new FileInputStream("C:\\Users\\Gao\\Downloads\\B-small-attempt4.in");
			BufferedReader br=new BufferedReader(new InputStreamReader(fin));
			FileOutputStream fout=new FileOutputStream("out.txt");
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fout));
			int n=Integer.parseInt(br.readLine());
			for(int i=0;i<n;i++){
				int N,S,P;
				int t[];
				String []s=br.readLine().split(" ");
				N=Integer.parseInt(s[0]);
				S=Integer.parseInt(s[1]);
				P=Integer.parseInt(s[2]);
				t=new int[N];
				for(int j=0;j<N;j++){
					t[j]=Integer.parseInt(s[3+j]);
				}
				Arrays.sort(t);
				int k=0;
				int r=0;
				for(int j=0;j<t.length;j++){
					int b;
					b=t[j]/3;
					int xRe=t[j]%3;
					if(k<S&&t[j]>=2){
						if(xRe<=1){
							if(b+1<=10&&b+1>=P){
								k++;
								r++;
							}
						} else if(xRe==2){
							if(b+2<=10&&b+2>=P){
								k++;
								r++;
							}
						}
					}else {
						if(xRe>=1&&b<=9){
							b++;
						}
						if(b>=P){
							r++;
						}
					}
				}
				String str="Case #"+(i+1)+": "+r;
				bw.write(str);
				if(i<n-1){bw.newLine();}
			}			
			br.close();
			bw.close();
			fin.close();
			fout.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
