import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class round1 {

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
	
	
	static void processLine( String line ,  int k, PrintStream ps){
		ps.format("Case #%d: ", k);
		String[] lineItems = line.split(" ");
		int N = Integer.parseInt(lineItems[0]);
		int S = Integer.parseInt(lineItems[1]);
		int p = Integer.parseInt(lineItems[2]);
		int c = 3;
		int n = 0;
		for (int i = 0; i < N; i++){
			
			int pi = Integer.parseInt(lineItems[c++]);
			if (pi >= 3*p)
				n++;
			else if (pi >= 3*p -1)
				n++;
			else if (pi >= 3*p -2)
				n++;
			else if (pi >= 3*p - 4 && (3*p - 4)>=0 && S > 0){
				S--;
				n++;
			}
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
