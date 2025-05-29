package de.johanneslauber.codejam.model.impl;

import de.johanneslauber.codejam.model.ICase;

/**
 * 
 * @author Johannes Lauber - joh.lauber@googlemail.com
 * 
 */
public class RecycledNumbersCase implements ICase {
	private final int numberOfAttributes = 1;
	private int a;
	private int b;

	@Override
	public void setLine(int lineNumber, String lineValue) {
		if (lineNumber == 1) {
			String[] spllitedLine = lineValue.split(" ");
			a = Integer.parseInt(spllitedLine[0]);
			b = Integer.parseInt(spllitedLine[1]);
		} else {
			System.out.println("Linenumber is out of range");
		}
	}

	// Setter & Getter
	@Override
	public int getNumberOfAttributes() {
		return numberOfAttributes;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}
