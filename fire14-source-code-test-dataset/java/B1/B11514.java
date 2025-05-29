package Qualification.A.jam2011;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*

 4
 3 1 5 15 13 11
 3 0 8 23 22 21
 2 1 1 8 0
 6 2 8 29 20 8 18 18 21


 */
public class test {
	static int A = 0;
	static int B = 0;

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		File f = new File("output.txt");
		FileWriter fw = new FileWriter(f);

		for (int j = 0; j < T; j++) {

			A = in.nextInt();
			B = in.nextInt();

//			System.out.print("Case #" + (j + 1) + ": " + possible(A, B) + "\n");

			fw.write("Case #" + (j + 1) + ": " + possible(A, B) + "\n");
			// System.out.println("Case #" + (j + 1) + ": " + passed(s) + "\n");
		}

		fw.flush();
		fw.close();

	}

	private static int possible(Integer a, Integer b) {
		String as = a + "";
		int count = 0;
		int no=b-a+1;
		System.out.println(no);
		for (int i = 0; i < no; i++) {
//			if (as.length() == 1 && bs.length() == 1) {
//
//			} else {
			System.out.println(as+ "   "+i);
				ArrayList<String> aa = reverseNo(as);
				int n = Integer.parseInt(aa.get(0));
				for (int j = 1; j < aa.size(); j++) {
					
					int m = Integer.parseInt(aa.get(j));
					
					if (A <= n && n < m && m <= B) {
						if(aa.get(j).length()==aa.get(0).length())
							count++;
					}
				}
//			}
			a++;
			as = (a) + "";
			

		}
		return count;

	}

	private static ArrayList<String> reverseNo(String A) {
		ArrayList<String> aa = new ArrayList<String>();
		int alen = A.length();
		for (int i = 0; i < alen; i++) {
			aa.add(A.substring(i) + A.substring(0, i));
		}
		

		return aa;
	}

}