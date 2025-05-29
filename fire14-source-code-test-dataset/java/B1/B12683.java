import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class RecycledNumbers {
	public static void main(String[] args) throws IOException {
		RecycledNumbers r = new RecycledNumbers();
		r.run("C-small.in", "C-small.out");
	}
	
	public void run(String input, String output) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(input));
		FileWriter fw = new FileWriter(output);
		long C = 0;
		int N = new Integer(br.readLine());
		for (int cases = 1; cases <= N; cases++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long A = new Long(st.nextToken());
			long B = new Long(st.nextToken());
			C = count(A, B);
			fw.write("Case #" + cases + ": " + C + "\n");
		}
		fw.flush();
		fw.close();
	}
	
	public long count(long A, long B) {
		int recycledPairs = 0;
		for (long K = A; K <= B; K++) {
			int n = digits(K);
			int pairs = 0;
			long[] a = new long[n - 1];
			for (int i = 1; i < n; i++) {
				long divisor = (long) Math.pow(10, i);
				long R = (K % divisor) * (long) Math.pow(10, n - i) + (K / divisor);
				if (R > K && R <=B) {
					boolean repeat = false;
					for (int j = 0; j < pairs; j++) {
						if (R == a[j]) {
							repeat = true;
							break;
						}
					}
					if (!repeat) {
						a[pairs] = R;
						pairs++;
						recycledPairs++;
					}
				}
			}
		}
		return recycledPairs;
	}
	
	public int digits(long k) {
		int length = 0;
		for (int i = 0; i < 8; i++) {
			k /= 10;
			length++;
			if (k == 0)
				break;
		}
		return length;
	}
}
