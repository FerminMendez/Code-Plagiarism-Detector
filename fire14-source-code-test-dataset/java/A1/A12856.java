

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B {
    class Solver implements Runnable {
        int testId;
        boolean failed = false;
        int result = 0;
        
        Solver(int testId) {
            this.testId = testId;
        }

        String in, out = "";
        
        ArrayList<String> text = new ArrayList<String>();
        int N,S, p;

        private void readInput() {
        	N = nextInt();
        	S = nextInt();
        	p = nextInt();
        }

        int res;
        
        public void run() {
        	for (int i=0; i<N; i++){
        		int t = nextInt();
        		if (t >= (3*p-2) && t >=p) {//3*points_goal-2 is enough to reach goal for normal score
        			result++; 
        		} else if (S>0 && t>=(3*p-4) && t >=p) { //3*pg-4 is enough to reach for surprising score
        			result++;
        			S--;
        		}        		
        	}
        }


        private void printOutput() {
            if (failed) {
                writer.println("0");
                System.out.println("FAILURE!!!");
            } else {
                writer.println(String.format("Case #%d: %d", testId, result));
            }
        }
    }

	// solve the problem here
	private void solve(){
		int numTests = nextInt();
		for (int testId = 1; testId <= numTests; testId++) {
			Solver solver = new Solver(testId);
			solver.readInput();
			solver.run();
			solver.printOutput();
		}

	}


	BufferedReader reader;
	StringTokenizer tokenizer = null;
	PrintWriter writer;

	String encrypted = "ejp mysljylc kd kxveddknmc re jsicpdrysi"+
	         "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd"+
	         "de kr kd eoya kw aej tysr re ujdr lkgc jvq";
    String output    = "our language is impossible to understand"+
	         "there are twenty six factorial possibilities"+ 
	         "so it is okay if you want to just give upz";

    char[] code = new char[256];
    	
    private void preparehalfcode() {
    	for (int i = 0; i<encrypted.length(); i++) {
    		code[encrypted.charAt(i)] = output.charAt(i);
    	}    	
    }
    
    private void prepare() {
    	preparehalfcode();
    	encrypted = encrypted.toUpperCase();
    	output = output.toUpperCase();
    	preparehalfcode();
    }
    
    public void run() {
        try {
            long now = System.currentTimeMillis();
            String problemfilename = this.getClass().getSimpleName();
            reader = new BufferedReader(new FileReader(problemfilename + ".in"));
            writer = new PrintWriter(problemfilename + ".out");
            prepare();
            solve();
            reader.close();
            writer.close();
            System.out.println(System.currentTimeMillis() - now + "ms");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	int nextInt() {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		new B().run();
	}

}
