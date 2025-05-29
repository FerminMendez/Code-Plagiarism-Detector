package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		final String tmp = "Case #";
		BufferedReader in = new BufferedReader(new FileReader(new File(
				"C-small-attempt0.in")));
		//BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		for (int i = 0; i < tc; i++) {
			String[] s = in.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = 0;
			for (int n = a; n <= b; n++) {
				String str = n + "";
				int len = str.length();
				for(int j = 1; j < len; j++) {
					int num = Integer.parseInt(str.substring(len - j) + str.substring(0, len - j));
					if(n < num && num <= b && len == String.valueOf(num).length()) {
						++c;
					}
				}
			}
			System.out.println(tmp + (i + 1) + ": " + c);
		}
	}
}
