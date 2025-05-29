package codejam;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import fixjava.Split;

import proba.Main;

/**
 * Put this class in a package that ends with the name of the problem, e.g. proba => problem A, with input A-large.in etc.
 * 
 * Then save the sample problem to DirConsts.INPUT_DIR as X-test.in, where X is the problem letter. Save small and large attempt input files to that dir also.
 * 
 * */
public abstract class CodeJam {

	PrintWriter writer;
	BufferedReader reader;
	ArrayList<String> currLineTokens = new ArrayList<String>();
	int caseNum = 0;

	private String getStaticField(String name) {
		try {
			return (String) (this.getClass().getDeclaredField(name).get(null));
		} catch (Exception e) {
			return null;
		}
	}

	public CodeJam() {
		// Get package name and extract problem letter
		String fullClassName = Main.class.getName();
		int dotIdx = fullClassName.indexOf('.');
		String pkgName = fullClassName.substring(0, dotIdx).toLowerCase();
		pkgName = "probc";
		if (!(pkgName.substring(0, pkgName.length() - 1).equals("prob")))
			throw new RuntimeException("Package name must be of the form 'probX'");
		final String problemLetter = pkgName.substring(pkgName.length() - 1).toUpperCase();

		File inpDir = new File(DirConsts.INPUT_DIR);
		if (!inpDir.exists())
			throw new RuntimeException("Directory " + DirConsts.INPUT_DIR + " not found");
		
		File outDir = new File(DirConsts.OUTPUT_DIR);
		if (!outDir.exists())
			throw new RuntimeException("Directory " + DirConsts.OUTPUT_DIR + " not found");

		File srcDir = new File(new File((getClass().getProtectionDomain().getCodeSource().getLocation().toString()).substring(5)).getParentFile(), "src");
		if (!srcDir.exists())
			throw new RuntimeException("src directory not found");

		// See if input file has been manually overriden by static field in Main class
		String OVERRIDE_INPUT_FILE = getStaticField("OVERRIDE_INPUT_FILE");

		try {
			// Package source into zipfile
			File zipFile = new File(outDir, problemLetter + "-source-latest.zip");
			System.out.println("Zipping source from " + srcDir);
			ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)));
			byte data[] = new byte[1024 * 1024];
			for (String dirName : srcDir.list()) {
				// Don't include probX directories for problems other than this one, but include everything else
				if (!dirName.startsWith("prob") || dirName.equals(pkgName)) {
					File dir = new File(srcDir, dirName);
					for (String srcFile : dir.list()) {
						String zipEntry = dirName + "/" + srcFile;
						System.out.println(" -> Adding: " + zipEntry);
						zipOut.putNextEntry(new ZipEntry(zipEntry));
						BufferedInputStream srcFileStream = new BufferedInputStream(new FileInputStream(new File(dir, srcFile)), data.length);
						for (int count; (count = srcFileStream.read(data, 0, data.length)) != -1;)
							zipOut.write(data, 0, count);
						srcFileStream.close();
					}
				}
			}
			zipOut.close();
			System.out.println("Wrote: " + zipFile.getPath() + "\n");

			// Determine input file to use
			String inpFileName;
			if (OVERRIDE_INPUT_FILE != null) {

				// Manual override
				inpFileName = problemLetter + "-" + OVERRIDE_INPUT_FILE + ".in";

			} else {

				// Find latest-ordered input file to use
				// Sort in order A-test.in, A-test0.in, A-test1.in, ..., A-small-attempt0.in, A-small-attempt1.in, ..., A-large.in

				String[] inpFiles = inpDir.list(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String filename) {
						boolean matches = filename.matches(problemLetter + "-.*\\.in");
						if (matches && (filename.indexOf('(') >= 0 || filename.indexOf(')') >= 0)) {
							// Don't include otherwise-valid filenames with parens in, warn the user, as
							// there are probably downloads from multiple problem rounds in the same dir
							System.err.println("Filename " + filename + " contains parens -- skipping");
							return false;
						}
						return matches;
					}
				});
				if (inpFiles.length == 0)
					throw new IOException("No input files found for problem " + problemLetter);

				// Sort into correct order (see above)
				Arrays.sort(inpFiles, new Comparator<String>() {
					@Override
					public int compare(String arg0, String arg1) {
						String a = arg0.substring(2), b = arg1.substring(2);
						int aType = a.startsWith("test") ? 0 : a.startsWith("small") ? 1 : a.startsWith("large") ? 2 : -1;
						int bType = b.startsWith("test") ? 0 : b.startsWith("small") ? 1 : b.startsWith("large") ? 2 : -1;
						int typeDiff = aType - bType;
						if (typeDiff != 0)
							return typeDiff;
						int aDotIdx = a.lastIndexOf('.'), bDotIdx = b.lastIndexOf('.');
						if (aDotIdx < 1 || bDotIdx < 1)
							return arg0.compareTo(arg1);
						int aNumIdx = aDotIdx - 1;
						while (aNumIdx >= 0 && Character.isDigit(a.charAt(aNumIdx)))
							aNumIdx--;
						String aNumStr = a.substring(aNumIdx + 1, aDotIdx);
						int bNumIdx = bDotIdx - 1;
						while (bNumIdx >= 0 && Character.isDigit(b.charAt(bNumIdx)))
							bNumIdx--;
						String bNumStr = b.substring(bNumIdx + 1, bDotIdx);
						if (aNumStr.isEmpty() || bNumStr.isEmpty())
							return arg0.compareTo(arg1);
						int aNum = Integer.parseInt(aNumStr);
						int bNum = Integer.parseInt(bNumStr);
						return aNum - bNum;
					}
				});
				inpFileName = inpFiles[inpFiles.length - 1];
				// for (String inpFile : inpFiles)
				// System.out.println("Input file: " + inpFile);
			}

			File inpFile = new File(inpDir, inpFileName);
			File outFile = new File(outDir, inpFileName.replace(".in", ".out"));

			// Copy input file to output dir if it's not already there
			if (!inpDir.equals(outDir)) {
				System.out.println("Copying input file to output dir");
				reader = new BufferedReader(new FileReader(inpFile));
				writer = new PrintWriter(new File(outDir, inpFileName));
				for (String line; (line = reader.readLine()) != null;)
					writer.println(line);
				writer.close();
				writer = null;
				reader.close();
				reader = null;
			}

			System.out.println("Reading: " + inpFile.getPath() + "\n");
			reader = new BufferedReader(new FileReader(inpFile));
			writer = new PrintWriter(outFile); // = null; // to suppress output

			// Do the work
			solve();

			if (writer != null)
				writer.close();
			System.out.println("\nWrote: " + outFile.getPath() + "\n\nFinished.");
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeLineRaw(String outputLine) {
		System.out.println(outputLine);
		if (writer != null)
			writer.println(outputLine);
	}

	public void writeCaseNumThenLine(String outputLine) {
		writeLineRaw("Case #" + (++caseNum) + ": " + outputLine);
	}

	public String readLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}

	/** Read next token, splitting on space */
	public String readTok() {
		if (currLineTokens.size() > 0) {
			String tok = currLineTokens.get(0);
			currLineTokens.remove(0);
			return tok;
		} else {
			currLineTokens.addAll(Split.splitAsListOfString(readLine(), " "));
			return readTok();
		}
	}

	/** Read next int, splitting on space */
	public int readInt() {
		return Integer.parseInt(readTok());
	}

	public abstract void solve();
}
