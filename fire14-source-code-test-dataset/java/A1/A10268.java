import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class B {
	static ArrayList<Triplet> surprising = new ArrayList<Triplet>();
	static ArrayList<Triplet> nonSurprising = new ArrayList<Triplet>();

	public static boolean isValid(int a, int b, int c) {
		if (Math.abs(a - b) > 2 || Math.abs(a - c) > 2 || Math.abs(b - c) > 2)
			return false;
		return true;
	}

	static public void generate(int a, int b, int c, int i) {
		int j = 0;
		if (i == 1)
			j = a;
		else if (i == 2)
			j = b;

		for (; j <= 10; j++) {
			if (i == 0)
				generate(j, b, c, 1);
			else if (i == 1)
				generate(a, j, c, 2);
			else if (i == 2)
				if (isValid(a, b, j)) {
					Triplet tmp = new Triplet(a, b, j);
					if (tmp.isSurprising())
						surprising.add(tmp);
					else
						nonSurprising.add(tmp);
				}
		}
	}

	static private int getMax(ArrayList<Triplet> currTriplets, int n,
			ArrayList<Integer> googlers, int p) {
		int removed = 0;
		label:for (int i = 0; i < n; i++) {
			int maxNo = -1, maxI = -1;
			for (int j = 0; j < currTriplets.size(); j++) {
				Triplet tr = currTriplets.get(j);
				if (tr.a == tr.b && tr.a == 6)
					System.out.print("");
				int tmp = 0;
				for (int j2 = 0; j2 < googlers.size(); j2++)
					if (tr.sum == googlers.get(j2) && tr.best >= p)
						tmp++;
				if (tmp > maxNo) {
					maxNo = tmp;
					maxI = j;
				}
			}
			if (maxNo == 0)
				break;
			Triplet chosen = currTriplets.get(maxI);
			for (int j = 0; j < googlers.size(); j++)
				if (chosen.sum == googlers.get(j) && chosen.best >= p) {
					googlers.remove(j);
					removed++;
					if (removed == n)
						break label;
					j--;
				}
		}
		return removed;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileInputStream("B-small-attempt0.in"));
		FileWriter out = new FileWriter(new File("B-small-attempt0.out"));
		generate(0, 0, 0, 0);
		int t = in.nextInt(), cnt = 1, n, s, p, res;
		ArrayList<Integer> googlers = new ArrayList<Integer>();
		while (t-- > 0) {
			n = in.nextInt();
			s = in.nextInt();
			p = in.nextInt();
			for (int i = 0; i < n; i++)
				googlers.add(in.nextInt());
			res = getMax(nonSurprising, n - s, googlers, p);
			res += getMax(surprising, s, googlers, p);
			out.write("Case #" + cnt++ + ": " + res + "\n");
			googlers.clear();
		}
		out.close();
		in.close();
	}

	static class Triplet {
		private int a, b, c, sum, best;

		public Triplet(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
			sum = a + b + c;
			best = Math.max(a, Math.max(b, c));
		}

		public boolean isSurprising() {
			if (Math.abs(a - b) == 2 || Math.abs(a - c) == 2
					|| Math.abs(b - c) == 2)
				return true;
			return false;
		}

		public int sum() {
			return sum;
		}

		public String toString() {
			return "[" + a + " " + b + " " + c + "]";
		}

		public int getBest() {
			return best;
		}

	}
}
