package qualifications2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ReycledNumbers {

	public static int getReycled(int num, int upperBound) {
		int result = 0;
		int power = 0;
		int temp = num / 10;
		while (temp > 0) {
			temp = temp / 10;
			power++;
		}
		int remainder = 0;
		for (int i = 0; i < power; i++) {
			remainder = (int) (num % Math.pow(10, (i + 1)));
			temp = (int) (num / Math.pow(10, i + 1));
			int comp = (int) (temp + remainder * Math.pow(10, power - i));
			if (comp > num && comp <= upperBound) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input.txt"));
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter("out.txt");
			out = new BufferedWriter(fstream);
			int cases = Integer.parseInt(in.nextLine());
			for (int i = 0; i < (cases); i++) {
				int result = 0;
				int lower = in.nextInt();
				int upper = in.nextInt();
				for (int j = lower; j < upper; j++) {
					result += getReycled(j, upper);
				}
				out.write("Case #" + (i + 1) + ": " + result + "\n");
			}
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
