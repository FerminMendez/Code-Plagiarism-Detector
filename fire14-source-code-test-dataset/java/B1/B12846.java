package gcj2012.qr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {
	
	public static int count(int a, int b) {
		int r = 0, len, m;
		String sn, sm;
		Set<Integer> used = new HashSet<Integer>();
		for (int n = a; n < b; n++) {
			used.clear();
			sn = Integer.toString(n);
			len = sn.length();
			sn = sn + sn;
			for (int i = 1; i < len; i++) {
				if (sn.charAt(i) == '0') continue;
				sm = sn.substring(i, i + len);
				m = Integer.parseInt(sm);
				if ((m > n) && (m <= b) && !used.contains(m)) {
					r++;
					used.add(m);
				}
			}
		}
		return r;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		if (args.length < 1 ) {
			System.out.println("File name not given");
			System.exit(1);
		}
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			String[] test = br.readLine().split(" ");
			int a = Integer.parseInt(test[0]);
			int b = Integer.parseInt(test[1]);
			System.out.printf("Case #%d: %d\n", i, count(a, b));
		}
		br.close();
	}

}
