package b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GooglerDance {

	public int calculate(int s, int p, ArrayList<Integer> t) {
		int ret = 0;

		for(int ti : t) {
			int minbase = ti / 3;
			int overflow = ti % 3;

			if(minbase >= p) {
				ret++;
				continue;

			} else if(overflow == 0) {
				if((minbase + 1 == p) && (minbase > 0) && (s > 0)) {
					ret++;
					s--;
					continue;
				}

			} else if(overflow == 1) {
				if(minbase + 1 == p) {
					ret++;
					continue;
				}

			} else if(overflow == 2) {
				if(minbase + 1 == p) {
					ret++;
					continue;
				} else if((minbase + 2 == p) && (s > 0)) {
					ret++;
					s--;
					continue;
				}

			}
		}

		return ret;
	}


	public static void main(String args[]) throws Exception {

		//initial reader by args[0]
		BufferedReader r = new BufferedReader(new FileReader(args[0]));
		int cases = Integer.parseInt(r.readLine());

		//initial writer by args[1]
		PrintWriter w = new PrintWriter(args[1]);

		//do calculate
		GooglerDance g = new GooglerDance();
		for(int i = 1; i <= cases; i++) {
			String[] input = r.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			ArrayList<Integer> t = new ArrayList<Integer>();
			for(int x = 0; x < n; x++) {
				t.add(Integer.parseInt(input[x+3]));
			}

			w.println("Case #" + i + ": " + g.calculate(
					Integer.parseInt(input[1]),
					Integer.parseInt(input[2]),
					t)
			);
		}

		//close file handles
		w.close();
		r.close();
	}

}
