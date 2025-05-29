import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class prob3 {

	/**
	 * @param args
	 */
	
	
	
	
	static BufferedReader openRead(String fileName){
		 BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("Error Opening the input file");
			e.printStackTrace();
		}
		 return in;
	}
	
	
	
	static int countRecyclyed(int n, int A, int B, int len){
		int result = 0;
		int l = 10;
		int t = 1;
		for (int i = 1; i < len; i++)
			t = t*10;
		for (int i = 1; i < len; i++){
			int m = n / l + (n % l)*t; 
			l = l*10;
			t = t /10;
			if (m > A && m <=B && m >n){
			    result ++;
			    System.out.format("(%d , %d)\n", n, m);
			}
			
			
		}
		
		return result;
		
		
	}
	
	
	static void processLine( String line ,  int k, PrintStream ps){
		ps.format("Case #%d: ", k);
		String[] lineItems = line.split(" ");
			
		int A = Integer.parseInt(lineItems[0]);
		int B = Integer.parseInt(lineItems[1]);
		int len = lineItems[0].length();
		System.out.println(len);
		int n = 0;
		for (int i = A ; i < B; i++){
			 n += countRecyclyed(i, A, B, len);
		}
	  ps.format("%d\n", n);	
		
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length < 1){
			System.err.println("not suffucient args");
			System.exit(-1);
		}
		BufferedReader in = openRead(args[0]);
		PrintStream ps = new PrintStream(new File(args[1]));
		// read size
		int T = 0;
		String TStr = in.readLine();
		T = Integer.parseInt(TStr);
		if ( T < 1 || T > 100)
			System.exit(-1);
		
		
		// read contents
		String line;
		for (int i = 0; i < T  && (line = in.readLine())!= null; i++){
			processLine( line, i+1, ps);
		}
		
			
			
			
			
			
		System.out.println("Done!");

	}
	


}
