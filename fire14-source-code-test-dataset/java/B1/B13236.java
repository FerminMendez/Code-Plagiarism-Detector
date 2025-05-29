import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Permutation {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("Input"));
		PrintWriter out = new PrintWriter("Output");
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		String length = in.nextLine();
		int c = 0;
		while (in.hasNext()) {
			c++;
			array2.add(in.nextInt());
			array2.add(in.nextInt());
			if (c < Integer.valueOf(length) - 1)
				in.nextLine();
		}

		int count = 0;
		array2.trimToSize();
		for (int q = 0; q < array2.size(); q += 2) {
			count++;

			int dd1 = array2.get(q);
			int dd2 = array2.get(q + 1);
			int res = 0;
			for (int i = dd1; i < dd2; i++) {
				String td1 = String.valueOf(i);
				for (int j = i + 1; j <= dd2; j++) {
					String td2 = String.valueOf(j);
					ArrayList<Integer> kk = new ArrayList<Integer>();
					int k = 0;
					do {
						k = td2.indexOf(td1.charAt(0), k + 1);
						if (k >= 0)
							kk.add(k);
					} while (k >= 0);
					kk.trimToSize();
					HashSet<Integer> hs = new HashSet<Integer>();
					for (int w : kk) {
						k = w;
						if (k >= 0) {
							String rev2 = new StringBuffer(td2.substring(0, k))
									.reverse().toString();
							String rev1 = new StringBuffer(td2.substring(k))
									.reverse().toString();
							String rev = rev2 + rev1;
							String rev3 = new StringBuffer(rev).reverse()
									.toString();
							if (Integer.valueOf(rev3) == i){
								hs.add(j);
//								res++;
								//System.out.println(res + ": " + i + " | " + rev3 + " - rev: " + j);
							}
						}
					} res += hs.size();
				}
			}
			out.println("Case #" + count + ": " + res);
		}

		in.close();
		out.close();
	}

}
