import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
	static long calc(long A, long B) {
		long d[] = new long[100];
		long res = 0;
		for (long a = A; a<=B; a++) {
			long t = a;
			int n = 0;
			while (t > 0) {
				d[n++] = (t % 10);
				t /= 10;
			}
			Set<Long> set = new HashSet<Long>(); 
			for (int i=1; i<n; i++) {
				if (d[i-1]==0) continue;
				long b = 0;
				for (int j=i-1; j>=0; j--)
					b = b*10 + d[j];
				for (int j=n-1; j>=i; j--)
					b = b*10 + d[j];				
				if (a < b && b <= B && !set.contains(b)) {
					res++;
					set.add(b);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) throws Exception {
		/*System.out.println(calc(10, 40));
		System.out.println(calc(1, 9));
		System.out.println(calc(100, 500));
		System.out.println(calc(1111, 2222));
		for (int i =0; i<50; i++)
			System.out.println(calc(1000000, 2000000));*/
		Scanner scanner = new Scanner(new File("c.in"));
		int T = scanner.nextInt();
		PrintWriter pw = new PrintWriter(new File("c.out"));
		for (int i=0; i<T; i++) {
			pw.printf("Case #%d: ", i+1);
			long a = scanner.nextLong(),
					b = scanner.nextLong();
			pw.println(calc(a, b));
		}
		pw.close();
	}
}
