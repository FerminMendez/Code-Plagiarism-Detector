import java.util.HashSet;
import java.util.Set;


public class Problem3 {
	private static int getRecycledNumbersCount(int min, int max) {
		int numberOfDigits = getNumberOfDigits(min, max);
		int prefix;
		int suffix;
		int finalNumber;
		Set<String> pairs = new HashSet<String>();
		for (int i = min ; i < max; i++) {
			for (int j = 1; j<numberOfDigits; j++) {
				prefix = (int) (i % Math.pow(10, j) * Math.pow(10, numberOfDigits - j));
				suffix = (int) (i / Math.pow(10, j));
				finalNumber = prefix + suffix;
				
				if (isValid(finalNumber, i, min, max)) {
					pairs.add(i + " , " + finalNumber);
				}
				
			}
		}
		
		return pairs.size();
	}
	
	private static int getNumberOfDigits(int min, int max) {
		String s1 = String.valueOf(min);
		String s2 = String.valueOf(max);
		if (s1.length() == s2.length()) return s1.length();
		throw new RuntimeException("Minimum and Maximum values have different numberOfDigits");
	}

	private static boolean isValid(int finalNumber, int sourceNumber, int min, int max) {
		return finalNumber > sourceNumber && finalNumber <=max; 
	}

	public static void main(String[] args) {
		System.out.println(getRecycledNumbersCount(10,99));
		System.out.println(getRecycledNumbersCount(162,939));
		System.out.println(getRecycledNumbersCount(112,989));
		System.out.println(getRecycledNumbersCount(100,100));
		System.out.println(getRecycledNumbersCount(182,983));
		System.out.println(getRecycledNumbersCount(129,963));
		System.out.println(getRecycledNumbersCount(167,943));
		System.out.println(getRecycledNumbersCount(158,947));
		System.out.println(getRecycledNumbersCount(105,992));
		System.out.println(getRecycledNumbersCount(123,941));
		System.out.println(getRecycledNumbersCount(104,994));
		System.out.println(getRecycledNumbersCount(364,749));
		System.out.println(getRecycledNumbersCount(152,946));
		System.out.println(getRecycledNumbersCount(135,927));
		System.out.println(getRecycledNumbersCount(100,999));
		System.out.println(getRecycledNumbersCount(142,993));
		System.out.println(getRecycledNumbersCount(177,921));
		System.out.println(getRecycledNumbersCount(103,966));
		System.out.println(getRecycledNumbersCount(122,996));
		System.out.println(getRecycledNumbersCount(120,976));
		System.out.println(getRecycledNumbersCount(271,271));
		System.out.println(getRecycledNumbersCount(101,921));
		System.out.println(getRecycledNumbersCount(115,976));
		System.out.println(getRecycledNumbersCount(137,959));
		System.out.println(getRecycledNumbersCount(139,915));
		System.out.println(getRecycledNumbersCount(1,2));
		System.out.println(getRecycledNumbersCount(49,83));
		System.out.println(getRecycledNumbersCount(114,962));
		System.out.println(getRecycledNumbersCount(37,53));
		System.out.println(getRecycledNumbersCount(114,982));
		System.out.println(getRecycledNumbersCount(158,931));
		System.out.println(getRecycledNumbersCount(314,801));
		System.out.println(getRecycledNumbersCount(140,989));
		System.out.println(getRecycledNumbersCount(172,958));
		System.out.println(getRecycledNumbersCount(393,646));
		System.out.println(getRecycledNumbersCount(112,986));
		System.out.println(getRecycledNumbersCount(136,912));
		System.out.println(getRecycledNumbersCount(112,938));
		System.out.println(getRecycledNumbersCount(109,964));
		System.out.println(getRecycledNumbersCount(166,969));
		System.out.println(getRecycledNumbersCount(150,965));
		System.out.println(getRecycledNumbersCount(150,944));
		System.out.println(getRecycledNumbersCount(104,925));
		System.out.println(getRecycledNumbersCount(102,919));
		System.out.println(getRecycledNumbersCount(175,937));
		System.out.println(getRecycledNumbersCount(189,991));
		System.out.println(getRecycledNumbersCount(133,996));
		System.out.println(getRecycledNumbersCount(190,984));
		System.out.println(getRecycledNumbersCount(2,7));
		System.out.println(getRecycledNumbersCount(744,744));
	}
}
