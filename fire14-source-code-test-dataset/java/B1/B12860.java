import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class C {
	private Scanner in;
	
	private PrintWriter out;
	
	private final String file = "C";
	
	public C() throws IOException {
		try {
			System.setIn(new FileInputStream("io/q/" + file));
			System.setOut(new PrintStream(new FileOutputStream("io/q/" + file + ".out")));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		in = new Scanner(new BufferedInputStream(System.in));
		
		out = new PrintWriter(System.out);
		
		// for case
		int T = in.nextInt(), t = 1;
		int A, B, l, sum, total, currentNumberChar, currentNumber;
		HashMap<Integer, Boolean> map;
		
		while (T-- > 0) {
			A = in.nextInt();
			B = in.nextInt();
			map = new HashMap<Integer, Boolean>(B - A + 1);
			total = 0;
			
			if (A > 9) {
				final int size = (A + "").length() - 1;
				final int exp = (int) Math.pow(10, size);
				
				for (int nextNumber = A; nextNumber <= B; nextNumber++) {
					// processed
					if (null != map.get(nextNumber)) continue;
					
					// process
					map.put(nextNumber, true);
					
					currentNumber = nextNumber;
					sum = 0;
					
					for (l = 0; l++ < size;) {
						currentNumberChar = currentNumber % 10;
						currentNumber = currentNumberChar*exp + (int)Math.floor(currentNumber/10);
												
						if ((currentNumber >= A) && (currentNumber <= B)) {
							if (null == map.get(currentNumber)) {
								map.put(currentNumber, true);
								sum++;
							}
						}
						
					}
					total += sum + sum*(sum-1)/2;
				}
			}			
			out.printf("Case #%d: %d%n", t++, total);
		}
		in.close();
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) throws IOException {
		new C();
	}
}