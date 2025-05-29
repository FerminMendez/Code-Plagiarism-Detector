import java.util.HashSet;
import java.util.Scanner;

public class C {

	static HashSet p = new HashSet();
	static int low;
	static int high;
	int count = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();

		for (int i = 1; i <= no; i++) {

			p.clear();
			low = sc.nextInt();
			high = sc.nextInt();

			for (int l = low; l <= high; l++) {
				recycle(l);
			}
			System.out.println("Case #" + i + ": " + p.size());

		}
	}

	public static void recycle(int no) {

		String s = Integer.toString(no);
		for (int i = 0; i < s.length(); i++) {
			String rec = s.substring(i) + s.substring(0, i);
			int r = Integer.parseInt(rec);
			if (r != no && r >= low && r <= high) {
				int min = Math.min(r, no);
				int max = Math.max(r, no);
				String a = Integer.toString(min) + "" + Integer.toString(max);
				p.add(a);

			}
		}

	}
}
