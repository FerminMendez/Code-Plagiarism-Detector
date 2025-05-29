package codejam;

import java.util.Formatter;
import java.util.HashSet;
import java.util.Scanner;

public class RecycledNumbers {	//Counting numbers within a given range, having same sequence of digits 

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int i=1;i<=cases;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int digitCount = new Integer(a).toString().toCharArray().length;
			HashSet<String> pairs = new HashSet<String>();
			
			for(int num=a; num<b; num++){
				char[] numArray = new Integer(num).toString().toCharArray();
				for(int j=1; j<digitCount; j++){
					char[] tempIter = new char[digitCount];
					for(int k=0; k<digitCount; k++)
						tempIter[k] = numArray[(k+j)%digitCount];
					int tempNum = Integer.parseInt(String.valueOf(tempIter));
					if(tempNum > num && tempNum <=b)
						pairs.add(new Formatter().format("[%d, %d]", num,tempNum).toString());
				}
			}
			System.out.println("Case #"+i+": "+pairs.size());
		}
	}

}
