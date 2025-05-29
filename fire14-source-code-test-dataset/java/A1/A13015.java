import java.io.*;

public class Main2 {
	public static void main(String[] args) {
		try {
			String[] a;
			FileInputStream fstream = new FileInputStream("B-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			FileWriter fst = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fst);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = br.readLine();
			int x = Integer.parseInt(strLine);
			int result = 0;
			for (int j = 0; j < x; j++) {
				result = 0;
				System.out.print("Case #" + (j + 1) + ": ");
				strLine = br.readLine();
				a = strLine.split(" ");

				int n = Integer.parseInt(a[0]);
				int s = Integer.parseInt(a[1]);
				int p = Integer.parseInt(a[2]);

				for (int i = 3; i < (n + 3); i++) {
					int total = Integer.parseInt(a[i]);
					int temp = total / 3;
					int reminder = ((Integer.parseInt(a[i])) - (3 * temp));

					if (temp >= p) {
						result++;
					} else {
						if (reminder == 1) {

							if ((temp + 1) >= p)
								result++;

						} else if (reminder == 2) {
							if ((temp + 1) >= p)
								result++;
							else {
								if ((temp + 2) >= p && s != 0) {
									result++;
									s--;
								}
							}
						} else {
							if ((temp + 1) == p && s != 0 && temp != 0) {
								result++;
								s--;
							}

						}
					}
				}

				out.append("Case #" + (j + 1) + ": " + result);
				out.newLine();
				System.out.println(result);
			}

			in.close();
			out.close();
		} catch (Exception e) {// Catch exception if any
		}
	}
}