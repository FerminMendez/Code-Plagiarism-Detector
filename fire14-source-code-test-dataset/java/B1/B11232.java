import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class C {
	public static void main(String[] args) throws NumberFormatException, IOException {
			// Use scanner! Good for reading in bigints too.
			// Arrays.fill for initialising arrays
			// Look up cumulative frequency tables (only for dynamic querying with new numbers coming in)
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("in.in")));
			PrintStream writer = new PrintStream(new FileOutputStream("out.out"));
			int cases = Integer.parseInt(reader.readLine());
			for (int i = 1; i <= cases; i++) {
				String[] tokens = reader.readLine().split(" ");
				int A = Integer.parseInt(tokens[0]);
				int B = Integer.parseInt(tokens[1]);
				HashSet<ArrayList<Integer>> numbers = new HashSet<ArrayList<Integer>>();
				int maxPow = (int) Math.log10(A);
				for (int j = A; j <= B; j++) {
					for (int k = 0; k < maxPow; k++) {
						int cycled = j / (int) Math.pow(10, k + 1) + j % (int) Math.pow(10, k + 1) * (int) Math.pow(10, maxPow - k);
						if (cycled >= A && cycled <= B && maxPow == (int) Math.log10(cycled) && cycled != j) {
							ArrayList<Integer> pair = new ArrayList<Integer>();
							pair.add(cycled);
							pair.add(j);
							Collections.sort(pair);
							numbers.add(pair);
						}
					}
				}
				writer.printf("Case #%d: %d\n", i, numbers.size());
			}
	}
}
