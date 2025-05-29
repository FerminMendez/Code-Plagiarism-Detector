import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.Math.*;

public class RecycledNumbers {
	String PROBLEM_ID = "RecycledNumbers";

	enum TestType {
		EXAMPLE, SMALL, LARGE
	}

//	 TestType TYPE = TestType.EXAMPLE;
	 TestType TYPE = TestType.SMALL;
//	TestType TYPE = TestType.LARGE;

	public String getFileName() {
		String result = PROBLEM_ID + "_";
		switch (TYPE) {
		case EXAMPLE:
			result += "example";
			break;
		case SMALL:
			result += "small";
			break;
		case LARGE:
			result += "large";
			break;
		}
		return result;
	}

	public String getInFileName() {
		return getFileName() + ".in";
	}

	public String getOutFileName() {
		return getFileName() + ".out";
	}

	public static void main(String[] args) throws Exception {
		new RecycledNumbers();
	}

	public RecycledNumbers() throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(getInFileName()));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				getOutFileName())));
		Scanner scan = new Scanner(in);
		int tests = scan.nextInt();
		TreeSet<Integer> seen = new TreeSet<Integer>();
		for (int test = 0; test < tests; test++) {
			int result = 0;
			int A = scan.nextInt();
			int B = scan.nextInt();
			int s = (""+A).length();
			int Z = 1;
			for ( int i = 0; i < s; i++) Z *= 10;
			for ( int n = A; n < B; n++) {
				seen.clear();
				for ( int select = 10; select < Z; select *= 10) {
					int v = n / select;
					int w = n % select;
					int m = (Z/select) * w + v;
					if ( m > n && m <= B && !seen.contains(m) )  {
						seen.add(m);
//						System.out.printf("pair n = %d m = %d select = %d\n", n, m, select);
						result++;
					}
				}
			}
			String resultStr = String.format("Case #%d: %d", test + 1, result);
			// add answer here

			System.out.println(resultStr);
			out.println(resultStr);
		}
		out.close();
		System.out.println("*** in file =  " + getInFileName());
		System.out.println("*** out file = " + getOutFileName());
	}
}

