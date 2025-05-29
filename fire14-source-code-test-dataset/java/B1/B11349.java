import java.io.*;
import java.lang.reflect.Array;
import java.math.*;

public class Qualifying_C {

	public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        int T = Integer.parseInt(input.readLine());
        
        for (int t = 1; t <= T; t++) {
        	String[] tokens = input.readLine().split(" ");
        	
        	int A = Integer.parseInt(tokens[0]);
        	int B = Integer.parseInt(tokens[1]);
        	
        	int r = 0;
        	
        	for (int n = A; n < B; n++){
        		int i, m;
        		int [] C = new int[6];
        		
        		for (i = 0; n / (int) Math.pow(10, i) != 0; i++);    			
        		
        		outer:
        		for (int j = 1; j < i; j++) {
        			m = (n % (int) Math.pow(10, j)) * (int) Math.pow(10, i - j) + n / (int) Math.pow(10, j);
        			
        			if (m > n && m <= B){
        				int c;
        				for (c = 0; c < C.length && C[c] != 0; c++)
        					if (C[c] == m)
        						break outer;
        					
        				r++;
        				C[c] = m;
        			}
        		}
        	}
        	
        	System.out.println("Case #" + t + ": " + r);
        }		
	}
}
