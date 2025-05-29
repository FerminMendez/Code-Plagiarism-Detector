import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class BSmall {
	public static void get() {
		try {
			File inputFile = new File("B-small-attempt3.in");
			inputFile.createNewFile();
			Scanner scan = new Scanner(inputFile);
			int t = Integer.parseInt(scan.nextLine());
			File out = new File("out.txt");
			FileWriter fw = new FileWriter(out);
			for (int i = 0; i < t - 1; i++) {
				fw.append("Case #" + (i + 1) + ": ");
				int counter = 0;
				int n = scan.nextInt();
				int s = scan.nextInt();
				int p = scan.nextInt();

				for (int j = 0; j < n; j++) {
					int g1 = scan.nextInt();
					if (g1 == 0 && p > 0) {
						continue;
					}

					if (p > 0) {
						int key = g1 / p;

						if (key >= 3) {
							counter++;
						} else {
							if (key == 2) {
								int talet = p + (g1 % p);
								int v = talet / 2;
								if (p - v == 1) {
									counter++;
								} else {
									if (p - v == 2 && s > 0) {
										counter++;
										s--;
									}
								}
							} else {
								int x = g1 - p;
								x = x / 2;
								if (p - x == 1) {
									counter++;
								} else {
									if (p - x == 2 && s > 0) {
										s--;
										counter++;
									}

								}
							}

						}
					} else {
						counter++;
					}

				}
				fw.append("" + counter + "\n");
			}

			fw.append("Case #" + (t) + ": ");
			int counter = 0;
			int n = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();

			for (int j = 0; j < n; j++) {
				int g1 = scan.nextInt();
				if (p > 0) {
					int key = g1 / p;

					if (key >= 3) {
						counter++;
					} else {
						if (key == 2) {
							int talet = p + g1 % p;
							int v = talet / 2;
							if (p - v == 1) {
								counter++;
							} else {
								if (p - v == 2 && s > 0) {
									counter++;
									s--;
								}
							}
						}

					}
				} else {
					counter++;
				}
			}
			fw.append("" + counter);
			fw.close();

		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		get();
	}

}
