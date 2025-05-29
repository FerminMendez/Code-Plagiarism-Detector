package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SampleMain {

	public static void main(String[] args) throws Exception {
		String linesFile = //args[0];
			"lines.txt";
		String[] lines = getLines(linesFile);
		for (int i = 0; i < lines.length; i++) {
			if (i != 0) {
				System.out.println("Case #" + i + ": " + getOutput(lines[i]));
			}
		}
	}

	public static String[] getLines(String pathName) throws Exception {
		List<String> lines = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathName)), "UTF-8"));
		String line;
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}
		br.close();
		return (String[]) lines.toArray(new String[0]);
	}

	public static int getOutput(String line) throws Exception {
		String[] value = line.split(" ");
		int n = Integer.valueOf(value[0]);
		int s = Integer.valueOf(value[1]);
		int p = Integer.valueOf(value[2]);
		int countS = 0;
		int countP = 0;
		for (int i = 0; i < n; i++) {
			int t = Integer.valueOf(value[i + 3]);
			int x = t / 3;
			int y = t % 3;
			switch (y) {
			case 0:
				if (x >= p) {
					countP++;
				} else if (x + 1 >= p) {
					if (x != 0 && countS < s) {
						countS++;
						countP++;
					}
				}
				break;
			case 1:
				if (x + 1 >= p) {
					countP++;
				}
				break;
			case 2:
				if (x + 1 >= p) {
					countP++;
				} else if (x + 2 >= p) {
					if (countS < s) {
						countS++;
						countP++;
					}
				}
				break;
			default:
				break;
			}
		}

		return countP;
	}

}
