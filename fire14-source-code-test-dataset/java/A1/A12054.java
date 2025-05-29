import java.io.*;
import java.util.*;

public class ProjB {
	static Scanner scan = new Scanner (System.in);
	
	static void test (int k ) {
		System.out.print ("Case #" + k + ": ");
		int N = scan.nextInt();
		int S = scan.nextInt();
		int p = scan.nextInt();
		int[] input = new int[N];
		for (int i = 0; i < N; ++i)
			input[i] = scan.nextInt();
		Arrays.sort(input);
		
		int min1 = (p >= 1)? 3*p-2:0;
		int min2 = -1;
		if (p >= 2)
			min2 = 3 * p - 4;
		else if (p == 1)
			min2 = 1;
		else
			min2 = 0;
		int k1 = N - 1;
		while (k1 >= 0 && input[k1] >= min1)
			--k1;
		int ans = N - 1 - k1;
		int k2 = k1;
		while (k2 >=0 && (k1 + 1 - k2) <= S && input[k2] >= min2)
			--k2;
		ans += k1 - k2;
		System.out.println (ans);
		
	}
	
	public static void main (String[] args) {
		int T = scan.nextInt();
		for (int i = 1; i <= T; ++i)
			test (i);
		
	}
}
