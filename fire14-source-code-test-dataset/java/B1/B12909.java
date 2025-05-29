import java.util.*;
import java.io.*;

public class Main {

	public static boolean recycledNumber(int n, int m) {
		String N = String.valueOf(n);
		String M = String.valueOf(m);

		for(int i = 0; i < N.length(); i++) {
			String firstPart = N.substring(0, i);
			String endPart = N.substring(i, N.length());
			String combined = endPart + firstPart;
			if(M.equals(combined)) return true;
		}
		return false;
	}



	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("testcase.in"));
		int testcases = sc.nextInt();
		sc.nextLine();

		for(int testcase = 1; testcase <= testcases; testcase++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int recycledPairs = 0;

			for(int n = A; n < B; n++) {
				for(int m = n+1; m <= B; m++) {
					if(recycledNumber(n, m)) recycledPairs++;
				}
			}

			System.out.printf("Case #%d: %d\n", testcase, recycledPairs);
		}
	}
}