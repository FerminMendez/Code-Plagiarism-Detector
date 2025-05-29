package codej;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QualB {
	Scanner scanner = null;
	int caseLog = 0;
	int A = 0;
	int B = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QualB b = new QualB();
		b.go();
	}
	
	public void go() {		
		try {
			scanner = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int N = scanner.nextInt();	
		for (int i=1; i <= N; i++) {
			scanner.nextLine();
			System.out.print("Case #" + i +": ");
			System.out.println(doCase());
		}
	}
	
	public int doCase() {
		int rval = 0;
		A = scanner.nextInt();
		B = scanner.nextInt();
		caseLog = (int) Math.log10(A);
		
		if (A < 10)
			return 0;
		
		for (int i = A; i <= B; i++) {
			rval += recycle(i);
		}
		return rval;
	}
	
	public int recycle(int i) {
		int rval = 0;
		for (int log = caseLog; log > 0; log--) {
			int recycled = 0;
			int dec = (int) Math.pow(10, log);
			int rdec = (int) Math.pow(10, caseLog - (log - 1));
			recycled += (i % dec) * rdec;
			recycled += i / dec;
			if (recycled > i && recycled <= B) {
				rval++;
			}			
		}
		return rval;
	}
}
