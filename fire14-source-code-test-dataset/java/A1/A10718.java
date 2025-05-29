import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public class B2012 {
	public static void main(String[] args) throws Exception {
		File f = new File("C:\\gcj\\b_res.txt");
		FileWriter w = new FileWriter(f);
		Scanner sca = new Scanner(new File("C:\\gcj\\b.txt"));
		int T = sca.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sca.nextInt();
			int S = sca.nextInt();
			int p = sca.nextInt();
			int[] t = new int[N];
			int res = 0;
			int puwede = 0;
			for (int j = 0; j < N; j++) {
				t[j] = sca.nextInt();
				if (t[j] >= p * 3 - 2) {
					res++;
				} else if (t[j] >= p * 3 - 4 && p * 3 - 4 > 0) {
					puwede++;
				}
			}
			res += Math.min(puwede, S);
			w.write("Case #" + (i + 1) + ": " + res + "\n");
		}
		w.flush();
		w.close();
	}

}
