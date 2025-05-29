package info.m3o.gcj2012.recyclednumber;

public class RecycledNumber {
	protected String numStr;
	protected int numDigits;

	protected int minA, maxB;

	public RecycledNumber(String s, int mina, int maxb){
		numStr = new String(s);
		numDigits = s.length();
		minA = mina;
		maxB = maxb;
	}

	//	public RecycledNumber(String s){
	//		numStr = new String(s);
	//		numDigits = s.length();
	//	}

	public RecycledNumber(int p, int mina, int maxb){
		numStr = new String(String.valueOf(p));
		numDigits = numStr.length();
		minA = mina;
		maxB = maxb;
	}

	//	public RecycledNumber(int p){
	//		numStr = new String(String.valueOf(p));
	//		numDigits = numStr.length();
	//	}

	public static String recycleAt(String s, int i){
		assert ((i>0) && (i<s.length())) : "int parameter is greater than length.";
		return ( new String (s.substring(i) + s.substring(0, i)));
	}

	public static String[] getCycledNumber(String s){
		String [] str;
		str = new String[s.length()-1];
		
		for(int i=1; i < s.length(); i++){
		 // str[i-1] = new String (recycleAt(s, i));
			str[i-1] = recycleAt(s, i);
		}
		return str;
	}
	

	public void addRecycledNumbers(MyNumberStringPairSet recycledNumberSet,
			MyNumberStringSet tested,  String sNum2) {
// TODO
		/*
		if (tested.contains(sNum2) == true){
			return;
		}*/

		int intS2 = Integer.valueOf(sNum2);

		if (((this.numStr.compareTo(sNum2)) != 0) && (sNum2.startsWith("0") == false)
				&& (intS2 >= this.minA) && (intS2 <= this.maxB)) {
			recycledNumberSet.add(new MyNumberStringPair(this.numStr, sNum2));
		}
		tested.add(numStr);
		tested.add(sNum2);

	}			


	
	
	public void addRecycledNumbers(MyNumberStringPairSet recycledNumberSet, MyNumberStringSet tested){
		if (tested.contains(numStr) == true){ // This value has been tested already.
			return;  
		}

		for(int i=1; i < this.numDigits; i++){
			String s = new String (recycleAt(numStr, i));
			
			// HERE TODO
			tested.add(s);
			int intS = Integer.valueOf(s);
			
			if ((s.startsWith("0")==false) 
					&& (numStr.compareTo(s) != 0)
					&& (intS >=this.minA) 
					&& (intS <= this.maxB)){
				recycledNumberSet.add(new MyNumberStringPair(s, numStr));
			}
			
//			if (s.startsWith("0")== false){
//				tested.add(s); // Here is the part
//			}
		}
		tested.add(numStr);		

	}



	public static boolean testrecycleAt(){
		boolean retb = false;
		boolean []b = new boolean[4];

		String str1 = "12345";

		String str2 = recycleAt(str1, 1);
		b[0] = ("23451".compareTo(str2)==0);

		str2 = recycleAt(str1, 2);
		b[1] = ("34512".compareTo(str2) == 0);

		str2 = recycleAt(str1, 3);
		b[2] = ("45123".compareTo(str2) == 0);

		str2 = recycleAt(str1, 4);
		b[3] = ("51234".compareTo(str2) == 0);

		retb = (b[0] && b[1] && b[2] && b[3]);
		assert (retb == true) : "something is wrong with recycleAt method.";
		return retb;
	}

	public String getNumStr() {
		return numStr;
	}
	public void setNumStr(String numStr) {
		this.numStr = numStr;
	}
	public int getNumDigits() {
		return numDigits;
	}
	public void setNumDigits(int numDigits) {
		this.numDigits = numDigits;
	}



}
