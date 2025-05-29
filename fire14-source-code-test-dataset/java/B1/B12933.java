package org.sooo;

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.OutputSupplier;

public class RecycledNumbers {

	public static boolean isValidPair(long n, long m) {
		String nStr = Long.toString(n);
		String mStr = Long.toString(m);
		for (int i = 0; i < nStr.length(); i++) {
			String shifted = nStr.substring(i) + nStr.substring(0, i);
			if (shifted.charAt(0) != '0' && shifted.equals(mStr))
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		//String path = "src/main/resources/C-sample.in";
		String path = "src/main/resources/C-small-attempt0.in";
		List<String> lines = Files.readLines(new File(path), Charsets.UTF_8);

		OutputSupplier<OutputStreamWriter> outputSupplier = Files
				.newWriterSupplier(new File(path + ".out"), Charsets.UTF_8);
		StringBuilder results = new StringBuilder();
		for (int i = 1; i < lines.size(); i++) {
			List<String> tokens = Lists.newArrayList(Splitter.on(' ').split(
					lines.get(i)));
			long lowerBound = Long.parseLong(tokens.get(0));
			long upperBound = Long.parseLong(tokens.get(1));
			long count = 0;

			if (lowerBound >= 10) {
				for (long n = lowerBound; n < upperBound; n++) {
					for (long m = n + 1; m <= upperBound; m++) {
						if (RecycledNumbers.isValidPair(n, m))
							count++;
					}
				}
			}

			String result = String.format("Case #%d: %d\n", i, count);
			System.out.print(result);
			results.append(result);
		}
		CharStreams.write(results, outputSupplier);
	}
}
