import java.util.StringTokenizer;


public class DancingWithTheGooglers {
	public static int Solve(String q) {
		StringTokenizer st = new StringTokenizer(q, " ");
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int t;
		int d;
		int r;
		int ans = 0;
		
		while(st.hasMoreTokens()) {
			t = Integer.parseInt(st.nextToken());
			d = t / 3;
			r = t % 3;
			
			if(p - d <= 0) 
				ans++;
			else if(p - d == 1) {
				if(r != 0)
					ans++;
				else if(s > 0 && r == 0 && t != 0) {
					s--;
					ans++;
				}
			}
			else if(p - d == 2 && s > 0 && r == 2) {
				ans++;
				s--;
			}
		}
		
		return ans;
	}
}
