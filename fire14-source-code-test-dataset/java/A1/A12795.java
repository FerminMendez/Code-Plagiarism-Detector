import java.util.Scanner;


public class BS {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int count = in.nextInt();
		for (int i = 1; i <= count ; i++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int p_count = 0;
			int s_count = 0;
			for (int j = 0; j < n; j++) {
				int current = in.nextInt();
				int rest = current - p;
				if (rest < 0) {
					continue;
				}
				int restOf2p = rest - (p * 2);
				if (restOf2p >= -2) {
					p_count++;
					continue;
				}
				if (restOf2p >= -4) {
					s_count++;
				}
			}
			if (s_count > s) {
				s_count = s;
			}
			System.out.format("Case #%d: %d\n",i,p_count + s_count);
		}
	}

}

