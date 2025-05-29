import java.io.File;
import java.util.HashSet;
import java.util.Scanner;


public class C {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("C-small-attempt0.bin"));
//		Scanner in = new Scanner(new File("test.in"));
		int T = in.nextInt();
		for (int zz = 1; zz <= T; ++zz) {
			int A = in.nextInt();
			int B = in.nextInt();
			
			int r = 0;
//			HashSet<Integer> tested = new HashSet<>();
			for (int i = A; i < B; ++i) {
				int log = (int) Math.log10(i);
				int n = i;
				int p = (int) Math.pow(10, log+1);
				HashSet<Integer> tested = new HashSet<>(log);
				for (int l = 1; l <= log; ++l) {
					n *= 10;
					n = (n%p) + (n/p);
					if (tested.add(n) && n > i && n <= B)
						r++;
				}
			}
			
			System.out.format("Case #%d: %d\n", zz, r);
		}
		
	}
}
