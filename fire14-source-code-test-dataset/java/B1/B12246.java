import java.util.Scanner;


public class C {
	public static boolean recycled(int n, int m) {
		if (n == m) {
			return false;
		} else {
			String A = String.valueOf(n);
			A += A;
			String B = String.valueOf(m);
			return A.contains(B);
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for (int i = 0; i < T; i++) {
			int A = s.nextInt();
			int B = s.nextInt();
			
			int count = 0;
			
			for (int j = A; j <= B; j++) {
				for (int k = A; k <= B; k++) {
					if (recycled(j, k)) {
						count++;
					}
				}
			}
			System.out.print("Case #" + (i + 1) + ": ");
			System.out.println(count / 2);
		}
	}
}
