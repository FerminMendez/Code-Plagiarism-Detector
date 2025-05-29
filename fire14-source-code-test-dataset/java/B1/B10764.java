import java.util.*;
import java.io.*;

public class ProblemC {
	final long MOD = 1000003;
	final int MAX_LEN = 500000;

	long pow(long x, long y) {
		if (y == 0)	return 1;
		long res = pow(x, y/2);
		res = (res * res) % MOD;
		if (y % 2 == 1) res = (res * x) % MOD;
		return res;
	}

	long inv(long x) {
		return pow(x, MOD-2);
	}

	long[] fact, invfact;

	void precalc() {
		fact = new long[MAX_LEN + 1];
		fact[0] = 1;
		for (int i=1; i<=MAX_LEN; i++)
			fact[i] = (i * fact[i-1]) % MOD;
		invfact = new long[MAX_LEN + 1];
		invfact[0] = 1;
		for (int i=1; i<=MAX_LEN; i++)
			invfact[i] = (inv(i) * invfact[i-1]) % MOD;
	}

	long comb(int N, int M) {
		long res = fact[N];
		res = (res * invfact[M]) % MOD;
		res = (res * invfact[N-M]) % MOD;
		return res;
	}

	class Testcase {
		long ans;

		public Testcase() {
		}

		public Testcase(int seed) {
			Random rnd = new Random(seed);
		}

		String s;

		int A =0;
		int B = 0;


		public void loadInput(Scanner sc) {
//			s = sc.next();
			A = sc.nextInt();
			B = sc.nextInt();
		}


		public void solveSlow() {
		}

		String getShift(String sa) {
			String sb = sa.substring(sa.length() -1 ) + sa.substring(0,sa.length()-1);
			return sb;
//			return Integer.parseInt(s);
		}

		int getMaxDivide(int a) {
			int m = 1;
			while(a>=10){
				a=a/10;
				m=m*10;
			}
			return m;
		}

		HashMap<String, ArrayList<String> > map = new HashMap<String, ArrayList<String>>();

		public ArrayList<String> getShifts(String sa) {
			ArrayList<String> arr = null;
			arr = map.get(sa);
			if(  arr == null ) {

				arr = new ArrayList<String>();

				arr.add(sa);

				String sn = getShift(sa);

				while(!sn.equals(sa)) {
					arr.add(sn);
					sn = getShift(sn);
				}

				for(String ai : arr) {
					map.put(ai, arr);
				}
			}
			return arr;
		}


		boolean isCycle(int a, int b) {
			int am = getMaxDivide(a);
			if(b/am!=0) {
				return true;
			} else {
				return false;
			}
		}


		public void solveFast() {
			for(int n =A;n<B;n++) {
				String sn = String.format("%d", n);
				ArrayList<String> arr = getShifts(sn);
				for(String ai : arr ) {
					int m = Integer.parseInt(ai) ;
					if(m>n && m<=B && isCycle(n,m) ) {
						ans++;
					}

				}

			}

		}

		public void printSelf(PrintWriter pw) {
			System.out.println(ans);
			pw.println(ans);
		}

		public boolean sameAnswers(Testcase other) {
			return false;
		}
	}

	final String AFTER_CASE = " ";

	public void go() throws Exception {

		Scanner sc = new Scanner(new FileReader("src\\input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("src\\output.txt"));

		int caseCnt = sc.nextInt();

		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("solving case " + caseNum);

			Testcase tc = new Testcase();

			tc.loadInput(sc);
			tc.solveFast();

			pw.print("Case #" + (caseNum + 1) + ":");
			pw.print(AFTER_CASE);

			tc.printSelf(pw);
		}

		pw.flush();
		pw.close();
		sc.close();
	}

	public void stresstest() {
		int it = 0;
		Random rnd = new Random();
		while (true) {
			it++;
			if (it % 1000 == 0)
				System.out.println(it + " iterations");

			int seed = rnd.nextInt();

			Testcase tc1 = new Testcase(seed);
			tc1.solveFast();

			Testcase tc2 = new Testcase(seed);
			tc2.solveSlow();

			if (!tc1.sameAnswers(tc2)) {
				System.out.println("ERROR: it failed");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new ProblemC().go();
	}
}
