package com.codejam.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Recycled {
	public static void main(String[] args) {
		//File read & write variables
		File inputFile = new File("C:/Users/SNALLAMA/Desktop/C-small-attempt1.in");
		File outputFile = new File("C:/Users/SNALLAMA/Desktop/C-small-attempt1.out");
		String line = null;
		int t, a, b, noOfDigits, divider, localnumber;
		//long outNumber=0;
		Set<String> finalOP = new HashSet<String>();		
		
		try {
			BufferedReader bReader =  new BufferedReader(new FileReader(inputFile));
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(outputFile));
			try {
				t = Integer.parseInt(bReader.readLine().trim());
				//System.out.println("No. Of Cases"+t);
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
									//System.out.println(divider+" "+i);
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
