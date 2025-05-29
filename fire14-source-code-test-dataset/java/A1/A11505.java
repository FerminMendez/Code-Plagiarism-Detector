package World2012_01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class B {
	public static final String in = "/Users/vickcy/Downloads/B-small-attempt1.in.txt";
	public static final String out = "outB.txt";
	
	public static void main(String[] args) throws Exception {
		Writer writer = new OutputStreamWriter(new FileOutputStream(out));
		Scanner sc = new Scanner(new File(in));
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int result = 0;
			
			if (p == 0) {
				result = N;
				while (N-- > 0) sc.nextInt();
			} else {
				while (N-- > 0) {
					int ti = sc.nextInt();
					if (ti >= p * 3 - 2) {
						++result;
					} else if (p == 1) {
						result += ti > 0 ? 1 : 0;
					} else if (ti >= p * 3 - 4) {
						if (S > 0) {
							--S;
							++result;
						}
					}
				}	
			}
			writer.write("Case #" + i + ": " + result + "\n");
		}
		writer.close();
	}

}
