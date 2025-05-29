import java.util.Scanner;


public class Q3 {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(Q2.class.getResourceAsStream("C-small-attempt0.in"));
		
		int nTests = s.nextInt();
		
		int iTests = 1;
		while (nTests-- > 0) {
			
			int resp = 0;
			
			int m = s.nextInt();
			int n = s.nextInt();
			
			//boolean[][] criv = new boolean[n-m+1][n-m+1];
			boolean[] criv = new boolean[n-m+1];
			
			for (int i = 0; i < criv.length; i++) {
				
				
				
				int current = m + i;
				String currentString = String.valueOf(current);
				
				if (currentString.charAt(0) == '0') continue;
				
				if (criv[current - m]) continue;
				
				criv[current - m] = true;
				
				int nInterv = 0;
				for (int j = 1; j < currentString.length(); j++) {
					String invString = currentString.substring(j).concat(currentString.substring(0, j));
					Integer inv = Integer.valueOf(invString);
					
					
					if (invString.charAt(0) == '0') continue;
					if (invString.equals(currentString)) continue;
					if (inv > n || inv < m) continue;
					
					if (criv[inv - m]) continue;

					criv [inv-m] = true;
					
					nInterv ++;
					
					//System.out.println(currentString + " --- " + invString);
				}
				
				if (nInterv > 0) {
					int bbb = nInterv + 1;
					resp+= factorial(bbb) / (2 * factorial(bbb-2));
				}
				
				
				
			}
			
			
			System.out.println("Case #" + iTests + ": " + resp);
			
			iTests++;
		}
		
	}
	
	public static long factorial( int n )
    {
        if( n <= 1 )     // base case
            return 1;
        else
            return n * factorial( n - 1 );
    }

}
