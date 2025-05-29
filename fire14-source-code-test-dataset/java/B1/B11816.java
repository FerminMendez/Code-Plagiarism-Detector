/**
 * Google CodeJam 2012
 * Qualification round - Problem C
 * Recycled Numbers
 * 
 * Solved by Üllar Soon <positivew@gmail.com>
 */
package eu.positivew.codejam.recycled;

import java.io.BufferedReader;
import java.io.IOException;

import eu.positivew.codejam.framework.CodeJamInputCase;
import eu.positivew.codejam.framework.CodeJamInputParser;


/**
 * Recycled Numbers input parser class.
 * 
 * @author Üllar Soon <positivew@gmail.com>
 */
public class RecycledNumbersParser implements CodeJamInputParser {

	@Override
	public CodeJamInputCase readCase(BufferedReader input) {
		CodeJamInputCase inCase;
		
		try {
			String line = input.readLine();
			String[] args = line.split(" ");
			Integer[] abArr = new Integer[args.length];
			for(int i = 0; i < args.length; i++) {
				try {
					abArr[i] = Integer.parseInt(args[i]);
				}
				catch(NumberFormatException ex) {
					System.err.println("Badly formatted test case data!");
				}
			}
			inCase = new RecycledNumbersCase(abArr);
			return inCase;
		}
		catch (IOException e) {
			System.err.println("Failed to read test case data!");
			return null;
		}
	}

}
