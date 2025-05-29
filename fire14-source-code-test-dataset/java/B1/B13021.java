import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C {
	public static void main(String[] args) throws IOException {
		String filename = "C-small-attempt0";
		String inname = filename + ".in";
		String outname = filename + ".out";
		Scanner sc = new Scanner(new File(inname));
		//Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileWriter(outname));

		int N = sc.nextInt();
		for (int t = 1; t <= N; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int l = Integer.toString(a).length();
			int ans = 0;
			for(int n = a; n <= b; n++) {
				for(int i = 1; i < l; i++) {
					int front = n/((int)Math.pow(10, i));
					int back = n%((int)Math.pow(10, i));
					int m = back * (int) Math.pow(10,l-i) + front;
					//System.out.println(m + " " + n);
					if(m != n && m/(int)Math.pow(10,l-1) != 0 && n < m && m <= b) ans++;
				}
				
			}
			out.println("Case #" + t + ": " + ans);
			System.out.println("Case #" + t + ": " + ans);
		}
		out.close();
	}
}
