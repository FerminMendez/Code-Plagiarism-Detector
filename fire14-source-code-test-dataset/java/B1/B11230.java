package codezam.exercise.WR1C2012;

import java.util.HashMap;
import java.util.Map;

public class PairNumbers {
	Map pairNumberMap = new HashMap();
	
	public void put(String numberA, String numberB) {
		String key = getKey(numberA, numberB); 
		
		pairNumberMap.put(key, new PairNumber(new Long(numberA).longValue(), new Long(numberB).longValue()));
	}
	
	public boolean containsKey(String numberA, String numberB) {
		String key = getKey(numberA, numberB); 
		
		return pairNumberMap.containsKey(key);
	}
	
	private String getKey(String numberA, String numberB) {
		return new Long(numberA).longValue() >= new Long(numberB).longValue() ? numberA +" "+ numberB : numberB +" "+ numberA;
	}
	
	public int size() {
		return pairNumberMap.size();
	}
}

