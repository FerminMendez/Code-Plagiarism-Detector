import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class B {
	public static void main(String[] args) throws NumberFormatException, IOException {
			// Use scanner! Good for reading in bigints too.
			// Arrays.fill for initialising arrays
			// Look up cumulative frequency tables (only for dynamic querying with new numbers coming in)
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("in.in")));
			PrintStream writer = new PrintStream(new FileOutputStream("out.out"));
			int cases = Integer.parseInt(reader.readLine());
			for (int i = 1; i <= cases; i++) {
				String[] tokens = reader.readLine().split(" ");
				int googlers = Integer.parseInt(tokens[0]);
				int surprising = Integer.parseInt(tokens[1]);
				int target = Integer.parseInt(tokens[2]);
				int maxReached = 0;
				for (int j = 3; j < googlers + 3; j++) {
					int total = Integer.parseInt(tokens[j]);
					if ((total / 3 + Math.min(total % 3, 1) >= target) || ((total / 3 + Math.max(total % 3, 1) >= target) &&
							(surprising-- > 0) && ((total >= 1) || (total % 3 != 0)))) {
						maxReached++;
					}
				}
				writer.printf("Case #%d: %d\n", i, maxReached);
			}
	}
}
