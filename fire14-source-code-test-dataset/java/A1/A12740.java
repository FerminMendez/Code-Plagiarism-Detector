import java.io.*;
import java.util.*;
import java.math.*;
/** @author Samuel Ahn */

public class B {
    public static void main(String args[]) throws Exception {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	for (int i = 1; i <= T; i++) {
	    int N = in.nextInt();
	    int S = in.nextInt();
	    int p = in.nextInt();
	    int[] array = new int[N];
	    for (int j = 0; j < N; j++) {
		array[j] = in.nextInt();
	    }
	    Arrays.sort(array);
	    int sum = 0;
	    for (int j = 0; j < N; j++) {
		int temp = array[j];
		if ((temp == 0)) {
		    if (temp >= p) {
			sum++;
		    }
		} else if ((temp == 1)) {
		    if (temp >= p) {
			sum++;
		    }
		} else {
		    if (S > 0) {
			if (((temp + 4) / 3) >= p) {
			    sum++;
			    S--;
			}
		    } else {
			if (((temp + 2) / 3) >= p) {
			    sum++;
			}
		    }
		}
	    }
	    System.out.printf("Case #%d: %d\n", i, sum);
	}
    }
}