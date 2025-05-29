package es.saspelo.codejam.dancingwiththegooglers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPResult;

import es.saspelo.codejam.commons.CodeJamProblem;

public class DancingWithTheGooglers implements CodeJamProblem {

	private static final Logger log = LoggerFactory.getLogger(DancingWithTheGooglers.class);

	private static class DancingWithTheGooglersData {

		private int googlers = 0;
		private int surprisingTriplets = 0;
		private int score = 0;
		private List<Integer> points = null;

		public int getGooglers() {
			return googlers;
		}

		public void setGooglers(int googlers) {
			this.googlers = googlers;
		}

		public int getSurprisingTriplets() {
			return surprisingTriplets;
		}

		public void setSurprisingTriplets(int surprisingTriplets) {
			this.surprisingTriplets = surprisingTriplets;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public List<Integer> getPoints() {
			return points;
		}

		public void setPoints(List<Integer> points) {
			this.points = points;
		}

		@Override
		public String toString() {
			return "DancingWithTheGooglersData [googlers=" + googlers + ", surprisingTriplets=" + surprisingTriplets
			        + ", score=" + score + ", points=" + points + "]";
		}
	}

	public void execute(InputStream in, OutputStream out) throws IOException {

		int testCases = 1;

		final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

		final List<DancingWithTheGooglersData> problemDatas = readInput(in);

		if (log.isDebugEnabled()) {
			log.debug("==== starting problem '{}' ====", DancingWithTheGooglers.class.getSimpleName());
		}

		try {
			for (DancingWithTheGooglersData data : problemDatas) {
				int bestResultReached = 0;

				Collections.sort(data.getPoints());
				Collections.reverse(data.getPoints());

				log.debug("points: '{}' | score: '{}' | surprising: '{}'",
				        new Object[] { data.getPoints(), data.getScore(), data.getSurprisingTriplets() });

				int surprising = data.getSurprisingTriplets();
				List<int[]> tripletList = new ArrayList<int[]>();
				for (int i = 0; i < data.getGooglers(); i++) {
					int[] triplet = new int[3];

					int div = data.getPoints().get(i) / 3;
					int rest = data.getPoints().get(i) % 3;

					triplet[0] = div;
					triplet[1] = div;
					triplet[2] = div;

					int t = 0;
					while (rest > 0) {
						triplet[t++]++;
						rest--;
					}

					Arrays.sort(triplet);

					// adjust points to max
					if (triplet[2] <= 9 && triplet[1] > 0 && triplet[0] > 0
					        && ((triplet[2] + 1) - (triplet[0] - 1) < 2)) {
						triplet[2]++;
						triplet[0]--;
					}

					if (triplet[2] <= 9 && triplet[1] > 0 && triplet[0] > 0
					        && ((triplet[2] + 1) - (triplet[1] - 1) < 2)) {
						triplet[2]++;
						triplet[1]--;
					}

					boolean nothingToDoIn1 = false;
					boolean nothingToDoIn2 = false;
					while (surprising > 0 && !nothingToDoIn1 && !nothingToDoIn2) {
						if ((triplet[2] < data.getScore()) && triplet[2] <= 9 && triplet[1] > 0 && triplet[0] > 0
						        && (((triplet[2] + 1) - (triplet[0] - 1)) == 2)) {
							triplet[2]++;
							triplet[0]--;
							surprising--;
							nothingToDoIn1 = false;

						} else {
							nothingToDoIn1 = true;
						}
						nothingToDoIn2 = true;
						if (surprising > 0) {
							if ((triplet[2] < data.getScore()) && triplet[2] <= 9 && triplet[1] > 0 && triplet[0] > 0
							        && (((triplet[2] + 1) - (triplet[1] - 1)) == 2)) {
								triplet[2]++;
								triplet[1]--;
								surprising--;
								nothingToDoIn2 = false;
							}
						}
					}

					tripletList.add(triplet);
					log.debug("googler '{}'-> triplet: '{}'", new Object[] { i, triplet });
				}

				for (int[] triplet : tripletList) {
					if (triplet[2] >= data.getScore()) {
						bestResultReached++;
					}
				}

				writer.write("Case #" + testCases + ": " + bestResultReached + "\n");
				writer.flush();
				testCases++;
			}
		} finally {
			writer.close();
		}
	}

	private List<DancingWithTheGooglersData> readInput(InputStream in) {

		final Scanner sc = new Scanner(in);

		int testCases = sc.nextInt();
		if (log.isDebugEnabled()) {
			log.debug("testCases: '{}'", testCases);
		}

		List<DancingWithTheGooglersData> problemData = new ArrayList<DancingWithTheGooglersData>(testCases);

		for (int i = 0; i < testCases; i++) {
			DancingWithTheGooglersData data = new DancingWithTheGooglersData();

			data.setGooglers(sc.nextInt());
			data.setSurprisingTriplets(sc.nextInt());
			data.setScore(sc.nextInt());

			List<Integer> points = new ArrayList<Integer>();

			for (int j = 0; j < data.getGooglers(); j++) {
				points.add(sc.nextInt());
			}

			data.setPoints(points);

			if (log.isDebugEnabled()) {
				log.debug("data: '{}'", data);
			}

			problemData.add(data);

		}

		sc.close();
		return problemData;
	}

	public static void main(String[] args) throws Exception {
		final JSAP jsap = new JSAP();

		final FlaggedOption inputFileName = new FlaggedOption("input").setStringParser(JSAP.STRING_PARSER)
		        .setShortFlag('i').setLongFlag(JSAP.NO_LONGFLAG);

		final FlaggedOption outputFileName = new FlaggedOption("output").setStringParser(JSAP.STRING_PARSER)
		        .setShortFlag('o').setLongFlag(JSAP.NO_LONGFLAG);

		inputFileName.setHelp("File name with input for the problem");
		outputFileName.setHelp("File name for problem output file");

		jsap.registerParameter(inputFileName);
		jsap.registerParameter(outputFileName);

		final JSAPResult config = jsap.parse(args);

		if (!config.success()) {

			System.err.println();

			// print out specific error messages describing the problems
			// with the command line, THEN print usage, THEN print full
			// help. This is called "beating the user with a clue stick."
			for (Iterator<?> errs = config.getErrorMessageIterator(); errs.hasNext();) {
				System.err.println("Error: " + errs.next());
			}

			System.err.println();
			System.err.println("Usage: java " + DancingWithTheGooglers.class.getName());
			System.err.println("                " + jsap.getUsage());
			System.err.println();
			System.err.println(jsap.getHelp());
			System.exit(1);
		}

		InputStream in = System.in;
		OutputStream out = System.out;

		if (config.getString("input") != null) {
			in = new FileInputStream(new File(config.getString("input")));
		}

		if (config.getString("output") != null) {
			out = new FileOutputStream(new File(config.getString("output")));
		}

		DancingWithTheGooglers problem = new DancingWithTheGooglers();

		problem.execute(in, out);
	}
}
