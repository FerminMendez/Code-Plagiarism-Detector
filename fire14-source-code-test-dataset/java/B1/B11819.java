/**
 * Google CodeJam 2012
 * General framework that takes care of the similar and repetitive tasks for all the problems.
 * E.g. managing case input and output.
 * 
 * By Üllar Soon <positivew@gmail.com>
 */
package eu.positivew.codejam.framework;

import java.io.BufferedReader;
import java.io.IOException;



/**
 * CodeJam input parser class (for general one-line strings).
 * 
 * @author Üllar Soon <positivew@gmail.com>
 */
public class CodeJamStringParser implements CodeJamInputParser {

	@Override
	public CodeJamInputCase readCase(BufferedReader input) {
		CodeJamInputCase inCase = null;
		
		try {
			inCase = new CodeJamStringCase(input.readLine());
		}
		catch(IOException ex) {
			System.err.println("Failed to read a test case!");
		}
		
		return inCase;
	}

}
