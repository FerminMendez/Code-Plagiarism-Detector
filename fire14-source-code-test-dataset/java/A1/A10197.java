import java.util.*;

public class ProbB {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in).useDelimiter("\n");
		
		int t = s.nextInt();
		String[] lines = new String[t];
		
		for(int i = 0; i < t; i++) {
			lines[i] = s.next();
		}
		
		s.close();
		
		for(int i = 0; i < t; i++) {
			//System.out.println(lines[i]);
			System.out.println("Case #" + (i+1) + ": " + solve(lines[i]));
		}
	}
	
	private static int solve(String ln) {
		Scanner s2 = new Scanner(ln);
		
		int n = s2.nextInt(); // Number of Googlers
		int s = s2.nextInt(); // Number of surprising cases
		int p = s2.nextInt(); // result of at least p?
		int[] tPoints = new int[n]; // array of each Googler's total points
		
		for(int i = 0; i < n; i++) {
			tPoints[i] = s2.nextInt();
			//System.out.println(tPoints[i]);
		}
		
		s2.close();
		
		int total = 0;
		int firstChk = Math.max(3*p - 2, p);
		int scdChk = Math.max(3*p - 4, p);
		
		for(int i = 0; i < n; i++) {
			
			if(tPoints[i] >= firstChk) {
				total++;
				continue;
			}
			else if((tPoints[i] >= scdChk) && (s > 0)) {
				total++;
				s--;
				continue;
			}
		}
		
		return total;
	}

}
