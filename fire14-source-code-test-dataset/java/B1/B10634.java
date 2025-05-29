import java.util.Scanner;


public class C {
	String cycle(String s) {
		return s.substring(1) + s.charAt(0);
	}

	void run() {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t=1; t<=T; t++) {
			int A = in.nextInt();
			int B = in.nextInt();
			long res = 0;
			for (long i=A; i<=B; i++) {
				long cnt = 1;
				String str = String.valueOf(i);
				for (String nowstr = cycle(new String(str));
						!nowstr.equals(str); nowstr = cycle(nowstr)) {
					if (nowstr.charAt(0) != 0) {
						int nowint = Integer.parseInt(nowstr);
						if (nowint >= A && nowint <= B) {
							if (nowint < i) {
								cnt = 0;
								break;
							} else {
								cnt++;
							}
						}
					}
				}
				res += cnt*(cnt-1)/2;
			}
			System.out.println("Case #" + t + ": " + res);
		}
	}

	static public void main(String[] args) {
		C obj = new C();
		obj.run();
	}
}
