import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class ProblemC {

//	private static String inputFile = "input.txt";
	private static String inputFile = "C-small-attempt0.in";

	public static void main(String[] args) throws IOException {
	    BufferedReader input = null;
		try {
			input =  new BufferedReader(new FileReader(inputFile));

			String line = null;

			int numOfTestCases = 0;
			if ((line = input.readLine()) != null) {
				numOfTestCases = Integer.parseInt(line.trim());
			}

			for (int i = 1; i <= numOfTestCases; i++) {
				if ((line = input.readLine()) != null) {
					String ab = line;
					String[] ab_array = ab.split(" ");
					int a = Integer.parseInt(ab_array[0]);
					int b = Integer.parseInt(ab_array[1]);

					if (a<10 && b<10) {
						System.out.println("Case #" + i + ": 0");
					} else {
						Set<String> recycled = new HashSet<String>();

						if (a < 10) {
							a = 10;
						}
						for (int n=a; n<b; n++) {
							String n_string = "" + n;
							int length = n_string.length();
							for (int j=1; j<length; j++) {
								String m_string = n_string.substring(j) + n_string.substring(0, j);
								int m = Integer.parseInt(m_string);
								if (m>n && m<=b) {
									recycled.add(n_string + ", " + m_string);
								}
							}
						}
						System.out.println("Case #" + i + ": " + recycled.size());
					}
				} else {
					System.out.println("ERROR: Could not read the test case #" + i);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: FileNotFoundException for the input file.");
			e.printStackTrace();
		} finally {
	        input.close();
		}
	}

}
