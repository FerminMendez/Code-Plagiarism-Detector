import java.util.*;
import java.io.*;

public class DancingWithGooglers {
	public void translate() throws Exception {
		Scanner sc = new Scanner(new FileReader("C:\\Users\\i047312\\Desktop\\B-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\i047312\\Desktop\\output_small_B.txt"));
		//Translator
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			pw.print("Case #" + (i + 1) + ": ");
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int[][] l = new int[n][3];
			for (int j = 0; j < n; j++) {
				int score = sc.nextInt();
				int q = score / 3;
				int r = score % 3;
				if (r == 1) {
					l[j][0] = q;
					l[j][1] = q;
					l[j][2] = q + 1;
				} else if (r == 2) {
					l[j][2] = q;
					l[j][0] = q + 1;
					l[j][1] = q + 1;
				} else {
					l[j][0] = q;
					l[j][1] = q;
					l[j][2] = q;
				}
			}
			int s1 = 0;
			int count = 0;
			for (int j = 0; j < l.length; j++) {
				if (l[j][0] >= p || l[j][1] >= p || l[j][2] >= p) {
					count++;
					continue;
				} else if (s1 < s && p > 1) {
					if ((l[j][0] == p-1 && l[j][1] == p-1) || (l[j][2] == p-1 && l[j][1] == p-1) || (l[j][0] == p-1 && l[j][2] == p-1)) {
						count++;
						s1++;
						continue;
					}
				}
			}
			pw.println(count);
		}
		
		pw.flush();
		pw.close();
		sc.close();
	}
	
	public static void main(String[] args) throws Exception {
		new DancingWithGooglers().translate();
	}
}
