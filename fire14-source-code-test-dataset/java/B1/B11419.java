import java.util.Arrays;
import java.util.Scanner;


public class C {

	static Scanner in = new Scanner(System.in);

	long solve() {
		int A = in.nextInt();
		int B = in.nextInt();
		int digits = 1;
		int mult = 1;
		{
			int t = A;
			while (t>=10) {
				t/=10;
				++digits;
				mult *= 10;
			}
		}
		long ans = 0;
		int[] buf = new int[digits];
		for (int n=A; n<B; ++n) {
			int cnt = 0;
			int rot = n;
			for (int i=0; i+1<digits; ++i) {
				rot = rot/10 + (rot%10)*mult;
				if (rot > n && rot <= B) {
					buf[cnt++] = rot;
				}
			}
			if (cnt>0) {
				Arrays.sort(buf, 0, cnt);
				++ans;
				for (int i=1; i<cnt; ++i) {
					if (buf[i-1] != buf[i]) {
						++ans;
					}
				}
			}
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		int T = in.nextInt();
		for (int i=1; i<=T; ++i) {
			long ans = new C().solve();
			System.out.println("Case #" + i + ": " + ans);
		}

	}

}
