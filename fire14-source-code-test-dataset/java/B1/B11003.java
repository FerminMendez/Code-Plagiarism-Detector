package org.tritree_tritree;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProblemCSmall {

	public static void main(String[] args) throws IOException {
		File source = new File("C-small-attempt0.in");
		Scanner scan = new Scanner(source);

		int t = scan.nextInt();
		scan.nextLine();
		List<String> resultList = new ArrayList<String>();
		for (int i = 1; i < t + 1; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			String result = "Case #" + i + ": " + resolve(n, m);
			resultList.add(result);
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hhmmss");
		File resultFile = new File("C-small-" + dateFormat.format(new Date()) + ".out");
		FileOutputStream fileOutputStream = new FileOutputStream(resultFile);

		for (String result: resultList) {
			result = result + "\n";
			fileOutputStream.write(result.getBytes());
		}
		fileOutputStream.flush();
		fileOutputStream.close();
	}

	private static int resolve(int n, int m) {
		int cnt = 0;
		Set<Integer> pool = new HashSet<Integer>();
		for (int i = n; i < m + 1; i++) {
			if (i < 10 || pool.contains(i)) {
				continue;
			}
			List<Integer> recycleNumbers = getRecycleNumbers(i);
			System.out.println("i=" + i + ",recycleNumbers=" + recycleNumbers);
			Collections.sort(recycleNumbers);
			for (Iterator<Integer> iterator = recycleNumbers.iterator(); iterator.hasNext();) {
				int value = (Integer) iterator.next();
				if (n <= value && value <= m) {
					// do nothing
				} else {
					iterator.remove();
				}
			}
			if (1 < recycleNumbers.size()) {
				pool.addAll(recycleNumbers);
				cnt = cnt + getCombination(recycleNumbers.size());
			}
		}
		return cnt;
	}

	private static int getCombination(int size) {
		int result = (size * (size - 1)) / 2;
		return result;
	}

	private static List<Integer> getRecycleNumbers(int intValue) {
		Set<Integer> set = new LinkedHashSet<Integer>();
		String str = String.valueOf(intValue);
		for (int i = 0; i < str.length(); i++) {
			String string = getStartIndexString(str, i);
			if (string.startsWith("0")) {
				continue;
			}
			set.add(Integer.valueOf(string));
		}
		return new ArrayList<Integer>(set);
	}

	private static String getStartIndexString(String str, int startIndex) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
//			System.out.print("start:" + (startIndex + i) % str.length());
//			System.out.println(",end:" + ((startIndex + i) % str.length() + 1));
			builder.append(str.substring((startIndex + i) % str.length(), (startIndex + i) % str.length() + 1));
		}
		return builder.toString();
	}

}
