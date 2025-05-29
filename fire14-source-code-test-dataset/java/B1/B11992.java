package jam.qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class RecycledNumbers {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("file.in"));
			BufferedWriter out = new BufferedWriter(new FileWriter("file.out"));
			int n = Integer.parseInt(in.readLine());
			for (int i = 1; i <= n; ++i) {
				String[] ints = in.readLine().split(" ");
				char[] A = ints[0].toCharArray();
				char[] B = ints[1].toCharArray();
				
				int c = 0;
				try {
					c = count(A, B);
				}
				catch (Exception e) {
					System.err.println("Unexpected exception, I made a mistake...");
					e.printStackTrace();
					System.exit(1);
				}
				out.write("Case #" + i + ": " + c);
				if (i != n)
					out.newLine();
				out.flush();
			}
			out.close();
		}
		catch (Exception e) {
			System.err.println("Error occured while reading input!");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private static int count(char[] A, char[] B) {
		char[][] buff = new char[A.length][A.length];
		int count = 0, ptr;
		do {
			ptr = 0;
			for (int n = 1; n < A.length; ++n) {
				swap(A, buff[ptr], n);
				if (compare(buff[ptr], A) > 0 && compare(buff[ptr], B) <= 0) {
					for (int i = 0; i < ptr; ++i)
						if (compare(buff[i], buff[ptr]) == 0) {
							--count;
							--ptr;
							break;
						}
					++count;
					++ptr;
				}
			}
			if (compare(A, B) >= 0)
				break;
			inc(A);
		} while (true);
		return count;
	}
	
	private static void swap(char[] src, char[] dst, int n) {
		System.arraycopy(src, 0, dst, n, src.length - n);
		System.arraycopy(src, src.length - n, dst, 0, n);
	}
	
	private static void inc(char[] N) {
		int i = N.length;
		while (N[--i] == '9')
			N[i] = '0';
		++N[i];
	}
	
	private static int compare(char[] X, char[] Y) {
		for (int i = 0; i < X.length; ++i)
			if (X[i] < Y[i])
				return -1;
			else if (X[i] > Y[i])
				return 1;
		return 0;
	}
}
