package com.ignaciobona.codejam.practice.problema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solver {
	
	public static String PROBLEM_NUMBER="C";

	public static String PATH_TO_INPUT_FILE_SMALL="inputs/"+PROBLEM_NUMBER+"-small-attempt0.in";
	public static String PATH_TO_OUPUT_FILE_SMALL="outputs/"+PROBLEM_NUMBER+"-small-attempt0.out";
	

	public static String PATH_TO_INPUT_FILE_LARGE="inputs/"+PROBLEM_NUMBER+"-large.in";
	public static String PATH_TO_OUPUT_FILE_LARGE="outputs/"+PROBLEM_NUMBER+"-large.out";

	public static boolean SMALL=true;

	
	public static class Problem{
		public int nCase;
		public int a;
		public int b;
		public StringBuffer outputString;
		
		
		public void solve(){
			HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
			outputString=new StringBuffer("Case #"+nCase+": ");
			int found=0;
			for(int n=a;n<=b;n++){
				int nDigits=(n+"").length();
				int m=n;
				for(int j=1;j<nDigits;j++){
					int number=m%10;
					int rest=m/10;
					m=(int) (number*Math.pow(10, nDigits-1)+rest);
					
					if(a<=n&&n<m&&m<=b&&(map.get(n)==null||map.get(n)!=m)){
						//System.out.println(n+" "+m);
						map.put(n, m);
						found++;
					}
				}
				
			}
			outputString.append(found);
			
		}
	}
	
	//Boring IO handling
	public static void main(String[]args){
		try{
			String output=PATH_TO_OUPUT_FILE_LARGE;
			if(SMALL){
				output=PATH_TO_OUPUT_FILE_SMALL;
			}
			File file=new File(output);
			file.createNewFile();
			BufferedWriter bw=new BufferedWriter(new FileWriter(file));
			
		
			String input=PATH_TO_INPUT_FILE_LARGE;
			if(SMALL){
				input=PATH_TO_INPUT_FILE_SMALL;
			}
			FileInputStream fstream = new FileInputStream(input);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			

			String strLine;
			//Read File Line By Line
			int nCases=0;
			int nCase=1;	
			Problem problem=new Problem();
			for (int i=0;(strLine = br.readLine()) != null;i++)   {
				// Print the content on the console
				//System.out.println (strLine);
				if(i== 0){
						nCases=Integer.parseInt(strLine);
				}else{
					int nParam=(i-1)%1;
					switch(nParam){
						case 0:
							problem.nCase=nCase;
							
							
							String[]tokens=strLine.split(" ");
							problem.a=Integer.parseInt(tokens[0]);
							problem.b=Integer.parseInt(tokens[1]);
							
							
							problem.solve();
							System.out.println(problem.outputString);
							bw.append(problem.outputString);
							bw.newLine();
							problem=new Problem();
							nCase++;
							break;
						default:
							throw new Exception("Error Parsing");
					}
				}
			}
			//Close the input stream
			in.close();
			bw.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}



}


