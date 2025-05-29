package wangshu.codejam.google.com;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.regex.*;

public class QB {

	/**
	 * @param args
	 */
	public static int calculateNumber(int S, int p, int[] t){
		
		int yes=0, maybe=0;
		int temp; // temp is the higher value of p-1 or p-2 compared with 0;
		
		// For each Googler, calculate result
		for(int i=0; i<t.length; i++){
			temp = ((p-1)>0) ? p-1:0;
			if (t[i]-p-temp*2 >= 0){
				yes++;
			}else{ 
				temp = ((p-2)>0) ? p-2:0;
				if (t[i]-p-temp*2 >=0)
				maybe++;
			}
		}
		
		if(maybe > S){
			maybe = S;
		}
		
		return yes+maybe ;
	}
	
	public static void main(String[] args) throws java.lang.Exception{

		Scanner sc_line = new Scanner(new File("qb_in_small.txt"));  // Line scanner for input file
		Scanner sc_int; // Integer scanner for each line
		sc_line.useDelimiter(Pattern.compile("[\\p{javaWhitespace}]+"));
		String line;
		int T; // Number of test cases
		int N, S, p;
		int[] t;
		FileWriter outputFile = new FileWriter("qb_out_small.txt");  // Output file
		
		// Read number of test cases
		T = sc_line.nextInt(); 
		sc_line.nextLine();
		
		// Read each test case
		for(int i=0; i<T; i++){
			line = sc_line.nextLine();
			sc_int = new Scanner(line);
			N = sc_int.nextInt();
			S = sc_int.nextInt();
			p = sc_int.nextInt();
			t = new int[N];
			for(int j=0; j<N; j++){
				t[j] = sc_int.nextInt();
			}
			
			System.out.println("Case #" + (i+1) + ": " + calculateNumber(S, p, t));
			outputFile.write("Case #" + (i+1) + ": " + calculateNumber(S, p, t)+"\r\n");
		}
		outputFile.flush();
	}

}
