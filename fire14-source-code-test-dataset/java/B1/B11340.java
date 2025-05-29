package RecycledNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RecycledNumbers {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("RecycledInput"));
		PrintWriter pw = new PrintWriter(new File("RecycledOutput"));

		String cases = br.readLine();
		String line;
		int lines = 1;
		while ((line = br.readLine()) != null) {
			String[] strs = line.split(" ");
			int lowerbound = Integer.parseInt(strs[0]);
			int upperbound = Integer.parseInt(strs[1]);
			int number = lowerbound;
			int count = 0;
//			System.out.println(numberChars.);
			while (number <= upperbound) {
				char[] numberChars = String.valueOf(number).toCharArray();
				for (int i = 0; i < numberChars.length; i++) {
					String recycled = "";
					for (int j = 0; j < numberChars.length; j++)
						recycled += numberChars[(j + i + 1)
								% numberChars.length];
					if (Integer.parseInt(recycled) <= upperbound
							&& Integer.parseInt(recycled) > number) {
						count++;
						System.out.println(number + " " + recycled);
					}
				}
				number ++;
			}
			System.out.println("Case #" + lines + ": " + count);
			pw.write("Case #" + lines + ": " + count + "\n");
			lines++;
		
		}
		pw.flush();
		pw.close();
	}

}
