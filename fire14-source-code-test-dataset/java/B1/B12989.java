import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class RecycledNumbers {

	public static void main(String args[]) {

		FileInputStream fstream;
		FileOutputStream out;
		try {
			fstream = new FileInputStream(
					"C:\\Users\\inkrabh\\Downloads\\C-small-attempt0.in");
			out = new FileOutputStream(
					"C:\\Users\\inkrabh\\Downloads\\C-small-attempt0.out");
			DataInputStream in = new DataInputStream(fstream);
			PrintStream p = new PrintStream(out);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			strLine = br.readLine();
			int noOfTestCases = Integer.parseInt(strLine);
			for (int i = 1; i <= noOfTestCases; i++) {
				strLine = br.readLine();
				int result = findNoOfPairs(strLine.split(" ")[0],
						strLine.split(" ")[1]);
				p.println("Case #" + i + ": " + result);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int findNoOfPairs(String start, String end) {
		int count = 0;
		ArrayList<String> existingList = new ArrayList<String>();
		int begin = Integer.parseInt(start);
		int last = Integer.parseInt(end);
		for (int i = begin; i <= last; i++) {
			String sNum = new String((new Integer(i)).toString());
			existingList.add(sNum);
			String recycles[] = getRecycledNums(sNum);
			ArrayList<String> matchList = new ArrayList<String>();
			for (int j = 0; j < recycles.length; j++) {
				String temp = recycles[j];
				if (!matchList.contains(temp) && !existingList.contains(temp)
						&& temp.charAt(0) != '0' && temp.compareTo(end) <= 0
						&& temp.compareTo(start) >= 0 && !temp.equals(sNum)) {
					matchList.add(temp);
					count++;
				}

			}
		}
		return count;
	}

	static String[] getRecycledNums(String sNum) {
		String s[] = new String[sNum.length() - 1];
		for (int i = 1; i < sNum.length(); i++) {
			String temp = sNum.substring(i) + sNum.substring(0, i);
			s[i - 1] = temp;
		}
		return s;

	}

}
