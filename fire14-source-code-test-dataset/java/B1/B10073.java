import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RecycledNumbers {
	public RecycledNumbers() {
		// System.out.println(getBits(1123242));
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new FileReader("small.in"));
			out = new PrintWriter(new FileWriter("small.out"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			int T = Integer.parseInt(in.readLine());
			int result = 0;
			for (int group = 0; group < T; group++) {
				System.out.println("-------------" + group + "-----------");
				String line = in.readLine();
				StringTokenizer st = new StringTokenizer(line);
				long A = Long.parseLong(st.nextToken());
				long B = Long.parseLong(st.nextToken());
				result = getPairs(A, B);
				// System.out.println(Long.MIN_VALUE);
				int inn = group + 1;
				String target = "Case #" + inn + ": " + result;
				out.println(target);
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

	private int getPairs(long A, long B) {
		// TODO Auto-generated method stub
		int result = 0;
		long n;
		int temp;
		for (long i = A; i < B; i++) {
			n = i;
			temp = hasRecycle(n, B);
			result = result + temp;
		}
		return result;
	}

	private int hasRecycle(long nn, long B) {
		// TODO Auto-generated method stub
		// m>n;
		// same length;
		// distinct.
		String m;
		String n = nn + "";
		long mm;
		int mP;
		int nP;
		int result = 0;
		long[] cmm = new long[7];
		int cmmMAX = 0;
		for (int i = 1; i < n.length(); i++) {
			m = shift(n, i);
			mm = Long.parseLong(m);
			mP = getBits(mm);
			nP = getBits(nn);
			// System.out.println(nn + "," + mm);
			if (mP == nP && nn < mm && mm <= B) {
				if (notInclude(cmm, cmmMAX, mm)) {
					System.out.println(nn + "," + mm);
					cmm[cmmMAX++] = mm;
					result++;
				}
			}
		}
		return result;
	}

	private boolean notInclude(long[] cmm, int cmmMAX, long mm) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cmmMAX; i++) {
			if (cmm[i] == mm)
				return false;
		}
		return true;
	}

	private int getBits(long mm) {
		// TODO Auto-generated method stub
		int result = 1;
		while (mm / 10 > 0) {
			result++;
			mm = mm / 10;
		}
		return result;
	}

	private String shift(String n, int i) {
		// TODO Auto-generated method stub
		return n.substring(i) + n.substring(0, i);
	}

	public static void main(String args[]) {
		new RecycledNumbers();
	}
}
