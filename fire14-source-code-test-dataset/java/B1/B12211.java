package hk.polyu.cslhu.codejam.solution;

import java.util.List;

import org.apache.log4j.Logger;

public abstract class Solution implements Cloneable {
	public static Logger logger = Logger.getLogger(Solution.class);
	
	protected String result;
	
	/**
	 * Set the problem to be solved
	 * 
	 * @param problemDesc List<String> The description of problem
	 */
	public abstract void setProblem(List<String> problemDesc);
	
	/**
	 * Solve the problem
	 */
	public abstract void solve();
	
	/**
	 * Return the result of problem
	 * 
	 * @return String Result
	 */
	public String getResult() {
		return this.result;
	}
	
	public Solution clone() throws CloneNotSupportedException {
		return (Solution) super.clone();
	}
}
