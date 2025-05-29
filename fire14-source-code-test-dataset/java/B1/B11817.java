/**
 * Google CodeJam 2012
 * General framework that takes care of the similar and repetitive tasks for all the problems.
 * E.g. managing case input and output.
 * 
 * By �llar Soon <positivew@gmail.com>
 */
package eu.positivew.codejam.framework;

import java.io.BufferedReader;


/**
 * CodeJam IO input interface.
 * 
 * @author �llar Soon <positivew@gmail.com>
 */
public interface CodeJamInputParser {
	
	public CodeJamInputCase readCase(BufferedReader input);

}
