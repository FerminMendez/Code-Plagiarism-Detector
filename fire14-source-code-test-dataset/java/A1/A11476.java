package Qualification.A.jam2011;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*

 4
 3 1 5 15 13 11
 3 0 8 23 22 21
 2 1 1 8 0
 6 2 8 29 20 8 18 18 21


 */
public class C {
	static int S;
	static int p;
	static int min;

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		File f = new File("output.txt");
		FileWriter fw = new FileWriter(f);
		in.nextLine();

		for (int j = 0; j < T; j++) {

			S = in.nextInt();
			p = in.nextInt();
			min = in.nextInt();

			String s = in.nextLine();
			// System.out.println(S+"\n"+p+"\n"+min);
			s = s.substring(1);
			// System.out.println(s);

			fw.write("Case #" + (j + 1) + ": " + passed(s) + "\n");
			// System.out.println("Case #" + (j + 1) + ": " + passed(s) + "\n");
		}

		fw.flush();
		fw.close();

	}

	private static int passed(String s) {
		String[] v = s.split(" ");
		// int[] intv=new int[v.length];
		int total = 0;
		for (int i = 0; i < v.length; i++) {
			// intv[i]=Integer.parseInt(v[i]);
			total += calc(Integer.parseInt(v[i]));
		}

		return total;
	}

	private static int calc(int parseInt) {
		int base = parseInt / 3;
		switch (parseInt % 3) {
		case 0: {
			if (base >= min) {
				return 1;
			} else {
				if (p > 0 && base > 0 && base + 1 >= min) {
					p--;
					return 1;
				}
			}

			break;
		}
		case 1: {
			if (base >= min || base + 1 >= min) {
				return 1;
			} else {
				if (p > 0 && base > 0 && base + 1 >= min) {
					p--;
					return 1;
				}
			}

			break;
		}
		case 2: {
			if (base + 1 >= min || base >= min) {
				return 1;
			} else {
				if (p > 0 && base > 0 && base + 2 >= min) {
					p--;
					return 1;
				}
			}

			break;
		}
		}

		/*
		 * if(parseInt<min) return 0; //System.out.println(parseInt); if (base
		 * >= min) { return 1; } if (base == min - 1) { if (parseInt % 3 != 0) {
		 * return 1; } } if (p > 0) { if (base >= min - 2) { if (parseInt % 3 >=
		 * 0) { p = p - 1; return 1; }
		 * 
		 * } if (base == min - 1) { if (parseInt % 3 == 0) { p = p - 1; return
		 * 1; }
		 * 
		 * }
		 * 
		 * }
		 */
		return 0;
	}
}