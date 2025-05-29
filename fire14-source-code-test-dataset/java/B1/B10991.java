package c;

import java.io.*;
import java.lang.Math.*;
import java.util.Arrays;

public class C {

	public static void main(String[] args) {

		try {
			BufferedReader input = new BufferedReader(new FileReader("C:/CodeJam/C-small-attempt0.in"));
			BufferedWriter output = new BufferedWriter(new FileWriter("C:/CodeJam/C-small-attempt0.out"));
			try {
				int T = Integer.parseInt(input.readLine());

				//Process each case
				for (int i = 0; i < T; i++) {
					String line = input.readLine();
					String[] AB = line.split(" ");
					int A = Integer.parseInt(AB[0]);
					int B = Integer.parseInt(AB[1]);
					String max = String.valueOf(B);
					
					//Check every n,m pair for cur case
					int count = 0;
					for (int j = A; j < B; j++) {
						String n = String.valueOf(j);
						String m = n;
						int len = m.length();
						//For single digit numbers, no matches possible
						if (len == 1) {
							break;
						}
						//Check each possible match for current n
						int[] matches = new int[len];
						int subcount = 0;
						for (int k = 0; k < len; k++) {
							//Check current permutation of m for valid range
							if (m.compareTo(n) > 0 && m.compareTo(max) <= 0) {
								matches[subcount] = Integer.parseInt(m);
								subcount++;
							}
							//Move the last digit to the front
							m = m.substring(len - 1, len) + m.substring(0, len - 1);
						}
						//Check the matches for duplicates and uncount them
						Arrays.sort(matches);
						for (int k = 0; k < len - 1; k++) {
							if(matches[k] != 0 && matches[k+1] != 0 && matches[k] == matches[k+1]) {
								subcount--;
							}
						}
						count += subcount;
					}

					System.out.println("Case #" + (i + 1) + ": " + count);
					output.write("Case #" + (i + 1) + ": " + count + "\n");
				}
			} finally {
				input.close();
				output.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
