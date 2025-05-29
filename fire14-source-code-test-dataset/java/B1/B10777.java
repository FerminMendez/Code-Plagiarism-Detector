import java.util.Scanner;

/*
 * Google Code Jam 2012
 * Program by Tommy Ludwig
 * Problem: Recycled Numbers
 * Date: 2012-04-13
 * Time: 02:08 AM
 */


public class recycle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int A, B, n, m, y = 0;
			A = in.nextInt();
			B = in.nextInt();
			
			for (int j = 0; j < (B-A); j++) {
				m = B - j;
				String strM = String.valueOf(m);
				
				for (int k = 0; k < (B-A); k++) {
					n = A + k;
					//n must be less than m
					if (n >= m)
						break;
					
					String strN = String.valueOf(n);
					
					for (int l = 1; l < strN.length(); l++) {
						String sub = strN.substring(l);
						String new_strN = sub + strN.substring(0, l);
						
						if (new_strN.equalsIgnoreCase(strM)) {
							y++;
							break;
						}
					}
				}
			}
			System.out.printf("Case #%d: %d\n", i, y);
		}
	}

}
