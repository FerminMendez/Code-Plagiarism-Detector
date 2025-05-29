import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Case implements Runnable {

	private int id;
	private String output;

	private int a;
	private int b;
	private String sa;
	private String sb;
	private ArrayList<Couple> hs = new ArrayList<Couple>();

	public Case(int id, int a, int b) {
		super();
		this.id = id;
		this.a = a;
		this.b = b;
	}

	public String solve() {
		int l = (int) (Math.log10(a)) + 1;
		for (int i = a; i <= b; i++) {
			for (int j : shifts(i)) {
				if (i != j && j >= a && j <= b && (((int) (Math.log10(j)) + 1) == l)) {
					Couple c = new Couple(i, j);
					if (!hs.contains(c))
						hs.add(c);
				}
			}
		}
		return String.valueOf(hs.size());
	}

	private int[] shifts(int i) {
		int l = (int) (Math.log10(i)) + 1;
		int[] dgt = new int[l];
		int[] shf = new int[l-1];
		int j = i;
		for (int k = l; k > 0; k--) {
			dgt[l-k] = j / pow(k-1);
			j = j % pow(k-1);
		}
		for (int k = 1; k < l; k++) {
			int x = 0;
			for (int h = 0; h < l; h++) {
				x = 10 * x + dgt[(k+h)%l];
			}
			shf[k-1] = x;
		}
		return shf;
	}

	private int pow(int n) {
		switch(n) {
		case 0:
			return 1;
		case 1:
			return 10;
		case 2:
			return 100;
		case 3:
			return 1000;
		case 4:
			return 10000;
		case 5:
			return 100000;
		case 6:
			return 1000000;
		case 7:
			return 10000000;
		case 8:
			return 100000000;
		case 9:
			return 1000000000;
		}
		return 0;
	}

	private int pow99(int n) {
		int k = 1;
		int pow = 9;
		for (int i = 1; i < n; i++)
			pow = pow * 10 + 9;
		return pow;
	}

	@Override
	public void run() {
		output = solve();
	}

	@Override
	public String toString() {
		return "Case #" + id + ": " + output;
	}

}