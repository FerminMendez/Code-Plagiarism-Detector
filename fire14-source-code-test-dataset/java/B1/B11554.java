import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;


public class Recycled {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new FileReader(new File("C-small-attempt0.in")));
		
		PrintWriter out = new PrintWriter(new File("C-small-attempt0.out"));
		
		int t = in.nextInt();
		in.nextLine();
		
		for(int i=0; i<t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int l = Integer.toString(a).length();
			int r = 0;
			

//			System.out.println("a="+a+"\tb="+b);
			
			Vector<Integer> sub = new Vector<Integer>(20); 
			
			for(int c=a; c<=b; c++) {
				String cs = Integer.toString(c);
				
				sub.removeAllElements();

				for(int k=1; k<l;k++) {
					cs = cs.substring(1) + cs.charAt(0);
					if (cs.charAt(0) == '0') continue;

					int ns = Integer.parseInt(cs);
					if (ns > c && ns <= b && !sub.contains(ns)) {
						sub.add(ns);
						r++;
//						System.out.println(c+" -> "+ns);
					}
				}
//				System.out.println("......");
			}
			
			System.out.println("Case #" + (i+1)+ " of "+t+": " + r);
//			System.out.println("==================");
			
			out.println("Case #" + (i+1)+ ": " + r);
		}
		out.close();
	}
}
