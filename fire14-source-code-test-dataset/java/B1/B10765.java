package compete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		FileWriter fw = new FileWriter("A-small.out");
		int N = new Integer(in.readLine());
		for (int cases = 1; cases <= N; cases++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int A = new Integer(st.nextToken());
			int B = new Integer(st.nextToken());

			fw.write("Case #" + cases + ": " + nrecycled(A, B) + "\n");
		}
		fw.flush();
		fw.close();
	}

	private static int nrecycled(int a, int b) {
		int cpt = 0;
		for (int i = a; i < b; i++) {
			TreeSet<Integer> l = listRecycled(i);
			for(Integer x:l) {
				if ((i<x)&&(x<=b)) cpt++;
			}
		}
		return cpt;
	}

	private static TreeSet<Integer> listRecycled(int n) {
		TreeSet<Integer> l = new TreeSet<Integer>();
		int nbChiffres = Integer.toString(n).length();
		for(int i=1; i<nbChiffres; i++) {
			int expr = (int)Math.pow(10, i);
			int expl = (int)Math.pow(10, nbChiffres-i);
			int first = (n % expr) / (int)Math.pow(10, i-1);
			if (first!=0) {
				int nrotate = (n % expr)*expl + (n/expr);
				l.add(new Integer(nrotate));
			}
		}
		return l;
	}

}
