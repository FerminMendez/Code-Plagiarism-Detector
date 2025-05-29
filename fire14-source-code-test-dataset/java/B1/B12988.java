import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class RQC {
	
	private static BufferedReader in;
	private static PrintWriter out;
	private static StringTokenizer input;
	
	
	public static void main(String[] args) throws IOException {
		//Initializing ...
	 	new RQC();
		//-------------------------------------------------------------------------
		int testCases = nextInt();
		int counter=0;
		while (testCases -- > 0){
			counter++;
			//Here put the code..:)
			int a = nextInt();
			int b = nextInt();
			int ret=0;
			for (int i = a; i <= b; i++) {
				for (int j = i+1; j <=b; j++) {
					if(cir(""+i,""+j))ret++;
				}
			}
			
			writeln("Case #"+counter+": "+ret);
		}
		//-------------------------------------------------------------------------
		//closing up
		end();
		//--------------------------------------------------------------------------

	}
	
	private static boolean cir(String a, String b) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length(); i++) {
			boolean t = true;
			for (int j = 0; j < a.length(); j++) {
				if(a.charAt(j)!=b.charAt((j+i)%b.length())){t=false;break;}
			}
			if(t)return true;
		}
		return false;
	}

	

	public RQC() throws IOException {
		//Input Output for Console to be used for trying the test samples of the problem 
		in = new BufferedReader(new InputStreamReader(System.in));
//		out = new PrintWriter(System.out);
		//-------------------------------------------------------------------------
		//Input Output for File to be used for solving the small and large test files
//		in = new BufferedReader(new FileReader("RQC.in"));
		out = new PrintWriter("RQC.in");
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
