

import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.*;

public class ProblemC_Qual_2012 implements Runnable{
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");
	
	void init() throws FileNotFoundException{
		in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		out = new PrintWriter("output.txt");
	}
	
	String readString() throws IOException{
		while(!tok.hasMoreTokens()){
			try{
				tok = new StringTokenizer(in.readLine());
			}catch (Exception e){
				return null;
			}
		}
		return tok.nextToken();
	}
	
	int readInt() throws IOException{
		return Integer.parseInt(readString());
	}
	
	long readLong() throws IOException{
		return Long.parseLong(readString());
	}
	
	double readDouble() throws IOException{
		return Double.parseDouble(readString());
	}
	
	public static void main(String[] args){
		new Thread(null, new ProblemC_Qual_2012(), "", 256 * (1L << 20)).start();
	}
	
	long timeBegin, timeEnd;

	void time(){
		timeEnd = System.currentTimeMillis();
		System.err.println("Time = " + (timeEnd - timeBegin));
	}
	
	long memoryTotal, memoryFree;
	

	void memory(){
		memoryFree = Runtime.getRuntime().freeMemory();
		System.err.println("Memory = " + ((memoryTotal - memoryFree) >> 10) + " KB");
	}
	
	void debug(Object... objects){
		if (DEBUG){
			for (Object o: objects){
				System.err.println(o.toString());
			}
		}
	}
	
	public void run(){
		try{
			timeBegin = System.currentTimeMillis();
			memoryTotal = Runtime.getRuntime().freeMemory();
			init();
			solve();
			out.close();
			time();
			memory();
		}catch (Exception e){
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
	
	boolean DEBUG = false;
	
	void solve() throws IOException{
		int t = readInt();
		for (int it = 1; it <= t; it++){
			out.print("Case #" + it + ": ");
			
			int a = readInt();
			int b = readInt();
			
			boolean[] used = new boolean[b+1];
			
			int x = a;
			int pow = 1;
			while (x >= 10){
				x /= 10;
				pow *= 10;
			}
			
			long res = 0;
			for (int i = a; i <= b; i++){
				if (used[i]) continue;
				
				x = i;
				long count = 0;
				do{
					if (x / pow != 0 && x >= a && x <= b){
						used[x] = true;
						count++;
					}
					x = x % pow * 10 + (x / pow);
				}while (x != i);
				
				used[i] = true;
				res += (count - 1) * count / 2;
			}
			
			out.println(res);
		}
	}
}

