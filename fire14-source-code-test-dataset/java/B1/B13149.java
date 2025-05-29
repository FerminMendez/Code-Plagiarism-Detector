import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RecycledNumber {
	public static void main(String[] args) {
		try {
			BufferedReader bfrd = new BufferedReader(new FileReader("E:\\My Work\\TestWorkspace\\RecycledNumbers\\src\\C-small-attempt3.in"));
			int n = Integer.parseInt(bfrd.readLine());
			String out = "";
			for (int i = 0; i < n; i++) {
				String s = bfrd.readLine();
				out += "Case #" + (i + 1) + ": " + solve(s) + "\n";
			}
			System.out.println(out);
			bfrd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String solve(String s) {

		int iMinNumber = Integer.parseInt(s.split(" ")[0]);
		int iMaxNumber = Integer.parseInt(s.split(" ")[1]);
		int iLength;
		Integer iNoRecycledNo = 1;
		Integer iNoOfRecycledPairs = 0;
		ArrayList<Integer> alInputNos = new ArrayList<Integer>();

		for (int i = iMinNumber; i <= iMaxNumber; i++) {
			alInputNos.add(i);
		}

		for (int number : alInputNos) {
			StringBuffer sNumber = new StringBuffer(Integer.toString(number));
			iLength = sNumber.length();
			ArrayList<Integer> alRecycledPairs = new ArrayList<Integer>();

			for (int i = 1; i < sNumber.length(); i++) {
				StringBuffer recNum = new StringBuffer();
				recNum.append(sNumber.substring(i, sNumber.length()));
				recNum.append(sNumber.substring(0, i));
				int irecNumber = Integer.parseInt(recNum.toString());
				String sTempNum = Integer.toString(irecNumber);
				if (iLength == sTempNum.length()) {
					if ((!(alRecycledPairs.contains(irecNumber))) && irecNumber <= iMaxNumber && irecNumber >= iMinNumber && !(irecNumber == number) && (alInputNos.contains(irecNumber))) {
						alRecycledPairs.add(irecNumber);
						iNoOfRecycledPairs = iNoRecycledNo / 2;
						iNoRecycledNo++;
					}
				}
			}
		}
		
		return Integer.toString(iNoOfRecycledPairs);
	}
}
