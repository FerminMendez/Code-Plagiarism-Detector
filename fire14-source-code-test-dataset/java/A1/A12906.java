package org.sooo;

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.OutputSupplier;

public class DancingWithTheGooglers {

	class TripletScore {
		int a;
		int b;
		int c;

		public TripletScore(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public boolean isSatisfied(int pointRequired) {
			if (c >= pointRequired)
				return true;
			else
				return false;
		}

		public boolean satisfiedIfSurprised(int pointRequired) {
			if (isSatisfied(pointRequired))
				return false;
			if (c == 0)
				return false;

			if (pointRequired - c == 1 && (a + b) >= 1)
				return true;
			else
				return false;
		}

		@Override
		public String toString() {
			return String.format("(%d, %d, %d)", a, b, c);
		}
	}

	public static void main(String[] args) throws Exception {
		String inputFilePath = "src/main/resources/B-small-attempt1.in";
		//String inputFilePath = "src/main/resources/B-sample.in";
		OutputSupplier<OutputStreamWriter> outputSupplier = Files
				.newWriterSupplier(new File(inputFilePath + ".out"),
						Charsets.UTF_8);
		List<String> lines = Files.readLines(new File(inputFilePath),
				Charsets.UTF_8);
		StringBuilder results = new StringBuilder();
		for (int i = 1; i < lines.size(); i++) {
			List<String> fromList = Lists.newArrayList(Splitter.on(' ').split(
					lines.get(i)));
			List<Integer> info = Lists.transform(fromList,
					new Function<String, Integer>() {
						public Integer apply(String input) {
							return Integer.parseInt(input);
						}
					});
			int numSurprise = info.get(1);
			int pointRequired = info.get(2);
			int numSatisfied = 0;
			for (int j = 3; j < info.size(); j++) {
				int totalScore = info.get(j);
				int avg = totalScore / 3;
				TripletScore ts;
				if (avg * 3 == totalScore) {
					ts = new DancingWithTheGooglers().new TripletScore(avg,
							avg, avg);
				} else {
					if (totalScore - (avg * 3) == 1)
						ts = new DancingWithTheGooglers().new TripletScore(avg,
								avg, avg + 1);
					else
						ts = new DancingWithTheGooglers().new TripletScore(avg,
								avg + 1, avg + 1);
				}
				if (ts.isSatisfied(pointRequired))
					numSatisfied++;
				else {
					if (numSurprise > 0
							&& ts.satisfiedIfSurprised(pointRequired)) {
						numSurprise--;
						numSatisfied++;
					}
				}
			}
			String result = String.format("Case #%d: %d\n", i, numSatisfied);
			System.out.printf(result);
			results.append(result);
		}
		CharStreams.write(results, outputSupplier);
	}
}
