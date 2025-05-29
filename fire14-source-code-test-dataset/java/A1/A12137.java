import java.io.*;

public class Main {

	static private int getNonSuprising(int sum) {
		if (sum == 0) return 0;
		return (int) Math.floor((double) (sum+2) /3);
	}
		
	static private int getSuprising(int sum) {
		if (sum == 0) return 0;
		if (sum == 1) return 1;
		return (int) Math.ceil( (double) (sum-1) / 3) + 1;
	}
		
	static private int handleCase(String line) {
		String[] tokens = line.split(" ");
		int[] values = new int[tokens.length];
		
		for (int i=0; i < tokens.length; i++) {
		  values[i] = Integer.parseInt(tokens[i]);	
		}
		
		int n = values[0];
		int s = values[1];
		int p = values[2];
		
		int count = 0;
		for (int j=0;j<n;j++) {
			int sum = values[j+3];
			
			int suprising = getSuprising(sum);
			int nonsuprising = getNonSuprising(sum);
			
			if (nonsuprising >= p)
				count++;
			else if (suprising >= p && s > 0) {
			  s--;
			  count++;
			} 
			
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
				int best = handleCase(line);
				
				out.write("Case #" + (i+1) + ": " + best);
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
