package qualification.round.atual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File f = new File("C-small-practice.in");
		FileInputStream fis = new FileInputStream(f);
		Scanner scanner = new Scanner(fis);

		File fOut = new File("C-small-practice.out");
		Writer out = new BufferedWriter(new FileWriter(fOut));

		try {
			int t = Integer.parseInt(scanner.nextLine());

			for (int i = 1; i <= t; i++) {
				out.write("Case #" + i + ": "
						+ getNumberOfRecycledNumbers(scanner.nextLine()) + "\n");
			}

		} finally {
			scanner.close();
			out.close();
		}

	}

	private static int getNumberOfRecycledNumbers(String line) {
		int number = 0;
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		String v[] = line.split(" ");
		int a = Integer.parseInt(v[0]);
		int b = Integer.parseInt(v[1]);

		int c = a;

		while (c <= b) {
			String cStr = "" + c;
			for (int i = 0; i < cStr.length(); i++) {
				String newNumber = cStr.substring(i + 1);
				newNumber = newNumber + cStr.substring(0, i + 1);

				int newIntNumber = Integer.parseInt(newNumber);
				if (newIntNumber != c && newIntNumber >= a && newIntNumber <= b) {
					List<Integer> listNewInt = map.get(newIntNumber);
					boolean skip = false;
					if (listNewInt != null) {
						for (Integer integer : listNewInt) {
							if (integer == c) {
								skip = true;
							}
						}
					}
					
					if (skip) {
						continue;
					}
					
					if (map.get(c) == null) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(newIntNumber);
						map.put(c, list);
					} else {
						map.get(c).add(newIntNumber);
					}
				}
			}

			c++;
		}

		Set<Integer> set = map.keySet();
		for (Integer integer : set) {
			number += map.get(integer).size();
		}
		
		
		return number;
	}
}