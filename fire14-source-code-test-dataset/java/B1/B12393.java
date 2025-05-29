import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class GoogleC {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner scan = new Scanner(new File("B-small.txt"));
		//finit2();
		int n = scan.nextInt();
		for (int i = 0; i < n; i++){
			ht.clear();
			System.out.println("Case #" + (i+1) + ": " + sum(scan.nextInt(), scan.nextInt()));
		}
	}

	public static long sum(int a, int b){
		ht = new HashSet<Pair>();
		long ret = 0;
		for (int i = a; i <= b; i++){
			ret += run(i, a, b);
		}
		return ret;
	}

	public static HashSet<Pair> ht = new HashSet<Pair>();

	private static class Pair{
		int m, n;
		public Pair(int m, int n){
			this.m = m;
			this.n =n;
		}
		public int hashCode(){
			return 31*m+n;
		}

		@Override
		public boolean equals(Object o){
			Pair p = (Pair)o;
			return p.m == m && p.n == n;
		}
	}

	public static int run(Integer n, int a, int b){
		/*StringBuilder sb = new StringBuilder(n.toString());
		StringBuilder orig = new StringBuilder(n.toString());
		for (int i = 0; i < sb.length(); i++){
			sb = sb.substring(1);

		}*/
		int count = 0;
		String orig = n.toString();
		String cur = n.toString();
		for (int i = 0; i < orig.length()-1; i++){
			char c = cur.charAt(0);

			cur = cur.substring(1) + c;
			if (cur.charAt(0) == '0') continue;
			int k = Integer.parseInt(cur);
			if (a <= k && k < n && n <= b && cur.length() == orig.length()){
				Pair p = new Pair(k, n);
				if (!ht.contains(p)){
					count++;
					//System.out.println(k + " " + n);
					ht.add(p);
				}
			}
		}
		return count;
		/*char[] cur = n.toString().toCharArray();
		int count = 0;
		for (int start = 1; start < cur.length; start++){
			boolean failed = false;
			if (arr[start] == 0){
				failed = true;
			}
			for (int i = 0; !failed && i < cur.length; i++){
				if (cur[(start+i)%cur.length] != cur[i]){
					failed = true;
				}
			}
			if (!failed){
				count++;
			}
		}*/
	}

	public static void init2(){
		for (int i = 2; i < arr.length; i++){
			//run(i);
		}
	}

	public static boolean check(Integer a, Integer b){
		if (a.toString().length() != b.toString().length()) return false;
		if (a==123 && b==231){
			System.out.println("here");
		}
		String str = a.toString() + a.toString();
		return str.contains(b.toString());
	}

	public static void init(){
		for (int i = 2; i < arr.length; i++){
			int count = 0;
			for (int j = 1; j < i; j++){
				if (check(j, i)) count++;
			}
			arr[i] = count + arr[i-1];
		}
	}

	static int cap = 3000;
	public static int[] arr = new int[cap+1];

	public static int doit(int n, int m){
		return arr[m] - arr[n];
	}

}
