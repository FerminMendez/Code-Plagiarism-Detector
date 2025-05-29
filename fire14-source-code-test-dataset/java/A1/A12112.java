

import java.io.*;
import java.util.Scanner;

public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new FileReader(new File("B-small-attempt0.in")));
		PrintWriter out = new PrintWriter(new File("B.out"));
		StringBuilder resultat =new StringBuilder("");
		
		int T = s.nextInt();

		for (int i = 0; i < T; i++) {
			
			int r=0;
			
			int N = s.nextInt();
			int S = s.nextInt();
			int P = s.nextInt();
			
			int sr = S;
			
			int[] ti = new int[N];
			for (int j = 0; j < N; j++) {
				ti[j] = s.nextInt();
				
				if(ti[j]==0 && P>0)
					continue;
				
				if(ti[j]>=P*3-2) 
					r++;
				else if(ti[j]>=P*3-4 && sr>0) 
					{
					r++;
					sr--;
					}
			}
			
			if(i!=0)
				resultat.append("\n");
			resultat.append("Case #"+(i+1)+": "+r);


			
		}
		
		
		
		out.print(resultat);
		out.close();
	}
}
