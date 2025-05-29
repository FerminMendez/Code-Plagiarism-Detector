import java.io.*;
import java.util.*;

public class Recycled {

	public static void main(String[] args) {
		BufferedReader input = null;
		BufferedWriter output = null;
		try {
			input = new BufferedReader(new FileReader("C:\\Users\\cerebrus\\eclipse-workspace\\QualiC-Recycled\\src\\C-small-attempt0.in"));
			output = new BufferedWriter(new FileWriter("C:\\Users\\cerebrus\\eclipse-workspace\\QualiC-Recycled\\src\\C-small-attempt0.out"));
			
			int T = Integer.valueOf(input.readLine());
		    for(int i=1; i<=T; i++) {
		    	String nums[] = input.readLine().split(" ");
		    	int A = Integer.valueOf(nums[0]);
		    	int B = Integer.valueOf(nums[1]);
		    	output.write("Case #"+i+": ");
		    	
		    	if(A<10 || B<10)
		    		output.write("0");
		    	else if ((A == B) || (A > B))
		    		output.write("0");
		    	else {
		    		int count = 0;
		    		for(int j=A; j<B; j++) {
		    			String temp1 = Integer.toString(j);
		    			String temp = temp1 + temp1;
		    			Set<Integer> matches = new HashSet<Integer>();
		    			for(int k=1; k<temp1.length(); k++) {
		    				int m = Integer.valueOf(temp.substring(k, k+temp1.length()));
		    				if((m>j) && (m<=B))
		    					matches.add(m);
		    			}
		    			count += matches.size();
		    		}
		    		output.write(String.valueOf(count));
		    	}	
		        
		    	if(i<T) output.write("\n"); 
		    }
		    
		    
		} catch (FileNotFoundException e) {
			System.out.println("input file not found: ");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("Error opening files: ");
		    e.printStackTrace();
		    System.exit(1);
		} finally {
			try {
				input.close();
				output.close();
				System.out.println("Done !!");
			} catch (IOException e) {
				System.out.println("Error closing files: ");
				e.printStackTrace();
			}
		}

	}

}
