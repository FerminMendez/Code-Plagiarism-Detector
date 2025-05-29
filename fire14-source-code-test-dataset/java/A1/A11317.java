import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Dancing {
	static int s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int [] a;
		int n, p, res;		
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
		//	System.out.println(n+ "  " +s+ "  " + p);
			a = new int [n];
			for(int j = 0 ; j < n ; j ++)
				a[j] = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < n ; j ++)
				res += check(a[j], p);
			System.out.println("Case #" + i + ": "+res);
		}
	}
	private static int check(int i, int p) {
		int a,b,c;
		a = i/3;
		b = (i-a)/2;
		c = i - (a+b);
	//	System.out.println(i + " lol" +a+" hena" + c);
		if(c >= p)
			return 1;
		if((c == a || c == b ) && c+1 >= p && (a != 0 || b != 0)&& s > 0){
			s--;
			return 1;
		}
		return 0;
	}
}
