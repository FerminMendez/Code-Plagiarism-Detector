package problemb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DancingWithTheGooglers {

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
				int N = Integer.parseInt(inputs[0]);
				int S = Integer.parseInt(inputs[1]);
				int p = Integer.parseInt(inputs[2]);
				int[] t;
				if (inputs.length - 3 > N) {
					t = new int[N];
				} else {
					t = new int[inputs.length - 3];
				}
				for (int i = 0; i < t.length; i++) {
					t[i] = Integer.parseInt(inputs[i + 3]);
				}
				int surprizing = 0;
				Arrays.sort(t);
				int result = 0;
				for (int j = t.length - 1; j >= 0; j--) {
					if(p==0){
						result = t.length;
						break;
					}
					int dev = t[j] / 3;
					int mod = t[j] % 3;
					if (dev >= p) {
						result++;
						continue;
					}
					if (mod == 1 && dev + 1 >= p) {
						result++;
						continue;
					}
					if (mod == 2 && dev + 1 >= p) {
						result++;
						continue;
					}
					if (mod == 2 && dev + 2 >= p && surprizing < S) {
						surprizing++;
						result++;
						continue;
					}
					if (mod == 0 && dev > 0 && dev + 1 >= p && surprizing < S) {
						surprizing++;
						result++;
						continue;
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
