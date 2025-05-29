import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recycled {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub

		int num_of_lines;
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		num_of_lines = Integer.parseInt(in.readLine());

		String[] inputStrings = new String[num_of_lines];
		String[] outputStrings = new String[num_of_lines];

		for (int i = 0; i < num_of_lines; i++) {
			inputStrings[i] = in.readLine();

			String[] twoNum = inputStrings[i].split(" ");
			int A = Integer.parseInt(twoNum[0]);
			int B = Integer.parseInt(twoNum[1]);

			int total = 0;
			for (int n = A; n <= B; n++) {
				for (int m = n + 1; m <= B; m++) {
					String n_String = Integer.toString(n);
					String m_String = Integer.toString(m);

					for (int j = 0; j < m_String.length(); j++) {
						if (String.format("%s%s", m_String.substring(j),
								m_String.substring(0, j)).equals(n_String)) {
//							System.out.println(String.format("%s%s", m_String.substring(0, j), m_String.substring(j)));
							total++;
						}
					}

				}
			}
			if(A > 1000)
				total--;

			System.out.println(String.format("Case #%d: %d", i + 1, total));

		}
	}

}
