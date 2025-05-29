package org.tritree_tritree;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProblemBSmall {

	static private Map<Integer, Integer> MAP_1 = new HashMap<Integer, Integer>();
	static private Map<Integer, Integer> MAP_2 = new HashMap<Integer, Integer>();

	static {
		MAP_1.put(10, 28);
		MAP_1.put(9, 25);
		MAP_1.put(8, 22);
		MAP_1.put(7, 19);
		MAP_1.put(6, 16);
		MAP_1.put(5, 13);
		MAP_1.put(4, 10);
		MAP_1.put(3, 7);
		MAP_1.put(2, 4);
	}

	static {
		MAP_2.put(10, 26);
		MAP_2.put(9, 23);
		MAP_2.put(8, 20);
		MAP_2.put(7, 17);
		MAP_2.put(6, 14);
		MAP_2.put(5, 11);
		MAP_2.put(4, 8);
		MAP_2.put(3, 5);
		MAP_2.put(2, 2);
	}

	public static void main(String[] args) throws IOException {
		File source = new File("B-small-attempt0.in");
		Scanner scan = new Scanner(source);

		int t = scan.nextInt();
		scan.nextLine();
		List<String> resultList = new ArrayList<String>();
		for (int i = 1; i < t + 1; i++) {
			int n = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();
			int[] pointArray = new int[n];
			for (int j = 0; j < n; j++) {
				pointArray[j] = scan.nextInt();
			}
			String result = "Case #" + i + ": " + resolve(s, p, pointArray);
			resultList.add(result);
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hhmmss");
		File resultFile = new File("B-small-" + dateFormat.format(new Date()) + ".out");
		FileOutputStream fileOutputStream = new FileOutputStream(resultFile);

		for (String result: resultList) {
			result = result + "\n";
			fileOutputStream.write(result.getBytes());
		}
		fileOutputStream.flush();
		fileOutputStream.close();
	}

	private static int resolve(int s, int p, int[] pointArray) {
		int cnt = 0;
		int remainScnt = s;
		for (int i = 0; i < pointArray.length; i++) {
			int target = pointArray[i];
			if (p*3 -2  <= target) {
				cnt++;
			} else if (target == 0) {
				continue;
			} else if (0 < remainScnt) {
				if (p*3 -4  <= target) {
					cnt++;
					remainScnt--;
				}
			}
		}
		return cnt;
	}

}
