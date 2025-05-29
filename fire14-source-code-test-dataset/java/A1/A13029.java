import java.util.List;


public class Case implements Runnable {

	private int id;
	private String output;

	private int n;
	private int s;
	private int p;
	private List<Integer> g;

	public Case(int id) {
		this.id = id;
	}

	public Case(int id, int n, int s, int p, List<Integer> g) {
		super();
		this.id = id;
		this.n = n;
		this.s = s;
		this.p = p;
		this.g = g;
	}

	public String solve() {
		int res = 0;
		for (int googler : g) {
			int b = googler / 3;
			boolean div = googler % 3 == 0;
			if (b >= p) {
				res++;
				continue;
			}
			if (p == b+1) {
				if (div && s > 0 && b > 0) {
					res++;
					s--;
					continue;
				}
				if (!div) {
					res++;
					continue;
				}
			}
			if (p == b+2) {
				if (3*b+2 == googler && s > 0) {
					res++;
					s--;
				}
			}
		}
		return String.valueOf(res);
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