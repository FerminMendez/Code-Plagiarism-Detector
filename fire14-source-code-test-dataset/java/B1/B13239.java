package Qualifier;

import java.io.*;
import java.util.*;

public class C_Small {
	private static Scanner in;
	private static PrintWriter out;
    private static String testCase = "C-small";

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ENGLISH);
        out = new PrintWriter(new FileOutputStream(testCase + ".out"));
        in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(testCase + ".in"))));
        
        int tests = in.nextInt();
        in.nextLine();
    	
        for (int t = 1; t <= tests; ++t) {
            out.print("Case #" + t + ": ");
            new C_Small().solve();
        }
        in.close();
        out.close();
    }

    void solve() throws Exception {
    	int A = in.nextInt();
    	int B = in.nextInt();
    	long result = 0; 
    	if(B < A || String.valueOf(A).trim().length() != String.valueOf(B).trim().length()){
    		return;
    	}
    	
    	for(int n=A; n<=B; n++){
    		String nString = String.valueOf(n);
    		int length = nString.length();
    		for(int j = 1; j < length; j++){
    			String c = nString.substring(j, length) + nString.substring(0 , j);
    			int mCase = Integer.parseInt(c);
    			if(mCase >= A && mCase <= B && mCase > n){
    				result++;
    			}
    		}
    	}
  
    	out.println(result);
    }
}
