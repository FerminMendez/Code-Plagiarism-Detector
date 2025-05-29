import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(new FileOutputStream(new File("output.txt")), false);
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
		// StringTokenizer st = new StringTokenizer(in.readLine());
		// Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(in.readLine());
		
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int len = len(a);
			int ten = (int)Math.pow(10, len-1);
			
			int res = 0;

			for(int j = a;j <= b;j++) {
				int cur = j;
				int val = j;
				int per = period(j,len);
				for(int k = 0;k < per;k++) {
					int c = val%10;
					val = val/10+c*ten;
					if(val > cur && val <= b) {
						res++;
					}
				}
 			}
			out.println("Case #"+(i+1)+": "+res);
			out.flush();
		}
	}
	
	public static int period(int n, int len) {
		if(len == 2 && n/10 == n%10) return 1;
		if(len == 4 && n%100 == n/100) return 2;
		if(len == 6 && n%100 == n/10000 && n%100 == n/100%100) return 2;
		if(len == 6 && n%1000 == n/1000) return 3;
		return len;
	}
	
	public static int len(int n) {
		int len = 0;
		while(n > 0) {
			n /= 10;
			len++;
		}
		return len;
	}

}