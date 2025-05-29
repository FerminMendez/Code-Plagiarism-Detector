import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ProblemC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		String input = null;
		StringBuffer output = null;
		String[] twonumbers = null;
		int min = 0, max = 0;
		ArrayList<String> list = null;
		String temp = null;
		String strmin = "";
		int tempint = 0;
		int counter = 0;
		int digit1 = 0, digit2 = 0;
		try {
			br = new BufferedReader(new FileReader(new File(
					"C:/Users/DHAVAL/Downloads/Input1.txt")));
			bw = new BufferedWriter(new FileWriter("output1.txt"));
			int count = Integer.parseInt(br.readLine());
			for (int i = 0; i < count; i++) {
				input = br.readLine();
				output = new StringBuffer("Case #" + (i + 1) + ": ");
				counter=0;
				// logic here
				list = new ArrayList<String>();
				twonumbers = input.split(" ");
				min = Integer.parseInt(twonumbers[0]);
				max = Integer.parseInt(twonumbers[1]);
				if (max >= 10) {
					for (int j = min; j <= max; j++) {
						strmin = "" + j;
						temp = strmin;
						for (int k = 0; k < strmin.length() - 1; k++) {
							temp = temp.substring(1) + temp.charAt(0);
							tempint = Integer.parseInt(temp);
							digit1 = ("" + tempint).length();
							digit2 = strmin.length();
							if (j < tempint && digit1 == digit2
									&& tempint >= min && tempint <= max
									&& !list.contains(strmin + "||" + temp)
									&& !temp.equals(strmin)) {
								//System.out.println(strmin + " " + tempint);
								// list.add(temp);
								list.add(strmin + "||" + temp);
								counter++;
							}
						}
					}
				}
				bw.write(output.toString() + counter);
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
