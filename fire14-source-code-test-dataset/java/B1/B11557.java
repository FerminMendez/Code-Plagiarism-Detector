package gcj2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer t = Integer.parseInt(br.readLine());
		int init = t;
		while (t-- > 0) {
//			long s = System.currentTimeMillis();
			int res = 0;
			String[]parts = br.readLine().split("\\s+");
			int A = Integer.parseInt(parts[0]);
			int B = Integer.parseInt(parts[1]);
			for(int n = A; n <= B; n++){
				Set<String> set = new HashSet<String>();
				char[]num = (n+"").toCharArray();
				for(int i = 1; i < num.length; i++){
					if(num[i]<num[0])continue;
					int len = 0;
					int j = i;
					StringBuffer sb = new StringBuffer();
					while(len<num.length){
						sb.append(num[j++]);
						if(j>=num.length)j = 0;
						len++;
					}
					int m = Integer.parseInt(sb.toString());
					if(m>n&&m>=A&&m<=B){
						set.add(n+","+m);
					}
				}
				res+=set.size();
			}
			System.out.println("Case #"+(init-t)+": " + res);
//			System.out.println(System.currentTimeMillis()-s);
		}		
	}

}
