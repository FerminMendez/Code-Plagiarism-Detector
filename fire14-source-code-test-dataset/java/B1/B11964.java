import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Recycled {

	public static void main(String[] args) throws IOException {
		int T;
		Scanner sc = new Scanner(System.in);
		FileOutputStream out = new FileOutputStream("out.txt");
		T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) {
			HashSet<String> res = new HashSet<String>();
			int A = sc.nextInt();
			int B = sc.nextInt();
			for (int j = A; j <= B; j++) {
				String n = "" + j;
				for (int k = 1; k < n.length(); k++) {
					if (n.charAt(k) != '0') {
						String m = n.substring(k) + n.substring(0, k);
						if (j < Integer.valueOf(m) && Integer.valueOf(m) <= B)
							res.add(n + " " + m);
					}
				}
			}
			out.write(("Case #" + (i + 1) + ": " + res.size() + "\n").getBytes());

		}

	}

}