// Problem B

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class C {
	
	private void processInput() throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int A = in.nextInt();
            int B = in.nextInt();
			int res = go(A, B);

			System.out.printf(Locale.ENGLISH, "Case #%d: %d\n", testCase, res);
		}
		
		in.close();
	}
	
	private int go(int A, int B) {
		
        int res = 0;

        Set<Integer> set = new HashSet<Integer>();
        int l = String.valueOf(A).length();
        for (int n = A; n <= B; n++) {
            set.clear();
            String m = String.valueOf(n);
            for (int j = 1; j < l; j++) {
                m = m.charAt(l - 1) + m.substring(0, l - 1);
                if (m.charAt(0) != '0') {
                    int val = Integer.valueOf(m);
                    if (val > n && val <= B) {
                        set.add(val);
                    }
                }
            }
            res += set.size();
        }
		return res;
	}

	public static void main(String[] args) throws Exception {
		C temp = new C();
		temp.processInput();
	}
}
