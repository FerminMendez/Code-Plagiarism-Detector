import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProblemB {
	private String line = "";
	private String fileContents = "";
	private String delim = "\r\n";
	private String fileName = "B-small-attempt3.in";

//	private String fileName = "B-small-practice.in";

	public void solve() {
		StringTokenizer st = new StringTokenizer(fileContents, delim);
		StringTokenizer lineToken = null;
		int count = 1;
		int testCases = 0;
		int googlers = 0;
		int surTripler = 0;
		int p = 0;
		int y = 0;

		ArrayList<Integer> numbersList = new ArrayList<Integer>();

		testCases = Integer.parseInt(st.nextToken());

		while (st.hasMoreTokens()) {

			line = st.nextToken();

			System.out.print("Case #");
			System.out.print(count++);
			System.out.print(": ");

			lineToken = new StringTokenizer(line, " ");

			googlers = Integer.parseInt(lineToken.nextToken());
			surTripler = Integer.parseInt(lineToken.nextToken());
			p = Integer.parseInt(lineToken.nextToken());

			numbersList.clear();
			for (int i = 0; i < googlers; i++) {
				numbersList.add(Integer.parseInt(lineToken.nextToken()));
			}

			y = 0;
			for (Integer number : numbersList) {
//
//				if (number == 0)
//					continue;
//
//				if (p == 0) {
//					y++;
//					continue;
//				}

				int mid = number / 3;
				int rem = number % 3;
//				int prem = number % p;

				switch (rem) {
				case 0:
					if (mid >= p) {
						y++;
					} else {
						if (surTripler > 0 && mid > 0 && mid + 1 >= p) {
							y++;
							surTripler--;
						}
					}
					break;
				case 1:
					if (mid >= p || mid + 1 >= p) {
						y++;
					} else {
						if (surTripler > 0 && mid + 1 >= p) {
							y++;
							surTripler--;
						}
					}
					break;
				case 2:
					if (mid + 1 >= p || mid >= p) {
						y++;
					} else {
						if (surTripler > 0 && mid + 2 >= p) {
							y++;
							surTripler--;
						}
					}
					break;
				}
				// if(prem == 0 && p*3 >= number) {
				// y++;
				// }
				// else if(mid >= p) {
				// y++;
				// }
				// else if(mid + rem >= p) {
				// y++;
				// }
				// else if(rem == 1) {
				// if(mid + rem >= p) {
				// y++;
				// }
				// }
				// else if(rem == 2) {
				// if(mid + rem >= p) {
				// y++;
				// }
				// }
				// else if(mid + rem + 2 >= p && surTripler > 0 && mid > 2 &&
				// rem != 0) {
				// y++;
				// }
				// else if((prem + 1 >= (p - 1)) && surTripler == 0) {
				// y++;
				// }
				// else if((mid + 2 >= (p - 1) && surTripler > 0)) {
				// y++;
				// surTripler--;
				// }
				// else if((mid + 2 >= (p - 2) && surTripler > 0)) {
				// y++;
				// surTripler--;
				// }
				// else if(mid + 2 >= p && surTripler-- > 0 ) {
				// y++;
				// }
				// else if(rem == 2) {
				// System.out.print(mid + 1);
				// System.out.print(mid + 1);
				// System.out.print(mid);
				// }
				// else {
				// System.out.print(mid+rem);
				// System.out.print(mid);
				// System.out.print(mid);
				// }
			}
			System.out.println(y);
		}
	}

	public void readFile() {
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(fileName);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			StringBuilder sb = new StringBuilder();
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				sb.append(strLine);
				sb.append(delim);
			}
			// Close the input stream
			in.close();

			fileContents = sb.toString();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
