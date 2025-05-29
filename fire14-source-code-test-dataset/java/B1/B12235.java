import java.util.*;
import java.io.*;

public class Main {

	char []a;
	BufferedReader in;
	StringTokenizer str = null;
	PrintWriter out;
	
	private String next() throws Exception{
		if (str == null || !str.hasMoreElements())
			str = new StringTokenizer(in.readLine());
		return str.nextToken();
	}
	
	private int nextInt() throws Exception{
		return Integer.parseInt(next());
	}
	
	public void run() throws Exception{
		in = new BufferedReader(new FileReader("in.txt"));
		out = new PrintWriter(new File("out.txt"));
		int t = nextInt();
		for(int i=1;i<=t;i++){
			solve(i);
		}
		out.close();
	}
	
	TreeSet<pair> set;
	private void solve(int x) throws Exception{
		int A = nextInt();
		int B = nextInt();
		set = new TreeSet<pair>();

		for(int i=A;i<=B;i++){
			String s = Integer.toString(i);
			for(int j=1;j<s.length();j++){
				if (s.charAt(j) == '0') continue;
				String t = s.substring(j) + s.substring(0, j);
				int k = Integer.parseInt(t);
				if (k == Integer.parseInt(s)) continue;
				if (set.contains(new pair(i, k))) continue;
				if (A <= k && k <= B){ 
					set.add(new pair(k, i));
				}
			}
		}
		out.println("Case #"+x+": " + set.size());
	}
	
	public static void main(String[] args) throws Exception{
		new Main().run();
	}
}
class pair implements Comparable<pair>{
	public int a,b;
	public pair(int a, int b){
		this.a = a;
		this.b = b;
	}
	public int compareTo(pair p){
		if (a > p.a) return 1;
		if (a < p.a) return -1;
		if (b > p.b) return 1;
		if (b < p.b) return -1;
		return 0;
	}
}