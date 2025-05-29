package com.dten.cj.qual;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class B {

	public static final int NotSurprising = 0;
	public static final int Surprising = 1;
	public static final int Impossible = -2;

	private int N;
	private int S;
	private int p;
	private int[] scores;

	public int evaluate(int i, int j, int k) {
		int diff = max(i,max(j,k)) - min(i,min(j,k));
		if (diff == 0 || diff == 1 )
			return NotSurprising;
		if(diff == 2)
			return Surprising;
		if(diff > 2)
			return Impossible;
		return -1;
	}

	public int evaluate(int[] triple) {
		if (triple.length != 3)
			return Impossible;
		return evaluate(triple[0], triple[1], triple[2]);
	}

	public int processLine(String string) {
		String[] split = string.split(" ");
		if (split.length < 4)
			return -1;

		N = parseInt(split[0]);
		S = parseInt(split[1]);
		p = parseInt(split[2]);
		scores = new int[split.length - 3];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = parseInt(split[i + 3]);
		}
		N = parseInt(split[0]);

		List<int[][]> possibleCombos = new ArrayList<int[][]>();
		for (int i = 0; i < scores.length; i++) {
			possibleCombos.add(possibleScores(scores[i]));
		}

		int non = 0;
		int surp = 0;
		int fail = 0;

		for (int[][] ps : possibleCombos) {
			if(hasNonsurprisingTripleAbove(ps))
				non++;
			else if (hasSurprisingTripleAbove(ps))
				surp++;
			else
				fail++;
		}

		return non + min(S, surp);

	}

	public boolean hasNonsurprisingTripleAbove(int[][] ps) {
		for (int[] triple : ps) {
			if (max(triple[0], max(triple[1], triple[2])) >= p
					&& evaluate(triple) == NotSurprising) {
				return true;
			}
		}
		return false;
	}

	public boolean hasSurprisingTripleAbove(int[][] ps) {
		for (int[] triple : ps) {
			if (max(triple[0], max(triple[1], triple[2])) >= p
					&& evaluate(triple) == Surprising) {
				return true;
			}
		}
		return false;
	}
	
	public int[][] possibleScores(int score) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i <= 10; i++)
			for (int j = 0; j <= i; j++)
				for (int k = 0; k <= j; k++)
					if (k + j + i == score && evaluate(i, j, k) > -1)
						list.add(new int[] { k, j, i });
		return list.toArray(new int[list.size()][]);
	}

	public String processFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		int caseCount = 1;

		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			String str = in.readLine(); // Skip first
			while ((str = in.readLine()) != null) {
				sb.append("Case #").append(caseCount++).append(": ")
						.append(processLine(str)).append("\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString().trim();
	}

	public static void main(String[] args) {
		B b = new B();
		String fileName = "B-small-attempt0";

		try {
			FileUtils.write(new File("outputs/qual/" + fileName + ".out"),
					b.processFile("inputs/qual/" + fileName + ".in"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
