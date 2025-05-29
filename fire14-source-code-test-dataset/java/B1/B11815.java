/**
 * Google CodeJam 2012
 * Qualification round - Problem C
 * Recycled Numbers
 * 
 * Solved by Üllar Soon <positivew@gmail.com>
 */
package eu.positivew.codejam.recycled;

import eu.positivew.codejam.framework.CodeJamInputCase;


/**
 * Recycled Numbers test case class.
 * 
 * @author Üllar Soon <positivew@gmail.com>
 */
public class RecycledNumbersCase implements CodeJamInputCase {
	
	private Integer[] value = null;
	
	public RecycledNumbersCase(Integer[] value) {
		this.value = value;
	}

	public Integer[] getValue() {
		return value;
	}

	public void setValue(Integer[] value) {
		this.value = value;
	}
	
	public int getA() {
		if(value.length >= 2)
			return value[0];
		else
			return -1;
	}
	
	public int getB() {
		if(value.length >= 2)
			return value[1];
		else
			return -1;
	}

	@Override
	public String getType() {
		return "Integer[]";
	}

}
