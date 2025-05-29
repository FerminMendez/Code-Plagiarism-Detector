import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream("input.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		ArrayList<String> plik = new ArrayList<String>();
		try {
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				System.out.println(strLine);
				plik.add(strLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		plik.remove(0); // counter nie jest potrzebny
		int count = 1;

		FileWriter writer = null;
		try {
			writer = new FileWriter("output.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String s : plik) {
			StringBuilder outputString = new StringBuilder("Case #" + count++
					+ ": ");
			int recycledPairsCount = 0;

			String[] splitted = s.split(" ");
			Integer A = Integer.parseInt(splitted[0]);
			Integer B = Integer.parseInt(splitted[1]);
			int a = A;
			int b = B;
			for (int n = a; n < b; n++) {
				for (int m = n + 1; m <= B; m++) {
					if (Integer.toString(m).length() != Integer.toString(n)
							.length()) {
						continue;
					}
					if (isRecycledPair(n, m)) {
						recycledPairsCount += 1;
					}
				}
			}

			outputString.append(recycledPairsCount);
			System.out.println(outputString);

			try {
				writer.write(outputString.toString());
				writer.write("\r\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean isRecycledPair(int n, int m) {

		String N = Integer.toString(n);
		String M = Integer.toString(m);
		int digitNumber = N.length();
		if (digitNumber == 1) {
			return false;
		}
		for (int i = 1; i <= digitNumber; i++) {
			String temp = N.substring(i, digitNumber);
			temp += N.substring(0, i);
			if (temp.equals(M)) {
				return true;
			}
		}
		return false;
	}
}
