package QualRound;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DancingWiththeGooglers {
	String inFile = "c:/temp/DancingWiththeGooglers/B-small-attempt0.in";
	String outFile = "c:/temp/DancingWiththeGooglers/B-small-attempt0.out";
	ArrayList<String> input = new ArrayList<String>();
	ArrayList<String> output = new ArrayList<String>();
	int T;
	
	public DancingWiththeGooglers(){
		input = readInput();
		process(input);
		createOutputFile(output);
	}

	public void process(ArrayList<String> input){
		T = Integer.valueOf(input.get(0));
		for(int i = 1; i<input.size();i++){
			String[] temp = input.get(i).split(" ");
			output.add(String.valueOf(solveTest(temp)));
		}
		
	}
	
	public int solveTest(String[] temp){
		int N = Integer.valueOf(temp[0]);
		int S = Integer.valueOf(temp[1]);
		int P = Integer.valueOf(temp[2]);
		int result = 0;
		
		for(int i = 3; i<temp.length; i++){
			int value = Integer.valueOf(temp[i]);
			if(value%3==0){
				if(value/3>=P){
					result++;
				}else if(value/3+1<=10 	&& value/3+1>=P && S>0 && value/3-1>=0){
					S--;
					result++;
				}
			}
			if(value - 3*(value/3)==2){
				if(value/3+1>=P){
					result++;
				} else if(value/3+2>=P && value/3+2<=10 && S>0){
					S--;
					result++;
				}
			}
			
			if(value - 3*(value/3)==1){
				if(value/3+1>=P){
					result++;
				}
			}
		}
		return result;
	}
	
	public void createOutputFile(ArrayList<String> output){
		try{
			  FileWriter fstream = new FileWriter(outFile);
			  BufferedWriter out = new BufferedWriter(fstream);
			  int i = 1;
			  for(String str : output) {
				  out.write("Case #"+i+": ");
				  out.write(str);
				  out.newLine();
				  i++;
			  }

			  out.close();
			}catch (Exception e){
			  System.err.println("Error: " + e.getMessage());
			 }
			  
	}
	
	public ArrayList<String> readInput(){
		ArrayList<String> inp = new ArrayList<String>();
		
		try{
			  FileInputStream fstream = new FileInputStream(inFile);
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //T = Integer.parseInt(br.readLine());
			  
			  while ((strLine = br.readLine()) != null)   {
				  inp.add(strLine);
				}
			  in.close();
		    }catch (Exception e){
			  System.err.println("Error: " + e.getMessage());
			  }
		
		return inp;
	}
	
	
	public static void main(String[] args) {

		DancingWiththeGooglers dancingWiththeGooglers = new DancingWiththeGooglers();
	}

}
