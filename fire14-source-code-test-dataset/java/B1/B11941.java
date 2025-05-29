import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainB {

	private static final String toRead = "/home/jean/tmp/C-small-attempt0.in";
	private static final String toWrite = "/home/jean/tmp/C-small-attempt0.out";
	
	private static final Map<Integer, List<Integer>> permutations = new HashMap<Integer, List<Integer>>(2000000, 1);

	public static void main(String[] args) throws IOException {
		// InputStream is = System.in;
		BufferedReader br = new BufferedReader(new FileReader(toRead));
		BufferedWriter bw = new BufferedWriter(new FileWriter(toWrite, false));
		compute(br, bw);
	}

	private static void compute(BufferedReader br, BufferedWriter bw)
			throws IOException {
		Scanner sc = new Scanner(br);

		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < t; ++i) {
			System.out.println(i);
			String res = computeOne(sc);
			write(res, i, bw);
		}

		bw.flush();

		if (bw != null) {
			bw.close();
		}

	}

	private static void write(String res, int i, BufferedWriter bw)
			throws IOException {
		StringBuilder sb = new StringBuilder("Case #").append(i + 1)
				.append(": ").append(res);
		bw.write(sb.toString());
		// System.out.println(sb.toString());
		bw.newLine();
	}

	public static String computeOne(Scanner sc) {
		int min = sc.nextInt();
		int max = sc.nextInt();
//		System.out.println("A: " + min + " | " + "B :" + max);
		long count = 0;
		
		for (int i = min ; i < max ; ++i) {
			if(i % 100000 == 0) {
				System.out.println(i);
			}
			count += count(i, max);
		}
		return Long.toString(count);
	}

	private static long count(int number, int max) {
		if(number < 10) {
			return 0;
		}
		
		long count = 0;

		List<Integer> numberPermutations = permutations.get(number);
		if(numberPermutations == null) {
			if(number % 100000 == 0) {
				System.out.println("ENTERING !");
			}
			String numberString = String.valueOf(number);
			final int length = numberString.length();

			StringBuilder builder = new StringBuilder(length << 0);
			builder.append(numberString).append(numberString);
			
			numberPermutations = new ArrayList<Integer>(length - 1);
			permutations.put(number, numberPermutations);
			for(int start = 1 ; start < length ; ++start) {
				String nString = builder.substring(start, start + length);
				int n = Integer.parseInt(nString);
				if(n > number && !numberPermutations.contains(n)) {
					numberPermutations.add(n);
				}
			}
			Collections.sort(numberPermutations);
		} 
//		for(int n : numberPermutations) {
//			if (n > number && n <= max) {
//				++count;
//			}
//		}
		int c = Collections.binarySearch(numberPermutations, max);
		if(c >= 0) {
			count = c + 1;
		} else {
			count = -c-1;
		}
		
		return count;
	}

}
