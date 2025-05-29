import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q3M {
	public static void main(String[] args) throws Exception {
		compute();
	}

	private static void compute() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(
				"C:\\work\\Q3\\C-small-attempt0.in")));
		String line = null;
		int i = Integer.parseInt(br.readLine());
		List l = new ArrayList();
		for (int j = 0; j < i; j++) {
			line = br.readLine();
			String[] nums = line.split(" ");
			l.add(calculate(nums));
		}
		writeOutput(l);
	}

	private static int calculate(String[] nums) {
		int min = Integer.parseInt(nums[0]);
		int max = Integer.parseInt(nums[1]);
		int count = 0;
		List l = new ArrayList();
		for (int i = min; i <= max; i++) {
			for (int times = 1; times < countDigits(i); times++) {
				int res = shiftNum(i, times);
				if (res <= max && i < res) {
					if ((!l.contains((i + ":" + res)))) {
						l.add(i + ":" + res);
						l.add(res + ":" + i);
						count++;
					}
				}
			}
		}
		return count;
	}

	private static boolean checkZeros(int temp, int res) {
		if (temp % 10 == 0 || res % 10 == 0)
			return false;
		return true;
	}

	private static int shiftNum(int n, int times) {
		int base = (int) Math.pow(10, times);
		int temp2 = n / base;
		int placeHolder = (int) Math.pow((double) 10,
				(double) countDigits(temp2));
		int res = placeHolder * (n % base) + temp2;
		if (countDigits(res) == countDigits(n)) {
			return res;
		} else {
			return 2000001;
		}
	}

	public static int countDigits(int x) {
		if (x < 10)
			return 1;
		else {
			return 1 + countDigits(x / 10);
		}
	}

	private static void writeOutput(List l) throws Exception {
		StringBuffer b = new StringBuffer();
		int i = 1;
		BufferedWriter br = new BufferedWriter(new FileWriter(new File(
				"C:\\work\\Q3\\ans.txt")));
		for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			br.write("Case #" + i++ + ": " + iterator.next());
			br.newLine();
		}
		br.close();
	}

}