import java.io.*;
import java.util.*;

public class RecycledNumbersSmall {
	public static void main(String[] args) {
		try {
			FileWriter output = new FileWriter(new File("output.txt"));
			Scanner s = new Scanner(new File("input.txt"));
			int trials = s.nextInt();
			s.nextLine();
			for (int i = 0; i < trials; i++) {
				int count = 0;
				int start = s.nextInt();
				int end = s.nextInt();
				for (int b = end; b >= start; b--) {
					String numWord = b + "";
					ArrayList<Integer> added = new ArrayList<Integer>();
					for (int z = numWord.length() - 1; z >= 1; z--) {
						if (numWord.charAt(z) != '0') {
							int x = Integer
									.parseInt(numWord.substring(z,
											numWord.length())
											+ numWord.substring(0, z));
							if (x < b && x >= start && !added.contains(x)) {
								added.add(x);
								count++;
							}
						}
					}
				}
				output.write("Case #" + (i + 1) + ": ");
				output.write("" + count);
				output.write('\n');
			}
			s.close();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
