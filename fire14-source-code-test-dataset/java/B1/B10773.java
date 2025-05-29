package RecycledNumbers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecycledNumbers {

	public static int numCase = 0;
	public static int A = 0;
	public static int B = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		process();		
	}
	
	public static void process() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("RecycledNumbers.in")));
		numCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < numCase; i++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			
			if (arr[0].length() == 1 && arr[1].length() == 1) {
				writeOut(i + 1, 0);
				continue;
			}

			A = Integer.valueOf(arr[0]);
			B = Integer.valueOf(arr[1]);
			
			if (B - A <= 5) {
				writeOut(i + 1, 0);
				continue;
			}
			
			process2(i + 1);
		}
	}
	
	public static void process2(int order) {
				
		//List<Integer> lstB = new ArrayList<Integer>();
		int count = 0;
		for (int n = A; n < B; n++) {
			if (isAllZero(n)) {
				continue;
			}
			for (int m = n + 1; m <= B; m++) {				
				if (!isAllZero(m) && isRecycledNumbers(n, m)) {
					count++;	
					//lstB.add(m);
				}
			}			
		}
		writeOut(order, count);
	}
	
	public static boolean isAllZero(int n) {
		
		int lengthN = String.valueOf(n).length();
		int dec = 1;
		for (int i = 0; i < lengthN - 1; i++) {
			dec *= 10;
		}
		if (n % dec == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isRecycledNumbers(int n, int m) {
		
		String strN = String.valueOf(n);
		String strM = String.valueOf(m);
		
		int lengthStrN = strN.length();
		for (int i = 1; i < lengthStrN; i++) {
			String prefix = strN.substring(lengthStrN - i, lengthStrN);
			if (!prefix.startsWith("0") && strM.startsWith(prefix)) {
				String t = prefix + strN.substring(0, lengthStrN - i); 
				if (t.equals(strM)) {						
					return true;
				}
			}
		}		
		return false;
	}
	
	public static void writeOut(int order, int result) {
		
		System.out.format("Case #%d: %d\n", order, result);
	}
}
