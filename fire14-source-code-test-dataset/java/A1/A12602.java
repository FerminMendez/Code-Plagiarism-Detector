import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P02 {

	public static void main(String[] args) {
		init();
		Scanner inp = new Scanner(System.in);
		int t = inp.nextInt();
		inp.nextLine();
		int i = 1;
		while (t > 0) {
			int n = inp.nextInt();
			int s = inp.nextInt();
			int p = inp.nextInt();
			int ret = 0;
			for (int j = 0; j < n; j++) {
				int x = inp.nextInt();
				int v = x / 3;
				int mo = x % 3;
				if (v >= p)
					ret++;
				else if (mo > 0 && (v + 1) >= p)
					ret++;
				else if (s > 0 && (v + 2) >= p && mo == 2) {
					s--;
					ret++;
				} else if (s > 0 && (v + 1) >= p && (mo == 1 || v > 0)) {
					s--;
					ret++;
				}
			}

			System.out.println("Case #" + i + ": " + ret);

			--t;
			++i;
		}

	}

	static String[] coded = { "ejp mysljylc kd kxveddknmc re jsicpdrysi",
			"rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd",
			"de kr kd eoya kw aej tysr re ujdr lkgc jvqz" };
	static String[] uncoded = { "our language is impossible to understand",
			"there are twenty six factorial possibilities",
			"so it is okay if you want to just give upzq" };

	static Map<Character, Character> mapping = new HashMap<Character, Character>();

	private static void init() {
		for (int i = 0; i < coded.length; i++) {
			for (int j = 0; j < coded[i].length(); j++) {
				mapping.put(coded[i].charAt(j), uncoded[i].charAt(j));
			}
		}
	}

	private static String translate(String line) {
		String ret = "";
		for (int i = 0; i < line.length(); i++) {
			if (mapping.containsKey(line.charAt(i))) {
				ret = ret + mapping.get(line.charAt(i));
			} else if (line.charAt(i) == ' ') {
				ret = ret + line.charAt(i);
			} else {
				System.out.println("NOT " + line.charAt(i));
			}
		}
		return ret;

	}
}
