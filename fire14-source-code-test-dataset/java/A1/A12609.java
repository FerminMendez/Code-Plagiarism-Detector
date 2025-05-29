import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class dance {

	int single[][] = new int[4][3];
	int doublex[][] = new int[54][3];

	dance() {
		single[0][0] = 0;
		single[0][1] = 0;
		single[0][2] = 0;

		single[1][0] = 0;
		single[1][1] = 0;
		single[1][2] = 1;

		single[2][0] = 10;
		single[2][1] = 10;
		single[2][2] = 9;

		single[3][0] = 10;
		single[3][1] = 10;
		single[3][2] = 10;
	}

	int[][] gen_tuple(int num) {
		int tup[][] = new int[2][3];
		if (num % 3 == 0) {
			tup[0][0] = num / 3;
			tup[0][1] = num / 3;
			tup[0][2] = num / 3;

			tup[1][0] = num / 3 - 1;
			tup[1][1] = num / 3;
			tup[1][2] = num / 3 + 1;

		} else if (num % 3 == 1) {
			tup[0][0] = num / 3;
			tup[0][1] = num / 3;
			tup[0][2] = num / 3 + 1;

			tup[1][0] = num / 3 + 1;
			tup[1][1] = num / 3 + 1;
			tup[1][2] = num / 3 - 1;

		} else if (num % 3 == 2) {
			tup[0][0] = num / 3;
			tup[0][1] = num / 3 + 1;
			tup[0][2] = num / 3 + 1;

			tup[1][0] = num / 3;
			tup[1][1] = num / 3;
			tup[1][2] = num / 3 + 2;

		}
		return tup;
	}

	int maxx(int a, int b, int c) {
		int temp = Math.max(a, b);
		temp = Math.max(temp, c);
		return temp;

	}

	public static void main(String[] args) throws IOException {

		dance my = new dance();
		for (int i = 2; i < 29; i++) {
			int temp[][] = my.gen_tuple(i);
			// System.out.println((i - 2) * 2);
			my.doublex[(i - 2) * 2][0] = temp[0][0];
			my.doublex[(i - 2) * 2][1] = temp[0][1];
			my.doublex[(i - 2) * 2][2] = temp[0][2];

			my.doublex[(i - 2) * 2 + 1][0] = temp[1][0];
			my.doublex[(i - 2) * 2 + 1][1] = temp[1][1];
			my.doublex[(i - 2) * 2 + 1][2] = temp[1][2];

			// System.out.print(my.doublex[(i - 2) * 2][0] + " ");
			// System.out.print(my.doublex[(i - 2) * 2][1] + ",");
			// System.out.print(my.doublex[(i - 2) * 2][2] + ",");
			// System.out.print(my.doublex[(i - 2) * 2 + 1][0] + ",");
			// System.out.print(my.doublex[(i - 2) * 2 + 1][1] + ",");
			// System.out.println(my.doublex[(i - 2) * 2 + 1][2] + ",");

		}

		String Path = "C:\\Users\\Dell\\Desktop\\B-small-attempt0.in";
		Scanner read = new Scanner(new File(Path));

		File file = new File("C:\\Users\\Dell\\Desktop\\out.txt");
		PrintWriter Fout = new PrintWriter(new BufferedWriter(new FileWriter(
				file)), true);

		String line = read.nextLine();
		int iter = 0;

		while (read.hasNextLine()) {
			iter = iter + 1;
			line = read.nextLine();

			String d = "[ ]+";
			String[] SplitD = line.split(d);
			for (int x = 0; x < SplitD.length; x++) {
				// System.out.println(SplitD[x]);
			}

			int N = Integer.parseInt(SplitD[0]);
			int S = Integer.parseInt(SplitD[1]);
			int p = Integer.parseInt(SplitD[2]);

			int count = 0;
			int surp = 0;

			for (int j = 0; j < N; j++) {

				int val = Integer.parseInt(SplitD[j + 3]);

				if (val < 2) {

					if (my.maxx(my.single[val][0], my.single[val][1],
							my.single[val][2]) >= p) {
						count += 1;
					}

				} else if (val > 28) {
					if (my.maxx(my.single[val - 27][0], my.single[val - 27][1],
							my.single[val - 27][2]) >= p) {
						count += 1;
					}
				} else {
					if (my.maxx(my.doublex[(val - 2) * 2][0],
							my.doublex[(val - 2) * 2][1],
							my.doublex[(val - 2) * 2][2]) >= p) {
						count += 1;
					} else if (my.maxx(my.doublex[(val - 2) * 2 + 1][0],
							my.doublex[(val - 2) * 2 + 1][1],
							my.doublex[(val - 2) * 2 + 1][2]) >= p) {
						surp += 1;
					}
				}
			}

			if (surp > S) {
				count = count + S;
			} else {
				count = count + surp;
			}
			String output_str = "Case #" + iter + ": " + count;
			Fout.println(output_str);
		}
		read.close();
	}

}