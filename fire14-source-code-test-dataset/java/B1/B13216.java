import java.util.*;
import java.io.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;

public class C {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int t = parseInt(br.readLine());
		for(int z=1;z<=t;z++) {
			String[] ss = br.readLine().trim().split("\\s+");
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int a = parseInt(ss[0]);
			int b = parseInt(ss[1]);
			for(int n=a;n<=b;n++) {
				String s = go(n);
				if(map.containsKey(s)) {
					map.put(s,map.get(s)+1);
				} else {
					map.put(s,1);
				}
			}
			long ans = 0;
			for(int x : map.values()) {
				ans += (long)x*(x-1)/2;
			}
			// out.println(map);
			out.println("Case #"+z+": "+ans);
		}
	}
	
	static int p[] = {0, 1,10,100,1000,10000,100000,1000000,10000000};
	
	static String go(int n) {
		int c = 0;
		int x = n;
		while(x > 0) {
			x /= 10;
			c++;
		}
		int max = 0;
		for(int i=0;i<c;i++) {
			max = max(max,n);
			n = (n/10) + (n%10)*p[c];
		}
		return max+"";
	}
}