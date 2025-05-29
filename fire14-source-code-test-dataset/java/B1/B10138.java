import java.util.Scanner;


public class Recycled {
	/*
	private static boolean areTwoMirrors(int n, int m, int A, int B) {
		if (A > n || n >= m || m > B) return false;
		
		String mStr = Integer.toString(m);
		String nStr = Integer.toString(n);
		if (mStr.charAt(0) == '0' || nStr.charAt(0)=='0') return false;
		if (mStr.length() != nStr.length()) return false;
		for (int i=1; i < nStr.length(); i++) {
			nStr = nStr.substring(1) + nStr.charAt(0);
			if (nStr.equals(mStr)) return true;
		}
		return false;
	}*/
	static int[] powersOfTen = new int[7];
	private static int process(int A, int B) {
		//boolean[] hasVisited = new boolean[B+1];
		int numDigits = Integer.toString(A).length();
		int count = 0;
		for (int i = A; i < B; i++) {
			int num = i;
			for (int start = 1; start < numDigits; start++) {
				int firstDigit = num/powersOfTen[numDigits-1];
				num -= firstDigit*powersOfTen[numDigits-1];
				num *= 10;
				num += firstDigit;
				if (num <= B && num > i) {
					//if (!areTwoMirrors(i,num,A,B)) System.out.println("Jlfwje");
					//System.out.println(i+" "+num);
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int currPower = 1;
		for (int i=0; i < powersOfTen.length; i++) {
			powersOfTen[i] = currPower;
			currPower *= 10;
		}
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i=0; i < T; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			System.out.println("Case #"+(i+1)+": "+process(A,B));
		}
		
		//System.out.println(process(A,B));
	}
}
