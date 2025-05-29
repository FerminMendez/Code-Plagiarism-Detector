package round1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ProblemC {

	public static void main(String[] args) {
		int a = 1555555;
		int b = 2266666;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(args[0]));
			int lineNumber = 0;
			String line = null;
			while ((line = in.readLine()) != null) {
				if (lineNumber > 0) {
					String[] split = line.split(" ");
					a = Integer.parseInt(split[0]);
					b = Integer.parseInt(split[1]);
					System.out.println("Case #" + lineNumber + ": "
							+ getRecycledCount(a, b));
				}
				lineNumber++;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	private static int getRecycledCount(int a, int b) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = a; i <= b; i++) {
			String string = Integer.toString(i);
			char[] charArray = string.toCharArray();
			Arrays.sort(charArray);
			String key = new String(charArray);
			List<String> list = map.get(key);

			if (list == null) {
				list = new ArrayList<String>();
			}
			list.add(string);
			map.put(key, list);
		}
		Collection<List<String>> values = map.values();
		int count = 0;
		for (List<String> list : values) {
			if (list.size() > 1) {
				count = count + getRotations(list);
			}
		}
		return count;
	}

	private static int getRotations(List<String> list) {
		int count = 0;
		while (list.size() > 1) {
			String str1 = list.remove(0);
			for (String str2 : list) {
				String str3 = str2 + str2;
				if (str3.contains(str1)) {
					// list.remove(str2);
					// System.out.println(str1 + " " + str2);
					count++;
					// break;
				}

			}
		}
		return count;
	}
}
