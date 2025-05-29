/**
 * Google CodeJam 2012
 * General framework that takes care of the similar and repetitive tasks for all the problems.
 * E.g. managing case input and output.
 * 
 * By Üllar Soon <positivew@gmail.com>
 */
package eu.positivew.codejam.framework;


/**
 * CodeJam input case (string).
 * 
 * @author Üllar Soon <positivew@gmail.com>
 */
public class CodeJamStringCase implements CodeJamInputCase {
	
	private String value = "";
	
	public CodeJamStringCase(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getType() {
		return "String";
	}

}
