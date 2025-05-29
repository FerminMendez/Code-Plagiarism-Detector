import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RecycledNumbers {
	public static void main(String[] args) {
		try {
			run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void run() throws Exception {
		writeResult(calc(readInputData()));
	}

	private static int[] calc(Data[] data) {
		int[] res = new int[data.length];

		for (int i = 0; i < data.length; i++) {
			res[i] = calc(data[i]);
			// System.out.println("Case #" + (i + 1) + ": " + res[i]);
		}

		return res;
	}

	private static int calc(Data data) {
		if (data.len <= 1)
			return 0;

		int res = 0;

		for (int i = data.a; i < data.b; i++) {
			int pp = (int)Math.pow(10, data.len - 1);

			for (int j = 1, p = 10; j < data.len; j++, p *= 10, pp /= 10) {
				int x = i % p;
				int y = i / p;
				int rev = x * pp + y;

				if (x == y)
					break;
				if (rev > i && rev >= data.a && rev <= data.b)
					res++;
			}
		}

		return res;
	}

	private static Data[] readInputData() throws Exception {
		InputStream in = RecycledNumbers.class.getResourceAsStream("/test.in");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		int total = Integer.parseInt(br.readLine());
		Data[] data = new Data[total];

		for (int i = 0; i < total; i++)
			data[i] = new Data(br.readLine().split("\\s"));

		in.close();

		return data;
	}

	private static void writeResult(int[] res) throws Exception {
		BufferedWriter out = new BufferedWriter(new FileWriter("d:\\!!!\\test.out"));

		for (int i = 1; i <= res.length; i++)
			out.write("Case #" + i + ": " + res[i - 1] + "\n");

		out.close();
	}
}

class Data {
	final int len;
	final int a;
	final int b;

	Data(int a, int b) {
		this.a = a;
		this.b = b;
		this.len = 0;
	}

	Data(String[] str) {
		this.a = Integer.parseInt(str[0]);
		this.b = Integer.parseInt(str[1]);

		this.len = str[0].length();
	}

	@Override
	public String toString() {
		return "[" + a + ";" + b + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Math.min(a, b);
		result = prime * result + Math.max(a, b);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data)obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}
}
