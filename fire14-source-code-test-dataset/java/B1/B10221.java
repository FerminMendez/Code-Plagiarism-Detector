package com.code.jam;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

public class CRecycledNumbers {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner (new File("C:/codeJam/ficheros2012/CRecycledNumbers.in"));
		PrintStream ps = new PrintStream("C:/codeJam/ficheros2012/CRecycledNumbers.out");
		int T = new Integer (in.nextLine());
		for (int nCase = 1; nCase < T + 1; nCase++) {
			Scanner inLine = new Scanner (in.nextLine());
			int recycledPair = 0;
			int A = inLine.nextInt();
			int B = inLine.nextInt();
			int lengthI = String.valueOf(A).length();
			
			if (lengthI > 1){
				for (int n = A; n <= B; n++){
					int operatorGetLeftRight = 1;
					int operatorNewNumber = Integer.valueOf(StringUtils.rightPad("1", lengthI + 1, '0'));
					for (int j = 1; j < lengthI; j++) {
						operatorGetLeftRight *= 10;
						operatorNewNumber /= 10;
						int newLeft = n % operatorGetLeftRight;
						int newRight = (n - newLeft) / operatorGetLeftRight;
						int m = newLeft * operatorNewNumber + newRight;
						if ((m >= A) && (m <= B) && (n < m)){
							recycledPair++;
//							if (lengthI == 4){
//								System.out.format("(%d, %d) \n", n, m);
//							}	
						}
					}
				}
			}
			System.out.format("Case #%d: %d\n", nCase, recycledPair);
			ps.format("Case #%d: %d\n", nCase, recycledPair);
		}
//		ps.flush();
//		ps.close();
	}
}
