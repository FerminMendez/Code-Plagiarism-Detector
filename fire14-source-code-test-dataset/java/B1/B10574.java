package boy0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeJam_C_Small {
	public static void main(String[] args) throws IOException {
		String strLine;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		CodeJam_C_Small me = new CodeJam_C_Small();

		// me.init();

		strLine = br.readLine();
		int T = Integer.parseInt(strLine);
		String[] as;
		char[] a, b;
		int y;
		for (int x = 1; x <= T; x++) {
			strLine = br.readLine();
			as = strLine.split(" ");
			a = as[0].toCharArray();
			b = as[1].toCharArray();
			y = me.get_num_recycled_pairs(a, b);
			System.out.println("Case #" + x + ": " + y);
		}
	}

	// 1 ¡Â A ¡Â B ¡Â 2000000. max length = 7
	private char[] recycled = new char[16]; // (max+1)*2 = 8*2 = 16
	private int r_length = 0;
	private char[] b;
	private int b_length = 0;

	// A ¡Â n < m ¡Â B
	public int get_num_recycled_pairs(char[] a, char[] b_) {
		int y = 0;
		int a_length = a.length;
		b = b_;
		b_length = b.length;

		// r = a (&& a);
		r_length = a_length;
		for (int i = 0; i < a_length; i++) {
			recycled[i] = a[i];
			recycled[i + r_length] = a[i];
		}

		// while r <= b
		while (comp(recycled, 0, r_length, b, 0, b_length) <= 0) {
			// check each r-pair
			for (int i = 1; i < r_length; i++) {
				if (is_recycled_pair(i)) {
					y++;
				}
			}
			// r++;
			add_1_r();
		}

		return y;
	}

	// < : -x , == : 0, > : +x
	private int comp(char[] c1, int c1_offset, int c1_length, char[] c2,
			int c2_offset, int c2_length) {
		int x = c1_length - c2_length;
		if (x == 0) {
			for (int i = 0; i < c2_length; i++) {
				x = c1[c1_offset + i] - c2[c2_offset + i];
				if (x != 0) {
					break;
				}
			}
		}
		return x;
	}

	private boolean is_recycled_pair(int offset) {
		// n = r[0] , m = r[offset]
		// n >= m ? false
		if (comp(recycled, 0, r_length, recycled, offset, r_length) >= 0) {
			return false;
		}
		// m > b ? false
		if (comp(recycled, offset, r_length, b, 0, b_length) > 0) {
			return false;
		}
		// r[offset] == r[x] ? false (0 < x < offset)
		for (int x = 1; x < offset; x++) {
			if (comp(recycled, offset, r_length, recycled, x, r_length) == 0) {
				return false;
			}
		}
//		System.out.println("r:" + new String(recycled) + "\t offset:" + offset);
		return true;
	}

	// r++
	private void add_1_r() {
		for (int i = r_length - 1; i >= 0; i--) {
			if (recycled[i] == '9') {
				recycled[i] = '0';
				recycled[i + r_length] = recycled[i];
			} else {
				recycled[i] = (char) (recycled[i] + 1);
				recycled[i + r_length] = recycled[i];
				return;
			}
		}
		// here, length overflow
		r_length++;
		for (int i = r_length - 1; i >= 1; i--) {
			recycled[i] = recycled[i - 1];
			recycled[i + r_length] = recycled[i];
		}
		recycled[r_length] = recycled[0] = '1';

	}

}
