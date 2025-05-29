import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader(new File("B-small-attempt0.in")));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("B-small-attempt0.out")));

		int T = Integer.parseInt(bf.readLine());
		
		for (int c = 0; c < T; c++) {
			String tokens[] = bf.readLine().split(" ");
			int N = Integer.parseInt(tokens[0]), S = Integer.parseInt(tokens[1]), p = Integer.parseInt(tokens[2]), t[] = new int[N], ans =0;
			for (int i = 0; i < N; i++) {
				t[i] = Integer.parseInt(tokens[i + 3]);
				int base = t[i] / 3, mod = t[i] % 3;
				if (base >= p || (mod > 0 && base + 1 >= p)) 
					ans++;
				else if(S>0 && base >0 && base + Math.max(1, mod) >= p) {
					ans++;
					S--;
				}
			}
			bw.write(String.format("Case #%d: %d\n", c+1, ans));
		}
		bw.close();
	}
}
