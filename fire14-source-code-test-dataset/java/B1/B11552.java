import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */

/**
 * @author alfonzzz
 * 
 */
public class RecycledNumbersSolver {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	// Scanner in = getInputScanner();
	int T = in.nextInt();
	for (int i = 1; i <= T; i++) {
	    in.nextLine();
	    int min = in.nextInt();
	    int max = in.nextInt();
	    int result = solve(min, max);
	    System.out.format("Case #%d: %d\n", i, result);
	}
    }

    private static int solve(int min, int max) {
	int result = 0;
	for (int i = min; i <= max; i++) {
	    result += ArrayInt.INSTANCE.setNum(i, min, max);
	}
	result /= 2;
	return result;
    }

    public static enum ArrayInt {

	INSTANCE;

	private char[] backingArray;
	private int orginalNumber;
	private int min;
	private int max;

	private int currentValue;

	private Set<Integer> recycledSet = new HashSet<Integer>();

	public int setNum(int num, int min, int max) {
	    this.orginalNumber = num;
	    this.min = min;
	    this.max = max;
	    backingArray = Integer.toString(num).toCharArray();
	    calculateValue();
	    recycledSet.clear();
	    shiftLeft();
	    int length = length();
	    for (int i = 1; i < length; i++) {
		if (isValid()) {
		    recycledSet.add(value());
		}
		shiftLeft();
	    }

	    return numRecycled();
	}

	private int calculateValue() {
	    currentValue = Integer.parseInt(new String(backingArray));
	    return currentValue;
	}

	public int value() {
	    return currentValue;
	}

	public int length() {
	    return backingArray.length;
	}

	public int numRecycled() {
	    return recycledSet.size();
	}

	public void shiftLeft() {
	    char first = backingArray[0];
	    for (int i = 1; i < backingArray.length; i++) {
		int newPosition = i - 1;
		backingArray[newPosition] = backingArray[i];
	    }
	    backingArray[backingArray.length - 1] = first;
	    calculateValue();
	}

	public boolean isValid() {
	    return !isLeadingZero() && isUnique() && isInRange();
	}

	public boolean isLeadingZero() {
	    return backingArray[0] == '0';
	}

	public boolean isUnique() {
	    if (value() == orginalNumber) {
		return false;
	    }

	    char first = backingArray[0];
	    for (char c : backingArray) {
		if (c != first) {
		    return true;
		}
	    }

	    return false;
	}

	public boolean isInRange() {
	    int value = value();
	    return value >= min && value <= max;
	}

    }

    private static Scanner getInputScanner() {
	Scanner in = null;
	try {
	    in = new Scanner(new File("in.txt"));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	return in;
    }

}
