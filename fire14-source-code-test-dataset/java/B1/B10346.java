package QR_2012;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Utils.IOStreams;

public class C_Recycled_Numbers {

	public static void main(String[] args) throws IOException {

		IOStreams streams = new IOStreams(args[0]);
		System.setIn(new FileInputStream(args[0]));

		Scanner sc = new Scanner(System.in);
		sc.nextLine();

		int caseNum = 1;

		while (sc.hasNextInt()) {
			int lowerBoundInt = sc.nextInt();
			int upperBoundInt = sc.nextInt();

			int hits = 0;
			for (int num1 = lowerBoundInt; num1 <= upperBoundInt; num1++) {

				char[] num1Str = ("" + num1).toCharArray();
				int length = num1Str.length;
				Set<Integer> num2Duplicates = new HashSet<Integer>();

				for (int startingPoint = 0; startingPoint < length; startingPoint++) {

					int index = startingPoint;
					boolean init = true;
					StringBuffer num2Str = new StringBuffer();
					while (init || index % length != startingPoint) {
						init = false;
						num2Str.append(num1Str[index % length]);
						index++;
					}

					Integer num2 = new Integer(num2Str.toString());

					if (num1 < num2 && num2 <= upperBoundInt && !num2Duplicates.contains(num2)) {
						hits++;
						num2Duplicates.add(num2);
					}
				}
			}
			streams.printLine("Case #" + (caseNum++) + ": " + hits + "\n");
		}
		
		streams.closeStreams();

	}

}
