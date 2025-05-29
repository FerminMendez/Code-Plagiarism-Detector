import java.io.*;

public class Dancing_With_the_Googlers {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		FileInputStream inFile = new FileInputStream(
				new File("C:\\Users\\ruzbeh\\Downloads\\in.in"));
		DataInputStream br = new DataInputStream(inFile);
		FileOutputStream outFile = new FileOutputStream(new File("out.in"));
		DataOutputStream out = new DataOutputStream(outFile);

		int T = Integer.parseInt(br.readLine());
		

		for (int i = 0; i < T; i++) {
			int res = 0;
			String[] str = br.readLine().split(" ");
			int count = Integer.parseInt(str[1]);
			int focus_score = Integer.parseInt(str[2]);

			int min_score = focus_score - 2;
			if (min_score < 0)
				min_score = 0;
			int min_value = focus_score + (min_score) * 2;
			int surprise_value = focus_score * 3 - 3;
			for (int j = 0; j < Integer.parseInt(str[0]); j++) {
				if (Integer.parseInt(str[3 + j]) < min_value) {
					continue;
				} else if (Integer.parseInt(str[3 + j]) <= surprise_value) {
					if (count > 0) {
						count -= 1;
						res += 1;
					} else
						continue;
				} else {
					res += 1;
				}

			}
			out.writeBytes("Case #" + (i + 1) + ": " + res);
			out.writeBytes("\n");

		}

	}
}
