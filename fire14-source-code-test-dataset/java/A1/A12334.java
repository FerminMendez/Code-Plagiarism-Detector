package com.google.codejam;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.gdata.util.common.base.Charsets;

public class ProblemB {
	
	public static void main (String [] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Usage: ProblemB inputfile");
			return;
		}
		String filename = args[0];
		List<String> inputLines = Files.readLines(new File(filename), Charsets.US_ASCII);
		int T = Integer.parseInt(inputLines.get(0));
		List<String> testCases = inputLines.subList(1, inputLines.size());
		assert(T == testCases.size());
		for (int i = 0; i < testCases.size(); i++) {
			processLine(testCases, i);
		}
	}

	private static void processLine(List<String> testCases, int i) {
		String line = testCases.get(i);
		List<Integer> lineContents = Lists.newArrayList(Iterables.transform(Splitter.on(CharMatcher.WHITESPACE).split(line), new Function<String, Integer>() {
			@Override
			public Integer apply(String input) {
				return Integer.parseInt(input);
			}
		}));
		
		int numGooglers = lineContents.get(0);
		int numSurprising = lineContents.get(1);
		int targetBestResult = lineContents.get(2);
		List<Integer> scores = lineContents.subList(3, lineContents.size());
		assert(numGooglers == scores.size());
		int maxNumGooglers = 0;
		int numGooglersWithSurprise = 0;
		for (int score : scores) {
			if (((score + 2) / 3) >= targetBestResult) {  // This is equivalent to ciel(score/3) >= targetBestResult
				maxNumGooglers++;
			} else if ((score + 4) / 3 >= targetBestResult && score > 0) {
				numGooglersWithSurprise++;
			}
		}
		
		maxNumGooglers += Math.min(numGooglersWithSurprise, numSurprising);
		System.out.println("Case #" + (i+1) + ": " + maxNumGooglers);
	}

}
