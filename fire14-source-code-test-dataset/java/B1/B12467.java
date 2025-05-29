package gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class RecycledNumbers {
	private String solve(Scanner in) {
		HashSet<Integer> set = new HashSet<Integer>();
		int A = in.nextInt();
		int B = in.nextInt();
		
		int result = 0;
		int numberLen = ((Integer)A).toString().length();
		
		int multiple = 1;
		for (int tt = 1; tt < ((Integer)A).toString().length(); tt++)
			multiple *= 10;
		
		for (int n = A; n < B; n++) {
			if (n / multiple >= 10) multiple *= 10;

			int m = n;
			int d = m % 10;
			m /= 10;
			
			int counter = 0;
			while (counter < numberLen - 1) {
				m += multiple*d;
				if (m > n && m <= B && !set.contains(m)) set.add(m);
				d = m % 10;
				m = m / 10;
				counter++;
			}
			
			result += set.size();
			set.clear();
		}
		return "" + result;
	}
	
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner in = new Scanner(new File("C:\\Users\\User\\Desktop\\dane\\data.in"));//C:\\Users\\User\\workspace\\GoogleCodeJam\\src\\gcj\\data"));//"));
	    PrintWriter out = new PrintWriter("C:\\Users\\User\\Desktop\\dane\\output");//C:\\Users\\User\\workspace\\GoogleCodeJam\\src\\gcj\\output");//"C:\\Users\\User\\Desktop\\dane\\output");
		
	    int T = in.nextInt();
	    in.nextLine();
	
        for (int i = 0; i < T; i++) {
            String s = "Case #" + (i + 1) + ": " + new RecycledNumbers().solve(in);
            out.println(s);
            System.out.println(s);
        }
        out.close();

	}
}
