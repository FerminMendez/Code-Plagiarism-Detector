import java.util.StringTokenizer;


public class Numbers {

	final static String INPUT = "50\n" + 
"103 968\n" + 
"150 975\n" + 
"122 949\n" + 
"129 936\n" + 
"120 979\n" + 
"532 532\n" + 
"100 101\n" + 
"171 913\n" + 
"129 974\n" + 
"162 954\n" + 
"113 964\n" + 
"109 930\n" + 
"190 916\n" + 
"175 941\n" + 
"131 971\n" + 
"117 916\n" + 
"185 986\n" + 
"118 595\n" + 
"170 958\n" + 
"162 913\n" + 
"125 944\n" + 
"218 986\n" + 
"176 925\n" + 
"152 956\n" + 
"100 999\n" + 
"179 947\n" + 
"387 387\n" + 
"166 958\n" + 
"148 990\n" + 
"70 99\n" + 
"183 920\n" + 
"100 999\n" + 
"144 965\n" + 
"123 954\n" + 
"2 3\n" + 
"105 958\n" + 
"122 980\n" + 
"40 62\n" + 
"114 954\n" + 
"185 974\n" + 
"126 992\n" + 
"190 936\n" + 
"497 884\n" + 
"100 100\n" + 
"109 972\n" + 
"178 980\n" + 
"137 962\n" + 
"106 997\n" + 
"147 954\n" + 
"188 981\n";
	
	public static void main(final String argv[]) throws NumberFormatException, Exception {
		StringTokenizer st = new StringTokenizer(INPUT);
		
		final int testCases = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < testCases; i++) {
			System.out.println("Case #"+(i+1)+": " + 
					solve(Integer.parseInt(st.nextToken()), 
							Integer.parseInt(st.nextToken())));
		}
	}


	private static int solve(final int A, final int B) throws Exception {
		if(A < 10) {
			return 0;
		} else {
			int result = 0;

			final int digits = Integer.toString(A).length();	
			for(int n = A; n < B; n++) {
				
				for(int shifts = 0; shifts < (digits - 1); shifts++) {
					byte [] numB = new byte[digits];
					toByteArr(n, numB);
					shift(numB, shifts + 1);
					int m = toInt(numB);
					if(m > n && m <= B) {
						//System.out.println(i + " " + tmpNr);	
						result++;
						if(numB[0] == 0) throw new Exception("a");
					}
				}
			}
			return result;
		}
	}
	
	private static void shift(byte[] numB, int positions) {
		
		byte [] tmp = new byte[positions];
		for(int i = 0; i < positions; i++) {
			tmp[i] = numB[numB.length - (positions - i)];
		}
		
		for(int i = numB.length - 1; i > (positions - 1); i--) {
			numB[i] = numB[i-positions];
		}
		
		for(int i = 0; i < positions; i++) {
			numB[i] = tmp[i];
		}
	}


	private static byte [] toByteArr(int nr, byte [] arr) {
		char [] chars = Integer.toString(nr).toCharArray();
		
		
 		for(int i = 0; i < arr.length; i++) {
			arr[i] = (byte) (chars[i] - 48);
		}
		return arr;
	}
	
	private static int toInt(byte [] arr) {
		int result = 0;
		for(int i = 0; i < arr.length; i++) {
			result += arr[i] * (int)Math.pow(10, arr.length - 1 - i);
		}
		return result;
	}
}
