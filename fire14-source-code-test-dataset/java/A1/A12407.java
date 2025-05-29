import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class B {
	public static void main(String[] args) throws IOException {
		int[][] arr = new int[31][11];
		for(int[] a : arr) {
			Arrays.fill(a, 1000);
		}
		for(int i = 0; i <= 10; i++) {
			for(int j = i; j <= 10 && j <= i+2; j++) {
				for(int k = j; k <= 10 && k <= i+2; k++) {
					int sum = i+j+k;
					if(k-i <= 1) {
						for(int l = k; l >= 0; l--) {
							arr[sum][l] = 1;
						}
					} else {
						for(int l = k; l >= 0; l--) {
							arr[sum][l] = Math.min(arr[sum][l], 2);
						}
					}
				}
			}
		}
		
		PrintWriter out = new PrintWriter(new File("B.out"));
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int caseOn = 1; caseOn <= cases; caseOn++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int ans = 0;
			for(int i = 0; i < n; i++) {
				int t = in.nextInt();
				if(arr[t][p]==1000)
					continue;
				if(arr[t][p]==2) {
					if(s>0) {
						s--;
						ans++;
					}
				}
				if(arr[t][p]==1) {
					ans++;
				}
			}
			out.printf("Case #%d: %d\n",caseOn,ans);
		}
		out.close();
	}
}
/*

7
3 1 5 15 13 11
3 0 8 23 22 21
2 1 1 8 0
6 2 8 29 20 8 18 18 21
3 1 5 5 5 5
3 1 5 11 11 11
3 1 5 15 15 15


*/