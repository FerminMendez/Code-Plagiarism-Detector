import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Bool;


public class ProbC {

	static Hashtable<Integer, Hashtable<Integer, Boolean>> vis;
	public static void main(String[] args) {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter("d:\\codejam2012\\outputfile.txt"));
			Scanner scanner = new Scanner(new File("d:\\codejam2012\\C-small-attempt0.in"));
			
			int cases = scanner.nextInt();
			scanner.nextLine();
			
			for (int i = 1; i <= cases; i++) {
				int a = scanner.nextInt(), b = scanner.nextInt();
				vis = new Hashtable<Integer, Hashtable<Integer, Boolean>>();
				int sol = 0;
				for (int j = a; j < b + 1; j++) {
					sol += getPairs(j, a, b);
				}
				out.println("Case #"+i+": " +sol);
			}

			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	private static int getPairs(int n, int a, int b) {
		String str = "" + n;
		int count = 0;
		
		for (int i = 1; i < str.length(); i++) {
			int div = (int) Math.pow(10, i);
			int shift = (int) Math.pow(10, str.length() - i);
			int m = (n%div) * shift + (n / div);
			if(m >= a && m <= b && Integer.toString(n).length() == Integer.toString(m).length() && n != m){
				if(vis.containsKey(n) && vis.get(n).containsKey(m))
					continue;
				count++;
				
				if(!vis.containsKey(n))
					vis.put(n, new Hashtable<Integer, Boolean>());
				
				vis.get(n).put(m, true);
				
				if(!vis.containsKey(m))
					vis.put(m, new Hashtable<Integer, Boolean>());
				
				vis.get(m).put(n, true);
			}
		}
		return count;
	}

}
