package hk.polyu.cslhu.codejam.solution.impl;

import hk.polyu.cslhu.codejam.solution.Solution;

import java.util.ArrayList;
import java.util.List;

public class StoreCredit extends Solution {
	private int amountOfCredits, numOfItems;
	private List<Integer> priceList;
	
	@Override
	public void setProblem(List<String> testCase) {
		this.initial(testCase);
	}

	private void initial(List<String> testCase) {
		// TODO Auto-generated method stub
		this.amountOfCredits = Integer.valueOf(testCase.get(0));
		this.numOfItems = Integer.valueOf(testCase.get(1));
		this.setPriceList(testCase.get(2));
	}

	private void setPriceList(String string) {
		// TODO Auto-generated method stub
		String[] splitArray = string.split(" ");
		
		if (splitArray.length != numOfItems)
			logger.error("The price list does not include all items (" 
						+ splitArray.length 
						+ "/" + this.numOfItems + ")");
		
		this.priceList = new ArrayList<Integer>();
		for (String price : splitArray) {
			this.priceList.add(Integer.valueOf(price));
		}
	}
	
	@Override
	public void solve() {
		for (int itemIndex = 0; itemIndex < this.priceList.size() - 1; itemIndex++) {
			for (int anotherItemIndex = itemIndex + 1; anotherItemIndex < this.priceList.size(); anotherItemIndex++) {
				if (this.priceList.get(itemIndex) + this.priceList.get(anotherItemIndex) == this.amountOfCredits) {
					this.result = (itemIndex + 1) + " " + (anotherItemIndex + 1);
					break;
				}
			}
		}
	}
	
	@Override
	public String getResult() {
		return this.result;
	}
}
