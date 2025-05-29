package com.clausewitz.codejam.qr2012;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clausewitz.codejam.Solver;

public class Dancing extends Solver {

	private int N = -1;
	private int S = -1;
	private int p = -1;
	private int totalPoints[] = null;
	
	@Override
	public void readProblem() throws IOException {
		String line = fileIn.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());

		totalPoints = new int[N];
		for(int i=0;i<N;++i) totalPoints[i] = Integer.parseInt(st.nextToken());
	}
	
	private List<Object> comb = null;
	
	public void Combination(int[] list, int startIdx, int[] selected, int numOfRemain) {
		if(numOfRemain==0) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			for(int i=0;i<selected.length;++i) l.add(new Integer(selected[i]));
			comb.add(l);
		} else if(list.length==startIdx) {
			
		} else {
			selected[selected.length-numOfRemain] = startIdx;
			Combination(list, startIdx+1, selected, numOfRemain-1);
			selected[selected.length-numOfRemain] = -1;
			Combination(list, startIdx+1, selected, numOfRemain);
		}
	}

	@Override
	public void algorithm(int idx) {
		int maximum = 0;
		int[] list = new int[N];
		for(int i=0;i<N;++i) list[i] = i;
		
		if(idx==46) {
			System.out.print("");
		}
		
		if(S>0) {
			int[] selected = new int[S];
			comb = new ArrayList<Object>();
			Combination(list, 0, selected, S);
			
			for(int i=0;i<comb.size();++i) {
				int countOfThisCombination = 0;

				ArrayList<Integer> listOfSurprising = (ArrayList<Integer>) comb.get(i);				
				boolean isValidCombination = true;
				
				for(int j=0;j<N;++j) {
					boolean isSurprising = checkSurprisingNumber(listOfSurprising, j);

					int maxPoints = getMaxPoints(j, isSurprising);
					if(maxPoints>=p) ++countOfThisCombination;
					
					if(isSurprising && totalPoints[j]<2) {
						isValidCombination=false;
					}
				}

				if(isValidCombination && countOfThisCombination>maximum) maximum = countOfThisCombination;
			}
		} else {
			for(int j=0;j<N;++j) {
				int maxPoints = getMaxPoints(j, false);
				if(maxPoints>=p) ++maximum;
			}
		}
		
		answer[idx] = "" + maximum;
		if(idx==46) {
			System.out.println(maximum);
		}
	}

	private int getMaxPoints(int j, boolean isSurprising) {
		int maxPoints = 0;
		
		if(totalPoints[j]%3==0) {
			if(isSurprising) maxPoints = totalPoints[j]/3+1;
			else maxPoints = totalPoints[j]/3;
		} else if(totalPoints[j]%3==1) {
			maxPoints = totalPoints[j]/3+1;
		} else {
			if(isSurprising) maxPoints = totalPoints[j]/3+2;
			else maxPoints = totalPoints[j]/3+1;
		}
		return maxPoints;
	}

	private boolean checkSurprisingNumber(ArrayList<Integer> listOfSurprising, int j) {
		boolean isSurprising = false;
		for(int k=0;k<listOfSurprising.size();++k) {
			if(listOfSurprising.get(k).intValue()==j) {
				isSurprising = true;
				break;
			}
		}
		return isSurprising;
	}

}
