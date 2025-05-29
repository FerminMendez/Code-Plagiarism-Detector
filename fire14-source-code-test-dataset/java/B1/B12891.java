

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C {
    class Solver implements Runnable {
        int testId;
        boolean failed = false;
        int result = 0;
        
        Solver(int testId) {
            this.testId = testId;
        }

        String in, out = "";
        
        ArrayList<String> text = new ArrayList<String>();
        int a,b, p;

        private void readInput() {
        	a = nextInt();
        	b = nextInt();
        }

        int res;
        
        public void run() {
			//System.out.println("SOLVING  a = " + a + "   b = " + b );        	
        	
        	for (int i=a; i<b; i++){
        		int power = 1;
        		//A and B have the same num of digits, but to be sure...
        		     if (i>999999) power = 1000000; //to save some CPU cycles 
        		else if (i>99999)  power = 100000;
        		else if (i>9999)   power = 10000;
        		else if (i>999)    power = 1000;
        		else if (i>99)     power = 100;
        		else if (i>9)      power = 10;
        		
        		//k = i;
        		
        		int cycled = i;
        		int right = i;
        		
        		while (right>9) { //13205 //51320 //ignore 05132 //20513
        			cycled /= 10; //shift >>
        			cycled += (right % 10)*power; //add rightmost digit in front
        			right /= 10;
        		    
        			if (cycled == i ) right = 0;
        			if ( cycled <= b && cycled > i) {// no leading 0s
        				//System.out.println(" i = " + i + " cycled " + (cycled) );
        				result++;
        			}
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
		new C().run();
	}

}
