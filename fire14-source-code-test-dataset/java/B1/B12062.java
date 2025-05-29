/**
 * 
 */
package code.google.codejam;

import java.util.HashSet;



/**
 * @author sunilkumarp
 *
 */
public class RecycledNumbers extends Template {
	
	int A = 0;
	
	int B = 0;
	
	int digits = 0;
	
	int[] n = null;
	
	int m = 0;

	/* (non-Javadoc)
	 * @see code.google.codejam.Template#doSolveProblem()
	 */
	@Override
	protected Object doSolveProblem() throws Exception {
		if (A >= B) {
			return 0;
		}
		int result = 0;
		n = new int[digits];
		int counter = digits;
		int A_ = A;
		for (;--counter >= 0;) {
			n[counter] = A_ % 10;
			A_ = A_ / 10;
		}
		
		counter = B - A;
		for (int i = 0; i < counter; ++i) {
			HashSet<Integer> unique = new HashSet<Integer>();
			for (int j = 1; j < digits; ++j) {
				if (isGreaterThanA(j) && isLessOrEqThanB(j)) {
					if(unique.add(m)) {
						++result;
					} continue;
					
				}
			}
			incrementA();
		}
		return result;
	}

	private boolean isLessOrEqThanB(int j) {
		return m <= B;
	}
	
	private boolean isGreaterThanA(int j) {
		m = 0;
		for (int k = j; k < digits; ++k) {
			m *= 10;
			m += n[k];
		}
		
		for (int k = 0; k < j; ++k) {
			m *= 10;
			m += n[k];
		}
		
		int A_ = 0;
		for (int k = 0; k < digits; ++k) {
			A_ *= 10;
			A_ += n[k];
		}
		
		return m > A_;
	}
	
	/*private boolean isLessOrEqThanB(int j) {
		boolean notSwitched = true;
		for (int i = 0; i < digits; ++i) {
			if (notSwitched && i+j == digits) {
				j = -i;
				notSwitched = false;
			}
			if (b[i] > a[i+j]) {
				return true;
			} else if (b[i] < a[i+j]) {
				return false;
			}
		}
		return true;
	}

	private boolean isGreaterThanA(int j) {
		boolean notSwitched = true;
		for (int i = 0; i < digits; ++i) {
			if (notSwitched && i+j == digits) {
				j = -i;
				notSwitched = false;
			}
			if (a[i] > a[i+j]) {
				return false;
			} else if (a[i] < a[i+j]) {
				return true;
			}
		}
		return false;
	}*/

	private void incrementA() {
		for (int i = digits - 1; i >= 0; --i) {
			if ((n[i] += 1) == 10) {
				n[i] = 0;
			} else {
				break;
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see code.google.codejam.Template#printInput()
	 */
	@Override
	protected void printInput() throws Exception {
		System.out.println("Digits-" +digits + ":" + A + "-" + B);

	}

	/* (non-Javadoc)
	 * @see code.google.codejam.Template#initializeTestCase()
	 */
	@Override
	protected void initializeTestCase() throws Exception {
		readLine();
		A = readNextInteger();
		digits = linePointer;
		B = readNextInteger();
	}

}
