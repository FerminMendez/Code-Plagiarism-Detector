import java.io.*;
import java.util.*;
class c {
	public static int count(String A, String B) {
		int count=0;
		int a = Integer.parseInt(A);
		int b = Integer.parseInt(B);
		for(int i=a; i<=b;i++) {
			int n = i;
			int len = String.valueOf(i).length();
			for(int j= 1;j < len;j++) {
				String mod = String.valueOf(i).substring(len-j, len) + String.valueOf(i).substring(0, len - j);
				int m = Integer.parseInt(mod);
				if(a<=n && n<m && m<=b)  {
					count ++;
				}
			}
		}
		return count;
	}
	public static void main(String args[])throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int i=0;i<T;i++) {
			String line = in.readLine();
			String n[] = line.split(" ");
			System.out.println("Case #" + (i+1) + ": " + count(n[0] , n[1]));
		}
	}
}
