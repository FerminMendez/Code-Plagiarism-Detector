import java.io.*;
import java.util.*;

public class Main {

	static private String formatPair(int toMove, String num1) {
		String back = num1.substring(num1.length() - toMove);
		String front = num1.substring(0,num1.length() - toMove);
		return (back + front);
	}

	static private int getDistinctPairs(int v1,int v2) {
		String num1 = Integer.toString(v1);
		String num2 = Integer.toString(v2);
		
		if (num1.length() != num2.length()) return 0;
		
		for (int i = 1; i < num1.length();i++) {
			String match = formatPair(i,num1);
			if (match.equals(num2)) 
				return 1;
		}
		
		return 0;
	}
	
	static int getDistinctPairsBetween(int a, int b) {
		int count = 0;
		//generate all possible values
		for (int i=a; i <= b; i++) 
			for (int j=i+1;j <= b; j++) {
				
				boolean valid = (i >= a && i < j && j > i && j <= b);	
				if (valid) 
					count += getDistinctPairs(i,j);	
			}
		return count;
	}
		
	static public void main(String args[]) {
		
		try{
		  FileWriter fstream = new FileWriter("output.out");
		  BufferedWriter out = new BufferedWriter(fstream);
		  
		try {
		  BufferedReader input =  new BufferedReader(new FileReader(new File(args[0])));
		  try {
			String line = null; 
			
			line = input.readLine();
			int count = Integer.parseInt(line);
			
			for (int i =0; i<count;i++) {
				line = input.readLine();
				String[] values = line.split(" ");
				int pairs = getDistinctPairsBetween(Integer.parseInt(values[0]),Integer.parseInt(values[1]));
				out.write("Case #" + (i+1) + ": " + pairs);
				out.newLine();
			}
			
		  }
		  finally {
			input.close();
		  }
		}
		catch (IOException ex){
		  ex.printStackTrace();
		}
		
		out.close();
	  }catch (Exception e){
		System.err.println("Error: " + e.getMessage());
	  } 
	}
}
