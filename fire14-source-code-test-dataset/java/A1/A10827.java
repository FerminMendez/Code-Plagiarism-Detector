import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B {

	
	private void run() throws IOException {
		// put your code here ..
		
		String read=in.readLine();
		int testcases=Integer.parseInt(read);
		
		int number=1;
		
		while(testcases-->0){
			StringTokenizer tokens=new StringTokenizer(in.readLine());
			int answer=0;
			
			int N=Integer.parseInt(tokens.nextToken());
			int S=Integer.parseInt(tokens.nextToken());
			int P=Integer.parseInt(tokens.nextToken());
			
			if(P==0){
				writeln("Case #"+(number++)+": "+N);
				continue;
			}
			int mincount=P==1?1:3*(P-1)-1;
			
			
			for (int i = 0; i < N; i++) {
				int x=Integer.parseInt(tokens.nextToken());
				
				if(x<mincount)continue;
				
				int divideX=x/3;
				
				int inc=1;
				
				if(x%3==0)inc=0;
				
				if((divideX+inc)>=P){
					answer++;
				}
				else{
					if(S<=0)continue;
					
					if((divideX+2)>=P){
						answer++;
						S--;
					}
					
				}
			}

				
			
			writeln("Case #"+(number++)+": "+answer);
		}
		
		
	}
	
	
	
	
	

	private int nextInt() throws IOException {
		if (!input.hasMoreTokens())input=new StringTokenizer(in.readLine());
		return Integer.parseInt(input.nextToken());
	}
	private long nextLong() throws IOException {
		if (!input.hasMoreTokens())input=new StringTokenizer(in.readLine());
		return Long.parseLong(input.nextToken());
	}
	private double nextDouble() throws IOException {
		if (!input.hasMoreTokens())input=new StringTokenizer(in.readLine());
		return Double.parseDouble(input.nextToken());
	}
	private String nextString() throws IOException {
		if (!input.hasMoreTokens())input=new StringTokenizer(in.readLine());
		return input.nextToken();
	}
	private void write(String output){
		out.write(output);
		out.flush();
	}
	private void writeln(String output){
		out.write(output+"\n");
//		out.flush();
	}
	private void end() throws IOException{
		in.close();
		out.close();
		System.exit(0);
	}
	
	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer input;
	
	public B() throws IOException {
		//Input Output for Console to be used for trying the test samples of the problem 
//		in = new BufferedReader(new InputStreamReader(System.in));
//		out = new PrintWriter(System.out);
		//-------------------------------------------------------------------------
		//Input Output for File to be used for solving the small and large test files
		in = new BufferedReader(new FileReader("B-small-attempt0.in"));
		out = new PrintWriter("output2.txt");
		//-------------------------------------------------------------------------
		//Initialize Stringtokenizer input
		
	}
	
	public static void main(String[] args) throws Exception {
		//-------------------------------------------------------------------------
		//initializing...
		B sol = new B();
		//-------------------------------------------------------------------------
		sol.run();
		//-------------------------------------------------------------------------
		//closing up
		sol.end();
		//--------------------------------------------------------------------------
	}
	
}
