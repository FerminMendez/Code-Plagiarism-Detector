import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class RecycledNumbers {
	public static void main(String args[]) throws FileNotFoundException {
		new RecycledNumbers().Go();
	}

	public void Go() throws FileNotFoundException {
		Scanner in = new Scanner(new File("test.txt"));
		int tests = Integer.parseInt(in.nextLine());
		for (int i = 0; i < tests; i++) {
			String[] line = in.nextLine().split("\\s+");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			System.out.println("Case #" + (i + 1) + ": "
					+ countPairs(n, m, 1, 1000));
		}
	}

	public int countPairs(int n, int m, int A, int B) {
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();

		int count = 0;
		for (int i = n; i <= m; i++) {

			LinkedList<Integer> intList = permutations(i + "");
			map.put(i, intList);
			for (Integer it : intList) {
				if (map.containsKey(it)) {
					LinkedList<Integer> ints = map.get(it);
					if (ints.contains(i)) {
						count++;
					}
				}
			}
		}
		
		return count;
	}

	public LinkedList<Integer> permutations(String str) {
		LinkedList<Integer> numList = new LinkedList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			Integer temp = Integer.parseInt(str);
			if (!numList.contains(temp))
				numList.add(Integer.parseInt(str));
			str = leftRotate(str);
		}
		numList.removeFirst();
		return numList;
	}

	public String leftRotate(String str) {
		StringBuilder build = new StringBuilder();
		build.append(str.substring(1, str.length()));
		build.append(str.charAt(0));
		return build.toString();
	}
}
