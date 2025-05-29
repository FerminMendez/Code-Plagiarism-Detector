package hk.polyu.cslhu.codejam.solution.impl.qualificationround;

import java.util.ArrayList;
import java.util.List;

import hk.polyu.cslhu.codejam.solution.Solution;

public class DancingWithTheGooglers extends Solution {
	private int N, S, p;
	private List<Integer> totalPointList;

	@Override
	public void setProblem(List<String> problemDesc) {
		// TODO Auto-generated method stub
		String[] splitArray = problemDesc.get(0).split(" ");
		
		this.N = Integer.valueOf(splitArray[0]);
		this.S = Integer.valueOf(splitArray[1]);
		this.p = Integer.valueOf(splitArray[2]);
		
		this.totalPointList = new ArrayList<Integer>();
		for (int i = 3; i < splitArray.length; i++) {
			this.totalPointList.add(Integer.valueOf(splitArray[i]));
		}
		
		if (this.totalPointList.size() != this.N)
			logger.error("Found an error for " + problemDesc.get(0));
	}

	@Override
	public void solve() {
		// TODO Auto-generated method stub
		int minNotSupSum = this.p * 3 - 2;
		int minSupSum = this.p > 1 ? (this.p * 3 - 4) : 1;
		
		int totalNotSup = 0;
		int totalSup = 0;
		
		for (Integer point : this.totalPointList) {
			if (point >= minNotSupSum)
				totalNotSup++;
			else if (point >= minSupSum)
				totalSup++;
		}
		
		if (totalSup + totalNotSup < this.S)
			logger.error("Found an error for suprising cases");
		
		this.result = String.valueOf(totalNotSup + Math.min(totalSup, this.S));
	}

}
