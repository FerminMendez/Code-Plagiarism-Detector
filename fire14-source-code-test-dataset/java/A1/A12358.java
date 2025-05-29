import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class B {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("b.in"));
		int T = scanner.nextInt();
		PrintWriter out = new PrintWriter(new File("b.out"));
		for (int I=0; I<T; I++) {
			out.printf("Case #%d: ", I+1);
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int p = scanner.nextInt();
			int res = 0;
			for (int i=0; i<n; i++) {
				int t = scanner.nextInt();
				int s1 = t / 3;
				int s3 = s1 + (t%3>0?1:0);
				int s2 = t - s1 - s3;
				if (s3 >= p)
					res++;
				else if (s3+1 == p && s>0) {
					if (s3==s2 && s2>0) {
						res++;
						s--;
					}
				}
			}
			out.println(res);
		}
		out.close();
	}
}
