import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class C {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		ExecutorService es = Executors.newFixedThreadPool(Math.min(8, n));
		@SuppressWarnings("unchecked")
		Future<Integer>[] fs = new Future[n];

		for (int i = 0; i < n; i++) {
			String[] parts = in.readLine().split(" ");
			final int A = Integer.parseInt(parts[0]);
			final int B = Integer.parseInt(parts[1]);

			fs[i] = es.submit(new Callable<Integer>() {
				public Integer call() {
					return wastetime(A, B);
				}
			});

		}
		for (int i = 0; i < n; i++) {
			System.out.println("Case #" + (i + 1) + ": " + fs[i].get());
		}
		es.shutdown();

	}

	public static int wastetime(int A, int B) {
		HashSet<Long> answers = new HashSet<Long>();
		int len = (int) Math.log10(A) + 1;
		int m;
		int div = (int) Math.pow(10, len - 1);
		if (div <= 0) {
			return 0;
		}

		for (int n = A; n < B; n++) {
			m = n;
			for (int i = 0; i < len; i++) {
				m = ((m % div) * 10) + m / div;
				if (m > n && m <= B) {
					long ans = ((n & 0xFFFFFFFFl) << 32) + m;
					//System.out.println(Long.toHexString(ans));
					answers.add(ans);
				}
			}
		}
		return answers.size();//

		// return div;
	}
}