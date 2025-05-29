package com.googlecode.codejam.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class JamResolver {

	private final JamCaseResolverFactory jamCaseResolverFactory;
	
	private final File input;
	
	private final File output;

	public JamResolver(JamCaseResolverFactory jamCaseResolverFactory, String parentDirectory, String fileName) {
		this.jamCaseResolverFactory = jamCaseResolverFactory;
		if(!new File(parentDirectory).exists())
			parentDirectory = Constants.PARENT_DIRECTORY + parentDirectory;
		this.input = new File(parentDirectory, fileName);
		this.output = new File(parentDirectory, fileName.replaceFirst("\\.in$", ".out"));
	}
	
	public void resolve() throws Exception {
		System.out.println("Started computation, resolver: " + jamCaseResolverFactory.getClass().getPackage().getName());
		System.out.println("Input\tFile: " + input.getAbsolutePath());
		System.out.println("Output\tFile: " + output.getAbsolutePath());
		final ExecutorService executor = Executors.newFixedThreadPool(1);
		try {
			final Iterator<String> lineIterator = FileUtils.lineIterator(input, "UTF-8");
			final int caseNumber = Integer.parseInt(lineIterator.next());
			final List<Future<String>> solutions = new ArrayList<Future<String>>(caseNumber);
			for (int i = 1; i <= caseNumber; i++) {
				solutions.add(executor.submit(jamCaseResolverFactory.newJamCaseResolver(i, lineIterator)));
			}
			final BufferedWriter solutionFile = new BufferedWriter(new OutputStreamWriter(FileUtils.openOutputStream(output)));
			int count = 1;
			try {
				for (Future<String> future : solutions) {
					solutionFile.append("Case #").append(String.valueOf(count++)).append(": ");
					solutionFile.append(future.get());
					solutionFile.newLine();
				}
			} finally {
				IOUtils.closeQuietly(solutionFile);
			}
		} finally {
			executor.shutdown();
		}
		System.out.println("Ended computation");
	}
	
}
