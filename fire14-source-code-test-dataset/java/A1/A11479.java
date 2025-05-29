package Qualification;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DancingWithGooglers {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int m = 1; m <= t; m++) {
			String[] S = in.readLine().split(" ");
			int n = Integer.parseInt(S[0]);
			int sur = Integer.parseInt(S[1]);
			int p = Integer.parseInt(S[2]);
			int[] A = new int[n];
			for (int i = 0; i < n; i++)
				A[i] = Integer.parseInt(S[i + 3]);
			int cnt = 0;
			for (int i = 0; i < n; i++)
				if (Math.ceil(A[i] / 3.0) >= p)
					cnt++;
				else if (A[i] >= p && p - (A[i] - p) / 2 == 2 && sur > 0) {
					sur--;
					cnt++;
				}
			System.out.println("Case #" + m + ": " + cnt);
		}
	}
}
