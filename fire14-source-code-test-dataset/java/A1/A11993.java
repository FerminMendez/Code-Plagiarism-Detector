import java.util.*;
import java.io.*;

public class A
{
	private Scanner reader;
	private PrintWriter writer;
	
	public A(String inFile, String outFile)
	{
		try {
			reader = new Scanner(new File(inFile));
			writer = new PrintWriter(new File(outFile));
			init();
		}
		catch (Exception ex ) {
			ex.printStackTrace();
		}	
	}
	
	private void init() {
		int T = reader.nextInt();
		for (int i=1; i<=T; i++) {
			int N = reader.nextInt();
			int S = reader.nextInt();
			int p = reader.nextInt();
			int med = p*3;
			int vlow = med - 2;
			if (vlow < p)
				vlow = p;
			int slow = med - 4;
			if (slow < p)
				slow = p;
			int res = 0;
			for (int j=0; j<N; j++) {
				int k = reader.nextInt();
				if (k >= vlow) {
					res ++;
				}
				else if ( k >= slow && S > 0) {
					res++;
					S--;
				}
			}
			
			String out = "Case #"+i+": " + res +"\n";
			writer.write(out);
			writer.flush();
		}
		
		writer.close();
	}
	
	public static void main(String[] args) 
	{
		new A("/Users/prabhaks/work/workspace/Test/src/in.txt", "/Users/prabhaks/work/workspace/Test/src/out.txt");
	}
}