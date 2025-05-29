import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class ProblemB {
	


	
	
	// *************************************************************************************
	// *********************************** FRAMEWORK ***************************************
	// *************************************************************************************
	
	public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static boolean isStandardInput = false;
	
	public static File input;
	public static FileReader inputreader;
	public static BufferedReader in;
	
	public static File output;
	public static FileWriter outputwriter;
	public static BufferedWriter out;
	
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		doSTDIN(true);
		setOutput("test.out");
		run();
		close();
	}
	
	public static void run() throws Exception {
		
		
		init("E:\\workspace\\2012\\src\\B-small");
		
		int cases = INT();
		
		for(int cc = 1;cc<=cases;cc++) {
			StringBuffer outputString = new StringBuffer(100);	
			int dancers = INT();
			int s = INT();
			int p = INT();
			
			
			int scores [] = new int [dancers];
			
			for (int i=0; i < dancers; i++){
				scores[i] = INT();
			}
			
			int count = 0;
			for (int i=0; i<dancers; i++){

				if (p==0){
					count++;
					continue;
				}
				
				int x = scores[i];
				
				if (x==0){
					continue;
				}
				
				
				int result = x / 3;
				int reminder = x % 3;
				int dif = p - result;

				
				if (result + reminder < p - 2){
					continue;
				}
				
				if (result >= p){
					count++;
					continue;
				}
				
				
				
				
				switch (dif) {
				case 2:
					switch (reminder) {
					case 2:
						if (--s >=0){
							count++;
						}
						break;
					default:
						break;
					}
					break;
				case 1:
					switch (reminder) {
					case 2:
							count++;
						break;
					case 1:
							count++;
						break;
					case 0:
						if (--s>= 0){
							count++;
						}
					break;
					default:
						break;
					}
					break;
				case 0:
					break;

				default:
					break;
				}
				
			}
			
			print("Case #"+cc+": ");
			println(count);
			
		}
		
	}
	
	
	
	public static void init(String problemName) throws Exception {
		doSTDIN(false);
		setInput(problemName+".in");
		setOutput(problemName+".out");
	}
	
	// **************** PRINT METHODS **********************
	
	public static void println() throws IOException {
		out.write("\n");
		System.out.println();
	}
	
	public static void println(Object obj) throws IOException {
		out.write(obj.toString());
		out.write("\n");
		System.out.println(obj.toString());
	}
	
	public static void print(Object obj) throws IOException {
		out.write(obj.toString());
		System.out.print(obj.toString());
	}
	
	public static void println(long number) throws IOException {
		out.write(Long.toString(number));
		out.write("\n");
		System.out.println(number);
	}
	
	public static void print(long number) throws IOException {
		out.write(Long.toString(number));
		System.out.print(number);
	}
	
	public static void println(char c) throws IOException {
		out.write(Character.toString(c));
		out.write("\n");
		System.out.println(c);
	}
	
	public static void print(char c) throws IOException {
		out.write(Character.toString(c));
		System.out.print(c);
	}
	
	public static void println(String line) throws IOException {
		out.write(line);
		out.write("\n");
		System.out.println(line);
	}
	
	public static void print(String line) throws IOException {
		out.write(line);
		System.out.print(line);
	}
	
	// ******************** INPUT DECLARATION ******************
	
	public static void doSTDIN(boolean standard) {
		isStandardInput = standard;
	}
	
	public static void setInput(String filename) throws IOException {
		input = new File(filename);
		inputreader = new FileReader(input);
		in = new BufferedReader(inputreader);
	}
	
	public static void setOutput(String filename) throws IOException {
		output = new File(filename);
		outputwriter = new FileWriter(output);
		out = new BufferedWriter(outputwriter);
	}
	
	public static void close() throws IOException {
		if(in!=null)in.close();
		if(inputreader!=null)inputreader.close();
		
		if(out!=null)out.flush();
		if(out!=null)out.close();
		if(outputwriter!=null)outputwriter.close();
	}
	
	// ************************** INPUT READING *****************
	
	static String LINE() throws IOException { return isStandardInput?stdin.readLine():in.readLine(); }
	static String TOKEN() throws IOException {
		while (st == null || !st.hasMoreTokens())st = new StringTokenizer(LINE());
		return st.nextToken();
	}
	static int INT() throws IOException {return Integer.parseInt(TOKEN());}
	static long LONG() throws IOException {return Long.parseLong(TOKEN());}
	static double DOUBLE() throws IOException {return Double.parseDouble(TOKEN());}
	static BigInteger BIGINT() throws IOException {return new BigInteger(TOKEN());}


}
