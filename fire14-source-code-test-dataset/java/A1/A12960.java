import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;



public class RQB {
	
	private static BufferedReader in;
	private static PrintWriter out;
	private static StringTokenizer input;
	
	
	public static void main(String[] args) throws IOException {
		//Initializing ...
	 	
		int [] maxa = new int[31];int a =0;int b =1;
		for (int i = 1; i <= 30; i++) {
			maxa[i]=b;a++;if(a==3){a=0;b++;}
		}
		int [] maxb = new int[31];a =0;b =2;
		for (int i = 2; i <= 30; i++) {
			maxb[i]=b;a++;if(a==3){a=0;b++;}
		}
		new RQB();
		//-------------------------------------------------------------------------
		int testCases = nextInt();
		int counter=0;
		while (testCases -- > 0){
			counter++;
			//Here put the code..:)
			int n = nextInt();
			int s = nextInt();
			int p = nextInt();
			int [] ns = new int[n];
			for (int i = 0; i < ns.length; i++)ns[i]=nextInt();
			Arrays.sort(ns);
			int ret = 0;
			for (int i = 0; i < ns.length; i++) {
				if(s>0){
					if(ns[i]>=2&&ns[i]<=28){
						if(maxb[ns[i]]>=p){s--;ret++;}
					}else{
						if(maxa[ns[i]]>=p)ret++;
					}
				}else{
					if(maxa[ns[i]]>=p)ret++;
				}
			}
			
			writeln("Case #"+counter+": "+ret);
		}
		//-------------------------------------------------------------------------
		//closing up
		end();
		//--------------------------------------------------------------------------

	}
	
	public RQB() throws IOException {
		//Input Output for Console to be used for trying the test samples of the problem 
		in = new BufferedReader(new InputStreamReader(System.in));
//		out = new PrintWriter(System.out);
		//-------------------------------------------------------------------------
		//Input Output for File to be used for solving the small and large test files
//		in = new BufferedReader(new FileReader("RQB.in"));
		out = new PrintWriter("RQB.txt");
		//-------------------------------------------------------------------------
		//Initalize Stringtokenizer input
		input = new StringTokenizer(in.readLine());
	}

	private static int nextInt() throws IOException {
		if (!input.hasMoreTokens())input=new StringTokenizer(in.readLine());
		return Integer.parseInt(input.nextToken());
	}
	private static long nextLong() throws IOException {
		if (!input.hasMoreTokens())input=new StringTokenizer(in.readLine());
		return Long.parseLong(input.nextToken());
	}
	private static double nextDouble() throws IOException {
		if (!input.hasMoreTokens())input=new StringTokenizer(in.readLine());
		return Double.parseDouble(input.nextToken());
	}
	private static String nextString() throws IOException {
		if (!input.hasMoreTokens())input=new StringTokenizer(in.readLine());
		return input.nextToken();
	}
	private static void write(String output){
		out.write(output);
		out.flush();
	}
	private static void writeln(String output){
		out.write(output+"\n");
		out.flush();
	}
	private static void end() throws IOException{
		in.close();
		out.close();
		System.exit(0);
	}
	
}
