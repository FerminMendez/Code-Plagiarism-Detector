import java.io.*;
import java.util.Arrays;

public class Main{
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(finB.readLine());
		int test = 1;
		while(test <= t){
			int n = fnextInt();
			int s = fnextInt();
			int p = fnextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++){
				a[i] = fnextInt();
			}
			print(n + " " + s + " " + p + " ");
			for(int i = 0; i < n; i++){
				print(a[i] + " ");
			}
			int[] max = new int[n];
			for(int i = 0; i < n; i++){
				if(a[i] / 3 == 0){
					if(p == 2 && a[i] == 2 && s > 0){
						max[i] = a[i];
						s--;
						continue;
					}
					else if(a[i] == 2) max[i] = 1;
					else max[i] = a[i];
					continue;
				}
				if(a[i] % 3 == 0 && a[i] / 3 < p){
					if(s > 0 && a[i] / 3 + 1 == p){
						max[i] = a[i] / 3 + 1;
						s--;
						continue;
					}
				}
				if(a[i] % 3 == 2 && a[i] / 3 + 1 < p){
					if(s > 0 && a[i] / 3 + 2 == p){
						max[i] = a[i] / 3 + 2;
						s--;
						continue;
					}
				}
				max[i] = a[i] % 3 > 0 ? a[i] / 3 + 1 : a[i] / 3;
			}
			int ans = 0;
			for(int i = 0; i < n; i++){
				if(max[i] >= p) ans++;
			}
			fout.println("Case #" + test + ": " + ans);
			println("Case #" + test + ": " + ans);
			test++;
		}
		fout.flush();
	}
		
	private static PrintWriter out;
	private static BufferedReader inB;
	private static BufferedReader finB;
	private static PrintWriter fout;
	
	
	static {
		try {
			finB = new BufferedReader(new InputStreamReader(new FileInputStream("input.in")));
			fout = new PrintWriter(new FileOutputStream("output.txt"));
			out = new PrintWriter(System.out);
			inB = new BufferedReader(new InputStreamReader(System.in));
		} catch(Exception e) {e.printStackTrace();}
	}
	
	private static StreamTokenizer in = new StreamTokenizer(inB);
	private static StreamTokenizer fin = new StreamTokenizer(finB);
	
	private static void exit(Object o) throws Exception {
		out.println(o);
		out.flush();
		System.exit(0);
	}
	private static void println(Object o) throws Exception{
		out.println(o);
		out.flush();
	}
	private static void print(Object o) throws Exception{
		out.print(o);
		out.flush();
	}
	private static int fnextInt() throws Exception {
		fin.nextToken();
		return (int)fin.nval;
	}  
	private static int nextInt() throws Exception {
		in.nextToken();
		return (int)in.nval;
	}  
	private static String nextString() throws Exception {
		in.nextToken();
		return in.sval;        
	}
} 