package com.jam.contest2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dancing {

    public static int foo(final List<Integer> list, final int surprise,
	    final int p) {
	return find_max(new ArrayList<Integer>(), list, surprise, p);
    }

    private static int find_max(final ArrayList<Integer> unexpected,
	    final List<Integer> expected, final int surprise, final int p) {
	if (surprise == 0) {
	    return countExpected(expected, p) + countUnexpected(unexpected, p);
	}
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < expected.size(); i++) {
	    if (expected.get(i) == 0)
		continue;
	    unexpected.add(0, expected.remove(i));
	    final int local = find_max(unexpected, expected, surprise - 1, p);
	    if (local > max) {
		max = local;
	    }
	    expected.add(i, unexpected.remove(0));
	}
	return max;
    }

    private static int countExpected(final List<Integer> expected, final int p) {
	int result = 0;
	for (final Integer $ : expected) {
	    switch ($ % 3) {
	    case 0: {
		if (($ / 3) >= p)
		    ++result;
		break;
	    }
	    case 1: {
		if ((($ + 2) / 3) >= p)
		    ++result;
		break;
	    }

	    case 2: {
		if ((($ + 1) / 3) >= p)
		    ++result;
		break;
	    }
	    }
	}
	return result;
    }

    private static int countUnexpected(final List<Integer> unexpected,
	    final int p) {
	int result = 0;
	for (final Integer $ : unexpected) {
	    switch ($ % 3) {
	    case 0: {
		if ((($ + 3) / 3) >= p)
		    ++result;
		break;
	    }
	    case 1: {
		if ((($ + 2) / 3) >= p)
		    ++result;
		break;
	    }

	    case 2: {
		if ((($ + 4) / 3) >= p)
		    ++result;
		break;
	    }
	    }
	}
	return result;
    }

    public static void main(final String[] args) {
	BufferedReader reader = null;
	try {
	    reader = new BufferedReader(new FileReader(new File(
		    "/home/artem/B-small-attempt0.in")));
	    final Integer numberOfCases = Integer.valueOf(reader.readLine());
	    for (int i = 1; i <= numberOfCases; ++i) {
		final String sentense = reader.readLine();
		final String[] tokens = sentense.split(" ");
		final int surprise = Integer.valueOf(tokens[1]);
		final int p = Integer.valueOf(tokens[2]);
		final List<Integer> list = new ArrayList<Integer>();
		for (int k = 3; k < tokens.length; ++k)
		    list.add(Integer.valueOf(tokens[k]));
		System.out
			.println("Case #" + i + ": " + foo(list, surprise, p));
	    }
	} catch (final Exception e) {
	    e.printStackTrace();
	} finally {
	    if (reader != null)
		try {
		    reader.close();
		} catch (final IOException e) {
		}
	}

    }

}