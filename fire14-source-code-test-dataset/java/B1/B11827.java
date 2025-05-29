package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class main {
	

	
	
public static void main(String[] args) throws IOException{
	String text = "";
	int lineCounter = 0;
	int totalLength = 2;
	int outputTotal = 0;
	int firstNum = 0;
	int secondNum = 0;
	long rotated = 0;
	String[] array = null;
	int copy=0;
	
	char[] Output=null;
	String output=null;
	String firstNumStr="";
	String secondNumStr = "";
	String temp = "";
	PrintWriter out = null;
	
	BufferedReader in = new BufferedReader(new FileReader("C-small.in"));
	
	text = in.readLine();
	totalLength = Integer.parseInt(text);
	//System.out.print(totalLength);
	
	while(lineCounter < totalLength){
		
		
	text = in.readLine();
	System.out.println(text);
	if(text == null)break;
	
	
	array = text.split(" ");
	firstNum = Integer.parseInt(array[0]);
	firstNumStr = array[0];
	secondNum = Integer.parseInt(array[1]);
	secondNumStr = array[1];
	copy = firstNum;
	//System.out.println("firstNum = " + firstNum);
	//System.out.println("secondNum = " + secondNum);
	
	int numOfDigits = (int) Math.log10((double) firstNum) + 1;
	
	for(int i = 0; i < (secondNum - copy); i++){
		for(int j = 1; j < numOfDigits; j++){
			temp = firstNumStr.substring(j);
			temp = temp + firstNumStr.substring(0, j);
			rotated = Integer.parseInt(temp);
			if(rotated > firstNum && rotated <= secondNum){
				outputTotal++;
			}
			
		}
		firstNum++;
		firstNumStr = Integer.toString(firstNum);
	}
		//output = new String(outputTotal);
		
				out = new PrintWriter(new FileWriter("outputfile.out",true)); 
				out.println("Case #"+ String.valueOf(lineCounter+1)+ ": "+ outputTotal); 
				out.close();
				
				System.out.println("Case #"+ String.valueOf(lineCounter+1)+ ": "+ outputTotal);
				outputTotal = 0;
				lineCounter++;
	
	
	
	
		

	
		
		
		}
	}
}

