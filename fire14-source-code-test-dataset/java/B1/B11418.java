package problem.c;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class RecycledNumbers {

	private static final String INPUT_FILE = "C-small-attempt0.in";

	public static void main(String[] args) throws IOException {
		File inputFile = new File(INPUT_FILE);
		List<String> inputLines = FileUtils.readLines(inputFile);
		Integer.parseInt(inputLines.remove(0));
		List<String> outputLines = Lists.newArrayList();
		for (int k = 0; k < inputLines.size(); k++) {
			String line = inputLines.get(k);
			int seperator = line.indexOf(' ');
			int a = Integer.valueOf(line.substring(0, seperator));
			int b = Integer.valueOf(line.substring(seperator + 1));
			Set<String> matches = Sets.newHashSet();
			for (int currentNumber = a; currentNumber < b; currentNumber++) {
				String stringA = String.valueOf(currentNumber);
				for (int j = 1; j < stringA.length(); j++) {
					String begin = stringA.substring(j);
					String end = stringA.substring(0, j);
					int generatedNumToCheck = Integer.valueOf(begin + end);
					if (generatedNumToCheck <= b && generatedNumToCheck >= a
							&& generatedNumToCheck != currentNumber
							&& generatedNumToCheck > currentNumber) {
						matches.add(currentNumber + " - " + generatedNumToCheck);
					}
				}
			}
			outputLines.add("Case #" + (k + 1) + ": " + matches.size());
		}
		System.out.println(outputLines);
		FileUtils.writeLines(new File("generated-recycled-numbers-output.txt"), outputLines);
	}

}
