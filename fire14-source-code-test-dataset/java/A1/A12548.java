package com.ignaciobona.codejam.practice.problema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solver {
	
	public static String PROBLEM_NUMBER="B";

	public static String PATH_TO_INPUT_FILE_SMALL="inputs/"+PROBLEM_NUMBER+"-small-attempt0.in";
	public static String PATH_TO_OUPUT_FILE_SMALL="outputs/"+PROBLEM_NUMBER+"-small-attempt0.out";
	

	public static String PATH_TO_INPUT_FILE_LARGE="inputs/"+PROBLEM_NUMBER+"-large-attempt0.in";
	public static String PATH_TO_OUPUT_FILE_LARGE="outputs/"+PROBLEM_NUMBER+"-large-attempt0.out";

	public static boolean SMALL=true;

	
	public static class Problem{
		public int nCase;
		public int nGooglers;
		public int nSurprising;
		public int desiredScore;
		public int[]scores;
		public StringBuffer outputString;
		
		
		public void solve(){
			
			outputString=new StringBuffer("Case #"+nCase+": ");
			int nSurprisingLeft=nSurprising;
			int nResult=0;
			for(int score:scores){
				boolean surprisingFound=false;
				boolean normalFound=false;
				for(int i=10;i>=0;i--){
					int score1=i;
					int score2=i;
					int score3=i;
					
					int aux=score-i;
					if(aux>=0){
						if(aux%2==0){
							score2=aux/2;
							score3=score2;
						}else{
							score2=aux/2;
							score3=score2+1;
						}
						if(score1>=desiredScore||score2>=desiredScore||score3>=desiredScore){
							if( (Math.abs(score1-score2))<2 && (Math.abs(score1-score3)) <2 ){
								//System.out.println("Posible score for "+score+" is ("+score1+","+score2+","+score3 +")");
								normalFound=true;
							}else if( (Math.abs(score1-score2))<=2 && (Math.abs(score1-score3)) <=2 ){
								//System.out.println("Posible surprising score for "+score+" is ("+score1+","+score2+","+score3 +")");
								surprisingFound=true;
							}
						}
					}
					
				}
				if(normalFound){
					nResult++;
				}else if(surprisingFound&&nSurprisingLeft>0){
					nSurprisingLeft--;
					nResult++;
				}
				
			}
			outputString.append(nResult);
			
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
							problem.nGooglers=Integer.parseInt(tokens[0]);
							problem.nSurprising=Integer.parseInt(tokens[1]);
							problem.desiredScore=Integer.parseInt(tokens[2]);
							problem.scores=new int[problem.nGooglers];
							for(int j=0,z=3;j<problem.nGooglers;j++,z++){
								problem.scores[j]=Integer.parseInt(tokens[z]);
							}
							
							
							
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


