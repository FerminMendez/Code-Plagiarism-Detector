package qualifying;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class B {

	public static String solve(int N, int S, int p, int[] t) {
		
		int cnt = 0;
		
		for(int i=0; i<t.length; i++) {
			if(t[i]>=2*Math.max(p-1,0)+p) cnt++;
			if(t[i]<2*Math.max(0,p-1)+p && t[i]>=2*Math.max(0,p-2)+p) { 
				if(S>0) {
					cnt++;
					S--;
				}
			}
		}
		
		
		return Integer.toString(cnt);
	}
	
	
	public static void main(String[] args) throws Exception {
		
		String fs_in = "/Users/ctynan/Downloads/test.txt";
		String fs_out = "/Users/ctynan/Documents/B-out.txt";
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fs_in));
		BufferedWriter bw = new BufferedWriter(new FileWriter(fs_out));
		
		line=br.readLine();
		line=line.toLowerCase();
		int tst = Integer.valueOf(line);
		
		for(int ii=0;ii<tst; ii++) {
			line=br.readLine();
			String output = "Case #" + Integer.toString(ii+1) +": ";
			String[] tem = line.split(" ");
			int N = Integer.valueOf(tem[0]);
			int S = Integer.valueOf(tem[1]);
			int p = Integer.valueOf(tem[2]);
			int[] t = new int[N];
			for(int i=3; i<tem.length; i++) {
				t[i-3] = Integer.valueOf(tem[i]);
			}
			
			String res = solve(N,S,p,t);
			bw.write(output+res);
			if(ii<tst-1) bw.write('\n');
		}
		bw.close();
		return;
	}
}
