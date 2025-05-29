import java.io.*;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader(new File("C-small-attempt1.in")));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C-small-attempt1.out")));

		int T = Integer.parseInt(bf.readLine());
		for (int c = 0; c < T; c++) {
			HashSet<String> set = new HashSet<String>();

			String tokens[] = bf.readLine().split(" ");
			int A = Integer.parseInt(tokens[0]), B = Integer.parseInt(tokens[1]), ans = 0;
			for (int I = A; I < B; I++) {
				String i = I + "";
				for (int j = 1; j < i.length(); j++) {
					String re = i.substring(j) + i.substring(0, j);
					if (I < Integer.parseInt(re) && Integer.parseInt(re) <= B) {
						if (!set.contains(i + "-" + re)) ans++;
						
						set.add(i + "-" + re);
					}
				}
			}
			bw.write(String.format("Case #%d: %d\n", c + 1, ans));
		}
		bw.close();
	}
}
