package qualification;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	String solve(Scanner in) throws IOException {
		int N = in.nextInt(), S = in.nextInt(), p = in.nextInt(),
			count = 0, need_surprise = 0;
		
		for(int i = 0; i < N; i++) {
			int t = in.nextInt();
			
			if((t+2)/3 >= p)
				count++;
			else if(2 <= t && t <= 28 && (t+4)/3 >= p)
				need_surprise++;
		}
		count += Math.min(S, need_surprise);
		
		return ""+count;
	}
	
/*************************************************************************************************/
	
	public static void main(String[] args) throws IOException {
		for(File f : new File(".").listFiles())
			if(f.isFile() && f.getName().startsWith(B.class.getSimpleName() + "-")
					      && f.getName().endsWith(".in")) {
				
				Scanner in = new Scanner(new FileReader(f));
				PrintWriter out = new PrintWriter(new FileWriter(f.getName() + ".out"));
				
				int cases = in.nextInt(); in.nextLine();
				for(int caseno = 1; caseno <= cases; caseno++)
					out.printf("Case #%d: %s%n", caseno, new B().solve(in));
				
				out.close();
			}
	}
}
