import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
	public boolean equals(Pair p){
		return this.x == p.x && this.y ==p.y;
	}
}
public class RecycledNumbers {

	static int [] x = new int [300];
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int A,B;
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			System.out.println("Case #" + i + ": "+get(A,B));
		}
	}

	private static int get(int a, int b) {
		int res = 0;
		for (int i = a; i < b; i++) {
			res += recycled(i,b);
		}
		return res;
	}

	private static int recycled(int a, int lim) {
		HashSet<Integer> set = new HashSet<Integer>();
		int b = a,c;
		String s = a+"";
		int len =s.length()-1;
		for(int i = 0 ; i <= len ; i++ ){
			c = (int) (b/10 + b%10* Math.pow(10, len));
			if(c > a && c <= lim){
				set.add(c);
			}
			b = c;
		}
		return set.size();
	}
}
