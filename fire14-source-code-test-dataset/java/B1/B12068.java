import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
    
	    
	
	int solve(int a, int b) {
		
		HashSet<Long> set = new HashSet<>();
		
		for (int i = a; i < b; ++ i) {
			StringBuilder s = new StringBuilder(Integer.toString(i));
			for (int j = 1;j < s.length(); ++ j) {
				if (s.charAt(j) == '0') {
					continue;
				}
				int x = 0;
				for (int k = j; k < s.length(); ++ k) {
					x = 10 * x + s.charAt(k) - '0';
				}
				for (int k = 0; k < j; ++ k) {
					x = 10 * x + s.charAt(k) - '0';
				}
				if (x > i && x <= b) {
					set.add(i * 10000000l + x);
				}
			}
		}
		
		return set.size();
	}
	
	public void solve() throws Exception {
		int t = sc.nextInt();
		for (int i = 0;i < t; ++ i) {
			out.println("Case #" + (i + 1) + ": " + solve(sc.nextInt(), sc.nextInt()));
		}
    }
    
    
    
    
    /*--------------------------------------------------------------*/
    
    static String filename = "";
    static boolean fromFile = false;
    
    BufferedReader in;
    PrintWriter out;
    FastScanner sc;
    
    public static void main(String[] args) {
        new Thread(null, new Solution(), "", 1 << 25).start();
    }
   
    public void run() {
        try {
            init();
            solve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }
    
    void init() throws Exception {
    	if (fromFile) {
    		in = new BufferedReader(new FileReader(filename+".in"));
        	out = new PrintWriter(new FileWriter(filename+".out"));
    	} else {
    		in = new BufferedReader(new InputStreamReader(System.in));
        	out = new PrintWriter(System.out);
    	}
        sc = new FastScanner(in);
    }
}

class FastScanner {
    
    BufferedReader reader;
    StringTokenizer strTok;
    
    public FastScanner(BufferedReader reader) {
        this.reader = reader;
    }
    
    public String nextToken() throws IOException {
        while (strTok == null || !strTok.hasMoreTokens()) {
            strTok = new StringTokenizer(reader.readLine());
        }
        
        return strTok.nextToken();
    }
    
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    
    public BigInteger nextBigInteger() throws IOException {
    	return new BigInteger(nextToken());
    }
    
    public BigDecimal nextBigDecimal() throws IOException {
    	return new BigDecimal(nextToken());
    }
}