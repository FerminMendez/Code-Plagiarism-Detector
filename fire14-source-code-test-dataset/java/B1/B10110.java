import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Third {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"/Users/narok119/Desktop/C-small-attempt0.in")));

		String txt = reader.readLine();
		int caseCount = 1;

		while ((txt = reader.readLine()) != null) {
			// Form the input
			String[] info = txt.split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			int output = 0;

			for (int n = a; n < b; n++) {
				for (int m = n + 1; m <= b; m++) {
					String ns = n + "";
					String ms = m + "";
					if (ns.length() == ms.length()) {
						for (int i = 0; i < ns.length(); i++) {
							String ms1 = ms.substring(0, i);
							String ms2 = ms.substring(i);
							if ((ms2 + ms1).equals(ns)) {
								output++;
								break;
							}
						}
					}
				}
			}
			System.out.println("Case #" + caseCount++ + ": " + output);
		}
	}

}
