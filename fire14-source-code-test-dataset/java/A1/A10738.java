import java.util.*;
import java.io.*;

public class ProblemB {
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

		int N;
		int S;
//		int T;
		int P;
//		ArrayList<Integer> ti = new ArrayList<Integer>();
		int [] ti = new int[0];
		public void loadInput(Scanner sc) {
//			s = sc.next();
			N = sc.nextInt();
			S = sc.nextInt();
			P = sc.nextInt();
			ti = new int[N];
			for(int i=0;i<N;i++) {
				ti[i] =sc.nextInt();
			}
		}


		public void solveSlow() {
		}

		public void solveFast() {

			int n1 = 0;
			int n2 =0;

			if(P==0) {
				ans = N;
				return;
			}



			int c1 = P*3 -2;
			int c2 = P*3 -4;
			for(int i=0;i<ti.length;i++){
				int tai = ti[i];
				if(tai>=c1){
					n1++;
				} else if(tai<c1 && tai>=c2) {
					n2++;
				}
			}
			if(P==1) {
				ans =n1;
				return;
			}
			n2 = Math.min(S, n2);
			ans = n1+ n2;
//			ans = F[26][runs][0];
		}

		public void printSelf(PrintWriter pw) {
			pw.println(ans);
		}

		public boolean sameAnswers(Testcase other) {
			return false;
		}
	}

	final String AFTER_CASE = " ";

	public void go() throws Exception {
		precalc();

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
		new ProblemB().go();
	}
}
