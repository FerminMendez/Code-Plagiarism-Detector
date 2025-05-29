import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author kishor
 * 
 */
public class Dance {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File f = new File("/tmp/dance.txt");
		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(f)));
		int lines = Integer.parseInt(bReader.readLine());
		String strLine = null;
		int n, s, p;
		int score[];
		String tokens[];
		for (int i = 0; i < lines; i++) {
			strLine = bReader.readLine();
			tokens = strLine.split(" ");
			n = Integer.parseInt(tokens[0]);
			s = Integer.parseInt(tokens[1]);
			p = Integer.parseInt(tokens[2]);
			score = new int[n];
			for (int j = 3; j < n + 3; j++) {
				score[j - 3] = Integer.parseInt(tokens[j]);
			}
			System.out.println("Case #" + (i + 1) + ": "
					+ getMaxDancers(s, p, score));
		}
	}

	protected static int getMaxDancers(int s, int p, int scores[]) {
		int retValue = 0;
		int rem;
		int a, b;
		int d1, d2, d3;
		for (int score : scores) {
			if (p * 3 <= score) {
				retValue++;
				continue;
			}
			if (score < p)
				continue;
			rem = score - p;
			a = (int) rem / 2;
			b = score - p - a;
			if (b < 0)
				continue;
			d1 = a > b ? a - b : b - a;
			d2 = a > p ? a - p : p - a;
			d3 = b > p ? b - p : p - b;
			if(d1 >= 3 || d2 >= 3 || d3 >= 3)
				continue;
			if(d1 == 2 || d2 == 2 || d3 == 2) {
				if(s > 0) {
					s--;
					retValue++;
					continue;
				} else {
					continue;
				}
			}
			retValue ++;
		}
		return retValue;
	}
}
