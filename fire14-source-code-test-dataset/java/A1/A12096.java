import java.io.*;
import java.util.*;

public class Pilot {

	public static void main(String[] args) {
		Pilot my = new Pilot();

		Calendar cal1 = Calendar.getInstance();
		my.doAll();
		Calendar cal2 = Calendar.getInstance();
		// System.out.println("\nseconds : " + (cal2.getTimeInMillis() -
		// cal1.getTimeInMillis())/1000);
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
				int num = 0;
				strLine = br.readLine();
				String[] MAll = strLine.split(" ");
				int N = Integer.parseInt(MAll[0]);
				int S = Integer.parseInt(MAll[1]);
				int p = Integer.parseInt(MAll[2]);

				Integer[][] T = new Integer[N][3];

				for (int i = 0; i < N; i++) {

					int k = Integer.parseInt(MAll[3 + i]);
					T[i][0] = k;

					// non-suprising
					if ((k + 3) % 3 == 0)
						T[i][1] = (k + 3) / 3 - 1;
					else if ((k + 1) % 3 == 0)
						T[i][1] = (k + 1) / 3;
					else if ((k + 2) % 3 == 0)
						T[i][1] = (k + 2) / 3;

					// suprising
					if ((k + 2) % 3 == 0)
						T[i][2] = (k + 2) / 3;
					else if ((k + 3) % 3 == 0)
						T[i][2] = (k + 3) / 3;
					else if ((k + 4) % 3 == 0)
						T[i][2] = (k + 4) / 3;

					if (T[i][2] == 1)
						T[i][2] = -100;

					if (T[i][1] < p)
						T[i][1] = -100;

					if (T[i][2] < p)
						T[i][2] = -100;
				}

				Arrays.sort(T, new Comparator<Integer[]>() {
					@Override
					public int compare(Integer[] entry1, Integer[] entry2) {
						if (entry2[1] < 0 && entry2[2] < 0
								&& (entry1[1] < 0 || entry1[2] < 0))
							return -1;
						else
							return 0;
					}
				});

				int bo = 0, su = 0, no = 0;

				for (int i = 0; i < N; i++) {
					if (T[i][1] >= 0 && T[i][2] >= 0)
						bo++;
					else if (T[i][1] >= 0 && T[i][2] < 0)
						no++;
					else if (T[i][1] < 0 && T[i][2] >= 0)
						su++;
				}

				//System.out.println("both= " + bo + "\nnormal= " + no + "\nsuprising= " + su);

				if (S >= su) {
					num += su;
					S -= su;
					su = 0;
				} else {
					num += S;
					su -= S;
					S = 0;
				}

				if (S == 0) {
					num += no + bo;
				} else {
					num += no + bo;
				}

				for (int i = 0; i < N; i++) {
					//System.out.println(T[i][0] + " " + T[i][1] + " " + T[i][2]);
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
