import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {
	private Scanner in;
	
	private PrintWriter out;
	
	private final String file = "B";
	
	public B() throws IOException {
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
		int N, S, p, ti, mod, res, y;
		
		while (T-- > 0) {
			N = in.nextInt(); 
			S = in.nextInt();
			p = in.nextInt();
			y = 0;
			
			while (N-- > 0) {
				ti = in.nextInt();
				
				if (ti < p) {
					continue;
				}
				
				mod = ti % 3;
				res = (ti - mod)/3;
				
				if (res >= p) {
					y++; continue;
				}
				
				switch (mod) {
					case 0:
						if ((S > 0) && ((res + 1) >= p)) {
							y++; S--;
						}
						break;
					case 1:
						if ((res + 1) >= p) {
							y++;
						}
						break;
					case 2:
						if ((res + 1) >= p) {
							y++;
						} else if ((S > 0) && ((res + 2) >= p)) {
							y++; S--;
						}
						break;
				}
			}
			out.printf("Case #%d: %d%n", t++, y);
		}
		in.close();
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) throws IOException {
		new B();
	}
}