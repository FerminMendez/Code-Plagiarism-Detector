import java.util.*;
import java.io.*;

class P2 {

	public static void main(String[] Args) throws IOException{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		int s, p, total, t = Integer.parseInt(br.readLine());
		String tmp;
		String[] tmp2 = new String[10];
		int[] n = new int[10];
		for(int i=0; i<t; i++) {
			tmp = br.readLine();
			tmp2 = tmp.split(" ");
			n = new int[tmp2.length];
			for(int j=0; j<tmp2.length; j++) n[j] = Integer.parseInt(tmp2[j]);
			total = 0;
			s = n[1];
			p = n[2];
			for(int j=3; j<n.length; j++) {
				if(n[j] >= 3*p - 2) {
					total++;
				}
				else if(n[j] >= 3*p - 4 && s>0 && n[j] >= 2) {
					total++;
					s--;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + total);
		}
	}
}