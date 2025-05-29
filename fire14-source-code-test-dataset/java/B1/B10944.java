import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new FileWriter("out.txt")); 
		RecycledNumbers prog = new RecycledNumbers();
		
		String inString = "";
		int t = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < t; i++) {
			
			inString = in.readLine();
			String[] word = inString.split(" ");
			int a = Integer.parseInt(word[0]);
			int b = Integer.parseInt(word[1]);
			out.println("Case #" + (i+1) + ": " + prog.getNumbers(a, b));
			
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
