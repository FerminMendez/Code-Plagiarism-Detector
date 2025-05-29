import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Recycle {
	public static void main(String[] args) throws IOException {
		Recycle r = new Recycle();
		// System.out.println(r.isRecycled(12345, 34512));

		String fileInput = "in.txt";

		Scanner s = new Scanner(new File(fileInput));

		int T = 0;

		T = Integer.parseInt(s.nextLine());
		FileOutputStream fos = new FileOutputStream(new File("out.txt"));

		for (int i = 1; i <= T; i++) {
			// System.out.println("Case #" + i + ": "
			// + r.recycle(s.nextInt(), s.nextInt()));
			fos.write(String.format("Case #%d: %d" + (i < T ? "\n" : ""), i,
					r.recycle(s.nextInt(), s.nextInt())).getBytes());
		}

	}

	private int recycle(int a, int b) {

		int count = 0;
		for (int n = a; n < b; n++) {
			for (int m = n + 1; m <= b; m++) {
				if (isRecycled(n, m)) {
					// System.out.println("n=" + n + " m=" + m);
					count++;
				}
			}
		}
		return count;
	}

	private boolean isRecycled(int n, int m) {
		String nm = "" + n + n;
		if (!nm.contains("" + m))
			return false;
		nm = nm.replace("" + m, "");
		nm = nm.replace("" + n, "");
		return nm.isEmpty();
	}
}
