package prob2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class prob2 {
	public static void main(String args[]) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream("./src/prob2/a-small.in"))));
			BufferedWriter out = new BufferedWriter(new FileWriter("./src/prob2/a-small.out"));

			int line = Integer.parseInt(in.readLine());

			for (int i = 0; i < line; i++) {
				int count = 0;
				String inLine[] = in.readLine().split(" ");
				out.append("Case #" + (i+1) + ": ");
				int min = Integer.parseInt(inLine[0]);
				int max = Integer.parseInt(inLine[1]);
				Set<Integer> inn = new HashSet<Integer>();
				if (max > 11) {
					for (int l = min; l <= max; l++) {
						inn.clear();
						String ll = l + "";
						for (int a = ll.length() - 1; a >= 1; a--) {
							if (ll.charAt(a) != '0') {
								int t = Integer.parseInt(ll.substring(a) + ll.substring(0, a));
								if (l >= min && t <= max && l<t) {
									inn.add(t);
								}
							}
						}
						count+=inn.size();
					}
					out.append("" + count);
				} else {
					out.append("0");
				}
				out.append("\n");
			}

			out.flush();
			in.close();
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}
}
