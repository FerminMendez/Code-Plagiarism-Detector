package google.gcj.recyclednumbers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers4 {

	public static void main(String[] args) throws FileNotFoundException {

		RecycledNumbers4 recycledNumbers = new RecycledNumbers4();
		recycledNumbers.doMain();
	}

	private void doMain() throws FileNotFoundException {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		int A, B, m, n, sum;

		for (int zz = 0; zz < T; zz++) {
			A = in.nextInt();
			B = in.nextInt();

			Queue<Integer> queue = new LinkedList<Integer>();
			Set<Integer> nm = new HashSet<Integer>();
			sum = 0;

			for (m = A; m <= B; m++) {
				if (!nm.contains(m)) {
					List<Integer> ml = integerToList(m);
					// new n
					queue.clear();
					for (int i = 0; i < ml.size(); i++) {
						queue.add(ml.get(i));
					}

					for (int j = 0; j < queue.size(); j++) {
						n = integerListToInteger(queue);
						if (A <= n && n < m && m <= B) {
							sum++;
							// System.out.format("Get %d\n", n);

							nm.add(m);
						}
						queue.add(queue.remove());
					}
				}
			}
			System.out.format("Case #%d: %s\n", zz + 1, sum);

		}
	}

	private List<Integer> integerToList(int B) {
		List<Integer> list = new ArrayList<Integer>();
		for (char c : String.valueOf(B).toCharArray()) {
			String s = String.valueOf(c);
			list.add(Integer.valueOf(s));
		}
		return list;
	}

	private int integerListToInteger(Queue<Integer> queue) {
		String s = "";
		for (int l : queue) {
			s += String.valueOf(l);
		}
		return Integer.valueOf(s);
	}

}
