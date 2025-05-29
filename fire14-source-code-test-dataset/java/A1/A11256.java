package codeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dance {
	
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			FileWriter fstream = new FileWriter("Dance.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			int noTestCases = Integer.parseInt(in.readLine());
			for (int i = 1; i <= noTestCases; i++) {
				out.write("\nCase #" + i + ": ");
				String[] inputs = in.readLine().split(" ");
				int surprise = Integer.parseInt(inputs[1]);
				int minMark = Integer.parseInt(inputs[2]);
				int result = 0;
				List<Integer> lessmarks = new ArrayList<Integer>();
				for (int j = 3; j < inputs.length; j++) {
					int div = Integer.parseInt(inputs[j]) / 3;
					int mod = Integer.parseInt(inputs[j]) % 3;
					if (mod > 0) {
						div++;						
					}
					if (div >= minMark) {
						result++;
					} else if (Integer.parseInt(inputs[j]) > 0) {
						lessmarks.add(Integer.parseInt(inputs[j]));
					}
				}
				if (surprise > 0 && !lessmarks.isEmpty()) {
					int ite = 0;
					for (int z = 0; z < lessmarks.size() && surprise > 0; z++) {
						ite++;
						if (ite > lessmarks.size() * 3 && surprise == Integer.parseInt(inputs[1])) {
							break;
						}
						int mark = lessmarks.get(z);
						int div = mark / 3;
						int mod = mark % 3;
						if (mod > 0) div++;
						if (minMark - div > 2) continue;
						div++;
						if (div >= minMark) {
							result++;
							lessmarks.remove(z);
						}
						surprise--;
						if (z + 1 == lessmarks.size() && surprise > 0) {
							z = 0;
						}
					}
				}
				out.write(Integer.toString(result));
			}
			out.close();
		} catch (NumberFormatException e) {
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}
		
	}

}
