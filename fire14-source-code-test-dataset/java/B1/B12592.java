package googlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Mainclass {
	String line[];
	int bv=1;
	Mainclass(){
		line=new String[50];
		FileInputStream fstream;
		DataInputStream in;
		BufferedReader br;
		try{
			fstream = new FileInputStream("in.txt");
			in = new DataInputStream(fstream);
			br = new BufferedReader(new InputStreamReader(in));
			int x=Integer.parseInt(br.readLine());
			for(int z=0;z<x;z++){
				line[z]=br.readLine();
				tranform(line[z]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void tranform(String string) {
		String A[];
		int count=0;
		int z=0;
		A=string.split(" ");
		int a=Integer.parseInt(A[0]);
		int b=Integer.parseInt(A[1]);
		//System.out.println(a+ " " +b);
		int len=new Integer(a).toString().length();
		for(int x=a;x<=b;x++){
			String test=new String(x+"");
			String temp=test;
			for(int y=0;y<len-1;y++){
				temp=temp.charAt(len-1)+temp.substring(0,len-1);
				int testn=Integer.parseInt(temp);
				//System.out.println(testn);
			
				if(testn==x)continue;
				if(testn<a||testn>b)
					continue;
				z++;
			}
				
				
			}
		
		System.out.println(z/2);
		String output=new String(z/2+"");
		try{
			File file = new File("out.txt");
			FileWriter fileWritter = new FileWriter(file.getName(),true);
	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(new String("Case #"+bv+": "+output+"\n"));
	        System.out.println("Case #"+bv+": "+output+"\n");
	        bv++;
	        bufferWritter.close();
	        

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String args[]){
		new Mainclass();
		
	}
	
}
