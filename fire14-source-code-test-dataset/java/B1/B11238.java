import java.util.Scanner;
import java.io.File;

public class RecycledNumbers {
	public static void main(String[] args) {
		Scanner input = null;
		boolean[][] counted;

	    try {
	        input = new Scanner(new File(args[0]));
	    } catch (Exception e) {
	        System.out.println("Please pass a correct filename as a program parameter");
	    	System.exit(1);
    	}

    	int t, a, b;

    	t = input.nextInt();
    	input.nextLine();

    	int recycledCount = 0;

    	for (int testNumber = 0; testNumber < t; testNumber++) {
	    	a = input.nextInt();
    		b = input.nextInt();
    		input.nextLine();

    		counted = getFalseArray(b-a+1);

    		// For each test case, look at all numbers between A and B as a possibleN
    		for (int possibleN = a; possibleN <= b; possibleN++) {
    			// For each possibleN, consider each recycled form
    			for (int offset = 1; offset < String.valueOf(possibleN).length(); offset++) {
    				int cycledN = Integer.parseInt(cycleRight("" + possibleN, offset));
    				// For each recycled form, consider whether it is within the appropriate range
    				if (cycledN >= a && cycledN <= b) {
    					// These numbers are cycled forms of eachother. Are they suitable?
    					if (possibleN != cycledN && counted[min(possibleN, cycledN)-a][max(possibleN, cycledN)-a] == false) {
    						counted[min(possibleN, cycledN)-a][max(possibleN, cycledN)-a] = true;
    						recycledCount++;
						}
    				}
				}
    		}

    		System.out.println("Case #" + (testNumber+1) + ": " + recycledCount);
    		recycledCount = 0;
    	}
	}

	public static String cycleRight(String number, int positions) {
		int intLen = number.length();

		while (positions > 0) {
			// Cycle one right
			number = number.charAt(intLen-1)+number.substring(0, intLen-1);
			positions--;
		}

		return number;
	}

	public static boolean[][] getFalseArray(int size) {
		boolean[][] array = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = false;
			}
		}

		return array;
	}

	public static int min(int a, int b) {
		return (a < b ? a : b);
	}

	public static int max(int a, int b) {
		return (a < b ? b : a);
	}
}