import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class RecycledNumbers {
	
	public static void main(String[] args) {
		
		try {
		
//			int T = 4;
//			int[][] testcases = new int[T][];
//			testcases[0] = new int[]{1,9};
//			testcases[1] = new int[]{10,40};
//			testcases[2] = new int[]{100,500};
//			testcases[3] = new int[]{1111,2222};
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C-small-attempt0.in")));
			
			String firstLine = reader.readLine();
			int T = Integer.valueOf(firstLine);
			int[][] testcases = new int[T][];
			
			for(int i = 0; i < T; i++) {
				String[] testcase = reader.readLine().split(" ");
				testcases[i] = new int[2];
				testcases[i][0] = Integer.valueOf(testcase[0]);
				testcases[i][1] = Integer.valueOf(testcase[1]);				
			}
			
			RecycledNumbers recylcing = new RecycledNumbers();
			
			for(int i = 0; i < T; i++) {
				System.out.printf("Case #%d: ",i+1,testcases[i]);
				int result = recylcing.count(testcases[i]);
				System.out.printf("%s\n", result);
			}
			
		}
		catch(Exception ex) {
			System.out.println("An error occured:\n");
			ex.printStackTrace();
		}
		
		
	}
	
	public int count(int[] input) {
		
		int A = input[0];
		int B = input[1];
		
		int hits = 0;
		
		for(int i = 0; i <= B - A; i++) {
			for(int j = 0; j <= B - A; j++) {
				
				int lessB = B - i;
				int moreA = A + j;
				
				if(lessB >= moreA) {
				
					int switchA = moreA;
					do {
						if(lessB == switchA && switchA > moreA) {
							hits++;
							break;
						}
						char[] chars = Integer.toString(switchA).toCharArray();
						chars = rotateCharacters(chars);
						switchA = Integer.valueOf(String.valueOf(chars));
					} while (moreA != switchA);
					
				}
				else {
					break;
				}
				
			}
		}
		
		return hits;
		
	}
	
	public char[] rotateCharacters(char[] chars) {
		if(chars.length > 1) {
			char charNext = chars[1];
			chars[1] = chars[0];
			for(int i = 1; i < chars.length - 1; i++) {
				char charNextNext = chars[i+1];
				chars[i+1] = charNext;
				charNext = charNextNext;
			}
			chars[0] = charNext;
			if(chars[0] == '0') {
				return rotateCharacters(chars);
			}
			else {
				return chars;
			}
		}
		else {
			return chars;
		}
	}

}
