package codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class DancingWithTheGooglers {
	
	private StreamTokenizer in;
	private PrintWriter out;
	
	public static void main (String[] args) throws IOException {
		new DancingWithTheGooglers().soilve();
	}
	
	int nextInt () throws IOException {
		in.nextToken();
		return (int)in.nval;
	}
	
	void soilve () throws IOException {
		in = new StreamTokenizer(new BufferedReader(new FileReader("./src/codejam/input.txt")));
		out = new PrintWriter(new FileWriter("./src/codejam/output.txt"));
		
		int t = nextInt();
		for (int i = 0; i < t; i++) {
			int n = nextInt();
			int s = nextInt();
			int p = nextInt();
			
			int max = 0;
			
			for (int j = 0; j<n; j++) {
				int a = nextInt();
				
				if (a == 0) {
					if (p == 0) {
						max++;
					}
					continue;
				}
				
				if (a % 3 == 0) {
					if (a / 3 >= p) {
						max++;
					} else if (((a / 3) + 1 == p) && (s > 0)) {
						max++;
						s--;
						
					}
				} else if (a % 3 == 2) {
					if ((a + 1) / 3 >= p) {
						max++;
					} else if ((((a + 1) / 3) + 1 == p) && (s > 0)) {
						max++;
						s--;
					}
				} else if (a % 3 == 1) {
					if ((a + 2) / 3 >= p) {
						max++;
					}
				}
			}
			
			out.println("Case #" + (i + 1) + ": " + max);
		}
		
		out.flush();
	}

}
