package es.saspelo.codejam.recyclednumbers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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

public class RecycledNumbers implements CodeJamProblem {

	private static final Logger log = LoggerFactory.getLogger(RecycledNumbers.class);

	public void execute(InputStream in, OutputStream out) throws IOException {

		int testCases = 1;

		final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

		final List<int[]> problemDatas = readInput(in);

		if (log.isDebugEnabled()) {
			log.debug("==== starting problem '{}' ====", RecycledNumbers.class.getSimpleName());
		}

		try {
			for (int[] minMax : problemDatas) {

				int recycled = 0;

				int[] numbersbettweenAandB = new int[minMax[1] - minMax[0] + 1];

				for (int i = 0; i < numbersbettweenAandB.length; i++) {
					numbersbettweenAandB[i] = minMax[0] + i;
				}

				for (int i = 0; i < numbersbettweenAandB.length; i++) {
					for (int j = i + 1; j < numbersbettweenAandB.length; j++) {
						if (isRecycled(numbersbettweenAandB[i], numbersbettweenAandB[j])) {
							recycled++;
						}
					}
				}

				writer.write("Case #" + testCases + ": " + recycled + "\n");
				testCases++;
			}
		} finally {
			writer.close();
		}
	}

	private boolean isRecycled(int m, int n) {
		String nAsChars = String.valueOf(n);
		String mAsChars = String.valueOf(m);

		for (int i = nAsChars.length() - 1; i >= 1; i--) {

			String front = nAsChars.substring(0, i);
			String back = nAsChars.substring(i, nAsChars.length());

//			if (log.isDebugEnabled()) {
//				log.debug("back: '{}', front: '{}'", back, front);
//			}
			
			String newNumber = back + front;

//			if (log.isDebugEnabled()) {
//				log.debug("n: '{}', m: '{}', newNumber: '{}'", new Object[] { nAsChars, mAsChars, newNumber });
//			}

			if (mAsChars.equals(newNumber)) {
				return true;
			}
		}

		return false;
	}

	private List<int[]> readInput(InputStream in) {

		final Scanner sc = new Scanner(in);

		int testCases = sc.nextInt();
		if (log.isDebugEnabled()) {
			log.debug("testCases: '{}'", testCases);
		}

		List<int[]> problemData = new ArrayList<int[]>(testCases);

		for (int i = 0; i < testCases; i++) {
			int[] minMax = new int[2];

			minMax[0] = sc.nextInt();
			minMax[1] = sc.nextInt();

			if (log.isDebugEnabled()) {
				log.debug("minMax: '{}'", minMax);
			}

			problemData.add(minMax);

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
			System.err.println("Usage: java " + RecycledNumbers.class.getName());
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

		RecycledNumbers problem = new RecycledNumbers();

		problem.execute(in, out);
	}
}
