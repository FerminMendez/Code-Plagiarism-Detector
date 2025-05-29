import java.util.Scanner;


public class Recycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numLines = sc.nextInt();
		int lineCounts = 1;
		
		while (numLines > 0) {
			String A = sc.next();
			String B = sc.next();
//			System.out.println(A + " " + B);
			
			int result = findRecyclePairs(A, B);
			System.out.println("Case #" + lineCounts + ": " +result);
			numLines--;
			lineCounts++;
		}

	}

	private static int findRecyclePairs(String a, String b) {
		
		int result = 0;
		int strLength = a.length();
		int pos;
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		int i;
		int j;
		String str1;
		String str2;
		String strTemp;
		String front;
		
		
		if (strLength > 1) {
			
			for (i = num1; i < num2; i++) {
				str1 = Integer.toString(i);
				for (j = i+1; j <= num2; j++) {
					str2 = Integer.toString(j);
					for (pos = 1; pos < strLength; pos++) {
						strTemp = str1.substring(pos);
						front = str1.substring(0, pos);
//						System.out.println(str2+ " " + front);
						
						strTemp = strTemp.concat(front);
//						System.out.println("Str2: "+ str2);
						
						if (!str2.startsWith("0") && !str1.startsWith("0")) {
							if (strTemp.equals(str2)) {
								result++;
							}
						}
					}
				}
			}
			
		}
		
		return result;
	}
	
	
}
