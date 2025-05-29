import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C {

	
	private void run() throws IOException {
		// put your code here ..
		
		int testcases=nextInt();
		
		int number=1;
		
		

		
		
		while(testcases-->0){
			long answer=0;
			
			int A=nextInt();
			int B=nextInt();
			

			
			

			for (int i = A; i < B; i++) {
				String a=new String(i+"");
				ArrayList<String> hash=new ArrayList<String>();
				for (int j = 1; j < a.length(); j++) {
					String now =a.charAt(a.length()-1)+a.substring(0,a.length()-1);
					int n=Integer.parseInt(now);
					String nlen=n+"";
					
					if(nlen.length()!=now.length()||nlen.equals(a)||n<=i||hash.contains(n+"")){
						a=now;
						continue;
					}
					

					if(n<=B){
						hash.add(n+"");
						answer++;
						
					}
					a=now;
					
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
	
	public C() throws IOException {
		//Input Output for Console to be used for trying the test samples of the problem 
//		in = new BufferedReader(new InputStreamReader(System.in));
//		out = new PrintWriter(System.out);
		//-------------------------------------------------------------------------
		//Input Output for File to be used for solving the small and large test files
		in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		out = new PrintWriter("output3.txt");
		//-------------------------------------------------------------------------
		//Initialize Stringtokenizer input
		input = new StringTokenizer(in.readLine());
	}
	
	public static void main(String[] args) throws Exception {
		//-------------------------------------------------------------------------
		//initializing...
		C sol = new C();
		//-------------------------------------------------------------------------
		sol.run();
		//-------------------------------------------------------------------------
		//closing up
		sol.end();
		//--------------------------------------------------------------------------
	}
	
}
