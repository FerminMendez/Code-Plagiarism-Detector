import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new FileWriter("out.txt")); 
		GooglersDance a = new GooglersDance();
		
		String inString = "";
		int t = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < t; i++) {
			
			inString = in.readLine();
			String[] word = inString.split(" ");
			int n = Integer.parseInt(word[0]);
			int s = Integer.parseInt(word[1]);
			int p = Integer.parseInt(word[2]);
			int dancers[] = new int[n];
			for(int j = 3; j < word.length; j++) {
				
				dancers[j-3] = Integer.parseInt(word[j]);
				
			}
			out.println("Case #" + (i+1) + ": " + a.maxDancers(n,s,p,dancers));
			
		}
		in.close();
		out.close();
		
	}
	
	private static void printArray(String[] a) {
		
		for(int i = 0; i < a.length; i++) {
			
			System.out.print(a[i] + " ");
			
		}
		System.out.print("\n");
		
	}

}
