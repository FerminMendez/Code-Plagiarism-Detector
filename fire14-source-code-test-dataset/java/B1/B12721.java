import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.Integer;
import java.util.HashSet;
import java.util.Scanner;

public class RecycledNumbers {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader("input.in")));
		int x = new Integer(in.nextLine());
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int xi = 1; xi <= x; xi++) {
			String[] token = in.nextLine().split(" ");
			int min = Integer.parseInt(token[0]);
			int max = Integer.parseInt(token[1]);
			int count = 0;
			for (int i = min; i <= max; i++) {
				String s = Integer.toString(i);

				for (int j = 0; j < Integer.toString(min).length(); j++) {
					Integer recycle = Integer.parseInt(s.substring(j)
							+ s.substring(0, j));
					if (!visited.contains(recycle))
						if (recycle < i && recycle >= min && recycle <= max)
							count++;
					visited.add(recycle);
				}
				visited.clear();
			}
			System.out.print("Case #" + xi + ": ");
			System.out.println(count);
		}

	}
}