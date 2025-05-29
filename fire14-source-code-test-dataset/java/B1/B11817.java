/**
 * Google CodeJam 2012
 * General framework that takes care of the similar and repetitive tasks for all the problems.
 * E.g. managing case input and output.
 * 
 * By Üllar Soon <positivew@gmail.com>
 */
package eu.positivew.codejam.framework;

import java.io.BufferedReader;


/**
 * CodeJam IO input interface.
 * 
 * @author Üllar Soon <positivew@gmail.com>
 */
public interface CodeJamInputParser {
	
	public CodeJamInputCase readCase(BufferedReader input);

}
