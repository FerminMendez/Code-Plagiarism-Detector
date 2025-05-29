package de.johanneslauber.codejam.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * 
 * @author Johannes Lauber - joh.lauber@googlemail.com
 * 
 */
public abstract class BaseProblem implements IProblem {

	protected List<ICase> listOfCases;
	private BufferedWriter out;
	private int countOutputLines = 0;

	public BaseProblem() {
		try {
			out = new BufferedWriter(new FileWriter("output/output.out"));
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	@Override
	public void setListOfCases(List<ICase> listOfCases) {
		this.listOfCases = listOfCases;
	}

	/**
	 * 
	 * @author Johannes Lauber - joh.lauber@googlemail.com
	 * @param stringArray
	 * @return
	 */
	protected int[] toIntArray(String[] stringArray) {
		int[] intArray = new int[stringArray.length];

		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.valueOf(stringArray[i]);
		}
		return intArray;
	}

	/**
	 * 
	 * @author Johannes Lauber - joh.lauber@googlemail.com
	 * @param line
	 */
	protected void writeToFile(String line) {
		countOutputLines++;
		try {
			out.write("Case #" + countOutputLines + ": " + line);
			out.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author Johannes Lauber - joh.lauber@googlemail.com
	 */
	protected void closeWriter() {
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}