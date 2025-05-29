import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class C {

	public static void main(String[] args) {
		try {
			// so eclipse can read file from system in
			System.setIn(new FileInputStream(new File("small.in")));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		Scanner scanner = new Scanner(System.in);
		long T = scanner.nextLong();
		scanner.nextLine();
		for (int i = 0; i < T; i++) {
			long A = scanner.nextLong();
			long B = scanner.nextLong();
			long count = 0;
			for (long number = A; number <= B; number++) {
				String numberS = String.valueOf(number);
				Set<String> newNumbers = new HashSet<String>();
				for (int k = 1; k < numberS.length(); k++) {
					String newNumberS = numberS.substring(numberS.length() - k) + numberS.substring(0, numberS.length() - k);
					if (newNumbers.contains(newNumberS)) {
						continue;
					}
					newNumbers.add(newNumberS);
					long newNumber = Long.parseLong(newNumberS);
					if (newNumber != number && newNumber > number && newNumber >= A && newNumber <= B) {
						count++;
					}
				}
			}
			System.out.printf("Case #%d: %d%n", i + 1, count);
		}
	}
}
