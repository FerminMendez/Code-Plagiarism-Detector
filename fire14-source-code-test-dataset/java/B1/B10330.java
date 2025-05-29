import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


public class q3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	public static String next() throws Exception {
		while (true) {
			if (st.hasMoreTokens())
				return st.nextToken();
			String s = br.readLine();
			if (s == null)
				return null;
			st = new StringTokenizer(s);
		}
	}
	public static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}
	
	public static void main(String[] args) throws Exception {
		int T = nextInt();
		
		for(int t = 1 ; t <=T ; t++){
			HashSet<Point> set  = new HashSet<Point>();
			set.add(new Point(1,2));

			int A = nextInt();
			int B = nextInt();
			int n = (""+A).length();
			int count = 0;
			for(int i = A ; i <= B ; i ++){
				int d = 10;
				int c = 1;
				while(i/d >0){
					int temp = i/d;
					temp += (i%d) * Math.pow(10, n-c);
					if(temp<=B && temp > i){
						if(set.contains(new Point(i , temp)))
							;
						else
							count++;
					}
						
					d *= 10;
					c++;
				}
			}
			
			System.out.println("Case #" + t + ": "+count );
		}
		
		
	}
}
