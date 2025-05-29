import java.io.*;

public class RecycledNumbers {


	public static void main(String[] args) {

		BufferedReader in;
		BufferedWriter out;
		int T, i;
		String line;
		

		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new BufferedWriter(new FileWriter("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}

		try {
			T = Integer.parseInt(in.readLine());

			for (i = 0; i < T; i++) {
				line = in.readLine();

				String lineToWrite = "Case #" + (i+1) + ": ";

				lineToWrite += String.valueOf(solve(line));

				out.write(lineToWrite + "\n");

			}
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	public static int solve(String input) {
		int a, b, counter;
		String[] inputs = input.split(" ");
		a = Integer.parseInt(inputs[0]);
		b = Integer.parseInt(inputs[1]);
		counter = 0;

		for (int n = a; n < b; n++) {

			int i;
			for (i = 10; i < b; i *= 10) {
				int m = split(n, i);

				if (m > n && m <= b) counter++;

			}


		}
		return counter;

	}
	
	public static int split(int num, int pow) {
		int half1, half2;
		half1 = num/pow;
		half2 = (num%pow) * (orderOf(num) / pow);
		return half1 + half2;
	}
	
	public static int orderOf(int num) {
		int i = 1;
		while (i < num) {
			i*=10;
		}
		return i;
	}
}
