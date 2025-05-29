package CodeJam;

import java.io.*;
import java.util.Scanner;

public class C_2012 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		
		int c = in.nextInt();
		
		for(int cases=0;cases<c;cases++){
			
			int A = in.nextInt();
			int B = in.nextInt();
			int C = 0;
			
			for(int i=A;i<B;i++){
				
				for(int j=i+1;j<=B;j++){
					
					int n = String.valueOf(i).length();
					for(int k=1;k<n;k++){
						String I = String.valueOf(i);
						int ip = Integer.parseInt(I.substring(n-k, n)+I.substring(0, n-k));
						if(ip==j) {
							C++;
							break;
						}
					}
				}					
			}
			
		out.println("Case #"+(cases+1)+": "+C);
			
		}
		out.close();
		System.exit(0);
	}
}
