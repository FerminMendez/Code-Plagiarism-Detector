import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		// inputファイルを読み込み
		BufferedReader bufferReader = null;
		String str = "";
		try {
			bufferReader = new BufferedReader(new InputStreamReader(
					new FileInputStream("/Users/yago/Documents/in.txt"),
					"UTF-8"));
			// 一行ずつ読み込み
			int probs = 0;
			while ((str = bufferReader.readLine()) != null) {
				if (str.length() > 2) {
					probs++;
					calc(str, probs);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (bufferReader != null) {
					bufferReader.close();
				}
			} catch (Exception e) {
			}
		}
	}

	private static void calc(String str, int probNum) {
		Integer n1, n2, ansCnt = 0;
		String[] strAry = str.split(" ");
		n1 = Integer.valueOf(strAry[0]);
		n2 = Integer.valueOf(strAry[1]);
		for (int i = n1; i <= n2; i++) {
			for (int j = i + 1; j <= n2; j++) {
				if(String.valueOf(j).length() == 1)
					break;
				if (String.valueOf(j).length() == 2) {
					if (String.valueOf(j).charAt(0) == String.valueOf(i)
							.charAt(1)
							&& String.valueOf(j).charAt(1) == String.valueOf(i)
									.charAt(0))
						ansCnt++;
				} else if ((String.valueOf(j).charAt(0) == String.valueOf(i)
						.charAt(1)
						&& String.valueOf(j).charAt(1) == String.valueOf(i)
								.charAt(2) && String.valueOf(j).charAt(2) == String
						.valueOf(i).charAt(0))
						|| String.valueOf(j).charAt(0) == String.valueOf(i)
								.charAt(2)
						&& String.valueOf(j).charAt(1) == String.valueOf(i)
								.charAt(0)
						&& String.valueOf(j).charAt(2) == String.valueOf(i)
								.charAt(1)) {
					ansCnt++;
				}
			}
		}

		System.out.println("Case #" + probNum + ": " + ansCnt);
	}
}