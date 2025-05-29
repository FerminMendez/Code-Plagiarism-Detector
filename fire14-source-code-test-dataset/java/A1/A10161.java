import java.io.*;
import java.util.*;


public class B {
	
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new FileWriter("B-small.out"));
		int T = Integer.parseInt(in.readLine());
		for(int i=0; i<T; i++) {
			String s = in.readLine();
			String[] ss = s.split(" ");
			int N = Integer.parseInt(ss[0]);
			int S = Integer.parseInt(ss[1]);
			int P = Integer.parseInt(ss[2]);
			int[] ar = new int[50];
			for(int j=0; j<N; j++) {
				int x = Integer.parseInt(ss[3+j]);
				ar[x]++;
			}
			
			int ans = 0;
			
			if(P==0) ans=N; else {
				int a = 0;
				int b = 0;
				for(int k=40; k>=0; k--) {
					int n = ar[k];
					if(k>(P-1)*3) {
						a+=n;
					} else if(P>1&& (k==(P-1)*3||k==(P-1)*3-1)) {
						b+=n;
					}
				}
				ans = a+Math.min(b,S);
				
			}
			
			out.println("Case #"+(i+1)+": "+ans);
		}
		out.close();
	}
}
