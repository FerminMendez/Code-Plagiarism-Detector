import java.util.*;

public class B {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		for (int i=1; i<=cases; i++) {
			int n = s.nextInt();
			int surprising = s.nextInt();
			int p = s.nextInt();
			int number = 0;
			for (int j=0; j<n; j++) {
				int t = s.nextInt();
				int m = t/3;
				int remind = t%3;
				if ((remind == 0)&&(t!=0)) {
					if (m>=p) number++;
					else
					if ((m+1) >= p) {
						surprising--;
						if (surprising >=0) number++;
					}
				}
				
				if (t==0) 
					if (t >= p) number++;
				
				if (remind == 1) {
					if ((m+1) >= p) number++;
				}
				
				if (remind == 2) {
					if ((m+1) >= p) number++;
					else
					if ((m+2) >= p) {
						surprising--;
						if (surprising >=0) number++;
					}
				}
				
			}
			System.out.println("Case #" + i + ": " + number);
		}
	}
}