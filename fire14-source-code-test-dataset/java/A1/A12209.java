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
	
	private void solve(int x) throws Exception{
		int n = nextInt();
		int s = nextInt();
		int p = nextInt();
		int ret = 0;
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = nextInt();
		
		for(int i=0;i<n;i++){
			int k = a[i]/3;
			int r = a[i]%3;
			if (r == 0){
				if (k >= p){
					ret++;
				}else{
					if (k > 0 && k + 1 >= p && s > 0){
						ret++;
						s--;
					}
				}
			}else if (r == 1){
				if (k + 1 >= p){
					ret++;
				}
			}else{
				if (k + 1 >= p){
					ret++;
				}else{
					if (k + 2 >= p && s > 0){
						ret++;
						s--;
					}
				}
			}
		}
		out.println("Case #" + x + ": " + ret);
	}
	
	public static void main(String[] args) throws Exception{
		new Main().run();
	}
}
