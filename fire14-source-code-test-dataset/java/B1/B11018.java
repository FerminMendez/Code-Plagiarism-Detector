package code.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		int T;
		try {
			BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter("out")));
			String strLine;
			String outLine;
			strLine = in.readLine();
			T = Integer.valueOf(strLine);
			for (int i = 0; i < T; i++) {
				strLine = in.readLine();
				String result = "";
				String[] stringArray = strLine.split(" ");
				// char[] charArray = strLine.toCharArray();
				int A = Integer.valueOf(stringArray[0]);
				int B = Integer.valueOf(stringArray[1]);
				int count = 0;
				for (int j = A; j <= B; j++) {
					for (int k = j+1; k <= B; k++) {
						if(isRecycledNumber(j,k))
							count++;
					}
				}

				outLine = "Case #" + (i + 1) + ": " + count;
				out.println(outLine);
			}
			in.close();
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean isRecycledNumber(int j, int k) {
		String jStr = String.valueOf(j);
		String newStr;
		for(int i=1;i<jStr.length();i++){
			newStr= jStr.substring(i)+jStr.substring(0,i);
			if(k == Integer.valueOf(newStr))
				return true;
		}

		return false;
	}

}
