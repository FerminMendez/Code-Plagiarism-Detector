import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Recycled {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inStr = null;
		int numCases = 0;
		
		
		try {
			inStr = br.readLine();
			numCases = Integer.parseInt(inStr);
			for (int i = 0; i < numCases; i++) {
				inStr = br.readLine();
				System.out.println("Case #" + (i+1) + ": " + checkNums(inStr));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int checkNums(String s) {
		int [] n, m;
		int length, A, B;

		int result = 0;
		Scanner ints = new Scanner(s);
		
		A = ints.nextInt();
		B = ints.nextInt();
		
		length = (s.length()-1) / 2;
				
		n = new int[length];
		m = new int[length];
		
		for (int i = A; i < B; i++) {
			for (int j = i+1; j <= B; j++) {
				String nStr = "" + i;
				String mStr = "" + j;
				
				for (int x = 0; x < length; x++) {
					n[x] = nStr.charAt(x) - 48;
					m[x] = mStr.charAt(x) - 48;
				}
				for (int x = 0; x < length - 1; x++) {
					int tempInt = n[length - 1];
					for (int y = length - 1; y > 0; y--) {
						n[y] = n[y-1];
					}
					n[0] = tempInt;
					if (isEqual(n, m, length)) {
						result++;
						break;
					}
				}
				
				
				
				
			}
		}
		

		return result;
	}
	
	public static Boolean isEqual(int[] m, int [] n, int length) {

		for (int i = 0; i < length; i++) {
			if (n[i] != m[i]) return false;
		}
		
		return true;
	}

}
