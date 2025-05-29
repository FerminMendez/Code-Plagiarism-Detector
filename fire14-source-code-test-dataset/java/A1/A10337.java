package QuickStart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GoogleDancer {

	public static void main (String[] args) {
		String inputFile = "D:\\B-small-attempt0.in";
		String outputFile = "D:\\out2.txt";
		String prefix = "Case #";
		int p = 0;
		int s = 0;
		int n = 0;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line = "";
			line = br.readLine();
			int num = Integer.valueOf(line);
			for (int i = 1; i <= num; i++) {
				String tline = br.readLine();
				String[] nStr = tline.split("\\s+");
				int result = 0;
				int len = nStr.length;
				int[] intS = new int[len];
				for (int j = 0; j < len; j++) {
					intS[j] = Integer.valueOf(nStr[j]);
				}
				n = intS[0];
				s = intS[1];
				p = intS[2];
				int v1 = 3 * p - 2;
				v1 = v1 > 0 ? v1 : 0;
				ArrayList<Integer> left = new ArrayList<Integer>();
				for (int k = 0; k < n; k++) {
					if (intS[k+3] >= v1)
						result++;
					else
						left.add(intS[k+3]);
				}
				int v2 = v1 - 2;
				v2 = v2 > 0 ? v2 : 0;
				int leftlen = left.size();
				for (int k = 0; k < leftlen && s > 0; k++) {
					if (left.get(k) >= v2 && left.get(k) >= 2) {
						result++;
						s--;
					}
				}
				String output = prefix + i + ": " + result;
				bw.write(output);
				if (i < num)
					bw.write("\n");
			}
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
