// Problem B

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class B {
	
	private void processInput() throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = in.nextInt();
            int S = in.nextInt();
            int p = in.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = in.nextInt();
            }

			int res = go(N, S, p, arr);

			System.out.printf(Locale.ENGLISH, "Case #%d: %d\n", testCase, res);
		}
		
		in.close();
	}
	
	private int go(int N, int S, int p, int[] arr) {
		
        int res = 0;
        int s = S;
	    
	    for (int i = 0; i < N; i++) {
	        int rr = -1;
	        for (int P = p; P <= 10; P++) {
    	        int diff = arr[i] - P;
    	        if (diff >= 0) {
    	            int v1 = diff / 2;
    	            int v2 = diff - v1;
    	            if (P >= v1 && P >= v2) {
    	                if (P - v1 <= 1 && P - v2 <= 1) {
    	                    rr = 0;
    	                } else if (P - v1 <= 2 && P - v2 <= 2) {
    	                    if (rr == -1) {
    	                        rr = 1;
    	                    }
    	                }
    	                
    	            }
    	        }
	        }
	        if (rr == 0) {
	            res++;
	        } else if (rr == 1 && s > 0) {
	            s--;
	            res++;
	        }
	    }
	    
		return res;
	}
	
	
	public static void main(String[] args) throws Exception {
		B temp = new B();
		temp.processInput();
	}
}
