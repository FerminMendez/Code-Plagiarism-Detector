package qualification_2012;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	
	public void run() {
		try {
			Scanner in = new Scanner(new File("C.in"));
			PrintWriter out = new PrintWriter(new File("C.txt"));
			
			int T = in.nextInt();
			for (int TC = 1; TC <= T; TC++) {
				int A = in.nextInt();
				int B = in.nextInt();
				long counter = 0;
				HashSet<String> set = new HashSet<String>();
				for (int n = A; n < B; n++) {
					for (int i = 10; i < n; i*=10) {
						String p1 = (n/i) + "";
						p1 = (n%i) + p1;
						int m = Integer.parseInt(p1);
						String t = n+"-"+m;
						if (m > n && m <= B && !set.contains(t)) {
							set.add(t);
							counter++;
						}
					}
				}
				
				System.out.println("Case #" + TC + ": " + counter);
				out.println("Case #" + TC + ": " + counter);
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new C().run();
	}
}
