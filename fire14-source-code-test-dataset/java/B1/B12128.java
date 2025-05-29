import java.io.*;
import java.util.*;

public class Pilot {

	int Globe_k = 0;
	int max_units = 30;

	public static void main(String[] args) {
		Pilot my = new Pilot();

		Calendar cal1 = Calendar.getInstance();
		my.doAll();
		Calendar cal2 = Calendar.getInstance();
		// System.out.println("seconds : " + (cal2.getTimeInMillis() -
		// cal1.getTimeInMillis())/1000);
	}
	private static void doME(Vector<Integer> combination) {
		System.out.println(combination.toString());
	}
	public void doAll() {
		try {

			String out = "";

			FileInputStream fstream = new FileInputStream("in.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = "";

			int glob = Integer.parseInt(strLine = br.readLine());

			for (int j = 0; j < glob; j++) {

				
				
				
				Vector<Vector<Integer>> results = new Vector<Vector<Integer>>();
				
				strLine = br.readLine();
				String[] splitted = strLine.split(" ");
				int A = Integer.parseInt(splitted[0]);
				int B = Integer.parseInt(splitted[1]);

				int num = 0;

				for (int k = A; k <= B; k++) {
					int L = Integer.toString(k).length();
					int e = L - 1;
					int C = k;
					Integer[][] T = new Integer[L][2];

					for (int i = 0; i < L; i++) {
						T[i][0] = (C % 10);
						C /= 10;
						T[i][1] = i;
					}

					for (int i = 0; i < e; i++) {
						for (int q = 0; q < L; q++) {
							T[q][1] = (q + e - i) % L;
						}

						// for (int u = 0; u < L; u++)
						// System.out.println(T[u][0] + " " + T[u][1]);

						int n = k;
						int m = 0;
						for (int q = 0; q < L; q++)
							m += T[q][0] * (int) Math.pow(10, T[q][1]);

						if (A <= n && n < m && m <= B) {
							Vector<Integer> combination = new Vector<Integer>();;
							combination.addElement(n);
							combination.addElement(m);
							if (!results.contains(combination)) {
								//doME(combination);
								results.addElement(combination);
								//System.out.println(k + " - " + m);
								num++;
							}
							
						}
						// System.out.println("---");
					}
					
					
					
					
					
					
					
					
				}
				out += ("Case #" + (j + 1) + ": " + num + "\n");
			}
			in.close();
			out = out.trim();

			Writer output = null;
			File file = new File("out.out");
			output = new BufferedWriter(new FileWriter(file));
			output.write(out);
			output.close();

			System.out.print(out);

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			
			
		}
	}
}
