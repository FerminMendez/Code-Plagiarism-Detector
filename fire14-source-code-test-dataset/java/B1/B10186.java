package jwalinpandya;

import java.io.*;
import java.util.*;

/**
 * @author Jwalin Pandya
 */
public class RecycledNumbers {

	public static void main(String[] args) {
		try {
			String inputFilename = System.getProperty("user.dir")
					+ System.getProperty("file.separator") + "C-small-attempt0.in";

			String outputFilename = System.getProperty("user.dir")
					+ System.getProperty("file.separator") + "C-small-attempt0.out";

			ArrayList<String> input = new ArrayList<String>();
			SortedSet<String> numbersFound = new TreeSet<String>();

			FileInputStream fstream = new FileInputStream(inputFilename);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = "";

			while ((strLine = br.readLine()) != null) {
				input.add(strLine);
			}
			in.close();

			System.out.println("Input:");
			for (int i = 0; i < input.size(); i++)
				System.out.println(input.get(i));

			System.out
					.println("\n------------------------------------------\n");

			// write to file
			FileWriter fwriter = new FileWriter(outputFilename);
			BufferedWriter bwriter = new BufferedWriter(fwriter);

			System.out.println("Output");
			for (int i = 1; i < input.size(); i++) {
				String inputVal[] = input.get(i).split(" ");

				int A = Integer.parseInt(inputVal[0]);
				int B = Integer.parseInt(inputVal[1]);

				System.out.print("Case #" + i + ": ");
				bwriter.write("Case #" + i + ": ");

				for (int num = A; num <= B; num++) {
					for (int j = 1; j < (num + "").length(); j++) {
						String xStr = (num + "").substring(j);
						String yStr = (num + "").substring(0, j);

						int x = Integer.parseInt(xStr);
						int y = Integer.parseInt(yStr);

						String yxStr = xStr + "" + yStr;
						int yx = Integer.parseInt(yxStr);

						if (yx != num)
							if (checkNumber(yx, A, B)) {
								numbersFound.add("["+ num + ", " + yx + "]");
							}
					}
				}
				System.out.print(numbersFound.size()/2 + "");
				bwriter.write(numbersFound.size()/2 + "");
				numbersFound.clear();

				System.out.println();
				bwriter.newLine();
			}
			bwriter.close();
			System.out.println("Check output file..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkNumber(int x, int A, int B) {
		boolean checked = false;
		if (x >= A && x <= B)
			checked = true;
		return checked;
	}

	public static void printArray(String arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
