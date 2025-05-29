import java.io.*;

public class RecycledNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(
				new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(System.out);
		int n = Integer.parseInt(bfr.readLine());
		for (int i = 1; i <= n; i++) {
			String input[] = bfr.readLine().split(" ");
			int max = Integer.parseInt(input[1]);
			int count = 0;
			int min = Integer.parseInt(input[0]);
			for (; min < max; min++) {
				String moved = String.valueOf(min).charAt(
						String.valueOf(min).length() - 1)
						+ String.valueOf(min).substring(0,
								String.valueOf(min).length() - 1);
				if (Integer.parseInt(moved) <= max
						&& Integer.parseInt(moved) > min)
					count++;
				while (Integer.parseInt(moved) != min) {
					moved = moved.charAt(moved.length() - 1)
							+ moved.substring(0, moved.length() - 1);
					if (Integer.parseInt(moved) <= max
							&& Integer.parseInt(moved) > min)
						count++;
				}
			}
			pr.printf("Case #%d: %d\n", i, count);
			pr.flush();
		}
	}
}
