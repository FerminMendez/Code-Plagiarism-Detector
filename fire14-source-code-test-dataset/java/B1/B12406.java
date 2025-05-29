import java.util.*;

public class QualC12 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();	
		for (int i = 1; i <= T; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			int npairs = 0;
			for (int j = A; j <= B; j++) {
				String s = String.valueOf(j);
				String ns = s + s;
				boolean containsRepeat = false;
				for (int k = 1; k < s.length(); k++) {
					String rot = ns.substring(k, k + s.length());
					int rnum = Integer.valueOf(rot);
					if (rnum > j && rnum <= B && String.valueOf(rnum).length() == s.length()) {
						if (containsRepeat(s)) containsRepeat = true;
						++npairs;
					}
				}
				if (containsRepeat) --npairs;
			}
			System.out.println("Case #" + i + ": " + npairs);
		}
	}

	private static boolean containsRepeat(String s) {
		if (s.length() % 2 != 0) return false;
		if (s.substring(0, s.length()/2).equals(s.substring(s.length()/2, s.length()))) {
			return true;
		}
		else return false;
	}

}