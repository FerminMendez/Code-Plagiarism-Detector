import java.util.Scanner;


public class ProblemC {

	public static int rotate(int x) {
		int y = x % 10;
		x /= 10;
		int cd = (x + "").length();
		if (x == 0) {
			cd = 0;
		}
		y *= Math.pow(10, cd);
		y += x;
		return y;
	}
	
	public static String rotate(String x) {
		String r = x.substring(0, 1);
		if (x.length() > 1) {
			r = x.substring(1) + r;
		}
		return r;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 1; tt <= t; tt++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = 0;
			for (int i = a; i <= b; i++) {
				String s = i + "";
				while (true) {
					s = rotate(s);
					int x = Integer.parseInt(s);
					if (x == i) {
						break;
					}
					if (x > i && x >= a && x <= b) {
//						System.out.println(i + " " + x);
						c++;
					}
				}
			}
			System.out.println("Case #" + tt + ": " + c);
		}
	}

}
