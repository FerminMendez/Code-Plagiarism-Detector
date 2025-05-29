import java.util.*;
import java.io.*;

public class B  {
	public static void main (String [] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("B-small-0.in"));
			PrintWriter pw = new PrintWriter("B-small-0.out");
			int inputNo;
			inputNo = Integer.parseInt(br.readLine());

			for (int i = 1; i <= inputNo; i++) {
				// get one input here
				String in = br.readLine();
				pw.println("Case #" + i + ": " + processInput(in));
			}

			br.close();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int processInput(String in) {
		int result = 0;

		Scanner sc = new Scanner(in);
		int gNo = Integer.parseInt(sc.next());
		int sup = Integer.parseInt(sc.next());
		int max = Integer.parseInt(sc.next());
		int supNo = 0;
		int goodNo = 0;

		for (int i = 0; i < gNo; i++) {
			int total = Integer.parseInt(sc.next());
			int can = canMax(max, total);
			if (can == 1) supNo++;
			if (can == 0) goodNo++;
		}

		if (supNo > sup) result = goodNo + sup;
		else result = goodNo + supNo;

		return result;
	}

	public static int canMax(int max, int total) {
		int av = total/3;
		int r = total%3;
		if (r == 0) {
			if (av >= max) return 0;
			if (av+1 >= max && av+1 <= 10 && av-1 >= 0) return 1;
			return -1;
		}
		if (r == 1) {
			if (av+1 >= max && av + 1 <= 10) return 0;
			return -1;
		}
		if (r == 2) {
			if (av+1 >= max && av+1 <= 10) return 0;
			if (av+2 >=max && av+2 <= 10) return 1;
			return -1;
		}

		return -1;
	}
}
