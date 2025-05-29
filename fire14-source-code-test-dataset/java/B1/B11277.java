package problemc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int T = 1;
		String G = "";
		String[] inputs;
		BufferedReader reader;

		reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			T = Integer.parseInt(reader.readLine());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuffer buffer = new StringBuffer();
		for (int X = 1; X <= T; X++) {
			try {
				G = reader.readLine();
				inputs = G.split(" ");
				int A = Integer.parseInt(inputs[0]);
				int B = Integer.parseInt(inputs[1]);
				int result = 0;
				int n;
				int m;
				Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
				for (int i = A; i <= B; i++) {
					int x = 10;
					int shift = Integer.toString(i).length();
					while (i % x < i) {
						shift--;
						if (i % x >= x / 10) {
							n = i;
							m = i % x;
							for (int j = 0; j < shift; j++) {
								m = m * 10;
							}
							m += (i / x);
							if (n >= m) {
								x = x * 10;
								continue;
							}
							if (m <= B) {
								if (pairs.get(n) == null
										|| !pairs.get(n).equals(m)) {
									result++;
									pairs.put(n, m);
//									System.out.println(n+", "+m);
								}
							}
						}
						x = x * 10;
					}
				}
				buffer.append("Case #").append(X).append(": ").append(result)
						.append("\r\n");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(buffer.toString());

	}

}
