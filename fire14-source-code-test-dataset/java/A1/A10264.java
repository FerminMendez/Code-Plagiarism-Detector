
package code_jam;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_Jam {

	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = new BufferedReader(new FileReader("B-small-attempt4.in"));
		FileWriter out= new FileWriter("B-small-attempt4.out");
		//BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int T,S,P,N,C;
		T=Integer.parseInt(in.readLine());
		StringTokenizer x;
		for (int i = 1; i <= T; i++) {
			C=0;
			x=new StringTokenizer(in.readLine());
			N=Integer.parseInt(x.nextToken());
			S=Integer.parseInt(x.nextToken());
			P=Integer.parseInt(x.nextToken());
			int G[]=new int[N];
			for (int j = 0; j < N; j++) {
				G[j]=Integer.parseInt(x.nextToken());
			}
			Arrays.sort(G);
			for (int j = 0; j < N; j++) {
				if(G[j]<P)// may be  <p only
					continue;
				int A,B,D;
				A=P;G[j]-=P;
				B=G[j]/2;
				D=G[j]-B;
				if(D>=10){
				C++;
				continue;
				}
				if(P-B>2)
				continue;
				else if(P-B==2&&S>0){
				C++;
				S--;
				}
				else if(P-B<=1){
				C++;
				}
				
				
			}
			//System.out.println(C);
			out.write("Case #"+i+": "+C+"\n");
			
			
		}
		out.close();	
		
	}
}
