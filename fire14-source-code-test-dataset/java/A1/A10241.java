import java.io.*;
import java.util.*;

public class B {

	int N, S, P, T[];
	Map<Tuple, Integer> map = new HashMap<Tuple, Integer>();

	class Tuple {
		int x;
		int y;
		int z;

		public Tuple(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public String toString() {
			return x + " " + y + " " + z;
		}
	}

	void run() throws IOException {
		Scanner s = new Scanner(new FileReader("small.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("small.out"));
		int t = s.nextInt();
		int result;
		for (int k = 1; k <= t; k++) {
			map = new HashMap<B.Tuple, Integer>();
			N = s.nextInt();
			S = s.nextInt();
			P = s.nextInt();
			T = new int[N];
			for (int i = 0; i < T.length; i++)
				T[i] = s.nextInt();
			// answer here
			result = dp(0, 0, 0);
			pw.println("Case #" + k + ": " + result);
			System.out.println("Case #" + k + ": " + result);
		}
		pw.close();
		s.close();
	}

	int type(Tuple tuple) {
		int x = tuple.x;
		int y = tuple.y;
		int z = tuple.z;
		if (Math.abs(x - y) > 2)
			return -1;
		if (Math.abs(x - z) > 2)
			return -1;
		if (Math.abs(y - z) > 2)
			return -1;
		if (Math.abs(x - y) == 2)
			return 1;
		if (Math.abs(x - z) == 2)
			return 1;
		if (Math.abs(y - z) == 2)
			return 1;
		return 0;
	}

	int max(Tuple tuple) {
		return Math.max(Math.max(tuple.x, tuple.y), tuple.z);
	}

	int dp(int index, int surp_sofar, int valid_sofar) {
		Tuple state = new Tuple(index, surp_sofar, valid_sofar);
		if (map.containsKey(state))
			return map.get(state);
		if (index == N) {
			// base case
			if (surp_sofar == S) {
				map.put(state, valid_sofar);
				return valid_sofar;
			}
			map.put(state, 0);
			return 0;
		}
		int result, itr_result, max;
		result = 0;
		itr_result = 0;
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				for (int k = 0; k <= 10; k++) {
					if (i + j + k == T[index]) {
						Tuple tuple = new Tuple(i, j, k);
						int type = type(tuple);
						if (type == 1) {
							// surprising
							max = max(tuple);
							if (max >= P) {
								itr_result = dp(index + 1, surp_sofar + 1,
										valid_sofar + 1);
							} else {
								itr_result = dp(index + 1, surp_sofar + 1,
										valid_sofar);
							}
						} else if (type == 0) {
							// normal
							max = max(tuple);
							if (max >= P) {
								itr_result = dp(index + 1, surp_sofar,
										valid_sofar + 1);
							} else {
								itr_result = dp(index + 1, surp_sofar,
										valid_sofar);
							}
						}
						result = Math.max(result, itr_result);
					}
				}
			}
		}
		map.put(state, result);
		return result;
	}

	public static void main(String[] args) throws IOException {
		new B().run();
	}
}
