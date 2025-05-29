import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
		String li;
		int tcn = Integer.parseInt(in.readLine());
		Scanner sc;
		int N, S, P;
		int[] scr;
		for (int tc = 0; tc < tcn; tc++) {
			li = in.readLine();
			sc = new Scanner(li);
			N = sc.nextInt(); S = sc.nextInt(); P = sc.nextInt();
			scr = new int[N];
			for (int i = 0; i < N; i++) {
				scr[i] = sc.nextInt();
			}
			
			Arrays.sort(scr);
			
			int result = 0;
			for (int i = scr.length - 1; i >=0; i--) {
				int tmp = scr[i] / 3;
				if (P - tmp >= 3 || (scr[i] == 0 && P > 0)) break;
				int r = scr[i] % 3;
				if (tmp >= P) {
					result++;
				} else {
					if (P - tmp == 1) {
						if (r > 0) {
							result++;
						} else {
							if (S > 0) {
								result++;
								S--;
							}
						}
					} else {
						if (P -tmp == 2) {
							if (r == 2 && S > 0) {
								result++;
								S--;
							}
						}
					}
				}
			}
			
			System.out.println("Case #" + (tc + 1) + ": " + result);
		}
		in.close();
	}

}
