package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.management.ImmutableDescriptor;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class Problem3 {
	public static void main(String[] args) throws Exception {
		new Problem3().prepareAndSolve();
	}

	private void prepareAndSolve() throws Exception {
		File inout = new File("inout");
		final String testSuffix;
		if (getClass().getSimpleName().endsWith("1")) {
			testSuffix = "A";
		} else if (getClass().getSimpleName().endsWith("2")) {
			testSuffix = "B";
		} else if (getClass().getSimpleName().endsWith("3")) {
			testSuffix = "C";
		} else {
			testSuffix = "D";
		}
		File ioDir = inout.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.compareTo(testSuffix) == 0;
			}
		})[0];

		// SAMPLE

		File sampleIn = ioDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.compareTo("sample.in") == 0;
			}
		})[0];
		StringWriter buffer = new StringWriter();
		BufferedWriter writer = new BufferedWriter(buffer);

		long time = System.currentTimeMillis();
		solve(new BufferedReader(new FileReader(sampleIn)), writer);
		System.out.println("Sample checked: " + (System.currentTimeMillis() - time) + " ms");
		writer.close();

		File sampleOut = ioDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.compareTo("sample.out") == 0;
			}
		})[0];
		if (checkCorrectness(buffer.toString(), sampleOut) == false) {
			System.out.println("NOT CORRECT:");
			System.out.println(buffer.toString());
			return;
		}

		// ADDITIONAL

		File[] additionalTest = ioDir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.compareTo("add.in") == 0;
			}
		});
		if (additionalTest.length == 1) {
			buffer = new StringWriter();
			writer = new BufferedWriter(buffer);
			time = System.currentTimeMillis();
			solve(new BufferedReader(new FileReader(additionalTest[0])), writer);
			System.out.println("Additional checked: " + (System.currentTimeMillis() - time) + " ms");
			writer.close();
			File additionalTestAnswer = ioDir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.compareTo("add.out") == 0;
				}
			})[0];
			if (checkCorrectness(buffer.toString(), additionalTestAnswer) == false) {
				System.out.println("NOT CORRECT:");
				System.out.println(buffer.toString());
				return;
			}
		}

		// SMALL

		File[] smallTest = ioDir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.contains("small") && name.contains("in");
			}
		});
		if (smallTest.length == 1) {
			buffer = new StringWriter();
			writer = new BufferedWriter(buffer);
			time = System.currentTimeMillis();
			solve(new BufferedReader(new FileReader(smallTest[0])), writer);
			System.out.print("Small runned: " + (System.currentTimeMillis() - time) + " ms");
			writer.close();
			File smallAnswer[] = ioDir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.compareTo("small.out") == 0;
				}
			});
			if (smallAnswer.length == 1) {
				if (checkCorrectness(buffer.toString(), smallAnswer[0]) == false) {
					System.out.println("NOT CORRECT:");
					System.out.println(buffer.toString());
					return;
				}
				System.out.println(", verified");
			} else {
				BufferedWriter solutionWriter = new BufferedWriter(new FileWriter("inout" + File.separatorChar + testSuffix + File.separatorChar + "small.out"));
				solutionWriter.write(buffer.toString());
				solutionWriter.close();
				System.out.println(", written");
			}
		}

		// RANDOM GENERATED

		if (testWithRandom == true) {
			StringWriter sw = new StringWriter();
			BufferedWriter bw = new BufferedWriter(sw);
			bw.write("" + randomInputTestNum);
			bw.newLine();
			for (int i = 0; i < randomInputTestNum; i++) {
				generateOneRandomInputTest(bw);
			}
			time = System.currentTimeMillis();
			bw.flush();
			solve(new BufferedReader(new StringReader(sw.toString())), new BufferedWriter(new StringWriter()));
			System.out.print("Random runned: " + (System.currentTimeMillis() - time) + " ms");
		}

		// LARGE

		File[] largeTest = ioDir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.contains("large") && name.contains("in");
			}
		});
		if (largeTest.length == 1) {
			buffer = new StringWriter();
			writer = new BufferedWriter(buffer);
			time = System.currentTimeMillis();
			solve(new BufferedReader(new FileReader(largeTest[0])), writer);
			System.out.print("Large runned: " + (System.currentTimeMillis() - time) + " ms");
			writer.close();
			File largeAnswer[] = ioDir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.compareTo("large.out") == 0;
				}
			});
			if (largeAnswer.length == 1) {
				if (checkCorrectness(buffer.toString(), largeAnswer[0]) == false) {
					System.out.println("NOT CORRECT:");
					System.out.println(buffer.toString());
					return;
				}
				System.out.println(", verified");
			} else {
				BufferedWriter solutionWriter = new BufferedWriter(new FileWriter("inout" + File.separatorChar + testSuffix + File.separatorChar + "large.out"));
				solutionWriter.write(buffer.toString());
				solutionWriter.close();
				System.out.println(", written");
			}
		}
	}

	private boolean checkCorrectness(String answer, File correctAnswerFile) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(correctAnswerFile));
		try {
			BufferedReader stringReader = new BufferedReader(new StringReader(answer));
			String answerLine = stringReader.readLine();
			String solutionLine = reader.readLine();
			while (answerLine != null && solutionLine != null) {
				if (answerLine.compareTo(solutionLine) != 0) {
					return false;
				}
				answerLine = stringReader.readLine();
				solutionLine = reader.readLine();
			}
			if (solutionLine != null) {
				solutionLine = reader.readLine();
			}
			if (solutionLine != null || answerLine != null) {
				return false;
			}
			return true;
		} finally {
			reader.close();
		}

	}

	private int	tasksRunning	= 0;

	@SuppressWarnings("unchecked")
	public void solve(BufferedReader reader, BufferedWriter writer) throws Exception {
		int T = Integer.parseInt(reader.readLine());
		ExecutorService xs = Executors.newFixedThreadPool(4);
		Future<String>[] outputs = new Future[T];
		for (int i = 0; i < outputs.length; i++) {
			final Solution s = new Solution();
			tasksRunning++;
			s.readInput(reader);
			outputs[i] = xs.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					try {
						return s.solveInput();
					} finally {
						tasksRunning--;
					}
				}
			});
		}
		new Thread() {
			public void run() {
				try {
					while (true) {
						sleep(10000);
						if (tasksRunning == 0) {
							interrupt();
						}
						System.out.println("Tasks remaining:" + tasksRunning);
					}
				} catch (InterruptedException e) {
				}
			};
		}.start();
		for (int i = 0; i < outputs.length; i++) {
			writer.write("Case #" + (i + 1) + ": " + outputs[i].get());
			writer.newLine();
		}
		xs.shutdown();
	}

	// ------------------------START OF THE SOLUTION------------------------------

	public static boolean	testWithRandom		= false;

	public static int		randomInputTestNum	= 1;

	public void generateOneRandomInputTest(BufferedWriter bw) throws Exception {
		bw.write(500 + "");
		bw.newLine();
	}

	public static class Solution {

		private int getIntegerLength(int i) {
			return (i + "").length();
		}

		private int recycleInt(int integer, int position) {
			return Integer.parseInt((integer + "").substring(position) + (integer + "").substring(0, position));
		}

		private ImmutableSet<Integer> getRecycleds(int integer) {
			ImmutableSet.Builder<Integer> res = ImmutableSet.builder();
			for (int i = 1; i < getIntegerLength(integer); i++) {
				res.add(recycleInt(integer, i));
			}
			return res.build();
		}

		private ImmutableSet<Integer> getGreaterRecycledsBetween(final int integer, final int min, final int max) {
			return ImmutableSet.copyOf(Collections2.filter(getRecycleds(integer), new Predicate<Integer>() {
				public boolean apply(Integer arg0) {
					return arg0 >= min && arg0 <= max && arg0 > integer;
				};
			}));
		}

		private int getAllRecycledsNumBetween(int min, int max) {
			int result = 0;
			for (int i = min; i <= max; i++) {
				result += getGreaterRecycledsBetween(i, min, max).size();
			}
			return result;
		}

		private int	minParam;

		private int	maxParam;

		public void readInput(BufferedReader reader) throws Exception {
			String line = reader.readLine();
			minParam = Integer.parseInt(line.split("[ ]")[0]);
			maxParam = Integer.parseInt(line.split("[ ]")[1]);
		}

		public String solveInput() throws Exception {
			return getAllRecycledsNumBetween(minParam, maxParam) + "";
		}
	}
}
