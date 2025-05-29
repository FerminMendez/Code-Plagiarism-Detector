package com.problemC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecycledNumber {

	private static int A = 1111;
	private static int B = 2222;
	public static int count = 0;

	public static void main(String[] args) {
		String[] s ;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/com/problemC/C-small-attempt0.in"));
			int caseNo = 1;
			int T = Integer.parseInt(br.readLine());
			while (caseNo <= T) {
				count = 0;
				s = br.readLine().split(" ");
				A = Integer.parseInt(s[0]);
				B = Integer.parseInt(s[1]);
				for (int i = A; i <= B; i++) {
					rotate(i);
				}
				System.out.println("Case #" + caseNo++ + ": " + count);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(br != null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	private static void rotate(int num) {
		int l = (num + "").length(), l2;
		int toCut = 1;
		int original = num, newNum;
		String s = num + "", firstPart, secondPart;
//		 System.out.println(s);
		for (toCut = 1; toCut < l; toCut++) {
			firstPart = s.substring(0, l - toCut);
			secondPart = s.substring(l - toCut);
			newNum = Integer.parseInt(secondPart + firstPart);
//			 System.out.println(firstPart + " "+secondPart +": "+newNum);
			l2 = (newNum + "").length();
			if (l == l2 && newNum > original && newNum <= B) {
//				System.out.println(original + " " + newNum);
				count++;
			}
		}
	}
}
