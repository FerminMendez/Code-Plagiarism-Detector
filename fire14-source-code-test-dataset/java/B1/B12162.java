import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Recycled {
	public static void main(String[] args) throws Exception {
		FileInputStream fstream = new FileInputStream("text.in");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		int count = 0;
		int totalLines;
		// ArrayList<List> numbers = new ArrayList<List>();
		while ((strLine = br.readLine()) != null) {
			if (count == 0) {
				totalLines = Integer.parseInt(strLine);
			} else {
				int recycled = 0;
				String[] nums = strLine.split(" ");
				int startNum = Integer.parseInt(nums[0]);
				int endNum = Integer.parseInt(nums[1]);
				for (int i = startNum; i <= endNum; i++) {
					recycled += testInteger(i, endNum);
					
				}
				System.out.println("Case #" + count + ": " + recycled);
			}
			count++;
		}
		in.close();
	}

	private static int testInteger(int i, int endNum) {
		String numStr = String.valueOf(i);
		int currentCount = 0;
		Set<String> matches = new HashSet<String>();
		for (int j = 1; j < numStr.length(); j++) {
			String newNumStr = swapNumber(numStr);
			if ((Integer.parseInt(newNumStr) > i) && ((Integer.parseInt(newNumStr) <= endNum))) {
//				System.out.println(i+" "+newNumStr);
				currentCount++;
				matches.add(newNumStr);
		//	} else {
		//		return 0;
			}
			numStr = newNumStr;
		}
		return matches.size();
	}

	private static String swapNumber(String numStr) {
		String lastDigit = numStr.substring(numStr.length()-1);
		String firstDigits = numStr.substring(0, numStr.length()-1);
		return lastDigit.concat(firstDigits);
	}
	
	
}
