package com.codejam.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class RecycledNumbers {
	public static void main(String[] args) {
		File inputFile = new File("C:/Users/SNALLAMA/Desktop/C-small-attempt0.in");
		File outputFile = new File("C:/Users/SNALLAMA/Desktop/C-small-attempt0.out");
		String line = null;
		int t, a, b, noOfDigits, divider, localnumber;
		Set<String> finalOP = new HashSet<String>();	//Set to avoid duplicates	
		
		try {
			BufferedReader bReader =  new BufferedReader(new FileReader(inputFile));
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(outputFile));
			try {
				t = Integer.parseInt(bReader.readLine().trim());
				for(int index=0;index<t;index++) {
					line = bReader.readLine().trim();
					StringTokenizer st = new StringTokenizer(line, " ");
					a=Integer.parseInt(st.nextElement().toString());
					b=Integer.parseInt(st.nextElement().toString());
					noOfDigits=String.valueOf(a).length();
					finalOP=new HashSet<String>(); 
					if(noOfDigits!=1){						
						for(int i=a;i<=b;i++){
							for(int localIndex=1;localIndex<noOfDigits;localIndex++){
								divider=Integer.parseInt(String.valueOf((int)Math.pow(10, localIndex)));
								localnumber=Integer.parseInt(String.valueOf(i%divider)+String.valueOf(i/divider));
								if((String.valueOf(localnumber).length()==String.valueOf(i).length())&&(a<=i)&&(i<localnumber)&&(localnumber<=b)){
									if(!finalOP.contains(localnumber+" "+i))
										finalOP.add(i+" "+localnumber);							
								}
							}
						}
					}
					
					bWriter.write("Case #"+(index+1)+": "+finalOP.size());
					bWriter.write("\n");					
				}
			} catch(Exception e) {
				System.out.println("Exception Message: "+ e.getMessage());
				e.printStackTrace();
			}finally{
				bReader.close();
				bWriter.close();
			}
			
		} catch(Exception e) {
			System.out.println("Exception Message: "+ e.getMessage());
			e.printStackTrace();
		} 				
	}

}
