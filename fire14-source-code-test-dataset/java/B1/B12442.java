import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class CSmall {
	LinkedList<Integer>[]	map;

	public static void main(String[] args) throws FileNotFoundException {
		CSmall csmall = new CSmall();
		csmall.generateMap(1005);

		Scanner scanf = new Scanner(new File("CSmall_in.txt"));
		int T = scanf.nextInt();

		for (int t = 1; t <= T; t++) {
			int A = scanf.nextInt();
			int B = scanf.nextInt();
			System.out.println("Case #" + t + ": " + csmall.result(A, B));
		}
	}

	int result(	int a, int b) {
		int total = 0;
		for (int n = a; n <= b; n++) {
			int current = countBetween(n, a, b);
			total += current;
		}

		return total;
	}

	int countBetween(	int n, int low, int high) {
		LinkedList<Integer> list = map[n];

		int lowIndex = 0;
		for (; lowIndex < list.size() && list.get(lowIndex) < low; lowIndex++)
			;
		int highIndex = lowIndex;
		for (; highIndex < list.size() && list.get(highIndex) <= high; highIndex++)
			;

		return highIndex - lowIndex;
	}

	void generateMap(	int size) {
		map = new LinkedList[size + 1];

		for (int i = 0; i < map.length; i++) {
			map[i] = new LinkedList<Integer>();
		}

		for (int n = 1; n <= map.length; n++) {
			char[] charsInN = Integer.toString(n).toCharArray();

			for (int j = 0; j < charsInN.length; j++) {

				int rotation = rotateLeft(charsInN);

				if (rotation > size) {
					continue;
				}

				if (rotation < n) {
					map[rotation].add(n);
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			Collections.sort(map[i]);
		}
	}

	int rotateLeft(	char[] chars) {
		int l = chars.length - 1;
		char c = chars[0];
		for (int i = 0; i < l; chars[i] = chars[++i])
			;

		chars[l] = c;

		return Integer.parseInt(new String(chars));
	}
}
