import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Hashtable;

public class codejamb {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws Exception {
		RandomAccessFile r = new RandomAccessFile("testcase.txt", "r");
		PrintWriter p = new PrintWriter("out.txt");
		int t = Integer.parseInt(r.readLine());
		for (int i = 1; i <= t; i++) {
			String[] line = (r.readLine()).split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int count = countIt(a, b);
			p.println("Case #" + i + ": " + count);
		}
		p.close();

	}

	static int countIt(int a, int b) {
		int count = 0;
		for (int i = a; i <= b; i++) {
			for (int j = i + 1; j <= b; j++) {
				if (checkPair(i + "", j + "")) {
					count++;
				}
			}
		}
		return count;
	}

	static boolean checkPair(String x, String y) {
		if (x.length() == y.length() && isTheSame(x, y)) {
			for (int i = x.length() - 1; i >= 0; i--) {
				String sub = x.substring(i);
				// String sub2 = y.substring(0, sub.length());
				String newStr = sub + x.substring(0, i);
				if (newStr.equalsIgnoreCase(y))
					return true;
			}
			return false;
		} else {
			return false;
		}
	}

	static boolean isTheSame(String x, String y) {
		char[] xArr = x.toCharArray();
		char[] yArr = y.toCharArray();
		for (int i = 0; i < xArr.length; i++) {
			for (int j = 0; j < yArr.length; j++) {
				if (xArr[i] == yArr[j]) {
					xArr[i] = 0;
					yArr[j] = 0;
					break;
				}
			}
		}
		for (int i = 0; i < yArr.length; i++) {
			if (yArr[i] != 0 || xArr[i] != 0)
				return false;
		}
		return true;
	}

}
