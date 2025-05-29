
public class Number {
	int A ; 
	int B ;
	int length ; 
	
	public Number(String str) {
		String[] tmpArr = str.split(" ");
		A = Integer.parseInt(tmpArr[0]);
		B = Integer.parseInt(tmpArr[1]);
		length = tmpArr[0].length(); 
	}
	
	public int getRecycledPairCount() {
		int count = 0 ; 
		for (int i=A; i<B; i++) {  // i<B
			count += getRecycledPairCountNumber(i, B);
		}
		return count;
	}
	
	public int getRecycledPairCountNumber(int n, int maxNumber) { 
		int pairCount = 0 ;
		
		StringBuffer alreadyGet = new StringBuffer();
		StringBuffer strN = new StringBuffer(String.valueOf(n));
		for (int i=1; i<length; i++) {
			String s = strN.substring(i) +strN.substring(0, i);
			if (s.startsWith("0")) {
				continue; 
			}
			int pair = Integer.parseInt(s);
			if (n>=pair || pair>maxNumber) {
				continue;
			}
			
			if (alreadyGet.indexOf(s) > -1) {
				continue;
			}
			pairCount++;
			alreadyGet.append(" ").append(pair);
		}
		
		return pairCount ; 
	}
}
