package com.gao.t3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	public static void main(String args[]){
		try{
			FileInputStream fin=new FileInputStream("C:\\Users\\Gao\\Downloads\\C-small-attempt0.in");
			//FileInputStream fin=new FileInputStream("cc.txt");
			BufferedReader br=new BufferedReader(new InputStreamReader(fin));
			FileOutputStream fout=new FileOutputStream("out.txt");
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fout));
			int n=Integer.parseInt(br.readLine());
			HashSet<String> hash=new HashSet<String>();
			for(int i=0;i<n;i++){
				int A,B;
				hash.clear();
				String s[]=br.readLine().split(" ");
				A=Integer.parseInt(s[0]);
				B=Integer.parseInt(s[1]);
				int j=A;
				for(;j<=B;j++){
					String strA=j+"";
					int m=strA.length();
					for(int k=0;k<m-1;k++){
						String end=strA.substring(m-1-k,m);
						if(end.startsWith("0")) continue;
						String start=strA.substring(0,m-1-k);
						String strB=end+start;
						if(strA.compareTo(strB)<0&&strA.compareTo(A+"")>=0&&strB.compareTo(B+"")<=0){
							hash.add(strA+" "+strB);
						}
					}
				}
				String str="Case #"+(i+1)+": "+hash.size();
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
