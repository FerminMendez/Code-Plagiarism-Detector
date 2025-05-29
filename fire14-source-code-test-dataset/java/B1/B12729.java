import java.util.HashSet;
import java.util.Scanner;


public class C_Recycled {

	static boolean recycled (String n, String B, String i) {
		return (n.compareTo(i) < 0) && (i.compareTo(B) <= 0);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int cas = 1; cas <= T; cas++) {
			int recycledPairs = 0;
			int A = in.nextInt();
			int B = in.nextInt();
			String sB = B+"";
			for (int n = A; n < B; n++) {
				HashSet<String> hs = new HashSet<String>();
				String sn = n+"";
				for (int i = 1; i <= sn.length(); i++) {
					String si = sn.substring(i) + sn.substring(0,i);
					if (recycled(sn,sB,si))
						hs.add(si);
				}
				recycledPairs += hs.size();
			}
			if (cas > 1)
				System.out.println();
			System.out.print("Case #"+cas+": "+recycledPairs);
		}

	}

}
