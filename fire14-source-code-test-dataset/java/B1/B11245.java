import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class recycle {

	public static HashMap<String, String> bigmap = new HashMap<String, String>();

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("in.in");
		Scanner input = new Scanner(f);
		int k = Integer.parseInt(input.nextLine());
		for (int i = 0; i < k; i++) {
			String[] stuff = input.nextLine().split(" ");
			int a = Integer.parseInt(stuff[0]);
			int b = Integer.parseInt(stuff[1]);
			System.out.println("Case #" + (i + 1) + ": " + doit(a, b));
		}
	}

	public static int doit(int A, int B) {

		HashMap<String, String> m = new HashMap<String, String>();
		int n = 1;
		for (int a = A; a < B; a++) {
			for (int b = a + 1; b <= B; b+=n) {
				n = 1;
				if (bigmap.containsKey(a + "" + b)) {
					m.put(a + "" + b, "");
				} else {
					String s = a + "";
					String q = b + "";
					for (int i = 0; i < s.length(); i++) {
						String old = s;
						char c = s.charAt(s.length() - 1);
						s = c + s.substring(0, s.length() - 1);
						if (s.equals(q)) {
							n = 9;
							m.put(a + "" + b, "");
							bigmap.put(a + "" + b, "");
						}
					}
				}
			}
		}
		return m.size();
	}

}
