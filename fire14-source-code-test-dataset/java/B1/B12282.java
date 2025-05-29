import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class C {

	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<String> list2;

	public static int convert(String input) {
		list2 = new ArrayList<String>();
		int output = 0;
		String[] pairs = input.split(" ");
		String first = pairs[0];
		String second = pairs[1];
		if (first.length() != 1) {
			int firstInt = Integer.parseInt(first);
			int secondInt = Integer.parseInt(second);
			for (int k = firstInt; k < secondInt; k++) {
				String firstNum = k + "";
				if (!same(firstNum)) {
					int len = firstNum.length();
					for (int i = 0; i < len - 1; i++) {
						char lastChar = firstNum.charAt(len - 1);
						String newFirstNum = lastChar
								+ firstNum.substring(0, len - 1);
//						 System.out.println(firstNum + "---" +
//								 newFirstNum);
//						list2.add(newFirstNum);
						int secondNum = Integer.parseInt(newFirstNum);
						if ((secondNum + "").length() == firstNum.length()) {
							if (secondNum <= secondInt && secondNum > k
//									&& !list.contains(secondNum)
									) {
								output++;
//								list.add(k);
//								 System.out.println(k + "---" +
//										 secondNum);
							}
						}
						firstNum = newFirstNum;
					}
				}
			}
			// output = getAll(firstInt,secondInt);
		}

		return output;
	}

//	private static int getAll(int firstInt, int secondInt) {
//		// System.out.println("-----"+firstInt);
//		// System.out.println("-----"+secondInt);
//		int count = 0;
//		for (int i = 0; i < list2.size(); i++) {
//			String str = list2.get(i);
//			if (str.charAt(0) != '0') {
//				int second = Integer.parseInt(str);
//				if (second <= secondInt && second >= firstInt)
//					count++;
//			}
//		}
//		count /= 2;
//		return count;
//	}

	private static boolean same(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String inputFile = "C-small-attempt2.in";
		String outPutFile = "C-small2.out";
		try {
			FileInputStream fstream = new FileInputStream(inputFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			FileWriter fstream2 = new FileWriter(outPutFile);
			BufferedWriter out = new BufferedWriter(fstream2);
			String strLine;
			strLine = br.readLine();
			int casesNum = Integer.parseInt(strLine);
			for (int i = 0; i < casesNum; i++) {
				strLine = br.readLine();
				String parse = "Case #" + (i + 1) + ": " + convert(strLine);
				System.out.println(parse);
				if (i < casesNum - 1)
					parse += "\n";
				out.write(parse);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

}
