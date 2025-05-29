package codezam.exercise.WR1B2012;

import java.util.ArrayList;
import java.util.List;

public class TripletSet {
	List<Triplet> tripletList = new ArrayList<Triplet>();
	
	//Sum을 넣으면 가능한 Valid Triplet 조합을 생성한다.
	public TripletSet(long numberSum) {
		double numberSumDouble = (double) numberSum;
		long minValue = (long)Math.round(numberSumDouble/3-1);
		if (minValue < 0) {
			minValue = 0;
		}
		
		if (minValue + (minValue) + (minValue) == numberSum) {
			tripletList.add(new Triplet(minValue, minValue, minValue));
		} 
		
		if (minValue + (minValue) + (minValue+1) == numberSum) {
			tripletList.add(new Triplet(minValue, minValue, minValue+1));
		} 
		
		if (minValue + (minValue) + (minValue+2) == numberSum) {
			tripletList.add(new Triplet(minValue, minValue, minValue+2));
		} 
		
		if (minValue + (minValue+1) + (minValue+1) == numberSum) {
			tripletList.add(new Triplet(minValue, minValue+1, minValue+1));
		} 

		if (minValue + (minValue+1) + (minValue+2) == numberSum) {
			tripletList.add(new Triplet(minValue, minValue+1, minValue+2));
		} 

		if (minValue + (minValue+2) + (minValue+2) == numberSum) {
			tripletList.add(new Triplet(minValue, minValue+2, minValue+2));
		} 

		if ((minValue+1) + (minValue+1) + (minValue+1) == numberSum) {
			tripletList.add(new Triplet(minValue+1, minValue+1, minValue+1));
		}
		
		if ((minValue+1) + (minValue+1) + (minValue+2) == numberSum) {
			tripletList.add(new Triplet(minValue+1, minValue+1, minValue+2));
		}
		
		if ((minValue+1) + (minValue+2) + (minValue+2) == numberSum) {
			tripletList.add(new Triplet(minValue+1, minValue+2, minValue+2));
		}
	}
	
	public boolean isSurprising(int index) {
		Triplet triplet = (Triplet)tripletList.get(index);
		boolean result = (triplet).isSurprising();
		return result;
	}
	
	public long maxValue(int index) {
		Triplet triplet = (Triplet)tripletList.get(index);
		return triplet.getNumberMax();
	}
	
	public int size() {
		return tripletList.size();
	}
	
	public static final void main(String[] args) {
		System.out.println(Math.round(1.3));
		System.out.println(Math.round(1.8));
		System.out.println(Math.round(-1.3));
		System.out.println(Math.round(-1.8));
	}
}