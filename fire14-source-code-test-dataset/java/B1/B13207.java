import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProblemC {
	
	static Scanner kb = null;
	static FileWriter fw = null;
	
	public static void main(String [] args) {
		
		try {
			kb = new Scanner(new File("input.in"));
		} catch (FileNotFoundException e) {}
		
		
		
		
		int T = kb.nextInt();
		
		//int result = solve(1111, 2222);
		//System.out.println("Case #"+2+": "+result);
		
		
		FileWriter fstream = null;
		try {
			fstream = new FileWriter("output.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fstream);
		  
		for(int i=1; i<=T; i++) {
			int A = kb.nextInt();
			int B = kb.nextInt();
			
			int result = solve(A, B);
			
			try {
				out.append("Case #"+i+": "+result+"\n");
				//out.write("Case #"+i+": "+result);
			} catch (IOException e) {
				System.out.println("error "+e.getMessage() );
			}
			//System.out.println("Case #"+i+": "+result);
		}
		 try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static int solve(int A, int B) { // 100 500
		
		int count = 0;
		for(int i=A; i<=B; i++) {
			
			String istr = i+""; // 100
			String icyc = istr + istr; // 100100
			
			int len = istr.length();
			
			//System.out.println("cyc: "+icyc);
			
			ArrayList<Integer> savedInts = new ArrayList<Integer>();
			
			savedInts.add(i);	
			
			for(int j=1; j<len; j++) {
				String recyc = icyc.substring(j, j+len);
				int recycInt = Integer.parseInt(recyc);
				
				//System.out.println("> "+recycInt);
				
				if(recycInt <= B && recycInt>=A && !savedInts.contains(recycInt)) {
					//System.out.println("*");
					savedInts.add(recycInt);
					count++;
				}
			}
		}
		
		return count/2;
	}
}
