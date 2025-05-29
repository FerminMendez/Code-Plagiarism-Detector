

import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.*;

public class ProblemB_Qual_2012 implements Runnable{
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");
	
	void init() throws FileNotFoundException{
		in = new BufferedReader(new FileReader("B-small-attempt0.in"));
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
		new Thread(null, new ProblemB_Qual_2012(), "", 256 * (1L << 20)).start();
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
		int[] a = new int[3];
		
		int t = readInt();
		for (int it = 1; it <= t; it++){
			out.print("Case #" + it + ": ");
			
			int count = 0;
			
			int n = readInt();
			int s = readInt();
			int p = readInt();
			
			int[] b = new int[n];
			for (int i = 0; i < n; i++){
				b[i] = readInt();
			}
			Arrays.sort(b);
			
			boolean[] used = new boolean[n];
			
			for (int i = 0; i < n; i++){
				int x = b[i];
				
				for (int j = 0; j < 3; j++){
					a[j] = x / 3;
				}
				
				x %= 3;
				for (int j = 2; x > 0; j--, x--){
					a[j]++;
				}
				
				if (a[2] >= p){
					count++;
					continue;
				}
				
				if (a[2] == a[1]){
					if (s > 0 && a[2] == p - 1 && a[1] > 0 && a[2] < 10){
						used[i] = true;
						s--;
						count++;
					}
				}
			}
			
			if (s > 0){
				for (int i = 0; i < n && s > 0; i++){
					if (used[i]) continue;
					
					int x = b[i];
					
					for (int j = 0; j < 3; j++){
						a[j] = x / 3;
					}
					
					x %= 3;
					for (int j = 2; x > 0; j--, x--){
						a[j]++;
					}
					
					if (a[2] == a[1]){
						if (a[2] < 10 && a[1] > 0){
							used[i] = true;
							s--;
						}
					}else if (a[1] == a[0]){
						if (a[1] < 10 && a[0] > 0){
							used[i] = true;
							s--;
						}
					}
				}
			}
			
			if (s > 0){
				System.err.println("AHTUNG!!!!! TEST #" + it);
			}
			out.println(count);
		}
	}
}

