package qualifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TC {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		try {
			File file = new File("src/qualifier/C-small-attempt0.in");
			String a = file.getAbsolutePath();
			in = new Scanner(file);
			out = new PrintWriter(new File("src/qualifier/C-small-attempt0.out"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TC worker = new TC();
		int n = in.nextInt();
		
		for (int i=1; i<=n; i++) {
			out.println("Case #" + i + ": " + worker.nums(in.nextInt(), in.nextInt(), out));
		}
		out.flush();
	}
	
	public int nums(int a,int b, PrintWriter out) {
		int sum = 0;
		int i = a;
		int order = 0;
		while (i>0) {
			i=i/10;
			order++;
		}
			
		for (i=a; i<b; i++) {
			Set<Integer> s = new HashSet<Integer>();
			for (int j=1; j<order; j++) {
				int n1 = 1;
				int n2 = 1;
				for (int k=1; k<=j; k++)
					n1 *= 10;
				for (int k=1; k<=order-j; k++)
					n2 *= 10;
				
				int k1 = i/n1;
				int k2 = i%n1;
				int tr = k2 * n2 + k1;
				if (tr>i && tr<=b && !s.contains(tr)) {
					sum++;
					s.add(tr);
				}
			}
		}
		
		return sum;
	}

}
