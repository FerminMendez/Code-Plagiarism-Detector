package CodeJam;

import java.io.*;
import java.util.*;

public class B_2012 {

	public static void main(String[] args) throws IOException {
		

		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test2.out")));
		
		int NS[] = {0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10};
		int S[] = {-1,-1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10,-1,-1};
		
		int cases= in.nextInt();
		
		for(int c=0;c<cases;c++){
			int n = in.nextInt();
			int s = in.nextInt();
			int b = in.nextInt();	
			int C=0;
			ArrayList<Integer>  G = new ArrayList<Integer>();
					
			for(int i=0;i<n;i++) G.add(in.nextInt());
			Collections.sort(G);
			for(int i=0;i<G.size();i++){
				if(s>0 && S[G.get(i)]>=b) {
					s--;
					G.remove(i);
					C++;
					i--;
				}
			}
			for(int i=0;i<G.size();i++){
				if(s>0 && NS[G.get(i)]<b && S[G.get(i)]<b ) {
					s--;
					G.remove(i);
					i--;
				}
			}
			for(int i=0;i<G.size();i++)
				if(NS[G.get(i)]>=b ) C++;
			
			out.println("Case #"+(c+1)+": "+C);
			
		}
		out.close();
		System.exit(0);
	}
}
