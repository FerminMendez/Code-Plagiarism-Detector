import java.io.*;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		try {
			FileInputStream fstream = new FileInputStream("C-small-attempt2.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = br.readLine();
			int x = Integer.parseInt(strLine);
			int result;
			String[] a;
			for (int j = 0; j < x; j++) {
				System.out.print("Case #" + (j + 1) + ": ");
				strLine = br.readLine();
				a = strLine.split(" ");
				result = 0;
					int first = Integer.parseInt(a[0]);
					int second = Integer.parseInt(a[1]);
					
					for (int i = first; i < second; i++) {
						for (int k = i + 1; k <= second; k++) {

							boolean b = m.check(i + "", k + "");
							if (b)
								result++;
						}
					}
				System.out.println(result);
			}
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("error");
		}
	}

	private boolean check(String i, String k) {
		boolean b = false;

		for (int j = k.length() - 1; j >= 0; j--) {

			k = k.charAt(k.length() - 1) + "" + k.substring(0, k.length() - 1);

			if (k.equalsIgnoreCase(i)) {
				b = true;
				break;
			}
			if (b) break;
		}

		return b;
	}
}