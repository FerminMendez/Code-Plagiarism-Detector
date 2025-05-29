import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class RecycledNumbers {
	
	public long getNumbers(int a, int b) {
		
		long ans = 0;
		
		for(int n = a; n < b; n++) {
			
			String nString = n + "";
			ArrayList<Integer> store = new ArrayList<Integer>();
			for(int i = 1; i < nString.length(); i++) {
				
				if(nString.charAt(i) == '0') continue;
				int m = Integer.parseInt(nString.substring(i) + nString.substring(0, i));
				if(m > n && m <= b) {
					
					if(!store.contains(m)) {
						
						store.add(m);
						ans++;	
					
					}
				
				}
			}
			
		}
		
		return ans;
		
	} 

}
