import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class C {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int lines = Integer.parseInt(in.readLine());
		for (int i = 0; i < lines; i++) {
			long res = 0;
			String line = in.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = a; j <= b; j++) {
				res += (long) recycleNum(j, b);
			}
			System.out.println("Case #" + (i + 1) + ": " + res);
		}
	}

	private static int recycleNum(int n, int b) {
		Set<Integer> set = new HashSet<Integer>();
		int result = 0;
		String num = (n + "");
		for (int i = 1; i < num.length(); i++) {
			String part1 = "";
			String part2 = "";
			part1 = num.substring(0, i);
			part2 = num.substring(i, num.length());
			int temp = Integer.parseInt(part2 + part1);
			if (n < temp && temp <= b && !set.contains(temp)) {
				set.add(temp);
				result++;
			}
		}
		return result;
	}
}
