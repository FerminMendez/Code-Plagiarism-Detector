import java.io.*;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileInputStream fstream = new FileInputStream("CProblem/C-small-attempt2.in");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			FileWriter fwstream = new FileWriter("CProblem/Cout.txt");
			BufferedWriter out = new BufferedWriter(fwstream);

			String strLine = br.readLine();
			int n = 0;
			int A, B;
			RecycledNumbers recycledNumbers = new RecycledNumbers();
			if (strLine != null) {
				n = Integer.parseInt(strLine);
				System.out.println(n);
			}
			// Read File Line By LIN
			for (int i = 0; i < n; i++) {
			if ((strLine = br.readLine()) != null) {
				String[] numbers = strLine.split(" ");
				A = Integer.parseInt(numbers[0]);
				B = Integer.parseInt(numbers[1]);
				int count = recycledNumbers.calculate(A, B);
				out.write("Case #"+(i+1)+": "+count+'\n');
			}
		}
			// Close the input stream
			in.close();
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	private int calculate(int A, int B) {
		int count = 0;
		int n,m;
		for (int i = A; i <= B; i++) {
			String num1 = String.valueOf(i);
			//String num2 = String.valueOf(B);
			String str="";
			 n = Integer.parseInt(num1);
			if (num1.length() == 1) {
				return 0;
			}
			switch (num1.length()) {
			case 4:
				str = num1.charAt(num1.length() - 1) + num1.substring(0, 3);
				m = Integer.parseInt(str);
				count = check(count, A, n, m, B);
				str = num1.substring(2, 4) + num1.substring(0, 2);
				m = Integer.parseInt(str);
				count = check(count, A, n, m, B);
				str = num1.substring(1, 4) + num1.charAt(0);
				m = Integer.parseInt(str);
				count = check(count, A, n, m, B);
				break;
			case 3:
				str = num1.charAt(num1.length() - 1) + num1.substring(0, 2);
				m = Integer.parseInt(str);
				count = check(count, A, n, m, B);
				str = num1.substring(1, 3) + num1.charAt(0);
				m = Integer.parseInt(str);
				count = check(count, A, n, m, B);
				break;
			case 2:
				str = num1.charAt(num1.length() - 1) + num1.substring(0, 1);
				m = Integer.parseInt(str);
				count = check(count, A, n, m, B);
				break;
			default:
				break;
			}
		}
		return count;

	}
	public int check(int count, int A, int n, int m, int B) {
		if (A <= n && n < m && m <= B) {
			count++;
		}
		return count;
	}

}
