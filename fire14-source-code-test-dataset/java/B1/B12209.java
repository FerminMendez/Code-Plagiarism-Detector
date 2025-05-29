package hk.polyu.cslhu.codejam.solution.impl.qualificationround;

import java.util.List;

import hk.polyu.cslhu.codejam.solution.Solution;

public class RecycledNumbers extends Solution {
	private int min, max;
	
	@Override
	public void setProblem(List<String> problemDesc) {
		// TODO Auto-generated method stub
		String[] splitArray = problemDesc.get(0).split(" ");
		this.min = Integer.valueOf(splitArray[0]);
		this.max = Integer.valueOf(splitArray[1]);
	}

	@Override
	public void solve() {
		// TODO Auto-generated method stub
		int numOfPairs = 0;
		
		for (int i = this.min; i < this.max; i++) {
			for (int j = i + 1; j <= this.max; j++) {
				if (this.isRecycledPair(i, j))
					numOfPairs++;
			}
		}
		
		this.result = String.valueOf(numOfPairs);
	}

	private boolean isRecycledPair(int i, int j) {
		// TODO Auto-generated method stub
		
		if (i >= j)
			return false;
		
		String m = String.valueOf(j);
		String n = String.valueOf(i);
		
		for (int startIndex = 1; startIndex < n.length(); startIndex++) {
			String partToMove = n.substring(startIndex, n.length());
			String newString = partToMove + n.substring(0, startIndex);
			
			if (newString.equals(m))
				return true;
		}
		
		return false;
	}

}
