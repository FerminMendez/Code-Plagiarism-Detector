import java.io.*;
import java.util.*;
import java.math.*;
/** @author Samuel Ahn */

public class C {
    public static void main(String args[]) throws Exception {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	for (int i = 1; i <= T; i++) {
	    int A = in.nextInt();
	    int B = in.nextInt();
		int sum = 0;

	    for (int n = A; n < B; n++) {
		String x = Integer.toString(n);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int j = 1; j < x.length(); j++) {
		    String a = x.substring(0, j);
		    String b = x.substring(j);
		    int tmp = Integer.parseInt(b + a);
		    if ((tmp > n) && (tmp <= B) && (!list.contains(tmp))) {
			sum++;
			list.add(tmp);
			//break;
		    }
		}
	    

	    }
	    System.out.printf("Case #%d: %d\n", i, sum);
	}
    }
 
}