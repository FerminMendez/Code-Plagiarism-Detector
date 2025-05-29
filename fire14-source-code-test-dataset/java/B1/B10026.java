import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class RecycledNumbers {
	static boolean isRecycled(int a, int b, int length) {
		String aString = String.valueOf(a);
		String bString = String.valueOf(b);
		
		for (int i = 0; i < length - 1; i++) {
//			System.out.println(aString.substring(length - 1 - i) + aString.substring(0, length - 1 - i));
			if (bString.equals(aString.substring(length - 1 - i) + aString.substring(0, length - 1 - i))) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> lengths = new HashMap<Integer,Integer>();
		for (int i = 1; i <= 2000000; i++) {
			lengths.put(i, String.valueOf(i).length());
		}
		for (int t = 1; t <= testCases; t++) {
			String[] ab  = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			int aLog = ab[0].length() - 1;
			int bLog = ab[1].length() - 1;
			
			int count = 0;
			for (int i = a; i <= b; i++) {
				int iLength = lengths.get(i);
				for (int j = i + 1; j <= b; j++) {
					if (iLength != lengths.get(j)) {
						break;
					}
					if (isRecycled(i, j, iLength)) {
						count++;
					}
				}
			}
			
			
			System.out.println("Case #" + t + ": " + count);
			
		}
	}
}
