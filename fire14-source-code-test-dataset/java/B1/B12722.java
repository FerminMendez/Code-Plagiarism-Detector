package codejam.Y2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(
				"C:\\Documents and Settings\\vikmalik\\Desktop\\input1.txt"));

		int numCases = sc.nextInt();
		
//		System.out.println("\nCount  = " + getCount(100, 500));
		

		for (int i = 1; i <= numCases; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int count;
			if(a < b){
				count = getCount(a, b);
			}else{
				count = getCount(b, a);
			}
			System.out.println("Case #" + i + ": " + count);
		}
	}

	private static int getCount(int a, int b) {
		int lim = 0;
		int count = 0;
		if (b > 10 && b < 100) {
			lim = 1;
		} else if (b >= 100) {
			lim = 2;
		}

		Set<String> numList = new HashSet<String>();
		for (int j = 1; j <= lim; j++) {
			double divFactor = Math.pow(10, j);
			
			double mulFactor = 10;

			for (int i = a; i <= b; i++) {
				int diviser = (int) (i / divFactor);
				int remider = (int) (i % divFactor);
				
				if(remider == 0 || (divFactor == 100 && remider < 10)){
					continue;
				}
				if(i>=100){
					mulFactor =100;
				}else{
					mulFactor =10;
				}

				int num = (int) (remider * mulFactor + diviser);

//				System.out.println("diviser = "+ diviser);
//				System.out.println("remider = "+ remider);
//				System.out.println("num = "+ num);
				
				if (num >= a && num <= b && i != num && i>10 ) {
					String pair;
					if(i<num){
						pair = i + " , " + num;
					}else{
						pair = num + " , " + i;
					}
					
					numList.add(pair);
				}
			}
		}
		count = numList.size();
		
//		System.out.println("The list");
//		for (String pair : numList) {
//			System.out.println(pair);
//		}

		return count;
	}

}
