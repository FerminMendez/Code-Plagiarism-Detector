package qualification;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C {

	String solve(Scanner in) throws IOException {
		int A = in.nextInt(), B = in.nextInt(), pow = 1, pairs = 0;
		
		while(10*pow <= A)
			pow *= 10;
		
		boolean[] seen = new boolean[B+1];
		for(int n = A; n <= B; n++)
			if(!seen[n]) {
				int count = 0;
				for(int m = n; m > B || !seen[m]; m = m/10 + m%10 * pow)
					if(A <= m && m <= B) {
						seen[m] = true;
						count++;
					}
				pairs += count * (count-1) / 2;
			}
		
		return ""+pairs;
	}
	
/*************************************************************************************************/
	
	public static void main(String[] args) throws IOException {
		for(File f : new File(".").listFiles())
			if(f.isFile() && f.getName().startsWith(C.class.getSimpleName() + "-")
					      && f.getName().endsWith(".in")) {
				
				Scanner in = new Scanner(new FileReader(f));
				PrintWriter out = new PrintWriter(new FileWriter(f.getName() + ".out"));
				
				int cases = in.nextInt(); in.nextLine();
				for(int caseno = 1; caseno <= cases; caseno++)
					out.printf("Case #%d: %s%n", caseno, new C().solve(in));
				
				out.close();
			}
	}
}
