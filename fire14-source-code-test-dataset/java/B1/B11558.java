import java.io.*;
import static java.lang.Math.*; 
import static java.math.BigInteger.*; 
import static java.util.Arrays.*; 
import static java.util.Collections.*; 
import java.math.*; 
import java.util.*;

import static java.lang.Math.*;
public class RecycledNumbers {
	public static void main (String [] args) throws IOException {
		String[]filename="test A-small A-large B-small B-large C-small C-large D-small D-large".split(" ");
		////////////////// 0      1       2       3       4       5       6       7       8
		String fn=filename[5];
		f = new BufferedReader(new FileReader(fn+".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fn+".out")));
		
		nl();
		int[]p10=new int[]{1,10,100,1000,10000,100000,1000000,10000000};
		int t = ip(tk());
		for (int i = 0; i < t; i++) {
			nl();
			boolean[]mark=new boolean[2000001];
			int a = ip(tk()),b=ip(tk());
			int res=0;
			int bitcnt=1;
			for (int j = 1;j<p10.length; j++) {
				if(a>=p10[j])bitcnt=j+1;
			}
			for (int j = a; j <= b; j++) {
				if(mark[j])continue;
				if(j>=p10[bitcnt])bitcnt++;
				int cur=j;
				int cnt=0;
				for (int k = 0; k < bitcnt; k++) {
					if(cur>=p10[bitcnt-1]&&cur>=a&&cur<=b&&mark[cur]==false){
						mark[cur]=true;
						cnt++;
					}
					int next=cur%10*p10[bitcnt-1]+cur/10;
					cur=next;
				}
				if(cnt>=2){
					res+=cnt*(cnt-1)/2;
				}
			}
			out.println("Case #"+(i+1)+": "+res);
		}
		
		out.close();
		System.exit(0);
	}
	static BufferedReader f;
	static StringTokenizer st;
	static void nl() throws IOException
	{
		st = new StringTokenizer(f.readLine());
	}
	static String tk()
	{
		return st.nextToken();
	}
	static void fill(Object array,int val){
		if(array instanceof int[])Arrays.fill((int[])array,val);
		else for(Object o:(Object[])array)fill(o,val);
	}
    //static String min(String a,String b){return a.compareTo(b)<0?a:b;}
	static int ip(String s){return Integer.parseInt(s);}
	static long lp(String s){return Long.parseLong(s);}
	static int inf=Integer.MAX_VALUE/2;
	static int gcd(int a,int b){return b==0?a:gcd(b,a%b);}
	static boolean isPrime(int number)
    {
    	if (number < 2) return false;
    	if (number == 2) return true;
    	if (number % 2 == 0) return false;
    	for (int i = 3; i * i <= number; i += 2)
    		if (number % i == 0) return false;
    	return true;
    }
	static public class Comp implements Comparable<Comp> {
        public int compareTo(Comp other) {// myself first asc
            if (len == other.len)
                return str.compareTo(other.str);// myself first asc
            return other.len - len;// other first desc
        }

        int len;
        String str;
        public Comp(int len, String str) {
            super();
            this.len = len;
            this.str = str;
        }
    }
}
