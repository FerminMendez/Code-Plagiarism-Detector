
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Dancers {

	public static void main(String[] args) throws IOException {
		int T, N, S, p;
		Scanner sc = new Scanner(System.in);
		FileOutputStream out = new FileOutputStream("out.txt");
		T = sc.nextInt(); sc.nextLine();
		for (int i = 0; i < T; i++) {
			int sure = 0, pos = 0;
			N = sc.nextInt(); S = sc.nextInt(); p = sc.nextInt(); 
			for (int j = 0; j < N; j++) {
				int act = sc.nextInt();
				if (act == 0) {
					if (p == 0) sure++;
				} else {
					if (act >= ((p*3)-2)) sure++;
					else if (act >= ((p*3)-4)) pos++;
				}
			}
			int res = Math.min(sure + Math.min(pos, S), N);
			out.write(("Case #" + (i + 1) + ": "+res+"\n").getBytes());
		}

	}

}