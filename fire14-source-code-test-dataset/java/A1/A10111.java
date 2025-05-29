package org.alaoui.googledance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		InputStream is = App.class
				.getResourceAsStream("/org/alaoui/googledance/input/sample.in");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line;
		int lineNumber = 0;

		while ((line = br.readLine()) != null) {
			if (lineNumber > 0) {
				String[] lineArray = line.split(" ");
				int s = Integer.parseInt(lineArray[1]);
				int p = Integer.parseInt(lineArray[2]);

				int okWithoutSurprise = 0;
				int okWithSurprise = 0;

				for (int i = 3; i < lineArray.length; i++) {
					Dancer dancer = new Dancer(Integer.parseInt(lineArray[i]));
					if (dancer.getMaxOrdinaryScore() >= p) {
						okWithoutSurprise++;
					} else if (dancer.getMaxSurprisingScore() != null
							&& dancer.getMaxSurprisingScore() >= p) {
						okWithSurprise++;
					}
				}

				int result = okWithoutSurprise + Math.min(okWithSurprise, s);

				System.out.println("Case #" + lineNumber + ": " + result);

			}
			lineNumber++;
		}
		br.close();
	}
}
