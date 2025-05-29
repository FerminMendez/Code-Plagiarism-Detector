import java.io.*;
import java.util.*;
import java.text.*;

public class ProblemC {
	
	public static void main(String[] args) {
		try {
			new ProblemC().solve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("D:\\input.in"));
    	Scanner scan = new Scanner(System.in);
    	PrintWriter out = new PrintWriter(System.out);

    	int T = scan.nextInt();
    	for (int i=0;i<T;i++) {
    		int A = scan.nextInt();
    		int B = scan.nextInt();
  
    		long f = find(A, B);
    		System.out.println("Case #" + (i+1) + ": " + f);
    	}

		out.flush();
		out.close();
		scan.close();
	}
	
	private long find(int A, int B) {
		long resx = 0;
		
		for (int i=A;i<B;i++) {
			resx += howmany(i, B);
		}
		
		return resx;
	}
	
	private long howmany(int n, int B) {
		long t = 0;
		String s = String.valueOf(n);
		Set<String> st = new HashSet<String>();
		
		for (int i=1;i<s.length();i++) {
			if (s.charAt(0) > s.charAt(i)) continue;
			String ssub = s.substring(i) + s.substring(0, i);
			int pn = Integer.parseInt(ssub);
			
			
			if (pn > n && pn <= B) {
				t++;
				if (!st.add(s+ssub)) {
					t--;
				}
				//System.out.println(n + ", " + ssub + " ++");
			} else {
				//System.out.println(n + ", " + ssub);
			}
		}
		
		return t;
	}
	
}
