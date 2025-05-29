import java.io.*;

import java.lang.*;

class RotateNumber {   
	public static long RotateNumber(long number, long A, long B)
	{
		long start = number;
		long sum = 0;
		int numdigits = (int) Math.log10((double)number); // would return numdigits - 1
		int multiplier = (int) Math.pow(10.0, (double)numdigits);
		while(true)
		{
			long q = number / 10;
			long r = number % 10;
			number = number / 10;
			number = number + multiplier * r;
			if(number == start)
				break;
			if (start < A) break;
			if (start >= A && start < number && number <= B) {
				sum++;
			}
		}
		return sum;
	}
	public static void main(String[] args) throws IOException {

		FileInputStream fstream = new FileInputStream("/tmp/codejam/A-small-practice.in");
		//DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		PrintWriter out = new PrintWriter(new File("/home/peeyushk/tmp/output.ou"));
		String strLine;
		strLine = br.readLine().trim();
		int test = Integer.parseInt(strLine);
		for (int i=0;i<test;i++) {
			strLine = br.readLine().trim();
			long count = 0;
			String[] strings = strLine.split(" ");
			long A = Integer.parseInt(strings[0].trim());
			long B = Integer.parseInt(strings[1].trim());
			for (long num = A; num <= B; num++) {
				count = count + RotateNumber(num, A, B);
			}
			int k = i+1;
			out.println("Case #" + k + ": " + count);
		}
		out.flush();
		out.close();
		br.close();
	}
}