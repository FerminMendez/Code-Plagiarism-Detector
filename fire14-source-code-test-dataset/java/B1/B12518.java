import java.io.*;
import java.util.*;

public class QualC {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int z = Integer.parseInt(br.readLine());
		int[] ten = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
		
		for(int i=0; i<z; i++){
			String[] s = br.readLine().split("\\s+");
			
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			int n = Integer.toString(a).length();
			
			HashSet<String> hs = new HashSet<String>();
			
			for(int j=a; j<b; j++){
				int t = j;
				
				for(int k=1; k<n; k++){
					int tt = t%ten[k];
					int ttt = t/ten[k];
					
					int tttt = tt*ten[n-k] + ttt;
					
					if(t < tttt && tttt <= b){
						String ss = Integer.toString(t);
						String sss = Integer.toString(tttt);
						
						hs.add(ss + sss);
					}
				}
			}
			
			System.out.println("Case #" + (i+1) + ": " + hs.size());
		}
	}
}
